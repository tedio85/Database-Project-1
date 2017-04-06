package stage1;

import java.util.HashMap;
import java.util.Vector;

public class TableManager {
	private HashMap<String, VectorTable> TableMap;
	
	TableManager() {
		TableMap = new HashMap<String, VectorTable>();
	}
	
	public void putTable(String name, String str_pk, Vector<String> attrs,Vector<String> attrTypes, Vector<Integer> strLen) {
		TableMap.put(name, new VectorTable(name, str_pk, attrs, attrTypes, strLen));
	}
	
	public void insertTup(String tableName, Vector<String> tup) {
		TableMap.get(tableName).insert(tup);
	}
	
	public void insertTup(String tableName, Vector<String> attrs, Vector<String> tup) {
		TableMap.get(tableName).insert(attrs, tup);
	}
	
	public VectorTable getTable(String tableName) {
		return TableMap.get(tableName);
	}
	
	
	public int getTableAttrSize(String tableName) {
		return TableMap.get(tableName).getAttrs().size();
	}
	
	public void dumpCSV() {
		for (HashMap.Entry<String, VectorTable> entry : TableMap.entrySet())
    	{
    	    TableMap.get(entry.getKey()).exportToCSV();
    	}
	}
	
	public boolean isExist(String tableName) {
		return TableMap.containsKey(tableName);
	}
}
