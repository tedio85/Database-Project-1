package stage1;

import java.util.HashMap;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

//import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import stage1.SqlParser.Any_nameContext;
import stage1.SqlParser.Collation_nameContext;
import stage1.SqlParser.Column_constraintContext;
import stage1.SqlParser.Column_defContext;
import stage1.SqlParser.Column_nameContext;
import stage1.SqlParser.Create_table_stmtContext;
import stage1.SqlParser.Database_nameContext;
import stage1.SqlParser.ErrorContext;
import stage1.SqlParser.Error_messageContext;
import stage1.SqlParser.ExprContext;
import stage1.SqlParser.Foreign_tableContext;
import stage1.SqlParser.Function_nameContext;
import stage1.SqlParser.Index_nameContext;
import stage1.SqlParser.Insert_stmtContext;
import stage1.SqlParser.KeywordContext;
import stage1.SqlParser.Literal_valueContext;
import stage1.SqlParser.Module_nameContext;
import stage1.SqlParser.NameContext;
import stage1.SqlParser.New_table_nameContext;
import stage1.SqlParser.ParseContext;
import stage1.SqlParser.Pragma_nameContext;
import stage1.SqlParser.Raise_functionContext;
import stage1.SqlParser.Savepoint_nameContext;
import stage1.SqlParser.Signed_numberContext;
import stage1.SqlParser.Sql_stmtContext;
import stage1.SqlParser.Table_aliasContext;
import stage1.SqlParser.Table_nameContext;
import stage1.SqlParser.Table_or_index_nameContext;
import stage1.SqlParser.Transaction_nameContext;
import stage1.SqlParser.Trigger_nameContext;
import stage1.SqlParser.Type_nameContext;
import stage1.SqlParser.Unary_operatorContext;
import stage1.SqlParser.View_nameContext;

public class Main {
	
	private static HashMap<String, VectorTable> TableMap = new HashMap<String, VectorTable>();
	
	// map attribute table name to table
    
	public static void main(String[] args) throws IOException {
		String input = new String();
		String fileName = new String();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		boolean fileInputFlag = false;
		System.out.println("Do you want to input with file? (Y/N)");
		String a = s.nextLine();
		if(a.equals("Y")) fileInputFlag=true;
		if(!fileInputFlag) System.out.println("Enter SQL statements : ");
		else {
			System.out.print("Please enter your file name : ");
			fileName = s.nextLine();
			fileInput(fileName);
		}
		
		while(true && !fileInputFlag) {
			// read input statements; execute if user enter >>
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String buffer = br.readLine();
	        if(!buffer.equals(">>")) {
	        	// handle nonsense input
	        	if(buffer.length()<4) System.err.println("What do you mean ?");
	        	// Exit System
	        	else if (buffer.substring(0, 4).toUpperCase().equals("EXIT")) {
	        		System.out.println("--Shut Down--");
	        		break;
	        	}
	        	// Show Table
	        	else if(buffer.substring(0, 4).toUpperCase().equals("SHOW")) {
	        		// Allow user to enter multiple spaces between "show" and "Table name"
	        		buffer = buffer.replaceAll("\\s","");
	        		if(TableMap.get(buffer.substring(4))==null) {
	        			System.err.println("Table do not exist !!");
	        		} else {
	        			System.out.println("Table Name :" + buffer.substring(4));
	        			TableMap.get(buffer.substring(4)).show();
	        		}
	        	}
	        	// allow enter multiple sql statements
	        	else input = input + " " +buffer ;
	        }
	        else {
	        	// classify input string into multiple sql statements
		        String[] classifyInput = input.split(";");
		        inputParse(classifyInput);
		        input = "";
	        }
        }
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
        for(int i=0; i<classifyInput.length; i++) {
        	Vector<String> parseOutput = parse(classifyInput[i]);
        	if (parseOutput!=null) {
        		sql_stmt.add(parseOutput);
        	}
        }
        // process Create or Insert according to the 1st word of sql_stmt
        if(sql_stmt.isEmpty()) System.out.println("parse output is empty");
        for(int i=0; i<sql_stmt.size(); i++) {
        	if(sql_stmt.get(i).get(0).toUpperCase().equals("CREATE")) 
        		processCreate(sql_stmt.get(i));
	        else if(sql_stmt.get(i).get(0).toUpperCase().equals("INSERT")) 
	        	processInsert(sql_stmt.get(i));
        }
	}
	
