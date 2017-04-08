package stage1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TableManager {
	private HashMap<String, VectorTable> TableMap;
	/*
	Queue<String> col_table_name = new LinkedList<String>();
	Queue<String> col_column_name = new LinkedList<String>();
	Queue<String> tab_table_name = new LinkedList<String>();
	Queue<String> tab_alias = new LinkedList<String>();
	Queue<String> whe_table_name = new LinkedList<String>();
	Queue<String> whe_operator = new LinkedList<String>();
	Queue<String> whe_column_name = new LinkedList<String>();
	Queue<String> whe_bool_expr = new LinkedList<String>();
	*/
	
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
	
	public void showTable(String tableName) {
		TableMap.get(tableName).show();
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
	
	public void select(Queue<String> col_table_name, Queue<String> col_column_name, Queue<String> tab_table_name, Queue<String> tab_alias,
			Queue<String> whe_table_name, Queue<String> whe_operator ,Queue<String> whe_column_name, Queue<String> whe_bool_expr) 
	{
		HashSet<String> selectedTable = new HashSet<String>();	// selected table names
		HashMap<String, String> aliasToName = new HashMap<String, String>();	// map alias to name
		
		// build selectedTable and aliasToName
		while(!tab_table_name.isEmpty()) {
			String str = tab_table_name.poll();
			selectedTable.add(str);
			aliasToName.put(str, str);
			String al = tab_alias.poll();
			if(al != null)
				aliasToName.put(tab_alias.poll(), str);
		}
		
		
						
		
	}
	
	private Boolean existAttr(String tableName, String attr) {
		return TableMap.get(tableName).getAttrs().contains(attr);
	}
	
	private Type checkType(String str) {
		if((str.startsWith("\'") || str.startsWith("\"")) && (str.endsWith("\'") || str.endsWith("\"")))
			return Type.STR;
		try {
			Integer.parseInt(str);
			return Type.NUM;
		}
		catch(NumberFormatException e) {
			return Type.ATTR_NAME;
		}
	}
	
}
