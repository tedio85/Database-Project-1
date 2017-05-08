package stage1;

public class Attribute {
	private String name;
	private Class<?> class_;
	private Integer maxLen=0;
	private String tableBelong;
	
	Attribute() {
		this.name = "no name";
		this.class_ = Exception.class;
		this.maxLen = 0 ;
		this.tableBelong = "no table";
	}
	
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
	
	public void show() {
		System.out.println();		
		System.out.println("name: "+name);
		System.out.println("class "+class_);
		System.out.println("maxLen: "+maxLen);
		System.out.println("tableBelong: "+tableBelong);
		System.out.println();
	}
}
