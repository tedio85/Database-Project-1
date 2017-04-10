package stage1;

import java.util.ArrayList;
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
		
		// find the table that contains the attribute name of WHERE
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
		TempTable finalResult = null;
		
		if(whe_bool_expr == null) {
			QThread q0 = new QThread(TableMap, wTable[0], wColumn[0], op[0], selectedTableName);
			Thread t0 = new Thread(q0);
			t0.start();
			try {
				t0.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finalResult = q0.getTempTable();
		}
		else {
			QThread q0 = new QThread(TableMap, wTable[0], wColumn[0], op[0], selectedTableName);
			QThread q1 = new QThread(TableMap, wTable[1], wColumn[1], op[1], selectedTableName);
			Thread t0 = new Thread(q0);
			Thread t1 = new Thread(q1);
			t0.start();
			t1.start();
			try {
				t0.join();
				q0.getTempTable().show();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				t1.join();
				q1.getTempTable().show();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch(whe_bool_expr.toUpperCase()) {
			case "AND" :
				finalResult = joinAND(q0.getTempTable(), q1.getTempTable());
				break;
			case "OR" :
				finalResult = joinOR(q0.getTempTable(), q1.getTempTable());
				break;
			default :
				throw new IllegalArgumentException("illegal join operator");
			}
		}
		
		// find the table that contains the attribute name of SELECT
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
		
		// project selected attributes
		project(finalResult, aliasToName, selectedTableName, col_table_name, col_column_name);
		
	}
	private TempTable joinAND(TempTable lt, TempTable rt) {
		TempTable tmp = new TempTable(lt.getAttrs());
		HashSet<Vector<Object>> smallerOne = new HashSet<Vector<Object>>();
		TempTable biggerOne = null;
		if(lt.getAttrs().size() < rt.getAttrs().size()) {
			smallerOne.addAll(lt.getTable());
			biggerOne = rt;
		}
		else {
			smallerOne.addAll(rt.getTable());
			biggerOne = lt;
		}
		for(Vector<Object> tup : biggerOne) {
			if(smallerOne.contains(tup)) 
				tmp.insert_(tup);
		}
		return tmp;
	}
	
	private TempTable joinOR(TempTable lt, TempTable rt) {
		TempTable ret = new TempTable(lt.getAttrs());
		HashSet<Vector<Object>> h = new HashSet<Vector<Object>>();

		h.addAll(lt.getTable());
		h.addAll(rt.getTable());
		for(Vector<Object> record : h) {
			ret.insert_(record);
		}
		return ret;
	}
	
	private void project(TempTable finalResult, HashMap<String, String> aliasToName, HashSet<String> selectedTableName,
						Queue<String> selectedTable, Queue<String> selectedAttr) {
		
		ArrayList<Integer> attrIdx = new ArrayList<Integer>();
		Vector<Attribute> newAttrs = new Vector<Attribute>();
		
		// get (attrName, tableName) from queue one by one
		while(!selectedAttr.isEmpty()) {
			String attrName = selectedAttr.poll();
			String tableName = null;
			if (selectedTable.peek().equals("*")) 
				tableName = "*";
			else if(selectedTable.peek() != null)
				tableName = aliasToName.get(selectedTable.poll());
			else
				tableName = findAttrTableName(attrName, selectedTableName);
			
			int count=0;
			for(Attribute a : finalResult.getAttrs()) {
				if(tableName.equals("*")) {
					attrIdx.add(count);
					newAttrs.add(a);
					
				}
				else if(a.getTableBelong().equals(tableName) && a.getName().equals(attrName)) {
					attrIdx.add(count);
					newAttrs.add(a);
				}
				count++;
			}
		}
		
		// put selected results into new TempTable
		TempTable t = new TempTable(newAttrs);
		for(Vector<Object> record : finalResult) {
			Vector<Object> newRecord = new Vector<Object>();
			for(Integer idx : attrIdx) {
				newRecord.add(record.get(idx));
			}
			t.insert_(newRecord);
		}
		t.show();
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
