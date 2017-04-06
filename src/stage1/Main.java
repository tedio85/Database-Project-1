package stage1;

import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import stage1.SqlParser.Alter_table_stmtContext;
import stage1.SqlParser.Analyze_stmtContext;
import stage1.SqlParser.Any_nameContext;
import stage1.SqlParser.Attach_stmtContext;
import stage1.SqlParser.Begin_stmtContext;
import stage1.SqlParser.Collation_nameContext;
import stage1.SqlParser.Column_aliasContext;
import stage1.SqlParser.Column_constraintContext;
import stage1.SqlParser.Column_defContext;
import stage1.SqlParser.Column_nameContext;
import stage1.SqlParser.Commit_stmtContext;
import stage1.SqlParser.Common_table_expressionContext;
import stage1.SqlParser.Compound_operatorContext;
import stage1.SqlParser.Compound_select_stmtContext;
import stage1.SqlParser.Conflict_clauseContext;
import stage1.SqlParser.Create_index_stmtContext;
import stage1.SqlParser.Create_table_stmtContext;
import stage1.SqlParser.Create_trigger_stmtContext;
import stage1.SqlParser.Create_view_stmtContext;
import stage1.SqlParser.Create_virtual_table_stmtContext;
import stage1.SqlParser.Cte_table_nameContext;
import stage1.SqlParser.Database_nameContext;
import stage1.SqlParser.Delete_stmtContext;
import stage1.SqlParser.Delete_stmt_limitedContext;
import stage1.SqlParser.Detach_stmtContext;
import stage1.SqlParser.Drop_index_stmtContext;
import stage1.SqlParser.Drop_table_stmtContext;
import stage1.SqlParser.Drop_trigger_stmtContext;
import stage1.SqlParser.Drop_view_stmtContext;
import stage1.SqlParser.ErrorContext;
import stage1.SqlParser.Error_messageContext;
import stage1.SqlParser.ExprContext;
import stage1.SqlParser.Factored_select_stmtContext;
import stage1.SqlParser.Foreign_key_clauseContext;
import stage1.SqlParser.Foreign_tableContext;
import stage1.SqlParser.Function_nameContext;
import stage1.SqlParser.Index_nameContext;
import stage1.SqlParser.Indexed_columnContext;
import stage1.SqlParser.Insert_stmtContext;
import stage1.SqlParser.Join_clauseContext;
import stage1.SqlParser.Join_constraintContext;
import stage1.SqlParser.Join_operatorContext;
import stage1.SqlParser.KeywordContext;
import stage1.SqlParser.Literal_valueContext;
import stage1.SqlParser.Module_argumentContext;
import stage1.SqlParser.Module_nameContext;
import stage1.SqlParser.NameContext;
import stage1.SqlParser.New_table_nameContext;
import stage1.SqlParser.Ordering_termContext;
import stage1.SqlParser.ParseContext;
import stage1.SqlParser.Pragma_nameContext;
import stage1.SqlParser.Pragma_stmtContext;
import stage1.SqlParser.Pragma_valueContext;
import stage1.SqlParser.Qualified_table_nameContext;
import stage1.SqlParser.Raise_functionContext;
import stage1.SqlParser.Reindex_stmtContext;
import stage1.SqlParser.Release_stmtContext;
import stage1.SqlParser.Result_columnContext;
import stage1.SqlParser.Rollback_stmtContext;
import stage1.SqlParser.Savepoint_nameContext;
import stage1.SqlParser.Savepoint_stmtContext;
import stage1.SqlParser.Select_coreContext;
import stage1.SqlParser.Select_or_valuesContext;
import stage1.SqlParser.Select_stmtContext;
import stage1.SqlParser.Signed_numberContext;
import stage1.SqlParser.Simple_select_stmtContext;
import stage1.SqlParser.Sql_stmtContext;
import stage1.SqlParser.Table_aliasContext;
import stage1.SqlParser.Table_constraintContext;
import stage1.SqlParser.Table_nameContext;
import stage1.SqlParser.Table_or_index_nameContext;
import stage1.SqlParser.Table_or_subqueryContext;
import stage1.SqlParser.Transaction_nameContext;
import stage1.SqlParser.Trigger_nameContext;
import stage1.SqlParser.Type_nameContext;
import stage1.SqlParser.Unary_operatorContext;
import stage1.SqlParser.Update_stmtContext;
import stage1.SqlParser.Update_stmt_limitedContext;
import stage1.SqlParser.Vacuum_stmtContext;
import stage1.SqlParser.View_nameContext;
import stage1.SqlParser.With_clauseContext;

