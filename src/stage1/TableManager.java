package stage1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.mapdb.DB;

public class TableManager {
	private int PARALLEL_THRESHOLD = 1000;
	private TreeMap<String, IndexTable> tableMap;
	DB db;
	/*--------------Constructor-------------------------*/
	
	TableManager(DB db) {
		tableMap = new TreeMap<String, IndexTable>(String.CASE_INSENSITIVE_ORDER);
		this.db = db;
	}
	

	/*-----------------Table Manager Operations--------------------------*/
	
	public void showTable(String tableName) {
		try {
			tableMap.get(tableName).show();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void dumpCSV() {
		for (HashMap.Entry<String, IndexTable> entry : tableMap.entrySet()) {
    	    tableMap.get(entry.getKey()).exportToCSV();
    	}
	}
	
	private boolean isTableExist(String tableName) {
		return tableMap.containsKey(tableName);
	}
	
	
	/*---------------------Statement Execution-----------------------*/
	
	public void executeStatement(Stmt statement) {
		try {
			switch(statement.stmtType) {
			case CREATE_TABLE:  createTableStmt((CreateTableStmt) statement);	break;
			case INSERT:		insertStmt((InsertStmt) statement);		break;
			case SELECT:		selectStmt((SelectStmt) statement);		break;
			default: throw new IllegalArgumentException("No such statement type: "+statement.stmtType); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createTableStmt(CreateTableStmt statement) throws IllegalArgumentException{
		if(!isTableExist(statement.getTable_name())) {
			try {
				IndexTable v = new IndexTable(db, statement);
				tableMap.put(v.getName(), v);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
			throw new IllegalArgumentException("table "+statement.getTable_name()+" already exists");
	}
	
	private void insertStmt(InsertStmt statement) {
		String tableName = statement.getTable_name();
		IndexTable v = tableMap.get(tableName);
		if(v == null)
			throw new NullPointerException("table "+tableName+" does not exist");
		try {
			v.insert(statement);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void selectStmt(SelectStmt statement) throws Exception{
		//statement.show();
		SelectStmt processedStatement = substituteAllTableAlias(statement);
		//processedStatement.show();
		processedStatement = matchAllAttrName(processedStatement);
		//processedStatement.show();
		
		/*----------------------codes below are untested-------------------*/

		ArrayList<IndexTable> tableList = new ArrayList<IndexTable>();
		processedStatement.getTable_or_subquery().forEach( (temp) -> {
			tableList.add( tableMap.get(temp.table_name) );
		});
		
		if(processedStatement.getExprCount() < 2) {
			QThread2 q = null;
			if(processedStatement.getExprCount() == 1)
				q = new QThread2(processedStatement.getExpr().get(0), tableList, true);
			else
				q = new QThread2(null , tableList, false);
			
			Thread t = new Thread(q);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CartesianTempCollection ctc = q.getCartesianTempCollection();
			project(processedStatement, ctc);
		}
		else if(processedStatement.getExprCount() == 2) {
			QThread2 q0 = new QThread2(processedStatement.getExpr().get(0), tableList, true);
			QThread2 q1 = new QThread2(processedStatement.getExpr().get(1), tableList, true);
			Thread t0 = new Thread(q0);
			Thread t1 = new Thread(q1);
			t0.start();
			t1.start();
			try {
				t0.join();
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CartesianTempCollection ctc0 = q0.getCartesianTempCollection();
			CartesianTempCollection ctc1 = q1.getCartesianTempCollection();
			
			if(statement.getBooleanOperator().equalsIgnoreCase("AND"))
				project(processedStatement, operationAND(ctc0, ctc1));
			else
				project(processedStatement, operationOR(ctc0, ctc1));
		}	
	}
	
	
	/*--------------------Select Statement Private Functions-----------------*/
	
	private SelectStmt substituteAllTableAlias(SelectStmt statement) {
		
		// create map: alias -> real name
		Map<String, String> aliasToReal = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		for(Table_or_subquery tos : statement.getTable_or_subquery()) {
			aliasToReal.put(tos.table_alias, tos.table_name);
		}
			
		// substitute alias table name in result column
		for(Result_column rc : statement.getResult_column()) {
			if(rc.hasTable_name) {
				String real = substituteHelper(aliasToReal, rc.table_name);
				rc.setTable_name(real, true);
			}
		}

		// substitute alias table name in expression
		for(Expr e : statement.getExpr()) {
			if(e.op1HasTable_name) {
				String real = substituteHelper(aliasToReal, e.op1_table_name);
				e.setOp1_table_name(real);
			}
			if(e.op2HasTable_name) {
				String real = substituteHelper(aliasToReal, e.op2_table_name);
				e.setOp2_table_name(real);
			}
		}
		
		return statement;
	}
	
	private String substituteHelper(Map<String, String> aliasToReal, String tableName) {
		if(aliasToReal.containsKey(tableName))	// encounter table alias
			return aliasToReal.get(tableName);
		else if(aliasToReal.containsValue(tableName))	// encounter real name
			 return tableName;
		else
			throw new IllegalArgumentException("No such table name "+tableName);
	}
	
	private SelectStmt matchAllAttrName(SelectStmt statement) {
		
		// selected tables
		Set<String> selectedTables = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		statement.getTable_or_subquery().forEach(t -> selectedTables.add(t.table_name));
		
		// process result column
		for(Result_column rc : statement.getResult_column()) {
			if(rc.hasTable_name)
				matchHelper_matchAttrTable(rc.attr_name, rc.table_name);
			else {
				if(!rc.isSingleStar) {
					try {
						String tableName = matchHelper_findAttrTable(rc.attr_name, selectedTables);
						rc.setTable_name(tableName, true);
					}
					catch(IllegalArgumentException e) {
						e.printStackTrace();
					}
				}
			}
		}

		// process expression
		for(Expr e : statement.getExpr()) {
			if(e.op1HasTable_name)
				matchHelper_matchAttrTable(e.op1_attr_name, e.op1_table_name);				
			else {
				if(e.op1Type.equals(Object.class)) {
					try {
						String tableName = matchHelper_findAttrTable(e.op1_attr_name, selectedTables);
						e.setOp1_table_name(tableName);
					}
					catch(IllegalArgumentException ex) {
						ex.printStackTrace();
					}
				}
			}
			if(e.op2HasTable_name)
				matchHelper_matchAttrTable(e.op2_attr_name, e.op2_table_name);
			else {
				if(e.op2Type.equals(Object.class)) {
					try {
						String tableName = matchHelper_findAttrTable(e.op2_attr_name, selectedTables);
						e.setOp2_table_name(tableName);
					}
					catch(IllegalArgumentException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		return statement;
	}
	
	private void matchHelper_matchAttrTable(String attrName, String tableName) {
		if(attrName.equals("*"))
			return;
		if(!tableMap.containsKey(tableName))
			throw new IllegalArgumentException("Table "+tableName+" does not exist");
		IndexTable t = tableMap.get(tableName);
		Set<String> attrSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		t.getAttrs().forEach(attr -> attrSet.add(attr.getName()));
		if(!attrSet.contains(attrName))
			throw new IllegalArgumentException("Table "+tableName+" does not contain attribute "+attrName);			
	}
	
	private String matchHelper_findAttrTable(String attrName, Set<String> selectedTables) {
		if(attrName.equals("*"))
			return "No Table_name";
		Set<String> tableSet = new TreeSet<String>();
		for(String s : selectedTables) {
			IndexTable t = tableMap.get(s);
			Set<String> attrSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
			t.getAttrs().forEach(attr -> attrSet.add(attr.getName()));
			if(attrSet.contains(attrName))
				tableSet.add(s);
		}
		if(tableSet.size()>1)
			throw new IllegalArgumentException("ambiguous attribute name");
		else if(tableSet.size() == 0)
			throw new IllegalArgumentException("no attribute name: "+attrName);			
		return tableSet.toArray(new String[10])[0];
	}
	
	private CartesianTempCollection operationOR(CartesianTempCollection cart1, CartesianTempCollection cart2) {
		
		ArrayList<CartesianTemp> list = new ArrayList<CartesianTemp>();
		HashSet<CartesianTemp> s = new HashSet<CartesianTemp>();
		s = operationHelper(s, cart1);
		s = operationHelper(s, cart2);
		CartesianTemp[] o = s.toArray(new CartesianTemp[s.size()]);
		for(CartesianTemp c : o) {
			list.add(c);
		}
		
		if(cart1.isSingleTable() && cart2.isSingleTable())
			return new CartesianTempCollection(list, false, cart1.getLeftTableName(), cart1.getRightTableName());
		else
			return new CartesianTempCollection(list, true, cart1.getLeftTableName(), cart1.getRightTableName());
	} 
	
	private CartesianTempCollection operationAND(CartesianTempCollection cart1, CartesianTempCollection cart2) {
		
		ArrayList<CartesianTemp> list = new ArrayList<CartesianTemp>();
		HashSet<CartesianTemp> s = new HashSet<CartesianTemp>();
		boolean usesCart1 = true;
		
		if(cart1.getCartesianTempList().size() > cart2.getCartesianTempList().size()) {
			s = operationHelper(s, cart2);
			usesCart1 = false;
		}
		else {
			s = operationHelper(s, cart1);
			usesCart1 = true;
		}
				
		if(usesCart1) {
			for(CartesianTemp c : cart2.getCartesianTempList()) {
				if(s.contains(c)) {
					list.add(c);
				}
			}
		}
		else {
			for(CartesianTemp c : cart1.getCartesianTempList()) {
				if(s.contains(c))
					list.add(c);
			}
		}
		if(cart1.isSingleTable() && cart2.isSingleTable())
			return new CartesianTempCollection(list, true, cart1.getLeftTableName(), cart1.getRightTableName());
		else
			return new CartesianTempCollection(list, false, cart1.getLeftTableName(), cart1.getRightTableName());
	}
	
	private HashSet<CartesianTemp> operationHelper(HashSet<CartesianTemp> s, CartesianTempCollection cart) {
		if(cart.getCartesianTempList().size() > PARALLEL_THRESHOLD) {
			cart.getCartesianTempList().parallelStream()
									   .forEach(t -> s.add(t));
		}
		else {
			cart.getCartesianTempList().stream()
									   .forEach(t -> s.add(t));
		}
		
		return s;
	}
	
	private void project(SelectStmt statement, CartesianTempCollection cart) {
		
		WorkingTable wt = new WorkingTable(PARALLEL_THRESHOLD);
		//cart.show();	
		
		if(cart.isSingleTable()) {
			IndexTable t = tableMap.get(cart.getLeftTableName());
			ArrayList<Integer> attrIdx = new ArrayList<Integer>();
			
			// set work table attribute & get attrIdx
			for(Result_column rc : statement.getResult_column()) {
				if(rc.isSingleStar) {
					wt.addAllAttrs(t.getAttrs());
					for(int i=0;i<t.getAttrs().size();i++)
						attrIdx.add(i);
					break;
				}
				else {
					wt.addAttr(t.getAttr(rc.attr_name));
					attrIdx.add(t.getIndexOfAttr(rc.attr_name));
				}
			}
			
			// get attribute from object[]
			for(CartesianTemp ct : cart.getCartesianTempList()) {
				ArrayList<Object> entry = new ArrayList<Object>();
				for(Integer i : attrIdx) {
					Object obj = t.get(ct.p_key1)[i];
					entry.add(obj);
				}
				wt.addTuple(entry);
			}
		}
		else {
			IndexTable lt = tableMap.get(cart.getLeftTableName());
			IndexTable rt = tableMap.get(cart.getRightTableName());
			ArrayList<Integer> lattrIdx = new ArrayList<Integer>();
			ArrayList<Integer> rattrIdx = new ArrayList<Integer>();
			
			/*--------------------------------------------*/
			/*
			System.out.println("----project----");
			System.out.println(cart.getRightTableName());
			System.out.println(cart.getLeftTableName());
			System.out.println(rt.getName());
			System.out.println(lt.getName());
			*/
			/*--------------------------------------------*/
			
			// add Attribute class into work table & get index of selected attributes
			for(Result_column rc : statement.getResult_column()) {
				if(rc.isSingleStar) {
					wt.addAllAttrs(lt.getAttrs());
					wt.addAllAttrs(rt.getAttrs());
					for(int i=0;i<lt.getAttrs().size();i++)
						lattrIdx.add(i);
					for(int i=0;i<rt.getAttrs().size();i++)
						rattrIdx.add(i);
					break;
				}
				else {
					if(rc.table_name.equals(lt)) {
						wt.addAttr(lt.getAttr(rc.attr_name));
						lattrIdx.add(lt.getIndexOfAttr(rc.attr_name));
					}
					else {
						wt.addAttr(rt.getAttr(rc.attr_name));
						lattrIdx.add(rt.getIndexOfAttr(rc.attr_name));
					}
				}
			}
			
			// get attribute from object[]
			for(CartesianTemp ct : cart.getCartesianTempList()) {
				ArrayList<Object> entry = new ArrayList<Object>();
				for(Integer i : lattrIdx) {
					Object obj = lt.get(ct.p_key1)[i];
					entry.add(obj);
				}
				for(Integer i : rattrIdx) {
					Object obj = rt.get(ct.p_key2)[i];
					entry.add(obj);
				}
				wt.addTuple(entry);
			}
		}
		wt.aggregate(statement.getResult_column());
		wt.show();
	}
	
}
