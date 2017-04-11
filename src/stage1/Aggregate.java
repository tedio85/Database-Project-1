package stage1;

import java.util.OptionalInt;
import java.util.Vector;

public class Aggregate {
	
	
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
	
	// NOT average attributes with null values
	public static TempTable avg_(TempTable t, int attrIdx) {
		
		if(!t.getAttrs().get(attrIdx).getClass_().equals(Integer.class))
			throw new IllegalArgumentException("Cannot sum attribute of type other than Integer");
		
		int count = (int) t.getTable().parallelStream()
				  .filter(r -> r.get(attrIdx)==null).count();
		
		int sum = (int) t.getTable().parallelStream()
									.filter(r -> r.get(attrIdx)==null)
									.mapToInt(r -> (Integer)r.get(attrIdx))
									.sum();
		int avg = sum / count;
		return packToNewTable(avg);
	}
	
	// NEGLECT attributes with null values
	public static TempTable max_(TempTable t, int attrIdx) {
		
		if(!t.getAttrs().get(attrIdx).getClass_().equals(Integer.class))
			throw new IllegalArgumentException("Cannot sum attribute of type other than Integer");
		
		OptionalInt optMax =  t.getTable().parallelStream()
									   .filter(r -> r.get(attrIdx) == null)
									   .mapToInt(r -> (Integer) r.get(attrIdx))
									   .max();
		int max = optMax.getAsInt();
		return packToNewTable(max);
	}
	
	// NEGLECT attributes with null values
	public static TempTable min_(TempTable t, int attrIdx) {
		
		if(!t.getAttrs().get(attrIdx).getClass_().equals(Integer.class))
			throw new IllegalArgumentException("Cannot sum attribute of type other than Integer");
		
		OptionalInt optMin =  t.getTable().parallelStream()
									   .filter(r -> r.get(attrIdx) == null)
									   .mapToInt(r -> (Integer) r.get(attrIdx))
									   .min();
		int min = optMin.getAsInt();
		return packToNewTable(min);
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
