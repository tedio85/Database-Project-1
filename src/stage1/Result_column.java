package stage1;

public class Result_column {
	public boolean isSingleStar;
	public boolean hasFunc_name;
	public boolean hasTable_name;
	public String func_name;
	public String table_name;
	public String attr_name;
	
	public Result_column() {
		this.isSingleStar = false;
		this.hasFunc_name = false;
		this.hasTable_name = false;
		this.func_name = "No func_name";
		this.table_name = "No table_name";
		this.attr_name = "No attr_name";
	}
	
	public void isSingleStar() {
		this.isSingleStar = true;
		this.hasFunc_name = false;
		this.hasTable_name = false;
		this.func_name = "No func_name";
		this.table_name = "No table_name";
		this.attr_name = "No attr_name";
	}
	
	public void setFunc_name(String func_name, boolean hasFunc_name) {
		this.hasFunc_name = hasFunc_name;
		if(hasFunc_name)
			this.func_name = func_name;
		else
			this.func_name = "No func_name";
	}
	
	public void setTable_name(String table_name, boolean hasTable_name) {
		this.hasTable_name = hasTable_name;
		if(hasTable_name)
			this.table_name = table_name;
		else
			this.table_name = "No table_name";
	}
	
	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}
	
	public void show() {
		System.out.println();
		System.out.println("isSingleStar: "+isSingleStar);
		System.out.println("hasFunc_name: "+hasFunc_name);
		System.out.println("hasTable_name: "+hasTable_name);
		System.out.println("func_name: "+func_name);
		System.out.println("table_name: "+table_name);
		System.out.println("attr_name: "+attr_name);
		System.out.println();
	}
}
