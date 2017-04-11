package stage1;

import java.util.ArrayList;
import java.util.Vector;

public class Aggregate {
	
	public static TempTable aggr(TempTable t, ArrayList<String> aggrFunc, ArrayList<String> attrNames, ArrayList<Integer> aggrAttrIdx) {
		
		if(aggrFunc.size() != attrNames.size())
			throw new IllegalArgumentException("mixing aggregation function with attribute names");
		
		
		Vector<Attribute> newAttrs = new Vector<Attribute>();
		for(int i=0;i<aggrFunc.size();i++) {
			Attribute a = new Attribute(aggrFunc.get(i)+"("+attrNames.get(i)+")", null, null, null);
			newAttrs.add(a);
		}
		
		Vector<Integer> record = new Vector<Integer>();
		for(int i=0;i<aggrFunc.size();i++)	record.add(0);
			
		
		// *
		int starIdx = -1;
		if(attrNames.contains("*")) {
			starIdx = attrNames.indexOf("*");
			if(aggrFunc.get(starIdx).equals("SUM"))
				throw new IllegalArgumentException("SUM cannot be used with *");
			else if(aggrFunc.get(starIdx).equals("COUNT"))
				record.set(starIdx, t.getTable().size());
			else
				throw new IllegalArgumentException("Illegal aggregation function");		
		}
		
		// loop through all table
		for(Vector<Object> tup : t) {
			for(int i=0;i<aggrFunc.size();i++) {
				if(i != starIdx) {
					Object attr = tup.get(aggrAttrIdx.get(i));
					switch(aggrFunc.get(i)) {
						case "SUM":
							if(attr != null) {
								try {
									record.set(i, record.get(i)+(Integer)attr);
								}
								catch(ClassCastException e) {
									throw new ClassCastException("Can't SUM attributes of type other than Integer");
								}
							}
							break;
						case "COUNT":
							if(attr != null)
								record.set(i, record.get(i)+1);
							break;
						default: throw new IllegalArgumentException("Illegal aggregation function");
					}
				}
			}
		}
		
		Vector<Object> recordInObj = new Vector<Object>();
		for(Integer i: record) {
			recordInObj.add(i);
		}
		TempTable ret = new TempTable(newAttrs);
		ret.insert_(recordInObj);
		return ret;
		
	}
	
	// NOT count attributes with null values
	public static TempTable count_(TempTable t, int attrIdx) {
		
		int count = (int) t.getTable().parallelStream()
									  .filter(r -> r.get(attrIdx)==null).count();
		return packToNewTable(count);
	}
	
	// NOT sum attributes with null values
	public static TempTable sum_(TempTable t, int attrIdx) {
		
		if(!t.getAttrs().get(attrIdx).getClass_().equals(Integer.class))
			throw new IllegalArgumentException("Cannot sum attribute of type other than Integer");
		
		int sum = (int) t.getTable().parallelStream()
									.filter(r -> r.get(attrIdx)==null)
									.mapToInt(r -> (Integer)r.get(attrIdx))
									.sum();
		
		return packToNewTable(sum);
	}
	
	
	private static TempTable packToNewTable(int num) {
		// the returned TempTable will have "" for attribute name and tableBelong
		Vector<Attribute> vec = new Vector<Attribute>();
		Attribute a = new Attribute("", null, 0, "");
		vec.add(a);
		
		// construct TempTable
		TempTable ret = new TempTable(vec);
		Vector<Object> record = new Vector<Object>();
		record.add(num);
		ret.insert_(record);
		return ret;
	}
	
		
}