	// process Create statements -> new a table to store it
	public static void processCreate(Vector<String> sql_stmt) {
		// table name exception occur - parser will ignore the table name we assign
		String name = sql_stmt.get(2);
		String str_pk = new String();
		Vector<String> attrs = new Vector<>();
		Vector<String> attrTypes = new Vector<>();
		Vector<Integer> strLen = new Vector<>();
		for(int i=3; i<sql_stmt.size(); i++) {
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
			TableMap.put(name, new VectorTable(name, str_pk, attrs, attrTypes, strLen));
		} catch (Exception e) {
			System.err.println("Table create fail : "+e.getMessage());
		}
	}
	
	// process Insert statements -> call insert() of the specific table according to their syntax
	public static void processInsert(Vector<String> sql_stmt) {
		boolean attrOrValue = false; //false -> attr
		String TableName = sql_stmt.get(2);
		Vector<String> attrs = new Vector<>();
		Vector<String> tup = new Vector<>();
		
		for(int i=3; i<sql_stmt.size(); i++) {
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
		
		if(attrs.isEmpty()) {
			try{
				TableMap.get(TableName).insert(tup);
			} catch(Exception e) {
				System.err.println("Table insertion fail : "+e.getMessage());
			}
		} else {
			try{
				TableMap.get(TableName).insert(attrs, tup);
			} catch(Exception e) {
				System.err.println("Table insertion fail : "+e.getMessage());
			}
		}
	}
	
    public static Vector<String> parse (String string) {    	
    	// Create a stream of characters from the string
        CharStream stream = new ANTLRInputStream(string);

        // Make a parser
        SqlParser parser = makeParser(stream);
        
        // Generate the parse tree using the starter rule.
        ParseTree tree;
        try {
        	tree = parser.parse();
           	MakeStmt stmtMaker = new MakeStmt();
            new ParseTreeWalker().walk(stmtMaker, tree);
            return stmtMaker.getStmt();
        } catch(Exception e) {
        	System.err.println(string +" : " +e.getMessage());
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
	private Vector<String> cur_stmt = new Vector<String>();

    public Vector<String> getStmt() {
        return cur_stmt;
    }
    @Override public void visitTerminal(TerminalNode arg0) {
    	if(!arg0.toString().equals("(") && !arg0.toString().equals(")") && !arg0.toString().equals(",") 
    	&& !arg0.toString().equals("<EOF>")) {
    		cur_stmt.add(arg0.toString());
    	}
    }
    
    // don't need these here, so just make them empty implementations
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) {}
	@Override public void enterParse(ParseContext ctx) {}
	@Override public void exitParse(ParseContext ctx) {}
	@Override public void enterError(ErrorContext ctx) {}
	@Override public void exitError(ErrorContext ctx) {}
	@Override public void enterSql_stmt(Sql_stmtContext ctx) {}
	@Override public void exitSql_stmt(Sql_stmtContext ctx) {}
	@Override public void enterTable_name(Table_nameContext ctx) {}
    @Override public void exitTable_name(Table_nameContext ctx) {}
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
	@Override public void enterColumn_name(Column_nameContext ctx) {}
	@Override public void exitColumn_name(Column_nameContext ctx) {}
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
	@Override public void enterTable_alias(Table_aliasContext ctx) {}
	@Override public void exitTable_alias(Table_aliasContext ctx) {}
	@Override public void enterTransaction_name(Transaction_nameContext ctx) {}
	@Override public void exitTransaction_name(Transaction_nameContext ctx) {}
	@Override public void enterAny_name(Any_nameContext ctx) {}
	@Override public void exitAny_name(Any_nameContext ctx) {}         
}
