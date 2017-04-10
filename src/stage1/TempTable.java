package stage1;

import java.util.Vector;

public class TempTable extends VectorTable{	
	private boolean reverse;
	
	public TempTable(Vector<Attribute> la, Vector<Attribute> ra, boolean reverse) {
		this.name = "";
		this.reverse = reverse;
		Vector<Attribute> merge = new Vector<Attribute>();
		if(reverse) {
			merge.addAll(ra);
			merge.addAll(la);
		} 
		else {
			merge.addAll(la);
			merge.addAll(ra);	
		}
		attrs.addAll(merge);
		for(int i=0;i<20;i++)
			longestStr[i] = 20;
	}
	
	public TempTable(Vector<Attribute> la) {
		this.name = "";
		attrs = la;
		for(int i=0;i<20;i++)
			longestStr[i] = 20;
	}
	
	public void insert_(Vector<Object> joinedTuple) {
		table.add(joinedTuple);
	}
	
	public void insert_(Vector<Object> lr, Vector<Object> rr) {
		Vector<Object> merge = new Vector<Object>();
		if(reverse) {
			if(rr != null)
				merge.addAll(rr);
			merge.addAll(lr);
		} else {
			merge.addAll(lr);
			if(rr != null)
				merge.addAll(rr);	
		}
		table.add(merge);
	}
}
