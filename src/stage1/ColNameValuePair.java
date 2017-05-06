package stage1;

public class ColNameValuePair {
	public final Class<?> valueType;
	public final String colName;
	public final Object value;
	
	public ColNameValuePair(Class<?> valueType, String colName, String value) {
		this.valueType = valueType;
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
