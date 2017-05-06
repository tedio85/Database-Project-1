package stage1;

public class Table_or_subquery {
	public final boolean hasTable_alias;
	public final String table_name;
	public final String table_alias;
	
	Table_or_subquery(boolean hasTable_alias, String table_name, String table_alias) {
		this.hasTable_alias = hasTable_alias;
		this.table_name = table_name;
		if(hasTable_alias)
			this.table_alias = table_alias;
		else
			this.table_alias = "No table_alias";
	}
	
	public void show() {
		System.out.println();
		System.out.println("hasTable_alias: "+hasTable_alias);
		System.out.println("table_name: "+table_name);
		System.out.println("table_alias: "+table_alias);
		System.out.println();
	}
}
