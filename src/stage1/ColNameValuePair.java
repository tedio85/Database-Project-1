package stage1;

public class ColNameValuePair {
	public final String colName;
	public final String value;
	
	public ColNameValuePair(String colName, String value) {
		this.colName = colName;
		this.value = value;
	}
	
	public void show() {
		System.out.println();
		System.out.println("column_name: "+colName);
		System.out.println("value: "+ value);
		System.out.println();
	}
}