public class Main {
	
	private static TableManager tMgr = new TableManager();
	// map attribute table name to table
    
	public static void main(String[] args) throws IOException {
		String input = new String();
		String fileName = new String();
		Scanner s = new Scanner(System.in);
		boolean fileInputFlag = false;
		// 2 mode : file input & console input
		System.out.println("Do you want to input with file? (Y/N)");
		String a = s.nextLine();
		if(a.equals("Y")) fileInputFlag=true;
		
		// file input mode
		if(!fileInputFlag) System.out.println("Enter SQL statements : ");
		else {
			System.out.print("Please enter your file name : ");
			fileName = s.nextLine();
			fileInput(fileName);
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        String buffer = br.readLine();
		        if(userInput(buffer)) break;		        
			}
		}
		
		// console input mode
		while(true && !fileInputFlag) {
			// read input statements; execute if user enter >>
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String buffer = br.readLine();
	        if(!buffer.equals(">>")) {
	        	if(buffer.length()<4) {
	        		input = input + " " + buffer;
	        		continue;
	        	}
	        	if(userInput(buffer)) break;
	        	// allow enter multiple sql statements
	        	else input = inputConcat(input, buffer);
	        }
	        else {
	        	// classify input string into multiple sql statements
		        String[] classifyInput = input.split(";");
		        inputParse(classifyInput);
		        input = "";
	        }
        }
		s.close();
    }
	// user input interface, return false if user want to shut down system
	public static boolean userInput(String buffer) {
		// Exit System
    	if (buffer.substring(0, 4).toUpperCase().equals("EXIT")) {
    		dumpFile();
    		System.out.println("--Shut Down--");
    		return true;
    	}
    	// Dump CSV File 
    	else if (buffer.substring(0, 4).toUpperCase().equals("DUMP")) {
    		dumpFile();
    	} 
    	// Show Table
    	else if(buffer.substring(0, 4).toUpperCase().equals("SHOW")) {
    		// Allow user to enter multiple spaces between "show" and "Table name"
    		buffer = buffer.replaceAll("\\s","");
    		if(tMgr.getTable(buffer.substring(4))==null) {
    			System.err.println("Table do not exist !!");
    		} else {
    			System.out.println("Table Name :" + buffer.substring(4));
    			tMgr.getTable(buffer.substring(4)).show();
    		}
    	}
    	return false;
	}
	
	public static String inputConcat(String input, String buffer) {
		// Exit System
    	if (buffer.substring(0, 4).toUpperCase().equals("EXIT")){
    	}
    	// Dump CSV File 
    	else if (buffer.substring(0, 4).toUpperCase().equals("DUMP")){
    	}
    	// Show Table
    	else if(buffer.substring(0, 4).toUpperCase().equals("SHOW")){
    	}
    	else {
    		input = input+" "+buffer;
    	}
    	return input;
	}
	
	//dump CSV file
	public static void dumpFile() {
		System.out.println("--Dump CSV File--");
    	tMgr.dumpCSV();
	}
	
	// use file input 
	public static void fileInput(String fileName) {
		try {
			String content = readFile(fileName, StandardCharsets.UTF_8);
			// classify input string into multiple sql statements
	        String[] classifyInput = content.split(";");
	        inputParse(classifyInput);
		} catch (IOException e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}
	
	// process file reading
	public static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		  return new String(encoded, encoding);
	}
			
	// put classified input to parser
	public static void inputParse(String [] classifyInput) {
		// use LinkedList to linked more than 1 input sql statement
        LinkedList<Vector<String>> sql_stmt = new LinkedList<Vector<String>>();
        Queue<String> col_table_name = new LinkedList<String>();
    	Queue<String> col_column_name = new LinkedList<String>();
    	Queue<String> tab_table_name = new LinkedList<String>();
    	Queue<String> tab_alias = new LinkedList<String>();
    	Queue<String> whe_table_name = new LinkedList<String>();
    	Queue<String> whe_operator = new LinkedList<String>();
    	Queue<String> whe_column_name = new LinkedList<String>();
    	Queue<String> whe_bool_expr = new LinkedList<String>();
    	
        for(int i=0; i<classifyInput.length; i++) {
        	MakeStmt makeStmt = parse(classifyInput[i]);
        	Vector<String> parseOutput = makeStmt.getStmt();
        	if (parseOutput!=null) {
        		sql_stmt.add(parseOutput);
        		if(parseOutput.get(0).toUpperCase().equals("SELECT")) {
        			col_table_name = makeStmt.getColTabName();
        			col_column_name = makeStmt.getColColName();
        			tab_table_name = makeStmt.getTabTabName();
        			tab_alias = makeStmt.getTabAlias();
        			whe_table_name = makeStmt.getWheTabName();
        	    	whe_operator = makeStmt.getWheOper();
        	    	whe_column_name = makeStmt.getWheColName();
        	    	whe_bool_expr = makeStmt.getWheBoolExpr();
        		}
        	}
        }
        // process Create or Insert according to the 1st word of sql_stmt
        if(sql_stmt.isEmpty()) System.out.println("parse output is empty");
        for(int i=0; i<sql_stmt.size(); i++) {
        	if(sql_stmt.get(i).get(0).toUpperCase().equals("CREATE")) 
        		processCreate(sql_stmt.get(i));
	        else if(sql_stmt.get(i).get(0).toUpperCase().equals("INSERT")) 
	        	processInsert(sql_stmt.get(i));
	        else if(sql_stmt.get(i).get(0).toUpperCase().equals("SELECT")) {
	        	tMgr.select(col_table_name, col_column_name, tab_table_name, tab_alias, 
	        			whe_table_name, whe_operator, whe_column_name, whe_bool_expr);
	        }
	        	
        }
	}
	
	// process Create statements -> new a table to store it
	public static void processCreate(Vector<String> sql_stmt) {		
		// table name exception occur - parser will ignore the table name we assign
		String name = sql_stmt.get(2);
		// check whether table name already exist
		if(tMgr.isExist(name)) {
			for(int i=0; i<sql_stmt.size(); i++) {
				System.err.print(sql_stmt.get(i)+" ");
			}
			System.out.println();
			System.err.println("You have already created a table with this name : " + name);
			return;
		}
		String str_pk = null;
		Vector<String> attrs = new Vector<>();
		Vector<String> attrTypes = new Vector<>();
		Vector<Integer> strLen = new Vector<>();
		for(int i=3; i<sql_stmt.size(); i++) {
			if(sql_stmt.get(i).equals(",")) continue;
			if(sql_stmt.get(i).toUpperCase().equals("PRIMARY")) {
				str_pk = sql_stmt.get(i-2);
				i++;
			} 
			else if(sql_stmt.get(i).toUpperCase().equals("VARCHAR")) {
				attrTypes.add(sql_stmt.get(i));
				i++;
				strLen.add(Integer.parseInt(sql_stmt.get(i)));
			}
			else if(sql_stmt.get(i).toUpperCase().equals("INT")) {
				attrTypes.add(sql_stmt.get(i));
			}
			else {
				attrs.add(sql_stmt.get(i));
			}
		}
		try{
			tMgr.putTable(name, str_pk, attrs, attrTypes, strLen);
		} catch (Exception e) {
			System.err.print("Table create fail : "+e.getMessage()+" -");
			for(int i=0; i<sql_stmt.size(); i++) {
				System.err.print(" "+sql_stmt.get(i));
			}
			System.out.println();
		}
	}
	
	// process Insert statements -> call insert() of the specific table according to their syntax
	public static void processInsert(Vector<String> sql_stmt) {
		boolean attrOrValue = false; //false -> attr
		String TableName = sql_stmt.get(2);
		Vector<String> attrs = new Vector<>();
		Vector<String> tup = new Vector<>();
		
		for(int i=3; i<sql_stmt.size(); i++) {
			if(sql_stmt.get(i).equals(",")) continue;
			if(sql_stmt.get(i).toUpperCase().equals("VALUES")) {
				attrOrValue = true;
				continue;
			}
			if(attrOrValue==false) {
				attrs.add(sql_stmt.get(i));
			} else {
				tup.add(sql_stmt.get(i));
			}
		}
		// Handle (, , , ) or (, , 2, 1)
		if(attrOrValue) {
			int attrsNum = tMgr.getTableAttrSize(TableName);
			if(tup.size()==0) {
				for(int i=0; i<attrsNum; i++) {
					tup.add(null);
				}
			}
			else if(tup.size()<attrsNum) {
				tup.removeAllElements();
				for(int i=4; i<sql_stmt.size(); i++) {
					if(sql_stmt.get(i).equals(",")) {
						if(i==4) {
							tup.add(null);
							tup.add(null);
						}
						else {
							tup.add(null);
						}
					} else {
						if(i==4) {
							tup.add(sql_stmt.get(i));
						} else {
							tup.remove(tup.size()-1);
							tup.add(sql_stmt.get(i));
						}
						
					}
				}
			}
		}
		
		
		if(attrs.isEmpty()) {
			try{
				tMgr.insertTup(TableName, tup);
			} catch(Exception e) {
				System.err.print("Table insertion fail : "+e.getMessage()+" -");
				for(int i=0; i<sql_stmt.size(); i++) {
					System.err.print(" "+sql_stmt.get(i));
				}
				System.out.println();
			}
		} else {
			try{
				tMgr.insertTup(TableName, attrs, tup);
			} catch(Exception e) {
				System.err.println("Table insertion fail : "+e.getMessage()+" -");
				for(int i=0; i<sql_stmt.size(); i++) {
					System.err.print(sql_stmt.get(i)+" ");
				}
				System.out.println();
			}
		}
	}
	
    public static MakeStmt parse (String string) {    	
    	// Create a stream of characters from the string
        CharStream stream = new ANTLRInputStream(string);

        // Make a parser
        SqlParser parser = makeParser(stream);
        
        // Generate the parse tree using the starter rule.
        ParseTree tree;
        try {
        	tree = parser.parse();
        	Trees.inspect(tree, parser);
           	MakeStmt stmtMaker = new MakeStmt();
            new ParseTreeWalker().walk(stmtMaker, tree);
            return stmtMaker;
        } catch(Exception e) {
        	System.err.print(e.getMessage().replace("\n", "").replace("\r", "")+" :");
        	System.out.println("Parsing statement "+string);
        	return null;
        }
    }
    
    private static SqlParser makeParser(CharStream stream) {
        // Make a lexer.  
        SqlLexer lexer = new SqlLexer(stream);
   
        //lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Make a parser whose input comes from the token stream produced by the lexer.
        SqlParser parser = new SqlParser(tokens);
        
        return parser;
    }
}

