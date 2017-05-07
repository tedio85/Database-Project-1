package stage1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.mapdb.DB;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.TreeMultimap;

public class IndexTable extends VectorTable{
	private Map<String, TreeMultimap<Object, Object>> treemapIndex 
			= new TreeMap<String, TreeMultimap<Object, Object>>(String.CASE_INSENSITIVE_ORDER);
	private Map<String, ArrayListMultimap<Object, Object>> listmapIndex
			= new TreeMap<String, ArrayListMultimap<Object, Object>>(String.CASE_INSENSITIVE_ORDER);
	
	
	IndexTable(DB db, CreateTableStmt statement){
		super(db, statement);
	}
	
	/*--------------------------Indexing--------------------------------*/
	
	public void createTreeIndex(String attrName) {
		if(getIndexOfAttr(attrName) != -1) {
			
		}
		else
			System.out.println("attribute "+attrName+" does not exist");
	}
	
	public void createHashIndex(String attrName) {
		
	}
	
	public void createIndexAll() {
		
	}
	
	// e.g. get all primary keys where "attribute = operand"
	public Set<Object> getAttrEquals(String attrName, Object operand) {
		Set<Object> ret = new HashSet<Object>();
		if(attrName.equalsIgnoreCase(primaryKey))
			ret.add(operand);
		else if(mapIndex.containsKey(attrName)) {
			ret.addAll(mapIndex.get(attrName).get(operand));
		}
		else {
			int attrIdx = getIndexOfAttr(attrName);
			Class<?> type = getClassOfAttr(attrIdx);
			for(Map.Entry<Object, Object[]> e : entrySet()) {
				if(compareObjectEqual(operand, e.getValue()[attrIdx], type))
					ret.add(e.getKey());
			}
		}
		return ret;
	}
	
	/*-------------------------BTree Operations-------------------------*/
	
	public Set<Object> headMap(String attrName, Object toKey) {
		Set<Object> ret = new HashSet<Object>();
		if(attrName.equalsIgnoreCase(primaryKey))
			return headMap(toKey);
		else if(mapIndex.containsKey(attrName))
			ret.addAll(mapIndex.get(attrName).asMap().headMap(toKey).values());
		else {
			int attrIdx = getIndexOfAttr(attrName);
			Class<?> type = getClassOfAttr(attrIdx);	
			for(Map.Entry<Object, Object[]> e : entrySet()) {
				if(compareObjectSmaller(toKey, e.getValue()[attrIdx], type))
					ret.add(e.getKey());
			}
		}
		return ret;
	}

	public Set<Object> tailMap(String attrName, Object fromKey) {
		Set<Object> ret = new HashSet<Object>();
		if(attrName.equalsIgnoreCase(primaryKey))
			return tailMap(fromKey);
		else if(mapIndex.containsKey(attrName))
			ret.addAll(mapIndex.get(attrName).asMap().tailMap(fromKey).values());
		else {
			int attrIdx = getIndexOfAttr(attrName);
			Class<?> type = getClassOfAttr(attrIdx);	
			for(Map.Entry<Object, Object[]> e : entrySet()) {
				if(compareObjectLarger(fromKey, e.getValue()[attrIdx], type))
					ret.add(e.getKey());
			}
		}
		return ret;	
	}
	
	public Set<Object> subMap(String attrName, Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive){
		Set<Object> ret = new HashSet<Object>();
		if(attrName.equalsIgnoreCase(primaryKey))
			return subMap(fromKey, fromInclusive, toKey, toInclusive);
		else if(mapIndex.containsKey(attrName))
			ret.addAll(mapIndex.get(attrName).asMap()
						.subMap(fromKey, fromInclusive, toKey, toInclusive).values());
		else {
			int attrIdx = getIndexOfAttr(attrName);
			Class<?> type = getClassOfAttr(attrIdx);	
			for(Map.Entry<Object, Object[]> e : entrySet()) {
				if(compareObjectLarger(fromKey, e.getValue()[attrIdx], type) &&
				   compareObjectSmaller(toKey, e.getValue()[attrIdx], type))
					ret.add(e.getKey());
			}
		}
		return ret;
	}
	
	
	/*-------------------------Compare Objects-----------------------*/
	
	private boolean compareObjectEqual(Object key, Object data, Class<?> type) {
		Integer opInt = Integer.MIN_VALUE;
		String opString = new String();
		if(type.equals(Integer.class))
			opInt = Integer.parseInt((String) key);
		else
			opString = (String) key;
		
		
		Integer eInt = Integer.MIN_VALUE;
		String eString = new String();
		if(type.equals(Integer.class)) {
			eInt = Integer.parseInt((String) data);
			if(opInt == eInt)
				return true;
			else
				return false;
		}
		else {
			eString = (String) data;
			if(opString.equals(eString))
				return true;
			else
				return false;
		}
	}
	
	private boolean compareObjectLarger(Object key, Object data, Class<?> type) {
		Integer opInt = Integer.MIN_VALUE;
		String opString = new String();
		if(type.equals(Integer.class))
			opInt = Integer.parseInt((String) key);
		else
			opString = (String) key;
		
		
		Integer eInt = Integer.MIN_VALUE;
		String eString = new String();
		if(type.equals(Integer.class)) {
			eInt = Integer.parseInt((String) data);
			if(opInt > eInt)
				return true;
			else
				return false;
		}
		else {
			eString = (String) data;
			if(opString.compareTo(eString) < 0)
				return true;
			else
				return false;
		}
	}
	
	private boolean compareObjectSmaller(Object key, Object data, Class<?> type) {
		return !compareObjectLarger(key, data ,type) & !compareObjectEqual(key, data, type);
	}
}
