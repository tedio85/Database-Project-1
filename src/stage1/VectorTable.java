package stage1;

import java.util.Vector;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.Serializer;
import org.mapdb.serializer.SerializerArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.IllegalArgumentException;


public class VectorTable implements Table {
	protected String name = null;													// name of table
	protected int primaryKeyIdx = -1;
	protected String primaryKey = null;												// name of primary key
	protected int primaryKeyCount = 0;												// generated primary key for tables with no primary key
	protected Vector<Attribute> attrs = new Vector<Attribute>();					// name of attributes
	protected HashMap<String, Integer> keyToIdx = new HashMap<String, Integer>();	// map attribute name to index
	protected HashMap<Integer, String> idxToKey = new HashMap<Integer, String>();	// map index to attribute name	
	protected BTreeMap<Object, Object[]> bTable = null;
												
	protected int[] longestStr = new int[20];
																
	/**Usage:
	 *	Creating a table NAME with attributes:
	 *		"A" int		primary_key
	 *		"B" varchar[10]
	 *		"C" int
	 *		"D" varchar[20]
	 *
	 *	Then type in:
	 *		new VectorTable(NAME, "A", Vector of(["A","B","C","D"]), Vector of("int","varchar","int","varchar"), Vector of([10,20]) )
	 * 
	 * @param name							name of table
	 * @param str_pk						name of primary key
	 * @param attrs							vector of names of attributes
	 * @param attrTypes						vector of strings describing the attribute types
	 * @param strLen						maximum length of varchar in the order of attrs
	 * @throws IllegalArgumentException		type error / strLen vector length incorrect
	 * 
	 */
	
	/*-------------------Constructors------------------------*/
	
	public VectorTable() {
		
	}
	

	@SuppressWarnings("unchecked")
	public VectorTable(DB db, CreateTableStmt statement) throws IllegalArgumentException{
		
		bTable =  db.treeMap(statement.getTable_name())
					.valuesOutsideNodesEnable()
					.keySerializer(Serializer.ELSA)
					.valueSerializer(new SerializerArray<Object[]>(Serializer.ELSA))
					.counterEnable()
					.createOrOpen();
													
		String pk = null;
		Vector<String> attrs = new Vector<String>();
		Vector<String> attrTypes = new Vector<String>();
		Vector<Integer> strLen = new Vector<Integer>();
		
		
		for(Column_def cd : statement.getColumn_defs()) {
			if(cd.isPrimaryKey) {
				if(pk == null)
					pk = cd.column_name;
				else
					throw new IllegalArgumentException("cannot have two primary keys");
			}
			attrs.add(cd.column_name);
			String[] type_name = cd.type_name.split(" ");
			attrTypes.add(type_name[0]);
			if(type_name[0].equalsIgnoreCase("varchar"))
				strLen.add(Integer.parseInt(type_name[1]));
		}
		vectorTable(statement.getTable_name(), pk, attrs, attrTypes, strLen);
	}
	
	private void vectorTable(String name, String str_pk, Vector<String> attrs,Vector<String> attrTypes, Vector<Integer> strLen) throws IllegalArgumentException{
		this.name = name;
		this.primaryKey = str_pk;
		
		
		Vector<String> attrs_ = attrs;								// attribute names
		Vector<Class<?>> attrTypes_ = new Vector<Class<?>>();		// default attribute types
		Vector<Integer> strLen_ = new Vector<Integer>();			// max length of each attribute
		
		
		// set longestStr
		for(int i=0;i<attrs_.size();i++)
			longestStr[i] = attrs_.get(i).length()+2;
		
		// set attrTypes
		int varCharCount = 0;
		if(attrs.size() != attrTypes.size())	
			throw new IllegalArgumentException("attrs.size()!=attrTypes.size()");
		for(String str : attrTypes) {
			switch(str.toLowerCase()) {
				case "int":
					attrTypes_.add(Integer.class);
					break;
				case "varchar":
					attrTypes_.add(String.class);
					varCharCount++;
					break;
				default:
					System.out.println(str.toLowerCase());
					throw new IllegalArgumentException("unknown type");
			}
		}
		
		
		// set strLen
		for(int i=0;i<attrs.size();i++) strLen_.add(0);
		
		if(strLen.size() != varCharCount)	
			throw new IllegalArgumentException("length of strLen should match numbers of varchar attributes");
		int count = 0;
		for(int i=0;i<attrTypes.size();i++) {
			if(attrTypes_.get(i).equals(new String().getClass())) {
				if(strLen.get(count)>0 && strLen.get(count)<=40) {
					strLen_.set(i,strLen.get(count));
					count++;
				}
				else {
					throw new IllegalArgumentException("varchar should be 1 to 40 characters");
				}
			}
		}
		
		// combine attrs_, attrTypes, strLen to attrs
		// also check for duplicated attribute name
		for(int i=0;i<attrs_.size();i++) {
			Attribute attr = new Attribute(attrs_.get(i), attrTypes_.get(i), strLen_.get(i), this.name);
			this.attrs.add(attr);
			if(!keyToIdx.containsKey(attrs_.get(i)))
				this.keyToIdx.put(attrs_.get(i), i);
			else
				throw new IllegalArgumentException("found duplicated attribute");
		}
		
		
		// get primary key index
		if(primaryKey != null)
			primaryKeyIdx = keyToIdx.get(primaryKey);
		
		// create inverse mapping of index to key
		for(Map.Entry<String, Integer> entry : keyToIdx.entrySet()){
		    idxToKey.put(entry.getValue(), entry.getKey());
		}
		
	}
	