class MakeStmt implements SqlListener {
	Vector<String> cur_stmt = new Vector<String>();
	Queue<String> col_table_name = new LinkedList<String>();
	Queue<String> col_column_name = new LinkedList<String>();
	Queue<String> tab_table_name = new LinkedList<String>();
	Queue<String> tab_alias = new LinkedList<String>();
	Queue<String> whe_table_name = new LinkedList<String>();
	Queue<String> whe_operator = new LinkedList<String>();
	Queue<String> whe_column_name = new LinkedList<String>();
	Queue<String> whe_bool_expr = new LinkedList<String>();
	
	boolean result_column_flag = false;
	boolean table_or_subquery_flag = false;
	boolean table_name_flag = false;
	boolean column_name_flag = false;
	boolean table_alias_flag = false;
	boolean whe_flag = false;
	
    public Vector<String> getStmt() {
        return cur_stmt;
    }
    public Queue<String> getColTabName() {
    	return col_table_name;
    }
    public Queue<String> getColColName() {
    	return col_column_name;
    }
    public Queue<String> getTabTabName() {
    	return tab_table_name;
    }
    public Queue<String> getTabAlias() {
    	return tab_alias;
    }
    public Queue<String> getWheTabName() {
    	return whe_table_name;
    }
    public Queue<String> getWheColName() {
    	return whe_column_name;
    }
    public Queue<String> getWheOper() {
    	return whe_operator;
    }
    public Queue<String> getWheBoolExpr() {
    	return whe_bool_expr;
    }
    
