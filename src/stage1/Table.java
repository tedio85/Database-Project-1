package stage1;
import java.lang.Object;
import java.util.Set;
import java.util.Vector;

public interface Table {
	
	String getName();					// get name of table
	Vector<String> getParams();			// get parameters of table
	Set<Vector<Object>> getTable();		// return the object itself
	void insert(Vector<Object> tup);	// insert a tuple
	void show();						// print the table
}