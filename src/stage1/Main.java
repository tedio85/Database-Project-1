package stage1;

//import java.util.List;
//import java.util.Stack;

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
import stage1.SqlParser.Sql_stmt_listContext;
import stage1.SqlParser.Table_aliasContext;
import stage1.SqlParser.Table_nameContext;
import stage1.SqlParser.Table_or_index_nameContext;
import stage1.SqlParser.Transaction_nameContext;
import stage1.SqlParser.Trigger_nameContext;
import stage1.SqlParser.Type_nameContext;
import stage1.SqlParser.Unary_operatorContext;
import stage1.SqlParser.View_nameContext;


public class Main {
 
    public static void main(String[] args) {
        String input = "INSERT INTO Student VALUES (11, 'Hsu You-Ting', 'F', 23);";
        parse(input);
        
    }

    /**
     */
    public static void parse(String string) {
    	// Create a stream of characters from the string
        CharStream stream = new ANTLRInputStream(string);

        // Make a parser
        SqlParser parser = makeParser(stream);
        
        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.parse();
        
        // *** debugging option #1: print the tree to the console
        System.err.println(tree.toStringTree(parser));

        // *** debugging option #2: show the tree in a window
        Trees.inspect(tree, parser);
        
        // *** debugging option #3: walk the tree with a listener
        new ParseTreeWalker().walk(new PrintTerminal(), tree);
    }
    
    private static SqlParser makeParser(CharStream stream) {
        // Make a lexer.  
        SqlLexer lexer = new SqlLexer(stream);
        //lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Make a parser whose input comes from the token stream produced by the lexer.
        SqlParser parser = new SqlParser(tokens);
        //parser.reportErrorsAsExceptions();
        
        return parser;
    }
}

class PrintTerminal implements SqlListener {
    @Override public void visitTerminal(TerminalNode terminal) {
        System.err.println("terminal " + terminal.getText());            
    }
    
    // don't need these here, so just make them empty implementations
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) { }
	@Override
	public void enterParse(ParseContext ctx) {}

	@Override
	public void exitParse(ParseContext ctx) {}

	@Override
	public void enterError(ErrorContext ctx) {}

	@Override
	public void exitError(ErrorContext ctx) {}

	@Override
	public void enterSql_stmt_list(Sql_stmt_listContext ctx) {
		System.err.println("Sql_stmt_list " + ctx.getText());
	}

	@Override
	public void exitSql_stmt_list(Sql_stmt_listContext ctx) {}

	@Override
	public void enterSql_stmt(Sql_stmtContext ctx) {}

	@Override
	public void exitSql_stmt(Sql_stmtContext ctx) {}

	@Override
	public void enterCreate_table_stmt(Create_table_stmtContext ctx) {}

	@Override
	public void exitCreate_table_stmt(Create_table_stmtContext ctx) {}

	@Override
	public void enterInsert_stmt(Insert_stmtContext ctx) {}

	@Override
	public void exitInsert_stmt(Insert_stmtContext ctx) {}

	@Override
	public void enterColumn_def(Column_defContext ctx) {}

	@Override
	public void exitColumn_def(Column_defContext ctx) {}

	@Override
	public void enterType_name(Type_nameContext ctx) {}

	@Override
	public void exitType_name(Type_nameContext ctx) {}

	@Override
	public void enterColumn_constraint(Column_constraintContext ctx) {}

	@Override
	public void exitColumn_constraint(Column_constraintContext ctx) {}

	@Override
	public void enterExpr(ExprContext ctx) {}

	@Override
	public void exitExpr(ExprContext ctx) {}

	@Override
	public void enterRaise_function(Raise_functionContext ctx) {}

	@Override
	public void exitRaise_function(Raise_functionContext ctx) {}

	@Override
	public void enterSigned_number(Signed_numberContext ctx) {}

	@Override
	public void exitSigned_number(Signed_numberContext ctx) {}

	@Override
	public void enterLiteral_value(Literal_valueContext ctx) {}

	@Override
	public void exitLiteral_value(Literal_valueContext ctx) {}

	@Override
	public void enterUnary_operator(Unary_operatorContext ctx) {}

	@Override
	public void exitUnary_operator(Unary_operatorContext ctx) {}

	@Override
	public void enterError_message(Error_messageContext ctx) {}

	@Override
	public void exitError_message(Error_messageContext ctx) {}

	@Override
	public void enterKeyword(KeywordContext ctx) {}

	@Override
	public void exitKeyword(KeywordContext ctx) {}

	@Override
	public void enterName(NameContext ctx) {}

	@Override
	public void exitName(NameContext ctx) {}

	@Override
	public void enterFunction_name(Function_nameContext ctx) {}

	@Override
	public void exitFunction_name(Function_nameContext ctx) {}

	@Override
	public void enterDatabase_name(Database_nameContext ctx) {}

	@Override
	public void exitDatabase_name(Database_nameContext ctx) {}

	@Override
	public void enterTable_name(Table_nameContext ctx) {}

	@Override
	public void exitTable_name(Table_nameContext ctx) {}

	@Override
	public void enterTable_or_index_name(Table_or_index_nameContext ctx) {}

	@Override
	public void exitTable_or_index_name(Table_or_index_nameContext ctx) {}

	@Override
	public void enterNew_table_name(New_table_nameContext ctx) {}

	@Override
	public void exitNew_table_name(New_table_nameContext ctx) {}

	@Override
	public void enterColumn_name(Column_nameContext ctx) {}

	@Override
	public void exitColumn_name(Column_nameContext ctx) {}

	@Override
	public void enterCollation_name(Collation_nameContext ctx) {}

	@Override
	public void exitCollation_name(Collation_nameContext ctx) {}

	@Override
	public void enterForeign_table(Foreign_tableContext ctx) {}

	@Override
	public void exitForeign_table(Foreign_tableContext ctx) {}

	@Override
	public void enterIndex_name(Index_nameContext ctx) {}

	@Override
	public void exitIndex_name(Index_nameContext ctx) {}

	@Override
	public void enterTrigger_name(Trigger_nameContext ctx) {}

	@Override
	public void exitTrigger_name(Trigger_nameContext ctx) {}

	@Override
	public void enterView_name(View_nameContext ctx) {}

	@Override
	public void exitView_name(View_nameContext ctx) {}

	@Override
	public void enterModule_name(Module_nameContext ctx) {}

	@Override
	public void exitModule_name(Module_nameContext ctx) {}

	@Override
	public void enterPragma_name(Pragma_nameContext ctx) {}

	@Override
	public void exitPragma_name(Pragma_nameContext ctx) {}

	@Override
	public void enterSavepoint_name(Savepoint_nameContext ctx) {}

	@Override
	public void exitSavepoint_name(Savepoint_nameContext ctx) {}

	@Override
	public void enterTable_alias(Table_aliasContext ctx) {}

	@Override
	public void exitTable_alias(Table_aliasContext ctx) {}

	@Override
	public void enterTransaction_name(Transaction_nameContext ctx) {}

	@Override
	public void exitTransaction_name(Transaction_nameContext ctx) {}

	@Override
	public void enterAny_name(Any_nameContext ctx) {}

	@Override
	public void exitAny_name(Any_nameContext ctx) {}         
}
