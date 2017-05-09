package stage1;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.mapdb.DB;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.TreeMultimap;

public class IndexTable extends VectorTable{
	private int[] treeIndexType = new int[20];
	private boolean[] listIndexType = new boolean[20];
	private final int PARALLEL_THRESHOLD = 1000000;
	
	private Map<String, TreeMultimap<Integer, String>> treemapInt 
			= new TreeMap<String, TreeMultimap<Integer, String>>(String.CASE_INSENSITIVE_ORDER);
	
	private Map<String, TreeMultimap<String, String>> treemapStr 
	= new TreeMap<String, TreeMultimap<String, String>>(String.CASE_INSENSITIVE_ORDER);
	
	private Map<String, ArrayListMultimap<String, String>> listmap
			= new TreeMap<String, ArrayListMultimap<String, String>>(String.CASE_INSENSITIVE_ORDER);
	
	
	IndexTable(DB db, DB diskDB, CreateTableStmt statement){
		super(db, diskDB, statement);
		for(int i=0;i<20;i++) {
			treeIndexType[i] = 0;
			listIndexType[i] = false;
		}
	}
	
	/*--------------------------Indexing--------------------------------*/
	// 0: no indexing
	// 1: tree integer -> string
	// 2: tree string -> string
	public void createTreeIndex(String attrName) {
		if(getClassOfAttr(attrName).equals(Integer.class)) {
			TreeMultimap<Integer, String> t = TreeMultimap.create();
			int i = getIndexOfAttr(attrName);
			treeIndexType[i] = 1;
			
			for(Map.Entry<Object, Object[]> e : this.entrySet()) {
				t.put(Integer.parseInt(e.getValue()[i].toString()), e.getKey().toString());
			}
			treemapInt.put(attrName, t);
		}
		else {
			TreeMultimap<String, String> t = TreeMultimap.create();
			int i = getIndexOfAttr(attrName);
			treeIndexType[i] = 2;
			
			for(Map.Entry<Object, Object[]> e : this.entrySet()) {
				t.put(e.getValue()[i].toString(), e.getKey().toString());
			}
			treemapStr.put(attrName, t);
		}
	}
	
	public void createHashIndex(String attrName) {
		ArrayListMultimap<String, String> a = ArrayListMultimap.create();
		int i = getIndexOfAttr(attrName);
		listIndexType[i] = true;
		
		for(Map.Entry<Object, Object[]> e : this.entrySet()) {
			a.put(e.getValue()[i].toString(), e.getKey().toString());
		}
		listmap.put(attrName, a);
		
	}
	
	public void createIndexAll() {
		for(Attribute a : attrs) {
			createTreeIndex(a.getName());
			createHashIndex(a.getName());
		}
	}

	
	/*-------------------------Index Operations-------------------------*/
	
	// e.g. get all primary keys where "attribute = operand"
	// precedence: primary key -> hash index -> tree map -> no index
	public Set<Object> getAttrEquals(String attrName, Object operand) {
		int i = getIndexOfAttr(attrName);
		
		if(attrName.equalsIgnoreCase(primaryKey)){
			Set<Object> ret = new HashSet<Object>();
			ret.add(operand);
			return ret;
		}
		else if(listIndexType[i]) {
			Set<Object> ret = new HashSet<Object>();
			List<String> l = listmap.get(attrName).get(operand.toString());
			for(Object o : l) {
				ret.add(o);
			}
			return this.castToOriginalType(ret);
		}
		else if(treeIndexType[i] != 0) {
			Set<Object> ret = new HashSet<Object>();
			switch(treeIndexType[i]) {
				case 1:
					int operandInt = Integer.parseInt((String)operand);
					ret.addAll(treemapInt.get(attrName).get(operandInt));
					break;
				case 2:
					ret.addAll(treemapStr.get(attrName).get(operand.toString()));
					break;
				default: throw new IllegalArgumentException("wrong indexType "+treeIndexType[i]);
			}
			ret = this.castToOriginalType(ret);
			return ret;
		}
		else {
			Set<Object> ret = new HashSet<Object>();
			Consumer<Map.Entry<Object, Object[]>> addMatched = 
				e -> {
					if(ObjCompare.compare(operand, e.getValue()[i]) == 0)
						ret.add(e.getKey());
				};  
			
			if(bTable.size() > PARALLEL_THRESHOLD) {
				this.entrySet().parallelStream()
							   .forEach(e -> addMatched.accept(e));
			}
			else {
				this.entrySet().stream()
				   			   .forEach(e -> addMatched.accept(e));
			}
			return ret;
		}
	}
	
	// use Set(all primary key) - getAttrEquals
	public Set<Object> getAttrNeq(String attrName, Object operand) {
		Set<Object> s = new HashSet<Object>(); 
		s.addAll(this.keySet());
		if(attrName.equalsIgnoreCase(primaryKey))
			s.remove(operand);
		else 
			s.removeAll(getAttrEquals(attrName, operand));
		return s;
	}
	
