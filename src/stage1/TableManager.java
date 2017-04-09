package stage1;

import java.util.HashMap;
import java.util.HashSet;
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
			Queue<String> whe_table_name, Queue<String> whe_operator ,Queue<String> whe_column_name, String whe_bool_expr) 
	{
		HashSet<String> selectedTableName = new HashSet<String>();	// true name of selected tables
		HashMap<String, String> aliasToName = new HashMap<String, String>();	// map alias to name
		
		// build selectedTable and aliasToName
		while(!tab_table_name.isEmpty()) {
			String str = tab_table_name.poll();	// true name
			selectedTableName.add(str);
			aliasToName.put(str, str);
			String al = tab_alias.poll();
			if(al != null)
				aliasToName.put(al, str);
		}
		
		// pop out of queue, [0]: lhs, [1[: rhs
		String[][] wTable = new String[2][2];
		String[][] wColumn = new String[2][2];
		String[] op = new String[2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				wTable[i][j] = whe_table_name.poll();
				wColumn[i][j] = whe_column_name.poll();
			}
			op[i] = whe_operator.poll();
		}
		
		// check if attribute
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				String foundTableName = findAttrTableName(wColumn[i][j], selectedTableName);
				if(wTable[i][j] == null) {	// table name not given in WHERE
					wTable[i][j] = foundTableName;
				}
				else {
					if(!aliasToName.get(wTable[i][j]).equals(foundTableName))	// mismatched table given in WHERE
						throw new IllegalArgumentException("attribute not in specified table");
					else	// replace table name alias with true name
						wTable[i][j] = foundTableName;
				}
			}
		}
		
		// distribute to thread
		if(whe_bool_expr == null) {
			QThread q0 = new QThread(TableMap, wTable[0], wColumn[0], op[0], selectedTableName);
			Thread t0 = new Thread(q0);
			t0.start();
			try {
				t0.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			q0.getTempTable().show();
		}
		else {
			Thread t0 = new Thread( new QThread(TableMap, wTable[0], wColumn[0], op[0], selectedTableName));
			Thread t1 = new Thread( new QThread(TableMap, wTable[1], wColumn[1], op[1], selectedTableName));
			t0.start();
			t1.start();
			
		}
						
	}
	
	// return the true name of the table where the attribute falls in 
	private String findAttrTableName(String attr, HashSet<String> selectedTableName) {
		if(checkType(attr)!=Type.ATTR_NAME) return null;
		Boolean found = false;
		String ret = null;
		for(String s: selectedTableName) {
			for(Attribute a : TableMap.get(s).getAttrs()) {
				if(a.getName().equals(attr)) {
					if(found == true) {	//duplicate
						throw new IllegalArgumentException("ambiguous attribute name");
					}
					else {				// found for first time
						found = true;
						ret = s;
					}
				}
			}
		}
		if(found == false) {
			throw new IllegalArgumentException("attribute does not belong to any table");
		}
		return ret;
	}
	
	private Type checkType(String str) {
		if(str == null)
			return Type.NULL;
		else if((str.startsWith("\'") || str.startsWith("\"")) && (str.endsWith("\'") || str.endsWith("\"")))
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
