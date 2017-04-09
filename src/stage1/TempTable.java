package stage1;

import java.util.Vector;

public class TempTable extends VectorTable{	
	
	public TempTable(Vector<Attribute> la, Vector<Attribute> ra) {
		this.name = "tmpTable";
		Vector<Attribute> merge = new Vector<Attribute>();
		merge.addAll(la);
		merge.addAll(ra);
		attrs.addAll(merge);
		for(int i=0;i<20;i++)
			longestStr[i] = 20;
		
	}
	
	public TempTable(Vector<Attribute> la) {
		this.name = "tmpTable";
		attrs = la;
		for(int i=0;i<20;i++)
			longestStr[i] = 20;
	}
	
	public void insert_(Vector<Object> lr, Vector<Object> rr) {
		Vector<Object> merge = new Vector<Object>();
		merge.addAll(lr);
		if(rr != null)
			merge.addAll(rr);
		table.add(merge);
	}
}
