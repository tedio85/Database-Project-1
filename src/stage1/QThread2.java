package stage1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/* process 1 expression in where clause */

public class QThread2 implements Runnable{
	Expr expr;                              // the expression processing
	ArrayList<VectorTable> tableList;       // table(s) which we select from
	int smallerTableIndex;                  // smaller Table means its name is smaller than the other table
	int biggerTableIndex;                   // bigger Table means its name is bigger than the other table
	                                        // ( according to String.compareTo() )
	int tableListNum;                       // size of tableList
	
	public QThread2(Expr expr, ArrayList<VectorTable> tableList) {
		this.expr = expr;
		this.tableList = tableList;
		this.tableListNum = tableList.size();
		/* deciding the index of table whether there is only 1 talbe. */
		if(tableList.size() == 1) {
			smallerTableIndex = 0;
			biggerTableIndex = 1;
		}
		/* deciding the index of table according to their name. */
		else {
			if( tableList.get(0).getName().compareTo(tableList.get(1).getName()) > 0 ) {
				smallerTableIndex = 0;
				biggerTableIndex = 1;
			}
			else {
				smallerTableIndex = 1;
				biggerTableIndex = 0;
			}
		}
	}
	/**
	 * 
	 * @param table           the table we want to do sub-map.
	 * @param operator        the operator we are using.
	 * @param attr            the attribute in table we compare with.
	 * @param value           the value we used to compare with attr.
	 * @return
	 */
	private Set<Object> evaluate(VectorTable table, String operator, String attr, Object value) {
		/* using expr.attr */
		switch(operator) {
		case ">":
			return table.???();
			break;
		case "<":
			return table.???();
			break;
		case "=":
			return table.???();
			break;
		default:
			System.out.println("QThread2 operator wrong!");
			break;
		}
			
	}
	
	private ArrayList<CartesianTemp> cartesianProduct(Set<Object> set1, Set<Object> set2){
		ArrayList<CartesianTemp> result = new ArrayList<CartesianTemp>();
		Object[] s_array = set1.toArray();
		
		if(tableListNum == 1) {
			for(int i = 0; i < s_array.length; i++) {
				CartesianTemp tmp = new CartesianTemp(s_array[i], -1);
				result.add(tmp);
			}
		} 
		else if(tableListNum == 2){
			Object[] b_array = set2.toArray();
			for(int i = 0; i < s_array.length; i++) {
				for(int j = 0; j < b_array.length; j++) {
					CartesianTemp tmp = new CartesianTemp(s_array[i], b_array[j]);
					result.add(tmp);
				}
			}
		}
		else {
			System.err.println("In QThread: tableListNum wrong " + tableListNum);
		}
		
		return result;
	}
	
	private ArrayList<CartesianTemp> exprProcess() {
		ArrayList<CartesianTemp> result = new ArrayList<CartesianTemp>();
		Set<Object> smallerName = new HashSet<Object>();
		Set<Object> biggerName = new HashSet<Object>();
		
		//  1st. whether expression is unary.                           Ex: where 1.
		//  2nd. whether there is only one side of op with table name.  Ex: where s.t > 1
		//  3rd. two side of op with table name.                        Ex: where s.t = a.i
		if(expr.isUnary) {
			if(Integer.class.cast(expr.op1_attr_name) != 0) {
				smallerName = tableList.get(smallerTableIndex).???;
				biggerName = tableList.get(biggerTableIndex).???;
				result = cartesianProduct(smallerName, biggerName);
			}
		} 
		else if(!expr.op1HasTable_name || !expr.op2HasTable_name){
			String compared_attr_name;
			String attr_value;
			if(expr.op1HasTable_name) {
				compared_attr_name = expr.op1_attr_name;
				attr_value = expr.op2_attr_name;
			}
			else if(expr.op2HasTable_name) {
				compared_attr_name = expr.op2_attr_name;
				attr_value = expr.op1_attr_name;
			}
			smallerName = evaluate(tableList.get(smallerTableIndex), expr.operator, compared_attr_name, attr_value);
			biggerName = tableList.get(biggerTableIndex).???;
			result = cartesianProduct(smallerName, biggerName);
		} else {
			int op1Index, op2Index;
			boolean op1IsSmaller;
			if( expr.op1_table_name.equals( tableList.get(smallerTableIndex) ) ) {
				op1Index = biggerTableIndex;
				op2Index = smallerTableIndex;
				op1IsSmaller = true;
			}
			else {
				op1Index = smallerTableIndex;
				op2Index = biggerTableIndex;
				op1IsSmaller = false;
			}
			VectorTable op1Table = tableList.get(op1Index);
			for(Vector<Object> v : op1Table) {
				Object attr_value = v.get(op1Table.getIndexOfAttr(expr.op1_attr_name));
				Set<Object> set1 = evaluate(tableList.get(op2Index), expr.operator, expr.op2_attr_name, attr_value);
				Object[] set1_array = set1.toArray();
				for(int i=0; i < set1_array.length; i++) {
					Set<Object> set2 = new HashSet<Object>();
					set2.add(set1_array);
					if(op1IsSmaller) {
						result.addAll(cartesianProduct(set1, set2));
					}
					else {
						result.addAll(cartesianProduct(set2, set1));
					}
				}
			}
		}
		
		return result;
	}
	
	@Override
	public void run() {
		exprProcess();
	}

}
