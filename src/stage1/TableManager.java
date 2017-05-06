package stage1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.mapdb.DB;

public class TableManager {
	private TreeMap<String, VectorTable> tableMap;
	DB db;
	/*--------------Constructor-------------------------*/
	
	TableManager(DB db) {
		tableMap = new TreeMap<String, VectorTable>(String.CASE_INSENSITIVE_ORDER);
		this.db = db;
	}
	

	/*-----------------Table Manager Operations--------------------------*/
	
	public void showTable(String tableName) {
		try {
			tableMap.get(tableName).show();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void dumpCSV() {
		for (HashMap.Entry<String, VectorTable> entry : tableMap.entrySet()) {
    	    tableMap.get(entry.getKey()).exportToCSV();
    	}
	}
	
	private int getTableAttrSize(String tableName) {
		//TODO
		return tableMap.get(tableName).getAttrs().size();
	}
	
	private boolean isTableExist(String tableName) {
		return tableMap.containsKey(tableName);
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
		if(!isTableExist(statement.getTable_name())) {
			try {
				VectorTable v = new VectorTable(db, statement);
				tableMap.put(v.getName(), v);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
			throw new IllegalArgumentException("table "+statement.getTable_name()+" already exists");
	}
	
	private void insertStmt(InsertStmt statement) {
		String tableName = statement.getTable_name();
		VectorTable v = tableMap.get(tableName);
		if(v == null)
			throw new NullPointerException("table "+tableName+" does not exist");
		try {
			v.insert(statement);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void selectStmt(SelectStmt statement) {
		SelectStmt processedStatement = substituteAllTableAlias(statement);
		processedStatement = matchAllAttrName(processedStatement);
		processedStatement.show();
		
		/*----------------------codes below are untested-------------------*/
		
	}
	
	
	/*--------------------Select Statement Private Functions-----------------*/
	
	private SelectStmt substituteAllTableAlias(SelectStmt statement) {
		
		// create map: alias -> real name
		Map<String, String> aliasToReal = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		for(Table_or_subquery tos : statement.getTable_or_subquery()) {
			aliasToReal.put(tos.table_alias, tos.table_name);
		}
			
		// substitute alias table name in result column
		for(Result_column rc : statement.getResult_column()) {
			if(rc.hasTable_name) {
				String real = substituteHelper(aliasToReal, rc.table_name);
				rc.setTable_name(real, true);
			}
		}

		// substitute alias table name in expression
		for(Expr e : statement.getExpr()) {
			if(e.op1HasTable_name) {
				String real = substituteHelper(aliasToReal, e.op1_table_name);
				e.setOp1_table_name(real);
			}
			if(e.op2HasTable_name) {
				String real = substituteHelper(aliasToReal, e.op1_table_name);
				e.setOp2_table_name(real);
			}
		}
		
		return statement;
	}
	
	private String substituteHelper(Map<String, String> aliasToReal, String tableName) {
		if(aliasToReal.containsKey(tableName))	// encounter table alias
			return aliasToReal.get(tableName);
		else if(aliasToReal.containsValue(tableName))	// encounter real name
			 return tableName;
		else
			throw new IllegalArgumentException("No such table name "+tableName);
	}
	
	private SelectStmt matchAllAttrName(SelectStmt statement) {
		
		// selected tables
		Set<String> selectedTables = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		statement.getTable_or_subquery().forEach(t -> selectedTables.add(t.table_name));
		
		// process result column
		for(Result_column rc : statement.getResult_column()) {
			if(rc.hasTable_name)
				matchHelper_matchAttrTable(rc.attr_name, rc.table_name);
			else {
				if(!rc.isSingleStar) {
					try {
						String tableName = matchHelper_findAttrTable(rc.attr_name, selectedTables);
						rc.setTable_name(tableName, true);
					}
					catch(IllegalArgumentException e) {
						e.printStackTrace();
					}
				}
			}
		}

		// process expression
		for(Expr e : statement.getExpr()) {
			if(e.op1HasTable_name)
				matchHelper_matchAttrTable(e.op1_table_name, e.op1_table_name);				
			else {
				if(e.op1Type.equals(Object.class)) {
					try {
						String tableName = matchHelper_findAttrTable(e.op1_attr_name, selectedTables);
						e.setOp1_table_name(tableName);
					}
					catch(IllegalArgumentException ex) {
						ex.printStackTrace();
					}
				}
			}
			if(e.op2HasTable_name)
				matchHelper_matchAttrTable(e.op2_table_name, e.op2_table_name);
			else {
				if(e.op2Type.equals(Object.class)) {
					try {
						String tableName = matchHelper_findAttrTable(e.op2_attr_name, selectedTables);
						e.setOp2_table_name(tableName);
					}
					catch(IllegalArgumentException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		return statement;
	}
	
	private void matchHelper_matchAttrTable(String attrName, String tableName) {
		if(!tableMap.containsKey(tableName))
			throw new IllegalArgumentException("Table "+tableName+" does not exist");
		VectorTable t = tableMap.get(tableName);
		Set<String> attrSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		t.getAttrs().forEach(attr -> attrSet.add(attr.getName()));
		if(!attrSet.contains(attrName))
			throw new IllegalArgumentException("Table "+tableName+" does not contain attribute "+attrName);			
	}
	
	private String matchHelper_findAttrTable(String attrName, Set<String> selectedTables) {
		Set<String> tableSet = new TreeSet<String>();
		for(String s : selectedTables) {
			VectorTable t = tableMap.get(s);
			Set<String> attrSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
			t.getAttrs().forEach(attr -> attrSet.add(attr.getName()));
			if(attrSet.contains(attrName))
				tableSet.add(s);
		}
		if(tableSet.size()>1)
			throw new IllegalArgumentException("ambiguous attribute name");
		else if(tableSet.size() == 0)
			throw new IllegalArgumentException("no attribute name: "+attrName);			
		return tableSet.toArray(new String[10])[0];
	}
	
	private void project(List<Result_column> result_column, TempTable tmpTable) {
		
	}
}
