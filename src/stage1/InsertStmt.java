package stage1;

import java.util.ArrayList;

public class InsertStmt extends Stmt{
	private String table_name;
	private boolean usingDefaultAttrOrder;
	private ArrayList<ColNameValuePair> colNameValuePair = new ArrayList<ColNameValuePair>();
	
	InsertStmt() {
		stmtType = StmtType.INSERT;
		usingDefaultAttrOrder = false;
	}
	
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	
	public String getTable_name() {
		return table_name;
	}
	
	public void addNameValuePair(ColNameValuePair cnvp) {
		colNameValuePair.add(cnvp);
	}
	
	public ArrayList<ColNameValuePair> getNameValuePair() {
		return colNameValuePair;
	}
	
	public void setUsingDefaultAttrOrder(boolean usingDefaultAttrOrder) {
		this.usingDefaultAttrOrder = usingDefaultAttrOrder;
	}
	
	public boolean isUsingDefaultAttrOrder() {
		return usingDefaultAttrOrder;
	}
	
	public void show() {
		System.out.println();
		System.out.println("table_name: "+table_name);
		System.out.println("use default attribute order: "+ usingDefaultAttrOrder);
		for(ColNameValuePair cnvp : colNameValuePair) {
			cnvp.show();
		}
		System.out.println();
	}
}
