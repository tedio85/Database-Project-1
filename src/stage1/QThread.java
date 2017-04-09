package stage1;

import java.util.HashMap;
import java.util.Vector;

public class QThread implements Runnable{
	private HashMap<String, VectorTable> TableMap;
	private String lhs_table_name, rhs_table_name;
	private String lhs_column_name, rhs_column_name;
	private String op;
	private volatile TempTable tempTable;

	public QThread(HashMap<String, VectorTable> TableMap, String[] wTable, 
					String[] wColumn, String whe_operator) {
		this.TableMap = TableMap;
		lhs_table_name = wTable[0];
		rhs_table_name = wTable[1];
		lhs_column_name = wColumn[0];
		rhs_column_name = wColumn[1];
		op = whe_operator;
	}
	
	@SuppressWarnings("unchecked")
	private VectorTable nestedJoin() {
		
		VectorTable lhsTable = TableMap.get(lhs_table_name);
		VectorTable rhsTable = TableMap.get(rhs_table_name);
		int lhsIdx = lhsTable.getIndexOfAttr(lhs_column_name);
		int rhsIdx = rhsTable.getIndexOfAttr(rhs_column_name);
		tempTable = new TempTable(lhsTable.getAttrs(), rhsTable.getAttrs());
		
		// attribute type mismatch
		for(Vector<Object> lrec : lhsTable) {
			for(Vector<Object> rrec : rhsTable) {
				Boolean result = null;
				if(op == null) {
					result = true;
				}
				else {
					switch(op) {
						case ">":	result = Comparable.class.cast(lrec.get(lhsIdx)).compareTo(Comparable.class.cast(rrec.get(rhsIdx)))>0; 
									break;
						case "<":	result = Comparable.class.cast(lrec.get(lhsIdx)).compareTo(Comparable.class.cast(rrec.get(rhsIdx)))<0; 
									break;
						case "<>":	result = Comparable.class.cast(lrec.get(lhsIdx)).compareTo(Comparable.class.cast(rrec.get(rhsIdx)))!=0; 
									break;
						case "=":	result = Comparable.class.cast(lrec.get(lhsIdx)).compareTo(Comparable.class.cast(rrec.get(rhsIdx)))==0; 
									break;
						default: throw new IllegalArgumentException("illegal operator in WHERE");
					}
				}
				
				if(result == true) {
					tempTable.insert_(lrec, rrec);
				}
			}
		}
		return tempTable;
	}
	
	public TempTable getTempTable() {
		return tempTable;
	}
	
	@Override
	public void run() {
		if(lhs_table_name==null || rhs_table_name==null) {
			
		} 
		
		else nestedJoin();
	}
	
}
