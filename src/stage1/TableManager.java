package stage1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TableManager {
	private HashMap<String, VectorTable> TableMap;
	Queue<String> col_table_name = new LinkedList<String>();
	Queue<String> col_column_name = new LinkedList<String>();
	Queue<String> tab_table_name = new LinkedList<String>();
	Queue<String> tab_alias = new LinkedList<String>();
	Queue<String> whe_table_name = new LinkedList<String>();
	Queue<String> whe_operator = new LinkedList<String>();
	Queue<String> whe_column_name = new LinkedList<String>();
	Queue<String> whe_bool_expr = new LinkedList<String>();
	
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
		this.col_table_name = col_table_name;
		this.col_column_name = col_column_name;
		this.tab_table_name = tab_table_name;
		this.tab_alias = tab_alias;
		this.whe_table_name = whe_table_name;
		this.whe_operator = whe_operator;
		this.whe_column_name = whe_column_name;
		this.whe_bool_expr = whe_bool_expr;
	}
}
