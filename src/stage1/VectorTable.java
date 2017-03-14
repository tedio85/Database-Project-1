package stage1;

import java.util.Vector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;

public class VectorTable implements Table {
	protected String name = null;													// name of table
	protected String primaryKey = null;												// name of primary key
	protected Vector<Attribute> attrs = new Vector<Attribute>();					// name of attributes
	protected HashMap<String, Integer> keyToIdx = new HashMap<String, Integer>();	// map attribute name to index
	protected HashMap<Integer, String> idxToKey = new HashMap<Integer, String>();	// map index to attribute name	
	protected Vector<Vector<Object>> table = new Vector<Vector<Object>>();// tuples, where the order of elements is same as attrs
	private int[] longestStr = new int[20];
																
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
	public VectorTable(String name, String str_pk, Vector<String> attrs,Vector<String> attrTypes, Vector<Integer> strLen) throws IllegalArgumentException{
		this.name = parseString(name);
		this.primaryKey = parseString(str_pk);
		
		
		Vector<String> attrs_ = attrs;								// attribute names
		Vector<Class<?>> attrTypes_ = new Vector<Class<?>>();		// default attribute types
		Vector<Integer> strLen_ = new Vector<Integer>();			// max length of each attribute
		
		
		// remove "
		attrs_.replaceAll(v -> parseString(v));
		attrTypes.replaceAll(v -> parseString(v));
		
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
					attrTypes_.add(new Integer(0).getClass());
					break;
				case "varchar":
					attrTypes_.add(new String().getClass());
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
			Attribute attr = new Attribute(attrs_.get(i), attrTypes_.get(i), strLen_.get(i));
			this.attrs.add(attr);
			if(!keyToIdx.containsKey(attrs_.get(i)))
				this.keyToIdx.put(attrs_.get(i), i);
			else
				throw new IllegalArgumentException("found duplicated attribute");
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
				if(obj.getClass().equals(new String().getClass())) {
					String str = parseString((String) obj);
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
			int primaryKeyIdx = Integer.MAX_VALUE;
			try {
				primaryKeyIdx = keyToIdx.get(primaryKey);
			}
			catch(NullPointerException e) {
				throw new NullPointerException("primary key is not in attribute list"); 
			}
			
			for(Vector<Object> row : table) {
				if(tup.get(primaryKeyIdx).getClass().equals(new String().getClass())) {
					if(row.get(primaryKeyIdx).equals(parseString((String) tup.get(primaryKeyIdx)))) {
						pass = false;
						throw new IllegalArgumentException("primary key duplicated");
					}
				}
				else {
					if(row.get(primaryKeyIdx).equals(tup.get(primaryKeyIdx))) {
						pass = false;
						throw new IllegalArgumentException("primary key duplicated");
					}
				}
			}
		}
		else {
			if(table.contains(tup)) {
				pass = false;				
				throw new IllegalArgumentException("cannot insert a duplicated record");
			}
		}
		
		if(pass) {
			table.add(tup);
			
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
			if(attrs.get(i).getClass_().equals(new Integer(0).getClass())) {	//should be a number or null
				if(tup.get(i) == null)
					newtup.add(null);
				else {
					try {
						newtup.add(Integer.parseInt(tup.get(i)));
					}
					catch(NumberFormatException e) {
						System.out.println("number exceeds int range or incorrect type");
						throw new IllegalArgumentException("number exceeds int range or incorrect type");
					}
				}
			}
			else {	// should be string or null
				if(tup.get(i) == null)
					newtup.add(null);
				else if(isString(tup.get(i)))
					newtup.add(parseString(tup.get(i)));
				else {
					throw new IllegalArgumentException("type mismatch");
				}
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
			try {
				int idx = keyToIdx.get( parseString(attrNames.get(i)) );
				newtup.set(idx, tup.get(i));
			}
			catch(NullPointerException e) {
				pass = false;				
				throw new NullPointerException("attribute does not exist");
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
		
		// print table name
		System.out.println(this.name);
		
		printDivider(longestStr);
		
		// print attribute names
		for(int i=0;i<attrs.size();i++) {
			System.out.printf("|%"+longestStr[i]+"s", attrs.get(i).getName());
		}
		System.out.println("|");
		
		// print table content
		for(Vector<Object> tuple : table) {
			printDivider(longestStr);
			for(int i=0;i<tuple.size();i++) {
				if(tuple.get(i) == null) {
					String str = "NULL";
					System.out.printf("|%"+longestStr[i]+"s",str);
				}
				else {
					String objStr = tuple.get(i).toString();
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
		for(Vector<Object> tup : table) {
			try {
				String s = tup.toString();
				CSVUtils.writeLine(writer, Arrays.asList(s.substring(1,s.length()-1)));
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
	
	protected Boolean isString(String str) {
		if((str.startsWith("\'") || str.startsWith("\"")) && (str.endsWith("\'") || str.endsWith("\"")))
			return true;
		else
			return false;
	}
		
	protected String parseString(String str) {
		if(str == null)
			return null;
		else
			return str.replaceAll("\'", "").replaceAll("\"","");
	}
	
}
