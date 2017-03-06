package stage1;
import java.lang.Object;
import java.util.Set;
import java.util.Vector;

public interface Table {
	String name = null;					// name of table
	Vector<String> params = null;		// sequence of default parameters
	Set<Vector<Object>> set = null;		// tuples, where the order of elements is as same as params
	
	
	String getName();					// get name of table
	String getParams();					// get parameters of table
	String getTable();					// return the object itself
	void insert(Vector<Object> tup);	// insert a tuple
	void show();						// print the table
}