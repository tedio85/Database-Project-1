package stage1;
import java.lang.Object;
import java.util.Vector;

public interface Table {
	
	String getName();					// get name of table
	String getPrimaryKey();				// get primary key
	Class<?> getPrimaryKeyType();		// get type of primary key
	Vector<String> getAttrs();			// get names of all attributes
	Vector<Class<?>> getAttrTypes();	// get parameter type of all attributes of the table
	void insert(Vector<Object> tup);	// insert a tuple
	void insertStr(Vector<String> tup);	// insert a tuple with numbers as strings
	void show();						// print the table
}