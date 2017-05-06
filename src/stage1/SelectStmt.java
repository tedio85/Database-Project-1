package stage1;

import java.util.ArrayList;

public class SelectStmt extends Stmt{
	
	private int exprCount;
	private ArrayList<Result_column> result_column = new ArrayList<Result_column>();
	private ArrayList<Table_or_subquery> table_or_subquery = new ArrayList<Table_or_subquery>();
	private ArrayList<Expr> expr = new ArrayList<Expr>();
	private String booleanOperator;
	
	SelectStmt() {
		stmtType = StmtType.SELECT;
		booleanOperator = "No Operator";
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

	public void addExpr(Expr e) {
		expr.add(e);
		exprCount = expr.size();
	}
	
	public ArrayList<Expr> getExpr() {
		return this.expr;
	}
	
	public void setBooleanOperator(String op) {
		this.booleanOperator = op;
	}
	
	public String getBooleanOperator() {
		return booleanOperator;
	}
	
	public int getExprCount() {
		return this.exprCount;
	}
	
	public void show() {
		System.out.println();
		System.out.println("exprCount: "+exprCount);
		for(Result_column rc : result_column)
			rc.show();
		for(Table_or_subquery tos : table_or_subquery)
			tos.show();
		for(Expr e : expr) 
			e.show();
		System.out.println("booleanOperator: "+booleanOperator);
		System.out.println();		
	}
}
