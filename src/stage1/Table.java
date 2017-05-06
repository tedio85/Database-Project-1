package stage1;
import java.util.Vector;

public interface Table {
	
	String getName();										// get name of table
	String getPrimaryKey();									// get primary key
	Vector<Attribute> getAttrs();							// get names of all attributes
	void show();											// print the table
}