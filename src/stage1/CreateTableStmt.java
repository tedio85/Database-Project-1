package stage1;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateTableStmt extends Stmt implements Serializable, Comparable<CreateTableStmt>{
	
	private static final long serialVersionUID = 3079856025586162270L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((column_defs == null) ? 0 : column_defs.hashCode());
		result = prime * result + ((table_name == null) ? 0 : table_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateTableStmt other = (CreateTableStmt) obj;
		if (column_defs == null) {
			if (other.column_defs != null)
				return false;
		} else if (!column_defs.equals(other.column_defs))
			return false;
		if (table_name == null) {
			if (other.table_name != null)
				return false;
		} else if (!table_name.equals(other.table_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(CreateTableStmt o) {
		return this.table_name.compareTo(o.getTable_name());
	}
	
	
}
