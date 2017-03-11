package stage1;
import java.util.Vector;

public interface Table {
	
	String getName();										// get name of table
	String getPrimaryKey();									// get primary key
	Vector<Attribute> getAttrs();							// get names of all attributes
	void insert(Vector<String> tup);						// insert a tuple with numbers as strings
	void insert(Vector<String> attrNames, Vector<String> tup);	// insert tuple with specified attributes
	void show();											// print the table
}