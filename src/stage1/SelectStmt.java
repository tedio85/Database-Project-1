package stage1;

import java.util.ArrayList;

public class SelectStmt extends Stmt{
	
	private ArrayList<Result_column> result_column = new ArrayList<Result_column>();
	private ArrayList<Table_or_subquery> table_or_subquery = new ArrayList<Table_or_subquery>();
	
	
	SelectStmt() {
		stmtType = StmtType.SELECT;
	}
	
	public void addResult_column(Result_column rc) {
		result_column.add(rc);
	}
	
	public ArrayList<Result_column> getResult_column() {
		return this.result_column;
	}
	
	public void addTable_or_subquery(Table_or_subquery tos) {
		table_or_subquery.add(tos);
	}
	
	public ArrayList<Table_or_subquery> getTable_or_subquery() {
		return this.table_or_subquery;
	}

}