	/*---------------------VectorTable Operations-------------------*/

	// get name of table
	public String getName() {
		return this.name;
	}
	
	// get name of primary key
	public String getPrimaryKey() {
		return this.primaryKey;
	}
	
	// get names of attributes
	public Vector<Attribute> getAttrs() {
		return this.attrs;
	}
	
	public Vector<String> getAttrsAsString() {
		Vector<String> v = new Vector<String>();
		for(Attribute a : attrs) {
			v.add(a.getName());
		}
		return v;
	}
	
	// return the index of attribute in record
	public int getIndexOfAttr(String attrName) {
		return keyToIdx.get(attrName);
	}
	
	public Class<?> getClassOfAttr(int idxOfAttr) {
		return attrs.get(idxOfAttr).getClass();
	}
	
	/**
	 * @param tup	a vector of Object, such as integers mixed with Strings, including all the attributes in a tuple
	 * 
	 * insert a tuple to table:
	 * 		performs:
	 * 			null parameter check
	 * 			parameter type check
	 * 			string length check
	 * 			primary key uniqueness check
	 */
	
	
	/*----------------------Insert---------------------------*/
	
	
	protected void _insert(Vector<Object> tup) throws IllegalArgumentException {
		Boolean pass = true;
		
		// check numbers of parameters
		if(tup.size() != attrs.size()) {
			pass = false;
			throw new IllegalArgumentException("tuple size incorrect");
		}
		
		
		for(int i=0;i<tup.size();i++) {
			Object obj = tup.get(i);
			
			// null parameter check
			if(obj != null) {
				
				// parameter type check
				if(! obj.getClass().equals(attrs.get(i).getClass_())) {
					pass = false;
					throw new IllegalArgumentException("attribute class unmatch");
				}
				
				//	string length check
				if(obj.getClass().equals(String.class)) {
					String str = (String) obj;
					if(str.length() > attrs.get(i).getMaxLen()) {
						pass = false;
						throw new IllegalArgumentException("maximum string length exceeded");
					}
				}
				
			}
			else {
				if(idxToKey.get(i).equals(primaryKey)) {	// primary key of tuple is null
					pass = false;
					throw new IllegalArgumentException("primay key of tuple cannot be null");
				}
			}
		}
		
		
		// primary key uniqueness check
		// check all tuples if primary key does not exist
		if(primaryKey!=null) {
			if(bTable.containsKey(tup.get(primaryKeyIdx)))
				throw new NullPointerException("duplicate primary key");
		}
		else {
			if(containsValue(tup.toArray(new Object[attrs.size()]))) {
				pass = false;				
				throw new IllegalArgumentException("cannot insert a duplicated record");
			}
		}
		
		if(pass) {
			if(primaryKey != null)
				bTable.put(tup.get(primaryKeyIdx), tup.toArray(new Object[attrs.size()]));
			else {
				bTable.put(primaryKeyCount, tup.toArray(new Object[attrs.size()]));
				primaryKeyCount++;
			}
			
			for(int i=0;i<tup.size();i++) {
				if(tup.get(i) != null)
					longestStr[i] = Math.max(tup.get(i).toString().length()+2, longestStr[i]);
				else
					longestStr[i] = Math.max("NULL".length()+2, longestStr[i]);
			}
		}
		else {
			System.out.println("tuple NOT inserted");
		}
	}
	
	
	// insert tuple with specified attributes
	public void insert(Vector<String> attrNames, Vector<Object> tup) throws IllegalArgumentException {
		Boolean pass = true;
		
		Vector<Object> newtup = new Vector<Object>();
		for(int i=0;i<attrs.size();i++)	newtup.add(null);
		
		// check attrNames.length() == tup.length()
		if(attrNames.size() != tup.size()) {
			pass = false;
			throw new IllegalArgumentException("length of attrNames should match length of tup");
		}
		
		// check for duplicated attributes
		HashSet<String> set = new HashSet<String>();
		for(String s : attrNames) {
			if(set.add(s) == false)
				throw new IllegalArgumentException("duplicated attribute");		
		}
		
		// put attributes at corresponding position
		for(int i=0;i<tup.size();i++) {
			try {
				int idx = keyToIdx.get(attrNames.get(i));
				newtup.set(idx, tup.get(i));
			}
			catch(NullPointerException e) {
				pass = false;				
				throw new NullPointerException("attribute does not exist");
			}
		}
		
		if(pass)
			_insert(newtup);		
		else
			System.out.println("tuple NOT inserted");
	}
	
