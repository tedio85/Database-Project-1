package stage1;

import java.util.HashMap;
import java.util.Queue;
import java.util.Vector;

public class QThread implements Runnable{
	private HashMap<String, VectorTable> TableMap;
	private String lhs_table_name, rhs_table_name;
	private String lhs_column_name, rhs_column_name;
	private String op;

	public QThread(HashMap<String, VectorTable> TableMap, String[] wTable, 
					String[] wColumn, String whe_operator) {
		this.TableMap = TableMap;
		lhs_table_name = wTable[0];
		rhs_table_name = wTable[1];
		lhs_column_name = wColumn[0];
		rhs_column_name = wColumn[1];
		op = whe_operator;
	}
	
	private VectorTable nestedJoin() {
		
		VectorTable lhsTable = TableMap.get(lhs_table_name);
		VectorTable rhsTable = TableMap.get(rhs_table_name);
		int lhsIdx = lhsTable.getIndexOfAttr(lhs_column_name);
		int rhsIdx = rhsTable.getIndexOfAttr(rhs_column_name);
		Class<?> lhsType = lhsTable.getClassOfAttr(lhsIdx);
		Class<?> rhsType = rhsTable.getClassOfAttr(rhsIdx);
		
		// attribute type mismatch
		if(!lhsType.equals(rhsType))
			throw new IllegalArgumentException("comparing attributes of different types");
		else if(lhsType == new Integer(0).getClass()) {
			for(Vector<Object> lrec : lhsTable) {
				for(Vector<Object> rrec : rhsTable) {
					Boolean result = null;
					switch(op) {
					case ">":	result = (Integer)(lrec.get(lhsIdx)) > (Integer)(rrec.get(rhsIdx)); break;
					case "<":	result = (Integer)(lrec.get(lhsIdx)) < (Integer)(rrec.get(rhsIdx)); break;
					case "<>":	result = (Integer)(lrec.get(lhsIdx)) != (Integer)(rrec.get(rhsIdx));break;
					case "=":	result = (Integer)(lrec.get(lhsIdx)) == (Integer)(rrec.get(rhsIdx));break;
					default: throw new IllegalArgumentException("illegal operator in WHERE");
					}
					
					if(result == true) 
				}
			}
		}
		else {
			for(Vector<Object> lrec : lhsTable) {
				for(Vector<Object> rrec : rhsTable) {
					Boolean result = null;
					String l = (String) lrec.get(lhsIdx);
					String r = (String) rrec.get(rhsIdx);
					switch(op) {
					case ">":	result = l.compareTo(r)>0; break;
					case "<":	result = l.compareTo(r)<0; break;
					case "<>":	result = !l.equals(r);	   break;
					case "=":	result = l.equals(r);	   break;
					default: throw new IllegalArgumentException("illegal operator in WHERE");
					}
				}
			}
		}
		
		
		
	}
	
	@Override
	public void run() {
		
		if(op == null)	return;
		
		
	}
	
}
