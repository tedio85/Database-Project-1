package stage1;

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class TreeTable implements Table {
	private String name = null;											// name of table
	private Vector<String> params = null;								// sequence of default parameters
	private Set<Vector<Object>> set = new TreeSet<Vector<Object>>();	// tuples, where the order of elements is as same as params
	
	TreeTable(String name, Vector<String> params) {
		this.name = name;
		this.params = params;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Vector<String> getParams() {
		return this.params;
	}
	
	public Set<Vector<Object>> getTable() {
		return this.set;
	}
}
