package stage1;

public class Expr {
	public final boolean isUnary;
	public final Class<?> op1Type;
	public final Class<?> op2Type;
	public final String op1;
	public final String op2;
	public final String operator;
	
	Expr(String op1, Class<?> op1Type) {
		this.isUnary = true;
		this.op1Type = op1Type;
		this.op2Type = null;
		this.op1 = op1;
		this.op2 = "No String exist";
		this.operator = "No operator";
	}
	
	Expr(String op1, Class<?> op1Type, String op2, Class<?> op2Type, String operator) {
		this.isUnary = false;
		this.op1Type = op1Type;
		this.op2Type = op2Type;
		this.op1 = op1;
		this.op2 = op2;
		this.operator = operator;
	}
	
	public void show() {
		System.out.println();
		System.out.println("isUnary: "+isUnary);
		System.out.println("op1Type: "+op1Type);
		System.out.println("op2Type: "+op2Type);
		System.out.println("op1: "+op1);
		System.out.println("operator: "+operator);
		System.out.println("op2: "+op2);
		System.out.println();		
	}
}
