package stage1;

import java.util.Vector;
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;

public class VectorTable implements Table {
	private String name = null;											// name of table
	private String primaryKey = null;									// name of primary key
	private Class<?> primaryKeyType = null;								// type of primary key
	private int primaryKeyIdx = 0;										// index of primary key
	private Vector<String> attrs = new Vector<String>();				// name of attributes 
	private Vector<Class<?>> attrTypes = new Vector<Class<?>>();		// default attribute types
	private Vector<Integer> strLen = new Vector<Integer>();				// max length of strings
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
		this.attrs = attrs;
		
		// set attrTypes
		int varCharCount = 0;
		for(String str : attrTypes) {
			switch(str.toLowerCase()) {
				case "int":
					this.attrTypes.add(Integer.TYPE);
					break;
				case "varchar":
					this.attrTypes.add(new String().getClass());
					varCharCount++;
					break;
				default:
					throw new IllegalArgumentException("unknown type");
			}
		}
		
		// set primaryKeyType
		for(int i=0;i<this.attrs.size();i++) {
			if(this.attrs.get(i).equals(primaryKey)) {
				primaryKeyIdx = i;
				primaryKeyType = this.attrTypes.get(i); 
			}
		}
		
		// set strLen
		if(strLen.size() != varCharCount)	
			throw new IllegalArgumentException("length of strLen should match numbers of varchar attributes");
		int count = 0;
		for(int i=0;i<attrTypes.size();i++) {
			if(attrTypes.get(i).equals(new String().getClass())) {
				this.strLen.set(i, strLen.get(count));
				count++;
			}
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
	
	// get type of primary key
	public Class<?> getPrimaryKeyType() {
		return this.primaryKeyType;
	}
	
	// get names of attributes
	public Vector<String> getAttrs() {
		return this.attrs;
	}
	
	// get parameter type of all attributes of the table
	public Vector<Class<?>> getAttrTypes() {
		return this.attrTypes;
	}
	
	// for debugging, NOT FOR REGULAR USAGE
	public Vector<Vector<Object>> getTable() {
		return table;
	}
	
	/**
	 * @param tup	a vector of Object, such as integers mixed with Strings, including all the attributes in a tuple
	 * 
	 * insert a tuple to table:
	 * 		performs:
	 * 			parameter type check
	 * 			null parameter check
	 * 			integer range check
	 * 			string length check
	 * 			primary key uniqueness check
	 */
	public void insert(Vector<Object> tup) throws IllegalArgumentException {
		Boolean pass = true;
		
		// check numbers of parameters
		if(tup.size() != attrs.size()) {
			pass = false;
			throw new IllegalArgumentException("tuple size incorrect");
		}
			
		// check parameter type & null check
		for(int i=0;i<tup.size();i++) {
			Object tupAttr = tup.get(i);
			Class<?> requiredClassType = attrTypes.get(i);
			if(tupAttr != null) {
				if(!requiredClassType.equals(tupAttr.getClass())) {
					pass = false;
					throw new IllegalArgumentException("attribute class unmatch");
				}
			}
			else {
				if(primaryKey!=null && attrs.get(i).equals(primaryKey)) {	// primary key attribute in tuple is null
					pass = false;
					throw new IllegalArgumentException("primary key cannot be null");
				}
			}
		}
		// check integer range & string length
		for(int i=0;i<tup.size();i++) {
			if(tup.get(i).getClass().equals(Integer.TYPE)) {
				// is already integer, do nothing
			}
			else if(tup.get(i).getClass().equals(new String().getClass())) {
				String str = (String) tup.get(i);
				if(str.length() > strLen.get(i)) {
					pass = false;
					throw new IllegalArgumentException("maximum string length exceeded");
				}
			}
			else {
				throw new IllegalArgumentException("unknown type");
			}
		}
		
		
		// check if primary key is unique
		for(Vector<Object> t : table) {
			if(t.get(primaryKeyIdx).equals(tup.get(primaryKeyIdx)))
				pass = false;
		}
		
		if(pass) {
			table.add(tup);
		}
		else {
			System.out.println("tuple NOT inserted");
		}
	}
	
	/**
	 * @param tup vector of string, where numbers are not yet converted to integers
	 */
	public void insertStr(Vector<String> tup) {
	
		Boolean pass = true;
		
		// check number of parameters
		if(tup.size() != attrs.size()) {
			pass = false;
			throw new IllegalArgumentException("tuple size incorrect");
		}
		
		// convert numbers in tuple to string
		Vector<Object> newtup = new Vector<Object>();
		for(int i=0;i<tup.size();i++) {
			if(attrTypes.get(i).equals(Integer.TYPE)) {
				try {
					newtup.add(Integer.parseInt(attrs.get(i)));
				}
				catch(NumberFormatException e) {
					pass = false;
					System.out.println("number exceeds int range");
				}
			}
			else {
				newtup.add(tup.get(i));
			}
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
		
		printBoarder();
		
		for(String attrName : attrs) {
			System.out.format("|%s", attrName);
		}
		System.out.println("|");
		
		for(Vector<Object> tup : table) {
			for(Object attr : tup) {
				System.out.format("| %s", attr.toString());
			}
			System.out.println("|");
		}
		
		printBoarder();
	}
	
	private void printBoarder() {
		int intWidth = 8;
		
		Vector<Integer> w = new Vector<Integer>();
		for(int i=0;i<attrTypes.size();i++) {
			if(attrTypes.get(i).equals(Integer.TYPE)) {
				w.add(intWidth);
			}
			else {
				w.add(strLen.get(i));
			}
		}
		
		for(Integer width : w) {
			System.out.print("+");
			for(int i=0;i<width;i++)
				System.out.print("-");
			System.out.print("+");
		}
		System.out.print("\n");
	}
}
