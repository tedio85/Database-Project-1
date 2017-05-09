package stage1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* process 1 expression in where clause */

public class QThread2 implements Runnable{
	Expr expr;                              // the expression processing
	ArrayList<IndexTable> tableList;        // table(s) which we select from
	int smallerTableIndex;                  // smaller Table means its name is smaller than the other table
	int biggerTableIndex;                   // bigger Table means its name is bigger than the other table
	                                        // ( according to String.compareTo() )
	int tableListNum;                       // size of tableList
	CartesianTempCollection ctc;			// the collection of CartesianTemp
	boolean isWhere;                        // whether there is where clause
	
	public QThread2(Expr expr, ArrayList<IndexTable> tableList, boolean isWhere) {
		this.expr = expr;
		this.tableList = tableList;
		this.tableListNum = tableList.size();
		this.isWhere = isWhere;
		this.ctc = new CartesianTempCollection();
		/* deciding the index of table whether there is only 1 table. */
		if(tableListNum == 1) {
			smallerTableIndex = 0;
			biggerTableIndex = 1;
		}
		/* deciding the index of table according to their name. */
		else { // tableListNum = 2
			if( tableList.get(0).getName().compareTo(tableList.get(1).getName()) < 0 ) {
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
	private Set<Object> evaluate(IndexTable table, String operator, String attr, Object value) {
		/* using expr.attr */
		switch(operator) {
		case ">":
			return table.tailMap(attr, value);
		case "<":
			return table.headMap(attr, value);
		case "<>":
			return table.getAttrNeq(attr, value);
		case "=":
			return table.getAttrEquals(attr, value);
		default:
			throw new IllegalArgumentException("Your operator is wrong");
		}
	}
	
	private ArrayList<CartesianTemp> cartesianProduct(Set<Object> set1, Set<Object> set2) {
		ArrayList<CartesianTemp> result = new ArrayList<CartesianTemp>();
		
		if(tableListNum == 1) {
			for(Object s_object : set1) {
				result.add(new CartesianTemp(s_object, -1));
			}
		} 
		else if(tableListNum == 2) {
			for(Object s_object : set1) {
				for(Object b_object : set2) {
					result.add(new CartesianTemp(s_object, b_object));
				}
			}
		}
		else {
			System.err.println("In QThread: tableListNum wrong " + tableListNum);
		}
		
		return result;
	}
	
	private ArrayList<CartesianTemp> hashSpeedUp(String op1_attr, String op2_attr 
												 ,IndexTable op1Table, IndexTable op2Table, boolean isOp1Smaller){
		// smaller Table on left, bigger on right
		ArrayList<CartesianTemp> result = new ArrayList<CartesianTemp>();
		Set<Object> Set1 = new HashSet<Object>();
		Set<Object> Set2 = new HashSet<Object>();
		Set<Object> smallerSet = new HashSet<Object>();
		Set<Object> biggerSet = new HashSet<Object>();
		
		// loop through 2 tables and put attribute value into 2 set
		for(Map.Entry<Object, Object[]> entry : op1Table.entrySet()) {
			Object[] v = entry.getValue();
			Object attr_value = v[op1Table.getIndexOfAttr(op1_attr)];
			Set1.add(attr_value);
		}
		for(Map.Entry<Object, Object[]> entry : op2Table.entrySet()) {
			Object[] v = entry.getValue();
			Object attr_value = v[op2Table.getIndexOfAttr(op2_attr)];
			Set2.add(attr_value);
		}
		/*--------------------------------------------------*/
		/*
		System.out.println(op1Table.getName()+"."+op1_attr);
		System.out.println(op2Table.getName()+"."+op2_attr);
		System.out.println(Set1.toString());
		System.out.println(Set2.toString());
		*/
		Set<Object> intersection = new HashSet<Object>(Set1); // use the copy constructor
		intersection.retainAll(Set2);
		
		
		System.out.println("intersection size: "+intersection.size());
		//System.out.println(intersection.toString());
		
		/*--------------------------------------------------*/
		
		// op1 Table = op2 Table
		if( op1Table.getName().equalsIgnoreCase( op2Table.getName() ) ) {
			Set<Object> tmp = new HashSet<Object>();
			intersection.forEach( temp -> {
				tmp.addAll(op1Table.getAttrEquals(op1_attr, temp));
				tmp.retainAll(op1Table.getAttrEquals(op2_attr, temp));
			});
			
			if(isOp1Smaller){
				if(tableListNum == 2) biggerSet = tableList.get(biggerTableIndex).keySet();
				smallerSet = tmp;
			}
			else{ 
				smallerSet = tableList.get(smallerTableIndex).keySet();
				biggerSet = tmp;
			}
			
			result = cartesianProduct(smallerSet, biggerSet);
		} 
		else {
			for(Object temp : intersection) {
				Set<Object> op1tmp = new HashSet<Object>();
				Set<Object> op2tmp = new HashSet<Object>();
				op1tmp.addAll(op1Table.getAttrEquals(op1_attr, temp));
				op2tmp.addAll(op2Table.getAttrEquals(op2_attr, temp));
				if(isOp1Smaller)
					result.addAll(cartesianProduct(op1tmp, op2tmp));
				else 
					result.addAll(cartesianProduct(op2tmp, op1tmp));
			}
		}
		
		/*--------------------------------------------------*/
		//System.out.println(smallerSet.toString());
		//System.out.println(biggerSet.toString());
		/*--------------------------------------------------*/
		
		
		
		return result;
	}
	
	private CartesianTempCollection exprProcess() {
		ArrayList<CartesianTemp> result = new ArrayList<CartesianTemp>();
		Set<Object> set1 = new HashSet<Object>();
		Set<Object> set2 = new HashSet<Object>();
		String lname = tableList.get(smallerTableIndex).getName();
		String rname = "";
		
		/* The table we select from may be 1 or 2, which depends on \\tableListNum// */
		
		//  000. whether there is where clause in select statement      Ex:
		//  1st. whether expression is unary.                           Ex: where 1.
		//  2nd. whether there is only one side of op with table name.  Ex: where s.t > 1
		//  3rd. two side of op with table name.                        Ex: where s.t = a.i
		
		if(isWhere == false) {
			set1 = tableList.get(smallerTableIndex).keySet();
			if(tableListNum == 2) {
				set2 = tableList.get(biggerTableIndex).keySet();
				rname = tableList.get(biggerTableIndex).getName();
			}
			result = cartesianProduct(set1, set2);
			
			ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
		}
		else if(expr.isUnary) {
			if(Integer.class.cast(expr.op1_attr_name) != 0) {
				set1 = tableList.get(smallerTableIndex).keySet();
				if(tableListNum == 2) {
					set2 = tableList.get(biggerTableIndex).keySet();
					rname = tableList.get(biggerTableIndex).getName();
				}
				result = cartesianProduct(set1, set2);
			}
			else 
				lname = "";
			ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
		} 
		else if(!expr.op1HasTable_name || !expr.op2HasTable_name) {
			String compared_table_name = "";
			String compared_attr_name = "";
			String attr_value = "";
			int comparingTableIndex, theOtherOne;
			boolean isCpringSmal;
			// deciding which side of expression is constant
			if(expr.op1HasTable_name) {
				compared_table_name = expr.op1_table_name;
				compared_attr_name = expr.op1_attr_name;
				attr_value = expr.op2_attr_name;
			}
			else if(expr.op2HasTable_name) {
				compared_table_name = expr.op2_table_name;
				compared_attr_name = expr.op2_attr_name;
				attr_value = expr.op1_attr_name;
			}

			// deciding which table we are comparing now.
			if(tableList.get(smallerTableIndex).getName().equalsIgnoreCase(compared_table_name)) {
				comparingTableIndex = smallerTableIndex;
				theOtherOne = biggerTableIndex;
				isCpringSmal = true;
			}
			else {
				comparingTableIndex = biggerTableIndex;
				theOtherOne = smallerTableIndex;
				isCpringSmal = false;
			}
			
			set1 = evaluate(tableList.get(comparingTableIndex), expr.operator, compared_attr_name, attr_value);
			if(tableListNum == 2) {
				set2 = tableList.get(theOtherOne).keySet();
				rname = tableList.get(biggerTableIndex).getName();
			}
			
			System.out.println("set1.size()= "+ set1.size());
			System.out.println("set2.size()= "+ set2.size());
			
			if(isCpringSmal)
				result = cartesianProduct(set1, set2);
			else 
				result = cartesianProduct(set2, set1);
			
			ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
		} 
		else {
			int op1Index = -1, op2Index = -1;
			int theOtherIndex = -1;
			boolean op1IsSmaller;
			//System.out.println(expr.op1_table_name);
			//System.out.println(expr.op2_table_name);
			if(!expr.op1_table_name.equalsIgnoreCase(expr.op2_table_name)) {
				if( expr.op1_table_name.equalsIgnoreCase( tableList.get(smallerTableIndex).getName() ) ) {
					op1Index = smallerTableIndex;
					op2Index = biggerTableIndex;
					op1IsSmaller = true;
				}
				else {
					op1Index = biggerTableIndex;
					op2Index = smallerTableIndex;
					op1IsSmaller = false;
				}
			}
			else { // expr1 table name = expr2 table name 
				if(expr.op1_table_name.equalsIgnoreCase( tableList.get(smallerTableIndex).getName() )) {
					op1Index = smallerTableIndex;
					op2Index = smallerTableIndex;
					theOtherIndex = biggerTableIndex;
					op1IsSmaller = true;
				}
				else {
					op1Index = biggerTableIndex;
					op2Index = biggerTableIndex;
					theOtherIndex = smallerTableIndex;
					op1IsSmaller = false;
				}
			}
			
			IndexTable op1Table = tableList.get(op1Index);
			IndexTable op2Table = tableList.get(op2Index);
			// if operator is "=", use hash to speed up
			if(expr.operator.equals("=")) {
				result = hashSpeedUp(expr.op1_attr_name, expr.op2_attr_name, op1Table, op2Table, op1IsSmaller);
				if(tableListNum == 2) rname = tableList.get(biggerTableIndex).getName();
				ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
			} 
			else {
				if(expr.op1_table_name != expr.op2_table_name) {
					for(Map.Entry<Object, Object[]> entry : op2Table.entrySet()) {
						Object[] v = entry.getValue();
						Object attr_value = v[op2Table.getIndexOfAttr(expr.op2_attr_name)];
						set1 = evaluate(op1Table, expr.operator, expr.op1_attr_name, attr_value);
						set2 = new HashSet<Object>();
						rname = tableList.get(biggerTableIndex).getName();
						set2.add(attr_value);
						if(op1IsSmaller) {
							result.addAll(cartesianProduct(set1, set2));
							ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
						}
						else {
							result.addAll(cartesianProduct(set2, set1));
							ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
						}
					}
				}
				else { // expr1 table name = expr2 table name 
					for(Map.Entry<Object, Object[]> entry : op1Table.entrySet()) {
						Object[] v = entry.getValue();
						Object op1value = v[op1Table.getIndexOfAttr(expr.op1_attr_name)];
						Object op2value = v[op1Table.getIndexOfAttr(expr.op2_attr_name)];
						if(expr.operator.equals(">")) {
							if(op1value.toString().compareTo(op2value.toString()) > 0) {
								set1.add( v[op1Table.getIndexOfAttr(op1Table.getPrimaryKey())] );
							}
						} 
						else if(expr.operator.equals("<")) {
							if(op1value.toString().compareTo(op2value.toString()) < 0) {
								set1.add( v[op1Table.getIndexOfAttr(op1Table.getPrimaryKey())] );
							}	
						}
					}
					if(tableListNum == 2) {
						set2 = tableList.get(theOtherIndex).keySet();
						rname = tableList.get(biggerTableIndex).getName();
					}
					if(op1IsSmaller) {
						result.addAll(cartesianProduct(set1, set2));
						ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
					}
					else {
						result.addAll(cartesianProduct(set2, set1));
						ctc = new CartesianTempCollection(result, tableListNum == 1, lname, rname);
					}
				}
			}
			
		}
		
		return ctc;
	}
	
	public CartesianTempCollection getCartesianTempCollection(){
		return ctc;
	}
	
	@Override
	public void run() {
		exprProcess();
	}

}
