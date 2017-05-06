package stage1;

import java.util.ArrayList;

public class CreateTableStmt extends Stmt {
	private String table_name;
	private ArrayList<Column_def> column_defs = new ArrayList<Column_def>();
	
	CreateTableStmt() {
		stmtType = StmtType.CREATE_TABLE;
	}
	
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	
	public String getTable_name() {
		return table_name;
	}
	
	public ArrayList<Column_def> getColumn_defs() {
		return column_defs;
	}
	
	public void addColumn_def(Column_def cd) {
		column_defs.add(cd);
	}
	
	public void show() {
		System.out.println();
		System.out.println("table_name: "+table_name);
		for(Column_def cd : column_defs) {
			cd.show();
		}
		System.out.println();
	}
		
}
