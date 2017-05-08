package stage1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class WorkingTable {

	List<Attribute> selectedAttrs;
	ArrayList<ArrayList<Object>> table;
	private int PARALLEL_THRESHOLD;
	
	WorkingTable(int PARALLEL_THRESHOLD) {
		selectedAttrs = new ArrayList<Attribute>();
		table = new ArrayList<ArrayList<Object>>();
		this.PARALLEL_THRESHOLD = PARALLEL_THRESHOLD;
	}
	
	public void aggregate(ArrayList<Result_column> ar) {
		
		ArrayList<Object> aggrResult = new ArrayList<Object>();
		
		for(Result_column r : ar) {
			if(r.hasFunc_name) {
				if(r.func_name.equalsIgnoreCase("sum")) {
					aggrResult.add(sum(r));
				}
				else if(r.func_name.equalsIgnoreCase("count")) {
					aggrResult.add(count(r));
				}
			}
		}
		
		if(aggrResult.size() < selectedAttrs.size()) {
			aggrResult.add(null);
		}
	}
	
	public int sum(Result_column rc) {
		
		if(!getClassOfAttr(rc.table_name,rc.attr_name).equals(Integer.class))
			throw new IllegalArgumentException("Can't sum non-integer attribute");
		
		int i = getIndexOfAttr(rc.table_name, rc.attr_name);
		int sum = 0;
		if(table.size() > PARALLEL_THRESHOLD) {
			sum =  table.parallelStream()
						.filter(r -> r.get(i)==null)
						.mapToInt(r -> Integer.parseInt((String)r.get(i)))
						.sum();
		}
		else {
			sum =  table.stream()
					.filter(r -> r.get(i)==null)
					.mapToInt(r -> Integer.parseInt((String)r.get(i)))
					.sum();
		}
		return sum;
	}
	
	public int count(Result_column rc) {
		if(rc.isSingleStar)
			return table.size();
		else {
			int count = 0;
			int i = getIndexOfAttr(rc.table_name, rc.attr_name);
			
			if(!getClassOfAttr(rc.table_name,rc.attr_name).equals(Integer.class))
				throw new IllegalArgumentException("Can't sum non-integer attribute");
			
			if(table.size() >  PARALLEL_THRESHOLD) {
				count = (int) table.parallelStream()
							 .filter(t -> t.get(i) == null)
							 .count();
			}
			else {
				count = (int) table.stream()
						 .filter(t -> t.get(i) == null)
						 .count();
			}
			return count;
		}
	}
	
	public void addAttr(Attribute attr) {
		selectedAttrs.add(attr);
	}
	
	public void addAllAttrs(Vector<Attribute> v) {
		v.forEach(a -> selectedAttrs.add(a));
	}
	
	public void addTuple(ArrayList<Object> a) {
		table.add(a);
	}
	
	public void show() {
		
		int[] longestStr = new int[20];
		for(int i=0;i<selectedAttrs.size();i++)	longestStr[i] = 20;
		
		printDivider(longestStr);
		
		// print attribute names
		for(int i=0;i<selectedAttrs.size();i++) {
			System.out.printf("|%"+longestStr[i]+"s", selectedAttrs.get(i).getName());
		}
		System.out.println("|");
		
		// print table content
		for(ArrayList<Object> e : table) {
			printDivider(longestStr);
			for(int i=0;i<e.size();i++) {
				if(e.get(i) == null) {
					String str = "NULL";
					System.out.printf("|%"+longestStr[i]+"s",str);
				}
				else {
					String objStr = e.get(i).toString();
					System.out.printf("|%"+longestStr[i]+"s",objStr);
				}
			}
			System.out.println("|");
		}
		
		printDivider(longestStr);
	}
	
	private void printDivider(int[] w) {
		for(int i=0;i<selectedAttrs.size();i++) {
			int num = w[i];
			String repeated = new String(new char[num]).replace('\0', '-');
			System.out.format("+%s",repeated);
		}
		System.out.println("+");
	}
	
	private Class<?> getClassOfAttr(String tableName, String attrName) {
		
		Class<?> ret = Exception.class;
		for(Attribute a : selectedAttrs) {
			if(a.getTableBelong().equals(tableName) && a.getName().equals(attrName)) {
				ret = a.getClass_();
				break;
			}
		}
		return ret;
	}
	
	private int getIndexOfAttr(String tableName, String attrName) {
		
		int ret = -1;
		for(int i=0;i<selectedAttrs.size();i++) {
			if(selectedAttrs.get(i).getTableBelong().equals(tableName) &&
			   selectedAttrs.get(i).getName().equals(attrName)) {
				ret = i;
				break;
			}
		}
		return ret;
	}
}
