package stage1;

public class Attribute {
	private String name;
	private Class<?> class_;
	private Integer maxLen=0;
	
	Attribute(String name, Class<?> class_, Integer maxLen) {
		this.name = name;
		this.class_ = class_;
		this.maxLen = maxLen;
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
}
