package stage1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class QThread implements Runnable{
	private VectorTable innerTable, outerTable;
	private String innerColName, outerColName;
	private String[] wTable;
	private String op;
	private volatile TempTable tempTable;
	private boolean reverse;

	public QThread(HashMap<String, VectorTable> TableMap, String[] wTable, 
					String[] wColumn, String whe_operator, HashSet<String> selectedTableName) {
		this.wTable = wTable;
		String lhs_column_name = wColumn[0];
		String rhs_column_name = wColumn[1];
		String lhs_table_name = wTable[0];
		String rhs_table_name = wTable[1];
		this.op = whe_operator;
		
		// determine table and match outer and inner columns
		String[] tableNames = (String[]) selectedTableName.toArray(new String[0]);
		if(selectedTableName.size()==2) {
			if(lhs_table_name==null && rhs_table_name==null) {
				outerTable = TableMap.get(tableNames[0]);
				innerTable = TableMap.get(tableNames[1]);
				outerColName = lhs_column_name;
				innerColName = rhs_column_name;
			}
			else if(lhs_table_name==null && rhs_table_name!=null) {
				for(String t : tableNames) {
					if(!t.equals(rhs_table_name))
						outerTable = TableMap.get(t);
				}
				innerTable = TableMap.get(rhs_table_name);
				outerColName = lhs_column_name;
				innerColName = rhs_column_name;
			}
			else if(lhs_table_name!=null && rhs_table_name==null) {
				for(String t : tableNames) {
					if(!t.equals(lhs_table_name))
						innerTable = TableMap.get(t);
				}
				outerTable = TableMap.get(lhs_table_name);
				outerColName = lhs_column_name;
				innerColName = rhs_column_name;
			}
			else {
				outerTable = TableMap.get(lhs_table_name);
				innerTable = TableMap.get(rhs_table_name);
			}
		}
		else {
			outerTable = TableMap.get(tableNames[0]);
			innerTable = new VectorTable();
		}
		// decide reverse
		reverse = outerTable.getName().equals(selectedTableName.toArray(new String[0])[0]);
		
		// match innerCol and outerCol
		outerColName = lhs_column_name;
		innerColName = rhs_column_name;
	}
	
	private VectorTable nestedJoin() {
		
		int innerIdx = -1;
		int outerIdx = -1;
		
		if(innerTable != null)
			tempTable = new TempTable(outerTable.getAttrs(), innerTable.getAttrs(), reverse);
		else
			tempTable = new TempTable(outerTable.getAttrs());
		
		if(wTable[0] != null) {
			outerIdx = outerTable.getIndexOfAttr(outerColName);
		}
		if(wTable[1] != null) {
			innerIdx = innerTable.getIndexOfAttr(innerColName);
		}
		
		Object leval = outerColName;
		Object reval = innerColName;
			
		// attribute type mismatch
		for(Vector<Object> orec : outerTable) {
			boolean inSecondLoop = false;
			for(Vector<Object> irec : innerTable) {
				inSecondLoop = true;
				if(outerIdx != -1)
					leval = orec.get(outerIdx);
				if(innerIdx != -1)
					reval = irec.get(innerIdx);
				if(evaluate(Comparable.class.cast(leval), Comparable.class.cast(reval)) == true) {
					tempTable.insert_(orec, irec);
				}
			}
			if(!inSecondLoop) {
				if(outerIdx != -1)
					leval = orec.get(outerIdx);
				boolean tmp = evaluate(Comparable.class.cast(leval), reval);
				if(tmp == true) {
					tempTable.insert_(orec, null);
				}
			}
		}
		return tempTable;
	}
	
	private boolean evaluate(Object lval, Object rval) {
	
		String l = ((String) lval.toString()).replaceAll("\'", "").replaceAll("\"","");
		String r = null;
		if(rval != null)
			r = ((String) rval.toString()).replaceAll("\'", "").replaceAll("\"","");
		
		// WHERE 0; / WHERE 1; / WHERE ID; Only lval has value
		if(op == null) {
			if(l.matches("0*[1-9]+.*"))
				return true;
			else
				return false;
		}
		
		// check if both operands are integers
		int l2int = -1;
		int r2int = -1;
		boolean trySuccess = false;
		try {
			l2int = Integer.parseInt(l);
			r2int = Integer.parseInt(r);
			trySuccess = true;
		}
		catch(NumberFormatException e) {
			
		}
		
		// integer type comparison
		if(trySuccess == true) {
			switch(op) {
				case ">":	return l2int > r2int; 
				case "<":	return l2int < r2int;
				case "=":	return l == r;
				case "<>":	return l != r;
				default:	throw new IllegalArgumentException("invalid operator in WHERE");
			}
		}
		// WHERE 1>1; / WHERE Salary>1000; / WHERE a.ID = b.ID; (String type)
		else {
			switch(op) {
				case ">":	return l.compareTo(r)>0; 
				case "<":	return l.compareTo(r)<0;
				case "=":	return l.equals(r);
				case "<>":	return !l.equals(r);
				default:	throw new IllegalArgumentException("invalid operator in WHERE");
			}
		}
	}
	
	public TempTable getTempTable() {
		return tempTable;
	}
	
	@Override
	public void run() {
		nestedJoin();
	}
	
}
