package stage1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.google.common.base.Stopwatch;

public class Main {
	
	private static boolean exitProgram = false;				// exit loop and terminate program
	
	// user input source
	private static BufferedReader inputBr = new BufferedReader(new InputStreamReader(System.in));
	private static boolean fileInput = false;
	
	
	/*private static DB diskDB = DBMaker
							 	.fileDB("fileDB.db")
							 	.closeOnJvmShutdown()
							 	.fileLockDisable()
							 	.make();
	*/
	private static DB diskDB = DBMaker
								.memoryDB()
								.closeOnJvmShutdown()
								.make();
	
	private static TableManager tMgr = new TableManager(diskDB);		// map attribute table name to table
	
	private static BufferedReader determineInputSrc() throws IOException {
		
		BufferedReader br = inputBr;
		while(true) {
			System.out.println("File input? (y/n)");
			String inp = br.readLine().trim().toLowerCase();
			switch(inp) {
			case "y": 
				System.out.println("Enter file name:");
				inp = br.readLine().trim();
				try {
					br = new BufferedReader(new FileReader(inp));
					fileInput = true;
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
					continue;
				}
				break;
			case "n":
				br = inputBr;
				fileInput = false;
				break;
			default: System.out.println("wrong input"); continue; 
			}
			return br;
		}
	}
	
	/* 
	 * 	determine if statement is a DB system command, e.g. dump to file, show table, exit etc.
	 *	if true, execute command
	 *	if not, return false;
	 */
	private static boolean systemCmd(String line) {
		Stopwatch timer = Stopwatch.createStarted();
    	List<String> words = Arrays.asList(line.split(" "));
    	words = words.stream().map(v -> v.trim().toLowerCase()).collect(Collectors.toList());
    	switch(words.get(0)) {
    	case "show": 
    		tMgr.showTable(words.get(1));
    		timer.stop();
    		System.out.println("Execution time: "+timer);
    		return true;
    	case "dump": 
    		tMgr.dumpCSV();
    		timer.stop();
    		System.out.println("Execution time: "+timer);
    		return true;
    	case "exit": 
    		exitProgram = true;
    		timer.stop();
    		System.out.println("Execution time: "+timer);
    		return true;
    		default: return false;	// not a system command
    	}
    }
	
	public static void main(String[] args) {
		try {
			start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	private static void start() throws IOException{
		// input source, will be connected either file input or user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// reach EOF or not
		boolean inputEnd = true;
		
		// lexer, parser, tokens
		CharStream stream = new ANTLRInputStream();
		SqlLexer lexer = new SqlLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		SqlParser parser = new SqlParser(tokens);
		
	
		// keep looping for file inputs or user inputs
		outerloop:
		while(!exitProgram) {
			
			if(inputEnd)
				br = determineInputSrc();
			
			// get the statement ending with ";"
			Stopwatch timer = Stopwatch.createStarted();
			String statement = new String();
	        while(true) {
	        	
	        	String thisLine = br.readLine();
	        	statement += thisLine;
	        	statement += " ";
	        	inputEnd = (fileInput && thisLine != null ) ? false : true;
	        	
	        	if(thisLine == null) {
	        		continue outerloop;
	        	}
	        	else if(thisLine.trim().endsWith(";")) {
	        		statement = statement.trim();
	        		statement = statement.substring(0, statement.length()-1);
	        		break;
	        	}
	        }
		    System.out.println(statement);
		    
		    // detect system command
		    if(systemCmd(statement))	continue;
		    
		    // reset lexer & parser
		    lexer.reset();
		    parser.reset();
		    
		    // feed in new stream
	    	stream = new ANTLRInputStream(statement);
	    	lexer.setInputStream(stream);
	    	tokens = new CommonTokenStream(lexer);
	    	parser.setTokenStream(tokens);
	    	
		    // walk the tree
	    	ParseTree tree = null;
	    	StmtMaker stmtMaker = null;
	    	try {
	    		tree = parser.parse();
	    		ParseTreeWalker walker = new ParseTreeWalker();
				stmtMaker = new StmtMaker();
				walker.walk(stmtMaker, tree);
				//org.antlr.v4.gui.Trees.inspect(tree, parser);
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    		continue;
	    	}
	    	
	    	// get the statement
	    	Stmt statementClass = stmtMaker.getStatement();
	    	tMgr.executeStatement(statementClass);
	    	stmtMaker.resetStatement();
	    	timer.stop();
	    	System.out.println("Execution time: " + timer);
		}
		
		// close BufferedReader
		br.close();
		
		// dump file to disk & exit program
		tMgr.dumpCSV();
		diskDB.commit();
		diskDB.close();
	}
}
 