    @Override public void visitTerminal(TerminalNode arg0) {
    	if(!arg0.toString().equals("(") && !arg0.toString().equals(")") && !arg0.toString().equals(".")
    	&& !arg0.toString().toUpperCase().equals("AS") && !arg0.toString().equals("<EOF>")) {
    		if(result_column_flag) {
    			if(table_name_flag) col_table_name.add(arg0.toString());
    			if(column_name_flag) {
    				col_column_name.add(arg0.toString());
    				if(col_column_name.size()!=col_table_name.size()) 
    					col_table_name.add(null);
    			}
    		}
    		else if(table_or_subquery_flag) {
    			if(table_name_flag) tab_table_name.add(arg0.toString());
    			if(table_alias_flag) {
    				while(tab_alias.size()!=tab_table_name.size()-1) tab_alias.add(null);
    				tab_alias.add(arg0.toString());
    			}
    		}
    		else if(whe_flag) {
    			if(table_name_flag) whe_table_name.add(arg0.toString());
    			else if(column_name_flag) { 
    				whe_column_name.add(arg0.toString());
    				if(whe_column_name.size()!=whe_table_name.size()) 
    					whe_table_name.add(null);
    			}
    			else {
    				if(arg0.toString().toUpperCase().equals("AND")||arg0.toString().toUpperCase().equals("OR"))
    					whe_bool_expr.add(arg0.toString());
    				else 
    					whe_operator.add(arg0.toString());
    			}
    		}
    		else {
    			if(arg0.toString().toUpperCase().equals("WHERE")) whe_flag=true;
    			cur_stmt.add(arg0.toString());
    		}
    	}
    }
    
