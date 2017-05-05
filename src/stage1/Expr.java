package stage1;

import java.util.Arrays;
import java.util.List;

public class Expr {
	public final boolean isUnary;
	public final boolean op1HasTable_name;
	public final boolean op2HasTable_name;
	public final Class<?> op1Type;
	public final Class<?> op2Type;
	public String op1_table_name;
	public String op2_table_name;
	public final String op1_attr_name;
	public final String op2_attr_name;
	public final String operator;
	
	Expr(String op1, Class<?> op1Type) {
		this.isUnary = true;
		this.op1Type = op1Type;
		this.op2Type = Exception.class;
		if(op1Type.equals(Object.class)) {
			this.op1HasTable_name = hasTable_name(op1);
			this.op1_table_name = getTable_name(op1);
			this.op1_attr_name = getAttr_name(op1);
		}
		else {
			this.op1HasTable_name = false;
			this.op1_table_name = "No table_name";
			this.op1_attr_name = op1;
		}
		this.op2HasTable_name = false;
		this.op2_table_name = "No table_name";
		this.op2_attr_name = "No attr_name";
		this.operator = "No operator";
	}
	
	Expr(String op1, Class<?> op1Type, String op2, Class<?> op2Type, String operator) {
		this.isUnary = false;
		this.op1Type = op1Type;
		this.op2Type = op2Type;
		
		if(op1Type.equals(Object.class)) {
			this.op1HasTable_name = hasTable_name(op1);
			this.op1_table_name = getTable_name(op1);
			this.op1_attr_name = getAttr_name(op1);
		}
		else {
			this.op1HasTable_name = false;
			this.op1_table_name = "No table_name";
			this.op1_attr_name = op1;
		}
		
		if(op2Type.equals(Object.class)) {
			this.op2HasTable_name = hasTable_name(op2);
			this.op2_table_name = getTable_name(op2);
			this.op2_attr_name = getAttr_name(op2);
		}
		else {
			this.op2HasTable_name = false;
			this.op2_table_name = "No table_name";
			this.op2_attr_name = op2;
		}
		
		this.operator = operator;
	}

	public void setOp1_table_name(String table_name) {
		changeTable_name(table_name, 1);
	}
	
	public void setOp2_table_name(String table_name) {
		changeTable_name(table_name, 2);
	}
	
	private void changeTable_name(String name, int opNum) {
		if(opNum == 1)
			op1_table_name = name;
		else
			op2_table_name = name;
	}
	
	public void show() {
		System.out.println();
		System.out.println("isUnary: "+isUnary);
		System.out.println("op1Type: "+op1Type);
		System.out.println("op2Type: "+op2Type);
		System.out.println("op1HasTable_name: "+op1HasTable_name);
		System.out.println("op1_table_name: "+op1_table_name);
		System.out.println("op1_attr_name: "+op1_attr_name);
		System.out.println("operator: "+operator);
		System.out.println("op2HasTable_name: "+op2HasTable_name);
		System.out.println("op2_table_name: "+op2_table_name);
		System.out.println("op2_attr_name: "+op2_attr_name);
		System.out.println();		
	}
	
	private boolean hasTable_name(String op) {
		List<String> split = Arrays.asList(op.split("\\."));
		return split.size() == 2;	
	}
	
	private String getTable_name(String op) {
		if(hasTable_name(op))
			return op.split("\\.")[0];
		else
			return "No table_name";
	}
	
	private String getAttr_name(String op) {
		if(hasTable_name(op))
			return op.split("\\.")[1];
		else
			return op.split("\\.")[0];
	}
}