	// would be faster if key sorted
	// precedence: primary key -> tree map -> no index (Don't use hash map)
	public Set<Object> subMap(String attrName, Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive){
		int i = getIndexOfAttr(attrName);
		
		if(attrName.equalsIgnoreCase(primaryKey))
			return this.subMap(fromKey, fromInclusive, toKey, toInclusive);
		else if(treeIndexType[i] != 0) {
			Set<Object> ret = new HashSet<Object>();
			switch(treeIndexType[i]) {
			case 1:
				int fromInt = Integer.parseInt((String)fromKey);
				int toInt = Integer.parseInt((String) toKey);
				Collection<Collection<String>> c = 
						treemapInt.get(attrName)
									.asMap()
									.subMap(fromInt, fromInclusive, toInt, toInclusive)
									.values();
				
				for(Collection<String> cs : c) {
					ret.addAll(cs);
				}
				
				break;
			case 2:
				
				Collection<Collection<String>> d = 
					treemapStr.get(attrName)
								.asMap()
								.subMap(fromKey.toString(), fromInclusive, toKey.toString(), toInclusive)
								.values();
				for(Collection<String> cs : d)
					ret.addAll(cs);
				
				break;
			default: throw new IllegalArgumentException("wrong indexType "+treeIndexType[i]);
			}
			ret = this.castToOriginalType(ret);
			return ret;
		}
		else {
			Set<Object> ret = new HashSet<Object>();
			Consumer<Map.Entry<Object, Object[]>> addMatched =
				e -> {
					Object data = e.getValue()[i];
					if(ObjCompare.compare(fromKey, data) > 0 &&
					   ObjCompare.compare(toKey, data) < 0)
						ret.add(e.getKey());
					else if(fromInclusive && ObjCompare.compare(fromKey, data) == 0)
						ret.add(e.getKey());
					else if(toInclusive && ObjCompare.compare(fromKey, data) == 0)
						ret.add(e.getKey());
				};
			
			if(bTable.size() > PARALLEL_THRESHOLD) {
				this.entrySet().parallelStream()
						       .forEach(e -> addMatched.accept(e));
			}
			else {
				this.entrySet().stream()
							   .forEach(e -> addMatched.accept(e));
			}
			return ret;
		}
	}
	
	public Set<Object> headMap(String attrName, Object toKey) {
		int i = getIndexOfAttr(attrName);
		
		System.out.println("attrName: "+attrName+" "+toKey.toString());
		
		if(attrName.equalsIgnoreCase(primaryKey)) {
			Set<Object> s = new HashSet<Object>();
			s.addAll(this.headMap(toKey));
			return s;
		}
		else if(treeIndexType[i] != 0){
			Set<Object> ret = new HashSet<Object>();
			switch(treeIndexType[i]) {
			case 1:
				int toInt = Integer.parseInt(toKey.toString());
				Collection<Collection<String>> c =
						treemapInt.get(attrName)
									 .asMap()
									 .headMap(toInt)
									 .values();
				for(Collection<String> cs : c)
					ret.addAll(cs);

				break;
			case 2:
				Collection<Collection<String>> d =
						treemapStr.get(attrName)
									 .asMap()
									 .headMap(toKey.toString())
									 .values();
				for(Collection<String> cs : d)
					ret.addAll(cs);

				break;
			default: throw new IllegalArgumentException("wrong indexType "+treeIndexType[i]);
			}
			ret = this.castToOriginalType(ret);
			return ret;
		}
		else {
			Set<Object> ret = new HashSet<Object>();
			Consumer<Map.Entry<Object, Object[]>> addMatched = 
				e -> {
					if(ObjCompare.compare(e.getValue()[i], toKey) < 0)
						ret.add(e.getKey());
				};
				
				if(bTable.size() > PARALLEL_THRESHOLD) {
					this.entrySet().parallelStream()
				       .forEach(e -> addMatched.accept(e));
				}
				else {
					this.entrySet().stream()
					   .forEach(e -> addMatched.accept(e));
				}
			return ret;
		}
	}

	public Set<Object> tailMap(String attrName, Object fromKey) {
		Set<Object> s = new HashSet<Object>();
		s.addAll(this.keySet());
		s.removeAll(getAttrEquals(attrName, fromKey));
		//System.out.println(s.toString());
		s.removeAll(headMap(attrName, fromKey));
		//System.out.println(s.toString());
		return s;
	}
	
	private Set<Object> castToOriginalType(Set<Object> s) {
		
		if(primaryKeyIdx == -1 || getClassOfAttr(primaryKeyIdx).equals(Integer.class)) {
			if(s.size() > PARALLEL_THRESHOLD) {
				s = s.parallelStream()
					 .map(t -> Integer.parseInt(t.toString()))
				     .collect(Collectors.toSet());
			}
			else {
				s = s.stream()
				     .map(t -> Integer.parseInt(t.toString()))
				     .collect(Collectors.toSet());
			}
		}
		return s;
	}
}
	
