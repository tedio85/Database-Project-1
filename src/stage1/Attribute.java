package stage1;

public class Attribute {
	private String name;
	private Class<?> class_;
	private Integer maxLen=0;
	private String tableBelong;
	
	Attribute(String name, Class<?> class_, Integer maxLen, String tableBelong) {
		this.name = name;
		this.class_ = class_;
		this.maxLen = maxLen;
		this.tableBelong = tableBelong;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Class<?> getClass_() {
		return this.class_;
	}
	
	public Integer getMaxLen() {
		return this.maxLen;
	}
	
	public String getTableBelong() {
		return tableBelong;
	}
}
