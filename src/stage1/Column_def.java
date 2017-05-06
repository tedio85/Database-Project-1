package stage1;

public class Column_def {

	public final String column_name;
	public final String type_name;
	public final boolean isPrimaryKey;
	
	Column_def(String column_name, String type_name, boolean isPrimaryKey) {
		this.column_name = column_name;
		this.type_name = type_name;
		this.isPrimaryKey = isPrimaryKey;
	}
	
	public void show() {
		System.out.println();
		System.out.println("column_name: "+column_name);
		System.out.println("type_name: "+type_name);
		System.out.println("isPrimaryKey: "+isPrimaryKey);
		System.out.println();
	}
}
