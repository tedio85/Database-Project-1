package stage1;

import java.util.Vector;

public class TempTable extends VectorTable{	
	
	public TempTable(Vector<Attribute> la, Vector<Attribute> ra) {
		this.name = "tmpTable";
		Vector<Attribute> merge = new Vector<Attribute>();
		merge.addAll(la);
		merge.addAll(ra);
		attrs.addAll(merge);
	}
	
	public void insert_(Vector<Object> lr, Vector<Object> rr) {
		Vector<Object> merge = new Vector<Object>();
		merge.addAll(lr);
		merge.addAll(rr);
		table.add(merge);
	}
}
