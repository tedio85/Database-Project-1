package stage1;

public class Varchar {
	private String str = null;
	private int maxLength = 0;
	public Class<?> TYPE = this.getClass();
	
	public Varchar() {
		
	}
	
	public Varchar(String str, int maxLength) {
		this.str = str;
		this.maxLength = maxLength;
	}
	
	public String getString() {
		return this.str;
	}
	
	public int getLength() {
		return this.maxLength;
	}
	
}