    @Override 
    public void exitSelect_core(Select_coreContext ctx) {
    	while(tab_alias.size()!=tab_table_name.size()) tab_alias.add(null);
    }
    
	@Override 
	public void enterTable_alias(Table_aliasContext ctx) {
		table_alias_flag=true;
	}
	@Override 
	public void exitTable_alias(Table_aliasContext ctx) {
		table_alias_flag=false;
	}
	@Override 
	public void enterColumn_name(Column_nameContext ctx) {
		column_name_flag=true;
	}
	@Override 
	public void exitColumn_name(Column_nameContext ctx) {
		column_name_flag=false;
	}
	@Override 
	public void enterTable_name(Table_nameContext ctx) {
		table_name_flag=true;
	}
	@Override 
	public void exitTable_name(Table_nameContext ctx) {
		table_name_flag=false;
	}
    @Override
	public void enterTable_or_subquery(Table_or_subqueryContext ctx) {
    	table_or_subquery_flag=true;
	}
    @Override 
    public void exitTable_or_subquery(Table_or_subqueryContext ctx) {
    	table_or_subquery_flag=false;
    }
    @Override
	public void enterResult_column(Result_columnContext ctx) {
    	result_column_flag = true;
    }
    @Override 
    public void exitResult_column(Result_columnContext ctx) {
    	result_column_flag = false;
    }
    
