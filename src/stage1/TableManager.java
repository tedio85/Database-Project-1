package stage1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class TableManager {
	private HashMap<String, VectorTable> TableMap;
	
	/*--------------Constructor-------------------------*/
	
	TableManager() {
		TableMap = new HashMap<String, VectorTable>();
	}
	

	/*-----------------Table Manager Operations--------------------------*/
	
	public void showTable(String tableName) {
		TableMap.get(tableName).show();
	}
	
	public void dumpCSV() {
		for (HashMap.Entry<String, VectorTable> entry : TableMap.entrySet()) {
    	    TableMap.get(entry.getKey()).exportToCSV();
    	}
	}
	
	private int getTableAttrSize(String tableName) {
		//TODO
		return TableMap.get(tableName).getAttrs().size();
	}
	
	private boolean isTableExist(String tableName) {
		return TableMap.containsKey(tableName);
	}
	
	
	/*---------------------Statement Execution-----------------------*/
	
	public void executeStatement(Stmt statement) {
		switch(statement.stmtType) {
		case CREATE_TABLE:  createTableStmt((CreateTableStmt) statement);	break;
		case INSERT:		insertStmt((InsertStmt) statement);		break;
		case SELECT:		selectStmt((SelectStmt) statement);		break;
		default: throw new IllegalArgumentException("No such statement type: "+statement.stmtType);
		}
	}
	
	private void createTableStmt(CreateTableStmt statement) {
		
	}
	
	private void insertStmt(InsertStmt statement) {
		
	}
	
	private void selectStmt(SelectStmt statement) {
		
	}
	
	
	/*--------------------------Table Operations------------------------*/
	
	private void insertTup(String tableName, Vector<Object> tup) {
		//TODO
	}
	
	private void insertTup(String tableName, Vector<String> attrs, Vector<String> tup) {
		//TODO
	}
	
	
	/*--------------------Select Statement Private Functions-----------------*/
	
	private void substituteAllTableAlias(SelectStmt statement) {
		
	}
	
	private void project(List<Result_column> result_column, TempTable tmpTable) {
		
	}
}