	public void insert(InsertStmt statement) throws IllegalArgumentException{
		
		Vector<String> attrNames = new Vector<String>();
		Vector<Object> tup = new Vector<Object>();
		statement.getNameValuePair().forEach(t -> 	{
														attrNames.add(t.colName);
														if(t.valueType.equals(Integer.class))
															tup.add(Integer.parseInt((String)t.value));
														else
															tup.add( ((String)t.value).replaceAll("[']", "") );
													});	
		if(statement.isUsingDefaultAttrOrder())
			_insert(tup);
		else
			insert(attrNames, tup);
	}
	
	/*---------------------BTreeMap Operations----------------------*/
	
	@SuppressWarnings("unchecked")
	public Set<Object> keySet() {
		return bTable.keySet();
	}
	
	public Set<Object> subMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive){
		return bTable.subMap(fromKey, fromInclusive, toKey, toInclusive).keySet();
	}
	
	public Set<Object> headMap(Object toKey) {
		return bTable.headMap(toKey).keySet();
	}
	
	public Set<Object> tailMap(Object fromKey) {
		return bTable.tailMap(fromKey).keySet();
	}
	
	public Class<?> getPrimaryKeyType() {
		int i = keyToIdx.get(primaryKey);
		return attrs.get(i).getClass_();
	}
	
	@SuppressWarnings("unchecked")
	private boolean containsValue(Object[] obj) {
		boolean contain = false;
		for(Map.Entry<Object, Object[]> e : (Set<Map.Entry<Object, Object[]>>)bTable.entrySet()) {
			boolean theSame = true;
			Object[] arr = e.getValue();
			for(int i=0;i<arr.length;i++) {
				if(!arr[i].equals(obj[i])) {
					theSame = false;
				}
			}
			contain = contain | theSame;
			if(contain == true)
				break;
		}
		return contain;
	}
	
	/*---------------------IO Operations----------------------*/

	
	// print the table
	public void show() {
		
		// print table name
		System.out.println(this.name);
		
		printDivider(longestStr);
		
		// print attribute names
		for(int i=0;i<attrs.size();i++) {
			System.out.printf("|%"+longestStr[i]+"s", attrs.get(i).getName());
		}
		System.out.println("|");
		
		// print table content
		@SuppressWarnings("unchecked")
		Set<Map.Entry<Object,Object[]>> s = bTable.entrySet();
		for(Map.Entry<Object, Object[]> e : s) {
			printDivider(longestStr);
			for(int i=0;i<e.getValue().length;i++) {
				if(e.getValue()[i] == null) {
					String str = "NULL";
					System.out.printf("|%"+longestStr[i]+"s",str);
				}
				else {
					String objStr = e.getValue()[i].toString();
					System.out.printf("|%"+longestStr[i]+"s",objStr);
				}
			}
			System.out.println("|");
		}
		
		printDivider(longestStr);
	}
	
	private void printDivider(int[] w) {
		for(int i=0;i<attrs.size();i++) {
			int num = w[i];
			String repeated = new String(new char[num]).replace('\0', '-');
			System.out.format("+%s",repeated);
		}
		System.out.println("+");
	}
	
	
	public void exportToCSV() {
		
		String csvFile = "./output/" + this.name + ".csv";
		FileWriter writer = null;
        try {
			writer = new FileWriter(csvFile);
		} catch (IOException e) {
			System.out.println("failed to create file");
			e.printStackTrace();
		}
		// write attribute names to file
        Vector<String> anames = new Vector<String>();
        for(Attribute a : attrs) {
        	anames.add(a.getName());
        }
        try {
			String s = anames.toString();
			CSVUtils.writeLine(writer, Arrays.asList(s.substring(1,s.length()-1)));
		} catch (IOException e) {
			System.out.println("name writeLine failed");
			e.printStackTrace();
		}
        
        // write table content to file
        @SuppressWarnings("unchecked")
		Set<Map.Entry<Object,Object[]>> s = bTable.entrySet();
		for(Map.Entry<Object, Object[]> tup : s) {
			try {
				String str = tup.toString();
				CSVUtils.writeLine(writer, Arrays.asList(str.substring(1,str.length()-1)));
			} catch (IOException e) {
				System.out.println("table content writeLine failed");
				e.printStackTrace();
			}
		}
		
        try {
        	writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("failed to close writer");
			e.printStackTrace();
		}
	}
	
}
