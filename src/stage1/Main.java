package stage1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
	
	private static TableManager tMgr = new TableManager();
	// map attribute table name to table
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			String statement = new String();
		        while(true) {
		        	String thisLine = br.readLine();
		        	statement += thisLine;
		        	statement += System.lineSeparator();
		        	
		        	if(thisLine.trim().endsWith(";")) {
		        		statement = statement.trim();
		        		statement = statement.substring(0, statement.length()-1);
		        		break;
		        	}
		        }
		    System.out.println(statement);
			CharStream stream = new ANTLRInputStream(statement);
			SqlLexer lexer = new SqlLexer(stream);
			TokenStream tokens = new CommonTokenStream(lexer);
			SqlParser parser = new SqlParser(tokens);
			ParseTree tree = parser.parse();

			
			ParseTreeWalker walker = new ParseTreeWalker();
			SqlListener stmtMaker = new StmtMaker();
			walker.walk(stmtMaker, tree);

		}
    }
}
 