    // don't need these here, so just make them empty implementations
    @Override public void enterSelect_core(Select_coreContext ctx) {}
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) {}
	@Override public void enterParse(ParseContext ctx) {}
	@Override public void exitParse(ParseContext ctx) {}
	@Override public void enterError(ErrorContext ctx) {}
	@Override public void exitError(ErrorContext ctx) {}
	@Override public void enterSql_stmt(Sql_stmtContext ctx) {}
	@Override public void exitSql_stmt(Sql_stmtContext ctx) {}
	@Override public void enterCreate_table_stmt(Create_table_stmtContext ctx) {}
	@Override public void exitCreate_table_stmt(Create_table_stmtContext ctx) {}
	@Override public void enterInsert_stmt(Insert_stmtContext ctx) {}
	@Override public void exitInsert_stmt(Insert_stmtContext ctx) {}
	@Override public void enterColumn_def(Column_defContext ctx) {}
	@Override public void exitColumn_def(Column_defContext ctx) {}
	@Override public void enterType_name(Type_nameContext ctx) {}
	@Override public void exitType_name(Type_nameContext ctx) {}
	@Override public void enterColumn_constraint(Column_constraintContext ctx) {}
	@Override public void exitColumn_constraint(Column_constraintContext ctx) {}
	@Override public void enterExpr(ExprContext ctx) {}
	@Override public void exitExpr(ExprContext ctx) {}
	@Override public void enterRaise_function(Raise_functionContext ctx) {}
	@Override public void exitRaise_function(Raise_functionContext ctx) {}
	@Override public void enterSigned_number(Signed_numberContext ctx) {}
	@Override public void exitSigned_number(Signed_numberContext ctx) {}
	@Override public void enterLiteral_value(Literal_valueContext ctx) {}
	@Override public void exitLiteral_value(Literal_valueContext ctx) {}
	@Override public void enterUnary_operator(Unary_operatorContext ctx) {}
	@Override public void exitUnary_operator(Unary_operatorContext ctx) {}
	@Override public void enterError_message(Error_messageContext ctx) {}
	@Override public void exitError_message(Error_messageContext ctx) {}
	@Override public void enterKeyword(KeywordContext ctx) {}
	@Override public void exitKeyword(KeywordContext ctx) {}
	@Override public void enterName(NameContext ctx) {}
	@Override public void exitName(NameContext ctx) {}
	@Override public void enterFunction_name(Function_nameContext ctx) {}
	@Override public void exitFunction_name(Function_nameContext ctx) {}
	@Override public void enterDatabase_name(Database_nameContext ctx) {}
	@Override public void exitDatabase_name(Database_nameContext ctx) {}
	@Override public void enterTable_or_index_name(Table_or_index_nameContext ctx) {}
	@Override public void exitTable_or_index_name(Table_or_index_nameContext ctx) {}
	@Override public void enterNew_table_name(New_table_nameContext ctx) {}
	@Override public void exitNew_table_name(New_table_nameContext ctx) {}
	@Override public void enterCollation_name(Collation_nameContext ctx) {}
	@Override public void exitCollation_name(Collation_nameContext ctx) {}
	@Override public void enterForeign_table(Foreign_tableContext ctx) {}
	@Override public void exitForeign_table(Foreign_tableContext ctx) {}
	@Override public void enterIndex_name(Index_nameContext ctx) {}
	@Override public void exitIndex_name(Index_nameContext ctx) {}
	@Override public void enterTrigger_name(Trigger_nameContext ctx) {}
	@Override public void exitTrigger_name(Trigger_nameContext ctx) {}
	@Override public void enterView_name(View_nameContext ctx) {}
	@Override public void exitView_name(View_nameContext ctx) {}
	@Override public void enterModule_name(Module_nameContext ctx) {}
	@Override public void exitModule_name(Module_nameContext ctx) {}
	@Override public void enterPragma_name(Pragma_nameContext ctx) {}
	@Override public void exitPragma_name(Pragma_nameContext ctx) {}
	@Override public void enterSavepoint_name(Savepoint_nameContext ctx) {}
	@Override public void exitSavepoint_name(Savepoint_nameContext ctx) {}
	@Override public void enterTransaction_name(Transaction_nameContext ctx) {}
	@Override public void exitTransaction_name(Transaction_nameContext ctx) {}
	@Override public void enterAny_name(Any_nameContext ctx) {}
	@Override public void exitAny_name(Any_nameContext ctx) {
	}
	@Override
	public void enterAlter_table_stmt(Alter_table_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitAlter_table_stmt(Alter_table_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterAnalyze_stmt(Analyze_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitAnalyze_stmt(Analyze_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterAttach_stmt(Attach_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitAttach_stmt(Attach_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterBegin_stmt(Begin_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitBegin_stmt(Begin_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCommit_stmt(Commit_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCommit_stmt(Commit_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCompound_select_stmt(Compound_select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCompound_select_stmt(Compound_select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCreate_index_stmt(Create_index_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCreate_index_stmt(Create_index_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCreate_trigger_stmt(Create_trigger_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCreate_trigger_stmt(Create_trigger_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCreate_view_stmt(Create_view_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCreate_view_stmt(Create_view_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCreate_virtual_table_stmt(Create_virtual_table_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCreate_virtual_table_stmt(Create_virtual_table_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDelete_stmt(Delete_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDelete_stmt(Delete_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDelete_stmt_limited(Delete_stmt_limitedContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDelete_stmt_limited(Delete_stmt_limitedContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDetach_stmt(Detach_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDetach_stmt(Detach_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDrop_index_stmt(Drop_index_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDrop_index_stmt(Drop_index_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDrop_table_stmt(Drop_table_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDrop_table_stmt(Drop_table_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDrop_trigger_stmt(Drop_trigger_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDrop_trigger_stmt(Drop_trigger_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterDrop_view_stmt(Drop_view_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitDrop_view_stmt(Drop_view_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterFactored_select_stmt(Factored_select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitFactored_select_stmt(Factored_select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterPragma_stmt(Pragma_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitPragma_stmt(Pragma_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterReindex_stmt(Reindex_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitReindex_stmt(Reindex_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterRelease_stmt(Release_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitRelease_stmt(Release_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterRollback_stmt(Rollback_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitRollback_stmt(Rollback_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterSavepoint_stmt(Savepoint_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitSavepoint_stmt(Savepoint_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterSimple_select_stmt(Simple_select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitSimple_select_stmt(Simple_select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterSelect_stmt(Select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitSelect_stmt(Select_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterSelect_or_values(Select_or_valuesContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitSelect_or_values(Select_or_valuesContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterUpdate_stmt(Update_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitUpdate_stmt(Update_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterUpdate_stmt_limited(Update_stmt_limitedContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitUpdate_stmt_limited(Update_stmt_limitedContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterVacuum_stmt(Vacuum_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitVacuum_stmt(Vacuum_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterConflict_clause(Conflict_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitConflict_clause(Conflict_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterForeign_key_clause(Foreign_key_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitForeign_key_clause(Foreign_key_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterIndexed_column(Indexed_columnContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitIndexed_column(Indexed_columnContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterTable_constraint(Table_constraintContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitTable_constraint(Table_constraintContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterWith_clause(With_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitWith_clause(With_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterQualified_table_name(Qualified_table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitQualified_table_name(Qualified_table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterOrdering_term(Ordering_termContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitOrdering_term(Ordering_termContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterPragma_value(Pragma_valueContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitPragma_value(Pragma_valueContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCommon_table_expression(Common_table_expressionContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCommon_table_expression(Common_table_expressionContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterJoin_clause(Join_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitJoin_clause(Join_clauseContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterJoin_operator(Join_operatorContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitJoin_operator(Join_operatorContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterJoin_constraint(Join_constraintContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitJoin_constraint(Join_constraintContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCompound_operator(Compound_operatorContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCompound_operator(Compound_operatorContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCte_table_name(Cte_table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitCte_table_name(Cte_table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterModule_argument(Module_argumentContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitModule_argument(Module_argumentContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterColumn_alias(Column_aliasContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitColumn_alias(Column_aliasContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
