package stage1;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;

public class VectorTable implements Table {
	private String name = null;											// name of table
	private String primaryKey = null;									// name of primary key
	private Vector<Attribute> attrs = new Vector<Attribute>();			// name of attributes
	private HashMap<String, Integer> keyToIdx = new HashMap<String, Integer>();	// map attribute name to index
	private HashMap<Integer, String> idxToKey = new HashMap<Integer, String>();	// map index to attribute name	
	private Vector<Vector<Object>> table = new Vector<Vector<Object>>();// tuples, where the order of elements is same as attrs
																
	/**
	 * 
	 * @param name							name of table
	 * @param str_pk						name of primary key
	 * @param attrs							vector of names of attributes
	 * @param attrTypes						vector of strings describing the attribute types
	 * @param strLen						maximum length of varchar in the order of attrs
	 * @throws IllegalArgumentException		type error / strLen vector length incorrect
	 * 
	 * 
	 * Usage:
	 *	Creating a table NAME with attributes:
	 *		"A" int		primary_key
	 *		"B" varchar[10]
	 *		"C" int
	 *		"D" varchar[20]
	 *
	 *	Then type in:
	 *		new VectorTable(NAME, "A", Vector of(["A","B","C","D"]), Vector of("int","varchar","int","varchar"), Vector of([10,20]) )
	 */
	public VectorTable(String name, String str_pk, Vector<String> attrs,Vector<String> attrTypes, Vector<Integer> strLen) throws IllegalArgumentException{
		this.name = name;
		this.primaryKey = str_pk;
		
		
		Vector<String> attrs_ = attrs;								// attribute names
		Vector<Class<?>> attrTypes_ = new Vector<Class<?>>();		// default attribute types
		Vector<Integer> strLen_ = new Vector<Integer>();			// max length of each attribute
		
		
		// set attrTypes
		int varCharCount = 0;
		for(String str : attrTypes) {
			switch(str.toLowerCase()) {
				case "int":
					attrTypes_.add(new Integer(0).getClass());
					break;
				case "varchar":
					attrTypes_.add(new String().getClass());
					varCharCount++;
					break;
				default:
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
				strLen_.set(i,strLen.get(count));
				count++;
			}
		}
		
		// combine attrs_, attrTypes, strLen to attrs
		for(int i=0;i<attrs_.size();i++) {
			Attribute attr = new Attribute(attrs_.get(i), attrTypes_.get(i), strLen_.get(i));
			this.attrs.add(attr);
			this.keyToIdx.put(attrs_.get(i), i);
		}
		
		// create inverse mapping of index to key
		for(Map.Entry<String, Integer> entry : keyToIdx.entrySet()){
		    idxToKey.put(entry.getValue(), entry.getKey());
		}
		
	}
	
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
	
	// get the entire table
	public Vector<Vector<Object>> getTable() {
		return table;
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
	private void _insert(Vector<Object> tup) throws IllegalArgumentException {
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
				if(obj.getClass().equals(new String().getClass())) {
					String str = (String) obj;
					if(str.length() > attrs.get(i).getMaxLen()) {
						pass = false;
						throw new IllegalArgumentException("maximum string length exceeded");
					}
				}
				
			}
			else {
				if(idxToKey.get(i).equals(primaryKey))	// primary key of tuple is null
					pass = false;
			}
		}
		
		
		//	primary key uniqueness check
		if(primaryKey!=null) {
			int primaryKeyIdx = keyToIdx.get(primaryKey);
			for(Vector<Object> row : table) {
				if(row.get(primaryKeyIdx).equals(tup.get(primaryKeyIdx)))
					pass = false;
			}
		}
		
		if(pass) {
			table.add(tup);
		}
		else {
			System.out.println("tuple NOT inserted");
		}
	}
	
	/**
	 * 
	 * @param tup vector of string, where numbers are not yet converted to integers
	 * 
	 * Insert a tuple with numbers as strings.
	 * 
	 * 		For a string of number:	
	 * 			tests if the string can be converted to integer 
	 * 			(integer range check)
	 * 
	 * 		For a normal string or null attribute:
	 * 			copies and inserts directly
	 */
	public void insert(Vector<String> tup) {
	
		Boolean pass = true;
		
		// check number of parameters
		if(tup.size() != attrs.size()) {
			pass = false;
			throw new IllegalArgumentException("tuple size incorrect");
		}
		
		// convert numbers in tuple to string
		// adds normal strings and null attributes directly
		Vector<Object> newtup = new Vector<Object>();
		for(int i=0;i<tup.size();i++) {
			if(attrs.get(i).getClass_().equals(new Integer(0).getClass())) {	//is number
				try {
					newtup.add(Integer.parseInt(tup.get(i)));
				}
				catch(NumberFormatException e) {
					pass = false;
					System.out.println("number exceeds int range");
				}
			}
			else {	// is string or null
				newtup.add(tup.get(i));
			}
		}
		
		if(pass) {
			_insert(newtup);
		}
		else {
			System.out.println("tuple NOT inserted");
		}
	}
	
	// insert tuple with specified attributes
	public void insert(Vector<String> attrNames, Vector<String> tup) throws IllegalArgumentException {
		Boolean pass = true;
		
		Vector<String> newtup = new Vector<String>();
		for(int i=0;i<attrs.size();i++)	newtup.add(null);
		
		// check attrNames.length() == tup.length()
		if(attrNames.size() != tup.size()) {
			pass = false;
			throw new IllegalArgumentException("length of attrNames should match length of tup");
		}
		// put attributes at corresponding position
		for(int i=0;i<tup.size();i++) {
			int idx = keyToIdx.get(attrNames.get(i));
			newtup.set(idx, tup.get(i));
		}
		
		if(pass) {
			insert(newtup);
		}
		else {
			System.out.println("tuple NOT inserted");
		}
	}
	
	// print the table
	public void show() {
		int spacing = 1;
		int defaultWidth = 10;
		
		// calculate width of each column
		Vector<Integer> w = new Vector<Integer>();
		for(Attribute attr : attrs) {
			int len = attr.getName().length() + spacing*2;	// the '1' is for the vertical divider
			if(len < defaultWidth)
				w.add(defaultWidth);
			else
				w.add(len);
		}
		
		printDivider(w);
		
		// print attribute names
		for(int i=0;i<attrs.size();i++) {
			System.out.printf("|%"+w.get(i)+"s", attrs.get(i).getName());
		}
		System.out.println("|");
		
		// print table content
		for(Vector<Object> tuple : table) {
			printDivider(w);
			for(int i=0;i<tuple.size();i++) {
				if(tuple.get(i) == null) {
					String str = "NULL";
					System.out.printf("|%"+(w.get(i)-str.length())+"s",str);
				}
				else {
					String objStr = tuple.get(i).toString();
					System.out.printf("|%"+w.get(i)+"s",objStr);
				}
			}
			System.out.println("|");
		}
		
		printDivider(w);
	}
	
	private void printDivider(Vector<Integer> w) {
		for(Integer num : w) {
			String repeated = new String(new char[num]).replace('\0', '-');
			System.out.format("+%s",repeated);
		}
		System.out.println("+");
	}
}
