// Generated from Sql.g4 by ANTLR 4.5.1

package stage1;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, ASSIGN=6, STAR=7, PLUS=8, 
		MINUS=9, TILDE=10, PIPE2=11, DIV=12, MOD=13, LT2=14, GT2=15, AMP=16, PIPE=17, 
		LT=18, LT_EQ=19, GT=20, GT_EQ=21, EQ=22, NOT_EQ1=23, NOT_EQ2=24, K_ABORT=25, 
		K_ACTION=26, K_ADD=27, K_AFTER=28, K_ALL=29, K_ALTER=30, K_ANALYZE=31, 
		K_AND=32, K_AS=33, K_ASC=34, K_ATTACH=35, K_AUTOINCREMENT=36, K_BEFORE=37, 
		K_BEGIN=38, K_BETWEEN=39, K_BY=40, K_CASCADE=41, K_CASE=42, K_CAST=43, 
		K_CHECK=44, K_COLLATE=45, K_COLUMN=46, K_COMMIT=47, K_CONFLICT=48, K_CONSTRAINT=49, 
		K_CREATE=50, K_CROSS=51, K_CURRENT_DATE=52, K_CURRENT_TIME=53, K_CURRENT_TIMESTAMP=54, 
		K_DATABASE=55, K_DEFAULT=56, K_DEFERRABLE=57, K_DEFERRED=58, K_DELETE=59, 
		K_DESC=60, K_DETACH=61, K_DISTINCT=62, K_DROP=63, K_EACH=64, K_ELSE=65, 
		K_END=66, K_ESCAPE=67, K_EXCEPT=68, K_EXCLUSIVE=69, K_EXISTS=70, K_EXPLAIN=71, 
		K_FAIL=72, K_FOR=73, K_FOREIGN=74, K_FROM=75, K_FULL=76, K_GLOB=77, K_GROUP=78, 
		K_HAVING=79, K_IF=80, K_IGNORE=81, K_IMMEDIATE=82, K_IN=83, K_INDEX=84, 
		K_INDEXED=85, K_INITIALLY=86, K_INNER=87, K_INSERT=88, K_INSTEAD=89, K_INTERSECT=90, 
		K_INTO=91, K_IS=92, K_ISNULL=93, K_JOIN=94, K_KEY=95, K_LEFT=96, K_LIKE=97, 
		K_LIMIT=98, K_MATCH=99, K_NATURAL=100, K_NO=101, K_NOT=102, K_NOTNULL=103, 
		K_NULL=104, K_OF=105, K_OFFSET=106, K_ON=107, K_OR=108, K_ORDER=109, K_OUTER=110, 
		K_PLAN=111, K_PRAGMA=112, K_PRIMARY=113, K_QUERY=114, K_RAISE=115, K_RECURSIVE=116, 
		K_REFERENCES=117, K_REGEXP=118, K_REINDEX=119, K_RELEASE=120, K_RENAME=121, 
		K_REPLACE=122, K_RESTRICT=123, K_RIGHT=124, K_ROLLBACK=125, K_ROW=126, 
		K_SAVEPOINT=127, K_SELECT=128, K_SET=129, K_TABLE=130, K_TEMP=131, K_TEMPORARY=132, 
		K_THEN=133, K_TO=134, K_TRANSACTION=135, K_TRIGGER=136, K_UNION=137, K_UNIQUE=138, 
		K_UPDATE=139, K_USING=140, K_VACUUM=141, K_VALUES=142, K_VIEW=143, K_VIRTUAL=144, 
		K_WHEN=145, K_WHERE=146, K_WITH=147, K_WITHOUT=148, IDENTIFIER=149, NUMERIC_LITERAL=150, 
		BIND_PARAMETER=151, STRING_LITERAL=152, BLOB_LITERAL=153, SINGLE_LINE_COMMENT=154, 
		MULTILINE_COMMENT=155, SPACES=156, UNEXPECTED_CHAR=157;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sql_stmt = 2, RULE_alter_table_stmt = 3, 
		RULE_analyze_stmt = 4, RULE_attach_stmt = 5, RULE_begin_stmt = 6, RULE_commit_stmt = 7, 
		RULE_compound_select_stmt = 8, RULE_create_index_stmt = 9, RULE_create_table_stmt = 10, 
		RULE_create_trigger_stmt = 11, RULE_create_view_stmt = 12, RULE_create_virtual_table_stmt = 13, 
		RULE_delete_stmt = 14, RULE_delete_stmt_limited = 15, RULE_detach_stmt = 16, 
		RULE_drop_index_stmt = 17, RULE_drop_table_stmt = 18, RULE_drop_trigger_stmt = 19, 
		RULE_drop_view_stmt = 20, RULE_factored_select_stmt = 21, RULE_insert_stmt = 22, 
		RULE_pragma_stmt = 23, RULE_reindex_stmt = 24, RULE_release_stmt = 25, 
		RULE_rollback_stmt = 26, RULE_savepoint_stmt = 27, RULE_simple_select_stmt = 28, 
		RULE_select_stmt = 29, RULE_select_or_values = 30, RULE_update_stmt = 31, 
		RULE_update_stmt_limited = 32, RULE_vacuum_stmt = 33, RULE_column_def = 34, 
		RULE_type_name = 35, RULE_column_constraint = 36, RULE_conflict_clause = 37, 
		RULE_expr = 38, RULE_foreign_key_clause = 39, RULE_raise_function = 40, 
		RULE_indexed_column = 41, RULE_table_constraint = 42, RULE_with_clause = 43, 
		RULE_qualified_table_name = 44, RULE_ordering_term = 45, RULE_pragma_value = 46, 
		RULE_common_table_expression = 47, RULE_result_column = 48, RULE_table_or_subquery = 49, 
		RULE_join_clause = 50, RULE_join_operator = 51, RULE_join_constraint = 52, 
		RULE_select_core = 53, RULE_compound_operator = 54, RULE_cte_table_name = 55, 
		RULE_signed_number = 56, RULE_literal_value = 57, RULE_unary_operator = 58, 
		RULE_error_message = 59, RULE_module_argument = 60, RULE_column_alias = 61, 
		RULE_keyword = 62, RULE_name = 63, RULE_function_name = 64, RULE_database_name = 65, 
		RULE_table_name = 66, RULE_table_or_index_name = 67, RULE_new_table_name = 68, 
		RULE_column_name = 69, RULE_collation_name = 70, RULE_foreign_table = 71, 
		RULE_index_name = 72, RULE_trigger_name = 73, RULE_view_name = 74, RULE_module_name = 75, 
		RULE_pragma_name = 76, RULE_savepoint_name = 77, RULE_table_alias = 78, 
		RULE_transaction_name = 79, RULE_any_name = 80;
	public static final String[] ruleNames = {
		"parse", "error", "sql_stmt", "alter_table_stmt", "analyze_stmt", "attach_stmt", 
		"begin_stmt", "commit_stmt", "compound_select_stmt", "create_index_stmt", 
		"create_table_stmt", "create_trigger_stmt", "create_view_stmt", "create_virtual_table_stmt", 
		"delete_stmt", "delete_stmt_limited", "detach_stmt", "drop_index_stmt", 
		"drop_table_stmt", "drop_trigger_stmt", "drop_view_stmt", "factored_select_stmt", 
		"insert_stmt", "pragma_stmt", "reindex_stmt", "release_stmt", "rollback_stmt", 
		"savepoint_stmt", "simple_select_stmt", "select_stmt", "select_or_values", 
		"update_stmt", "update_stmt_limited", "vacuum_stmt", "column_def", "type_name", 
		"column_constraint", "conflict_clause", "expr", "foreign_key_clause", 
		"raise_function", "indexed_column", "table_constraint", "with_clause", 
		"qualified_table_name", "ordering_term", "pragma_value", "common_table_expression", 
		"result_column", "table_or_subquery", "join_clause", "join_operator", 
		"join_constraint", "select_core", "compound_operator", "cte_table_name", 
		"signed_number", "literal_value", "unary_operator", "error_message", "module_argument", 
		"column_alias", "keyword", "name", "function_name", "database_name", "table_name", 
		"table_or_index_name", "new_table_name", "column_name", "collation_name", 
		"foreign_table", "index_name", "trigger_name", "view_name", "module_name", 
		"pragma_name", "savepoint_name", "table_alias", "transaction_name", "any_name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", "'-'", "'~'", 
		"'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", "'<='", "'>'", 
		"'>='", "'=='", "'!='", "'<>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", 
		"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
		"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "K_ABORT", 
		"K_ACTION", "K_ADD", "K_AFTER", "K_ALL", "K_ALTER", "K_ANALYZE", "K_AND", 
		"K_AS", "K_ASC", "K_ATTACH", "K_AUTOINCREMENT", "K_BEFORE", "K_BEGIN", 
		"K_BETWEEN", "K_BY", "K_CASCADE", "K_CASE", "K_CAST", "K_CHECK", "K_COLLATE", 
		"K_COLUMN", "K_COMMIT", "K_CONFLICT", "K_CONSTRAINT", "K_CREATE", "K_CROSS", 
		"K_CURRENT_DATE", "K_CURRENT_TIME", "K_CURRENT_TIMESTAMP", "K_DATABASE", 
		"K_DEFAULT", "K_DEFERRABLE", "K_DEFERRED", "K_DELETE", "K_DESC", "K_DETACH", 
		"K_DISTINCT", "K_DROP", "K_EACH", "K_ELSE", "K_END", "K_ESCAPE", "K_EXCEPT", 
		"K_EXCLUSIVE", "K_EXISTS", "K_EXPLAIN", "K_FAIL", "K_FOR", "K_FOREIGN", 
		"K_FROM", "K_FULL", "K_GLOB", "K_GROUP", "K_HAVING", "K_IF", "K_IGNORE", 
		"K_IMMEDIATE", "K_IN", "K_INDEX", "K_INDEXED", "K_INITIALLY", "K_INNER", 
		"K_INSERT", "K_INSTEAD", "K_INTERSECT", "K_INTO", "K_IS", "K_ISNULL", 
		"K_JOIN", "K_KEY", "K_LEFT", "K_LIKE", "K_LIMIT", "K_MATCH", "K_NATURAL", 
		"K_NO", "K_NOT", "K_NOTNULL", "K_NULL", "K_OF", "K_OFFSET", "K_ON", "K_OR", 
		"K_ORDER", "K_OUTER", "K_PLAN", "K_PRAGMA", "K_PRIMARY", "K_QUERY", "K_RAISE", 
		"K_RECURSIVE", "K_REFERENCES", "K_REGEXP", "K_REINDEX", "K_RELEASE", "K_RENAME", 
		"K_REPLACE", "K_RESTRICT", "K_RIGHT", "K_ROLLBACK", "K_ROW", "K_SAVEPOINT", 
		"K_SELECT", "K_SET", "K_TABLE", "K_TEMP", "K_TEMPORARY", "K_THEN", "K_TO", 
		"K_TRANSACTION", "K_TRIGGER", "K_UNION", "K_UNIQUE", "K_UPDATE", "K_USING", 
		"K_VACUUM", "K_VALUES", "K_VIEW", "K_VIRTUAL", "K_WHEN", "K_WHERE", "K_WITH", 
		"K_WITHOUT", "IDENTIFIER", "NUMERIC_LITERAL", "BIND_PARAMETER", "STRING_LITERAL", 
		"BLOB_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
		"UNEXPECTED_CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  @Override
	  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
	  {
	    throw new RuntimeException(msg); 
	  }

	public SqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public Sql_stmtContext sql_stmt() {
			return getRuleContext(Sql_stmtContext.class,0);
		}
		public ErrorContext error() {
			return getRuleContext(ErrorContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			switch (_input.LA(1)) {
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXPLAIN:
			case K_INSERT:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_UPDATE:
			case K_VACUUM:
			case K_VALUES:
			case K_WITH:
				{
				setState(162);
				sql_stmt();
				}
				break;
			case UNEXPECTED_CHAR:
				{
				setState(163);
				error();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(167);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(166);
				match(EOF);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ErrorContext extends ParserRuleContext {
		public Token UNEXPECTED_CHAR;
		public TerminalNode UNEXPECTED_CHAR() { return getToken(SqlParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitError(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((ErrorContext)_localctx).UNEXPECTED_CHAR = match(UNEXPECTED_CHAR);
			 
			     throw new RuntimeException("UNEXPECTED_CHAR=" + (((ErrorContext)_localctx).UNEXPECTED_CHAR!=null?((ErrorContext)_localctx).UNEXPECTED_CHAR.getText():null)); 
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmtContext extends ParserRuleContext {
		public Alter_table_stmtContext alter_table_stmt() {
			return getRuleContext(Alter_table_stmtContext.class,0);
		}
		public Analyze_stmtContext analyze_stmt() {
			return getRuleContext(Analyze_stmtContext.class,0);
		}
		public Attach_stmtContext attach_stmt() {
			return getRuleContext(Attach_stmtContext.class,0);
		}
		public Begin_stmtContext begin_stmt() {
			return getRuleContext(Begin_stmtContext.class,0);
		}
		public Commit_stmtContext commit_stmt() {
			return getRuleContext(Commit_stmtContext.class,0);
		}
		public Compound_select_stmtContext compound_select_stmt() {
			return getRuleContext(Compound_select_stmtContext.class,0);
		}
		public Create_index_stmtContext create_index_stmt() {
			return getRuleContext(Create_index_stmtContext.class,0);
		}
		public Create_table_stmtContext create_table_stmt() {
			return getRuleContext(Create_table_stmtContext.class,0);
		}
		public Create_trigger_stmtContext create_trigger_stmt() {
			return getRuleContext(Create_trigger_stmtContext.class,0);
		}
		public Create_view_stmtContext create_view_stmt() {
			return getRuleContext(Create_view_stmtContext.class,0);
		}
		public Create_virtual_table_stmtContext create_virtual_table_stmt() {
			return getRuleContext(Create_virtual_table_stmtContext.class,0);
		}
		public Delete_stmtContext delete_stmt() {
			return getRuleContext(Delete_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext delete_stmt_limited() {
			return getRuleContext(Delete_stmt_limitedContext.class,0);
		}
		public Detach_stmtContext detach_stmt() {
			return getRuleContext(Detach_stmtContext.class,0);
		}
		public Drop_index_stmtContext drop_index_stmt() {
			return getRuleContext(Drop_index_stmtContext.class,0);
		}
		public Drop_table_stmtContext drop_table_stmt() {
			return getRuleContext(Drop_table_stmtContext.class,0);
		}
		public Drop_trigger_stmtContext drop_trigger_stmt() {
			return getRuleContext(Drop_trigger_stmtContext.class,0);
		}
		public Drop_view_stmtContext drop_view_stmt() {
			return getRuleContext(Drop_view_stmtContext.class,0);
		}
		public Factored_select_stmtContext factored_select_stmt() {
			return getRuleContext(Factored_select_stmtContext.class,0);
		}
		public Insert_stmtContext insert_stmt() {
			return getRuleContext(Insert_stmtContext.class,0);
		}
		public Pragma_stmtContext pragma_stmt() {
			return getRuleContext(Pragma_stmtContext.class,0);
		}
		public Reindex_stmtContext reindex_stmt() {
			return getRuleContext(Reindex_stmtContext.class,0);
		}
		public Release_stmtContext release_stmt() {
			return getRuleContext(Release_stmtContext.class,0);
		}
		public Rollback_stmtContext rollback_stmt() {
			return getRuleContext(Rollback_stmtContext.class,0);
		}
		public Savepoint_stmtContext savepoint_stmt() {
			return getRuleContext(Savepoint_stmtContext.class,0);
		}
		public Simple_select_stmtContext simple_select_stmt() {
			return getRuleContext(Simple_select_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Update_stmtContext update_stmt() {
			return getRuleContext(Update_stmtContext.class,0);
		}
		public Update_stmt_limitedContext update_stmt_limited() {
			return getRuleContext(Update_stmt_limitedContext.class,0);
		}
		public Vacuum_stmtContext vacuum_stmt() {
			return getRuleContext(Vacuum_stmtContext.class,0);
		}
		public TerminalNode K_EXPLAIN() { return getToken(SqlParser.K_EXPLAIN, 0); }
		public TerminalNode K_QUERY() { return getToken(SqlParser.K_QUERY, 0); }
		public TerminalNode K_PLAN() { return getToken(SqlParser.K_PLAN, 0); }
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSql_stmt(this);
		}
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if (_la==K_EXPLAIN) {
				{
				setState(172);
				match(K_EXPLAIN);
				setState(175);
				_la = _input.LA(1);
				if (_la==K_QUERY) {
					{
					setState(173);
					match(K_QUERY);
					setState(174);
					match(K_PLAN);
					}
				}

				}
			}

			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(179);
				alter_table_stmt();
				}
				break;
			case 2:
				{
				setState(180);
				analyze_stmt();
				}
				break;
			case 3:
				{
				setState(181);
				attach_stmt();
				}
				break;
			case 4:
				{
				setState(182);
				begin_stmt();
				}
				break;
			case 5:
				{
				setState(183);
				commit_stmt();
				}
				break;
			case 6:
				{
				setState(184);
				compound_select_stmt();
				}
				break;
			case 7:
				{
				setState(185);
				create_index_stmt();
				}
				break;
			case 8:
				{
				setState(186);
				create_table_stmt();
				}
				break;
			case 9:
				{
				setState(187);
				create_trigger_stmt();
				}
				break;
			case 10:
				{
				setState(188);
				create_view_stmt();
				}
				break;
			case 11:
				{
				setState(189);
				create_virtual_table_stmt();
				}
				break;
			case 12:
				{
				setState(190);
				delete_stmt();
				}
				break;
			case 13:
				{
				setState(191);
				delete_stmt_limited();
				}
				break;
			case 14:
				{
				setState(192);
				detach_stmt();
				}
				break;
			case 15:
				{
				setState(193);
				drop_index_stmt();
				}
				break;
			case 16:
				{
				setState(194);
				drop_table_stmt();
				}
				break;
			case 17:
				{
				setState(195);
				drop_trigger_stmt();
				}
				break;
			case 18:
				{
				setState(196);
				drop_view_stmt();
				}
				break;
			case 19:
				{
				setState(197);
				factored_select_stmt();
				}
				break;
			case 20:
				{
				setState(198);
				insert_stmt();
				}
				break;
			case 21:
				{
				setState(199);
				pragma_stmt();
				}
				break;
			case 22:
				{
				setState(200);
				reindex_stmt();
				}
				break;
			case 23:
				{
				setState(201);
				release_stmt();
				}
				break;
			case 24:
				{
				setState(202);
				rollback_stmt();
				}
				break;
			case 25:
				{
				setState(203);
				savepoint_stmt();
				}
				break;
			case 26:
				{
				setState(204);
				simple_select_stmt();
				}
				break;
			case 27:
				{
				setState(205);
				select_stmt();
				}
				break;
			case 28:
				{
				setState(206);
				update_stmt();
				}
				break;
			case 29:
				{
				setState(207);
				update_stmt_limited();
				}
				break;
			case 30:
				{
				setState(208);
				vacuum_stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_ALTER() { return getToken(SqlParser.K_ALTER, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_RENAME() { return getToken(SqlParser.K_RENAME, 0); }
		public TerminalNode K_TO() { return getToken(SqlParser.K_TO, 0); }
		public New_table_nameContext new_table_name() {
			return getRuleContext(New_table_nameContext.class,0);
		}
		public TerminalNode K_ADD() { return getToken(SqlParser.K_ADD, 0); }
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_COLUMN() { return getToken(SqlParser.K_COLUMN, 0); }
		public Alter_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAlter_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAlter_table_stmt(this);
		}
	}

	public final Alter_table_stmtContext alter_table_stmt() throws RecognitionException {
		Alter_table_stmtContext _localctx = new Alter_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alter_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(K_ALTER);
			setState(212);
			match(K_TABLE);
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(213);
				database_name();
				setState(214);
				match(DOT);
				}
				break;
			}
			setState(218);
			table_name();
			setState(227);
			switch (_input.LA(1)) {
			case K_RENAME:
				{
				setState(219);
				match(K_RENAME);
				setState(220);
				match(K_TO);
				setState(221);
				new_table_name();
				}
				break;
			case K_ADD:
				{
				setState(222);
				match(K_ADD);
				setState(224);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(223);
					match(K_COLUMN);
					}
					break;
				}
				setState(226);
				column_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Analyze_stmtContext extends ParserRuleContext {
		public TerminalNode K_ANALYZE() { return getToken(SqlParser.K_ANALYZE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Table_or_index_nameContext table_or_index_name() {
			return getRuleContext(Table_or_index_nameContext.class,0);
		}
		public Analyze_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analyze_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAnalyze_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAnalyze_stmt(this);
		}
	}

	public final Analyze_stmtContext analyze_stmt() throws RecognitionException {
		Analyze_stmtContext _localctx = new Analyze_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_analyze_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(K_ANALYZE);
			setState(236);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(230);
				database_name();
				}
				break;
			case 2:
				{
				setState(231);
				table_or_index_name();
				}
				break;
			case 3:
				{
				setState(232);
				database_name();
				setState(233);
				match(DOT);
				setState(234);
				table_or_index_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attach_stmtContext extends ParserRuleContext {
		public TerminalNode K_ATTACH() { return getToken(SqlParser.K_ATTACH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASE() { return getToken(SqlParser.K_DATABASE, 0); }
		public Attach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attach_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAttach_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAttach_stmt(this);
		}
	}

	public final Attach_stmtContext attach_stmt() throws RecognitionException {
		Attach_stmtContext _localctx = new Attach_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(K_ATTACH);
			setState(240);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(239);
				match(K_DATABASE);
				}
				break;
			}
			setState(242);
			expr(0);
			setState(243);
			match(K_AS);
			setState(244);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Begin_stmtContext extends ParserRuleContext {
		public TerminalNode K_BEGIN() { return getToken(SqlParser.K_BEGIN, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SqlParser.K_TRANSACTION, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SqlParser.K_DEFERRED, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SqlParser.K_IMMEDIATE, 0); }
		public TerminalNode K_EXCLUSIVE() { return getToken(SqlParser.K_EXCLUSIVE, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Begin_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterBegin_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitBegin_stmt(this);
		}
	}

	public final Begin_stmtContext begin_stmt() throws RecognitionException {
		Begin_stmtContext _localctx = new Begin_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_begin_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(K_BEGIN);
			setState(248);
			_la = _input.LA(1);
			if (((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (K_DEFERRED - 58)) | (1L << (K_EXCLUSIVE - 58)) | (1L << (K_IMMEDIATE - 58)))) != 0)) {
				{
				setState(247);
				_la = _input.LA(1);
				if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (K_DEFERRED - 58)) | (1L << (K_EXCLUSIVE - 58)) | (1L << (K_IMMEDIATE - 58)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(254);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(250);
				match(K_TRANSACTION);
				setState(252);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << K_ABORT) | (1L << K_ACTION) | (1L << K_ADD) | (1L << K_AFTER) | (1L << K_ALL) | (1L << K_ALTER) | (1L << K_ANALYZE) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_ATTACH) | (1L << K_AUTOINCREMENT) | (1L << K_BEFORE) | (1L << K_BEGIN) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASCADE) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_CHECK) | (1L << K_COLLATE) | (1L << K_COLUMN) | (1L << K_COMMIT) | (1L << K_CONFLICT) | (1L << K_CONSTRAINT) | (1L << K_CREATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DATABASE) | (1L << K_DEFAULT) | (1L << K_DEFERRABLE) | (1L << K_DEFERRED) | (1L << K_DELETE) | (1L << K_DESC) | (1L << K_DETACH) | (1L << K_DISTINCT) | (1L << K_DROP))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_EACH - 64)) | (1L << (K_ELSE - 64)) | (1L << (K_END - 64)) | (1L << (K_ESCAPE - 64)) | (1L << (K_EXCEPT - 64)) | (1L << (K_EXCLUSIVE - 64)) | (1L << (K_EXISTS - 64)) | (1L << (K_EXPLAIN - 64)) | (1L << (K_FAIL - 64)) | (1L << (K_FOR - 64)) | (1L << (K_FOREIGN - 64)) | (1L << (K_FROM - 64)) | (1L << (K_FULL - 64)) | (1L << (K_GLOB - 64)) | (1L << (K_GROUP - 64)) | (1L << (K_HAVING - 64)) | (1L << (K_IF - 64)) | (1L << (K_IGNORE - 64)) | (1L << (K_IMMEDIATE - 64)) | (1L << (K_IN - 64)) | (1L << (K_INDEX - 64)) | (1L << (K_INDEXED - 64)) | (1L << (K_INITIALLY - 64)) | (1L << (K_INNER - 64)) | (1L << (K_INSERT - 64)) | (1L << (K_INSTEAD - 64)) | (1L << (K_INTERSECT - 64)) | (1L << (K_INTO - 64)) | (1L << (K_IS - 64)) | (1L << (K_ISNULL - 64)) | (1L << (K_JOIN - 64)) | (1L << (K_KEY - 64)) | (1L << (K_LEFT - 64)) | (1L << (K_LIKE - 64)) | (1L << (K_LIMIT - 64)) | (1L << (K_MATCH - 64)) | (1L << (K_NATURAL - 64)) | (1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OF - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_PLAN - 64)) | (1L << (K_PRAGMA - 64)) | (1L << (K_PRIMARY - 64)) | (1L << (K_QUERY - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REFERENCES - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_REINDEX - 64)) | (1L << (K_RELEASE - 64)) | (1L << (K_RENAME - 64)) | (1L << (K_REPLACE - 64)) | (1L << (K_RESTRICT - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_ROW - 64)) | (1L << (K_SAVEPOINT - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (K_SELECT - 128)) | (1L << (K_SET - 128)) | (1L << (K_TABLE - 128)) | (1L << (K_TEMP - 128)) | (1L << (K_TEMPORARY - 128)) | (1L << (K_THEN - 128)) | (1L << (K_TO - 128)) | (1L << (K_TRANSACTION - 128)) | (1L << (K_TRIGGER - 128)) | (1L << (K_UNION - 128)) | (1L << (K_UNIQUE - 128)) | (1L << (K_UPDATE - 128)) | (1L << (K_USING - 128)) | (1L << (K_VACUUM - 128)) | (1L << (K_VALUES - 128)) | (1L << (K_VIEW - 128)) | (1L << (K_VIRTUAL - 128)) | (1L << (K_WHEN - 128)) | (1L << (K_WHERE - 128)) | (1L << (K_WITH - 128)) | (1L << (K_WITHOUT - 128)) | (1L << (IDENTIFIER - 128)))) != 0)) {
					{
					setState(251);
					transaction_name();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Commit_stmtContext extends ParserRuleContext {
		public TerminalNode K_COMMIT() { return getToken(SqlParser.K_COMMIT, 0); }
		public TerminalNode K_END() { return getToken(SqlParser.K_END, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SqlParser.K_TRANSACTION, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Commit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCommit_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCommit_stmt(this);
		}
	}

	public final Commit_stmtContext commit_stmt() throws RecognitionException {
		Commit_stmtContext _localctx = new Commit_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_commit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !(_la==K_COMMIT || _la==K_END) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(261);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(257);
				match(K_TRANSACTION);
				setState(259);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << K_ABORT) | (1L << K_ACTION) | (1L << K_ADD) | (1L << K_AFTER) | (1L << K_ALL) | (1L << K_ALTER) | (1L << K_ANALYZE) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_ATTACH) | (1L << K_AUTOINCREMENT) | (1L << K_BEFORE) | (1L << K_BEGIN) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASCADE) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_CHECK) | (1L << K_COLLATE) | (1L << K_COLUMN) | (1L << K_COMMIT) | (1L << K_CONFLICT) | (1L << K_CONSTRAINT) | (1L << K_CREATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DATABASE) | (1L << K_DEFAULT) | (1L << K_DEFERRABLE) | (1L << K_DEFERRED) | (1L << K_DELETE) | (1L << K_DESC) | (1L << K_DETACH) | (1L << K_DISTINCT) | (1L << K_DROP))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_EACH - 64)) | (1L << (K_ELSE - 64)) | (1L << (K_END - 64)) | (1L << (K_ESCAPE - 64)) | (1L << (K_EXCEPT - 64)) | (1L << (K_EXCLUSIVE - 64)) | (1L << (K_EXISTS - 64)) | (1L << (K_EXPLAIN - 64)) | (1L << (K_FAIL - 64)) | (1L << (K_FOR - 64)) | (1L << (K_FOREIGN - 64)) | (1L << (K_FROM - 64)) | (1L << (K_FULL - 64)) | (1L << (K_GLOB - 64)) | (1L << (K_GROUP - 64)) | (1L << (K_HAVING - 64)) | (1L << (K_IF - 64)) | (1L << (K_IGNORE - 64)) | (1L << (K_IMMEDIATE - 64)) | (1L << (K_IN - 64)) | (1L << (K_INDEX - 64)) | (1L << (K_INDEXED - 64)) | (1L << (K_INITIALLY - 64)) | (1L << (K_INNER - 64)) | (1L << (K_INSERT - 64)) | (1L << (K_INSTEAD - 64)) | (1L << (K_INTERSECT - 64)) | (1L << (K_INTO - 64)) | (1L << (K_IS - 64)) | (1L << (K_ISNULL - 64)) | (1L << (K_JOIN - 64)) | (1L << (K_KEY - 64)) | (1L << (K_LEFT - 64)) | (1L << (K_LIKE - 64)) | (1L << (K_LIMIT - 64)) | (1L << (K_MATCH - 64)) | (1L << (K_NATURAL - 64)) | (1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OF - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_PLAN - 64)) | (1L << (K_PRAGMA - 64)) | (1L << (K_PRIMARY - 64)) | (1L << (K_QUERY - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REFERENCES - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_REINDEX - 64)) | (1L << (K_RELEASE - 64)) | (1L << (K_RENAME - 64)) | (1L << (K_REPLACE - 64)) | (1L << (K_RESTRICT - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_ROW - 64)) | (1L << (K_SAVEPOINT - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (K_SELECT - 128)) | (1L << (K_SET - 128)) | (1L << (K_TABLE - 128)) | (1L << (K_TEMP - 128)) | (1L << (K_TEMPORARY - 128)) | (1L << (K_THEN - 128)) | (1L << (K_TO - 128)) | (1L << (K_TRANSACTION - 128)) | (1L << (K_TRIGGER - 128)) | (1L << (K_UNION - 128)) | (1L << (K_UNIQUE - 128)) | (1L << (K_UPDATE - 128)) | (1L << (K_USING - 128)) | (1L << (K_VACUUM - 128)) | (1L << (K_VALUES - 128)) | (1L << (K_VIEW - 128)) | (1L << (K_VIRTUAL - 128)) | (1L << (K_WHEN - 128)) | (1L << (K_WHERE - 128)) | (1L << (K_WITH - 128)) | (1L << (K_WITHOUT - 128)) | (1L << (IDENTIFIER - 128)))) != 0)) {
					{
					setState(258);
					transaction_name();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SqlParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> K_UNION() { return getTokens(SqlParser.K_UNION); }
		public TerminalNode K_UNION(int i) {
			return getToken(SqlParser.K_UNION, i);
		}
		public List<TerminalNode> K_INTERSECT() { return getTokens(SqlParser.K_INTERSECT); }
		public TerminalNode K_INTERSECT(int i) {
			return getToken(SqlParser.K_INTERSECT, i);
		}
		public List<TerminalNode> K_EXCEPT() { return getTokens(SqlParser.K_EXCEPT); }
		public TerminalNode K_EXCEPT(int i) {
			return getToken(SqlParser.K_EXCEPT, i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SqlParser.K_RECURSIVE, 0); }
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public List<TerminalNode> K_ALL() { return getTokens(SqlParser.K_ALL); }
		public TerminalNode K_ALL(int i) {
			return getToken(SqlParser.K_ALL, i);
		}
		public Compound_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCompound_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCompound_select_stmt(this);
		}
	}

	public final Compound_select_stmtContext compound_select_stmt() throws RecognitionException {
		Compound_select_stmtContext _localctx = new Compound_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compound_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(263);
				match(K_WITH);
				setState(265);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(264);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(267);
				common_table_expression();
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(268);
					match(COMMA);
					setState(269);
					common_table_expression();
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(277);
			select_core();
			setState(287); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(284);
				switch (_input.LA(1)) {
				case K_UNION:
					{
					setState(278);
					match(K_UNION);
					setState(280);
					_la = _input.LA(1);
					if (_la==K_ALL) {
						{
						setState(279);
						match(K_ALL);
						}
					}

					}
					break;
				case K_INTERSECT:
					{
					setState(282);
					match(K_INTERSECT);
					}
					break;
				case K_EXCEPT:
					{
					setState(283);
					match(K_EXCEPT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(286);
				select_core();
				}
				}
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION );
			setState(301);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(291);
				match(K_ORDER);
				setState(292);
				match(K_BY);
				setState(293);
				ordering_term();
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(294);
					match(COMMA);
					setState(295);
					ordering_term();
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(309);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(303);
				match(K_LIMIT);
				setState(304);
				expr(0);
				setState(307);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(305);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(306);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_index_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_INDEX() { return getToken(SqlParser.K_INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(SqlParser.K_ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode K_UNIQUE() { return getToken(SqlParser.K_UNIQUE, 0); }
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Create_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_index_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCreate_index_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCreate_index_stmt(this);
		}
	}

	public final Create_index_stmtContext create_index_stmt() throws RecognitionException {
		Create_index_stmtContext _localctx = new Create_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_create_index_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(K_CREATE);
			setState(313);
			_la = _input.LA(1);
			if (_la==K_UNIQUE) {
				{
				setState(312);
				match(K_UNIQUE);
				}
			}

			setState(315);
			match(K_INDEX);
			setState(319);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(316);
				match(K_IF);
				setState(317);
				match(K_NOT);
				setState(318);
				match(K_EXISTS);
				}
				break;
			}
			setState(324);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(321);
				database_name();
				setState(322);
				match(DOT);
				}
				break;
			}
			setState(326);
			index_name();
			setState(327);
			match(K_ON);
			setState(328);
			table_name();
			setState(329);
			match(OPEN_PAR);
			setState(330);
			indexed_column();
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(331);
				match(COMMA);
				setState(332);
				indexed_column();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
			match(CLOSE_PAR);
			setState(341);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(339);
				match(K_WHERE);
				setState(340);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<Column_defContext> column_def() {
			return getRuleContexts(Column_defContext.class);
		}
		public Column_defContext column_def(int i) {
			return getRuleContext(Column_defContext.class,i);
		}
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode K_WITHOUT() { return getToken(SqlParser.K_WITHOUT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public Create_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCreate_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCreate_table_stmt(this);
		}
	}

	public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
		Create_table_stmtContext _localctx = new Create_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create_table_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(K_CREATE);
			setState(344);
			match(K_TABLE);
			setState(345);
			table_name();
			setState(369);
			switch (_input.LA(1)) {
			case OPEN_PAR:
				{
				setState(346);
				match(OPEN_PAR);
				setState(347);
				column_def();
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(348);
						match(COMMA);
						setState(349);
						column_def();
						}
						} 
					}
					setState(354);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(355);
					match(COMMA);
					setState(356);
					table_constraint();
					}
					}
					setState(361);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(362);
				match(CLOSE_PAR);
				setState(365);
				_la = _input.LA(1);
				if (_la==K_WITHOUT) {
					{
					setState(363);
					match(K_WITHOUT);
					setState(364);
					match(IDENTIFIER);
					}
				}

				}
				break;
			case K_AS:
				{
				setState(367);
				match(K_AS);
				setState(368);
				select_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SqlParser.K_TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(SqlParser.K_ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_BEGIN() { return getToken(SqlParser.K_BEGIN, 0); }
		public TerminalNode K_END() { return getToken(SqlParser.K_END, 0); }
		public TerminalNode K_DELETE() { return getToken(SqlParser.K_DELETE, 0); }
		public TerminalNode K_INSERT() { return getToken(SqlParser.K_INSERT, 0); }
		public TerminalNode K_UPDATE() { return getToken(SqlParser.K_UPDATE, 0); }
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public List<Database_nameContext> database_name() {
			return getRuleContexts(Database_nameContext.class);
		}
		public Database_nameContext database_name(int i) {
			return getRuleContext(Database_nameContext.class,i);
		}
		public TerminalNode K_BEFORE() { return getToken(SqlParser.K_BEFORE, 0); }
		public TerminalNode K_AFTER() { return getToken(SqlParser.K_AFTER, 0); }
		public TerminalNode K_INSTEAD() { return getToken(SqlParser.K_INSTEAD, 0); }
		public List<TerminalNode> K_OF() { return getTokens(SqlParser.K_OF); }
		public TerminalNode K_OF(int i) {
			return getToken(SqlParser.K_OF, i);
		}
		public TerminalNode K_FOR() { return getToken(SqlParser.K_FOR, 0); }
		public TerminalNode K_EACH() { return getToken(SqlParser.K_EACH, 0); }
		public TerminalNode K_ROW() { return getToken(SqlParser.K_ROW, 0); }
		public TerminalNode K_WHEN() { return getToken(SqlParser.K_WHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_TEMP() { return getToken(SqlParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SqlParser.K_TEMPORARY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Update_stmtContext> update_stmt() {
			return getRuleContexts(Update_stmtContext.class);
		}
		public Update_stmtContext update_stmt(int i) {
			return getRuleContext(Update_stmtContext.class,i);
		}
		public List<Insert_stmtContext> insert_stmt() {
			return getRuleContexts(Insert_stmtContext.class);
		}
		public Insert_stmtContext insert_stmt(int i) {
			return getRuleContext(Insert_stmtContext.class,i);
		}
		public List<Delete_stmtContext> delete_stmt() {
			return getRuleContexts(Delete_stmtContext.class);
		}
		public Delete_stmtContext delete_stmt(int i) {
			return getRuleContext(Delete_stmtContext.class,i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public Create_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_trigger_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCreate_trigger_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCreate_trigger_stmt(this);
		}
	}

	public final Create_trigger_stmtContext create_trigger_stmt() throws RecognitionException {
		Create_trigger_stmtContext _localctx = new Create_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_create_trigger_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(K_CREATE);
			setState(373);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(372);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(375);
			match(K_TRIGGER);
			setState(379);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(376);
				match(K_IF);
				setState(377);
				match(K_NOT);
				setState(378);
				match(K_EXISTS);
				}
				break;
			}
			setState(384);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(381);
				database_name();
				setState(382);
				match(DOT);
				}
				break;
			}
			setState(386);
			trigger_name();
			setState(391);
			switch (_input.LA(1)) {
			case K_BEFORE:
				{
				setState(387);
				match(K_BEFORE);
				}
				break;
			case K_AFTER:
				{
				setState(388);
				match(K_AFTER);
				}
				break;
			case K_INSTEAD:
				{
				setState(389);
				match(K_INSTEAD);
				setState(390);
				match(K_OF);
				}
				break;
			case K_DELETE:
			case K_INSERT:
			case K_UPDATE:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(407);
			switch (_input.LA(1)) {
			case K_DELETE:
				{
				setState(393);
				match(K_DELETE);
				}
				break;
			case K_INSERT:
				{
				setState(394);
				match(K_INSERT);
				}
				break;
			case K_UPDATE:
				{
				setState(395);
				match(K_UPDATE);
				setState(405);
				_la = _input.LA(1);
				if (_la==K_OF) {
					{
					setState(396);
					match(K_OF);
					setState(397);
					column_name();
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(398);
						match(COMMA);
						setState(399);
						column_name();
						}
						}
						setState(404);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(409);
			match(K_ON);
			setState(413);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(410);
				database_name();
				setState(411);
				match(DOT);
				}
				break;
			}
			setState(415);
			table_name();
			setState(419);
			_la = _input.LA(1);
			if (_la==K_FOR) {
				{
				setState(416);
				match(K_FOR);
				setState(417);
				match(K_EACH);
				setState(418);
				match(K_ROW);
				}
			}

			setState(423);
			_la = _input.LA(1);
			if (_la==K_WHEN) {
				{
				setState(421);
				match(K_WHEN);
				setState(422);
				expr(0);
				}
			}

			setState(425);
			match(K_BEGIN);
			setState(434); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(430);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(426);
					update_stmt();
					}
					break;
				case 2:
					{
					setState(427);
					insert_stmt();
					}
					break;
				case 3:
					{
					setState(428);
					delete_stmt();
					}
					break;
				case 4:
					{
					setState(429);
					select_stmt();
					}
					break;
				}
				setState(432);
				match(SCOL);
				}
				}
				setState(436); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_DELETE || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (K_INSERT - 88)) | (1L << (K_REPLACE - 88)) | (1L << (K_SELECT - 88)) | (1L << (K_UPDATE - 88)) | (1L << (K_VALUES - 88)) | (1L << (K_WITH - 88)))) != 0) );
			setState(438);
			match(K_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_view_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_VIEW() { return getToken(SqlParser.K_VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_TEMP() { return getToken(SqlParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SqlParser.K_TEMPORARY, 0); }
		public Create_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_view_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCreate_view_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCreate_view_stmt(this);
		}
	}

	public final Create_view_stmtContext create_view_stmt() throws RecognitionException {
		Create_view_stmtContext _localctx = new Create_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_create_view_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(K_CREATE);
			setState(442);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(441);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(444);
			match(K_VIEW);
			setState(448);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(445);
				match(K_IF);
				setState(446);
				match(K_NOT);
				setState(447);
				match(K_EXISTS);
				}
				break;
			}
			setState(453);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(450);
				database_name();
				setState(451);
				match(DOT);
				}
				break;
			}
			setState(455);
			view_name();
			setState(456);
			match(K_AS);
			setState(457);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_virtual_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_VIRTUAL() { return getToken(SqlParser.K_VIRTUAL, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(SqlParser.K_USING, 0); }
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public List<Module_argumentContext> module_argument() {
			return getRuleContexts(Module_argumentContext.class);
		}
		public Module_argumentContext module_argument(int i) {
			return getRuleContext(Module_argumentContext.class,i);
		}
		public Create_virtual_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_virtual_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCreate_virtual_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCreate_virtual_table_stmt(this);
		}
	}

	public final Create_virtual_table_stmtContext create_virtual_table_stmt() throws RecognitionException {
		Create_virtual_table_stmtContext _localctx = new Create_virtual_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_create_virtual_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(K_CREATE);
			setState(460);
			match(K_VIRTUAL);
			setState(461);
			match(K_TABLE);
			setState(465);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(462);
				match(K_IF);
				setState(463);
				match(K_NOT);
				setState(464);
				match(K_EXISTS);
				}
				break;
			}
			setState(470);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(467);
				database_name();
				setState(468);
				match(DOT);
				}
				break;
			}
			setState(472);
			table_name();
			setState(473);
			match(K_USING);
			setState(474);
			module_name();
			setState(486);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(475);
				match(OPEN_PAR);
				setState(476);
				module_argument();
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(477);
					match(COMMA);
					setState(478);
					module_argument();
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(484);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmtContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(SqlParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(SqlParser.K_FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Delete_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDelete_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDelete_stmt(this);
		}
	}

	public final Delete_stmtContext delete_stmt() throws RecognitionException {
		Delete_stmtContext _localctx = new Delete_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_delete_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(488);
				with_clause();
				}
			}

			setState(491);
			match(K_DELETE);
			setState(492);
			match(K_FROM);
			setState(493);
			qualified_table_name();
			setState(496);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(494);
				match(K_WHERE);
				setState(495);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(SqlParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(SqlParser.K_FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public Delete_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDelete_stmt_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDelete_stmt_limited(this);
		}
	}

	public final Delete_stmt_limitedContext delete_stmt_limited() throws RecognitionException {
		Delete_stmt_limitedContext _localctx = new Delete_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_delete_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(498);
				with_clause();
				}
			}

			setState(501);
			match(K_DELETE);
			setState(502);
			match(K_FROM);
			setState(503);
			qualified_table_name();
			setState(506);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(504);
				match(K_WHERE);
				setState(505);
				expr(0);
				}
			}

			setState(526);
			_la = _input.LA(1);
			if (_la==K_LIMIT || _la==K_ORDER) {
				{
				setState(518);
				_la = _input.LA(1);
				if (_la==K_ORDER) {
					{
					setState(508);
					match(K_ORDER);
					setState(509);
					match(K_BY);
					setState(510);
					ordering_term();
					setState(515);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(511);
						match(COMMA);
						setState(512);
						ordering_term();
						}
						}
						setState(517);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(520);
				match(K_LIMIT);
				setState(521);
				expr(0);
				setState(524);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(522);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(523);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Detach_stmtContext extends ParserRuleContext {
		public TerminalNode K_DETACH() { return getToken(SqlParser.K_DETACH, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASE() { return getToken(SqlParser.K_DATABASE, 0); }
		public Detach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detach_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDetach_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDetach_stmt(this);
		}
	}

	public final Detach_stmtContext detach_stmt() throws RecognitionException {
		Detach_stmtContext _localctx = new Detach_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_detach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(K_DETACH);
			setState(530);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(529);
				match(K_DATABASE);
				}
				break;
			}
			setState(532);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_index_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SqlParser.K_DROP, 0); }
		public TerminalNode K_INDEX() { return getToken(SqlParser.K_INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_index_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDrop_index_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDrop_index_stmt(this);
		}
	}

	public final Drop_index_stmtContext drop_index_stmt() throws RecognitionException {
		Drop_index_stmtContext _localctx = new Drop_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_drop_index_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(K_DROP);
			setState(535);
			match(K_INDEX);
			setState(538);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(536);
				match(K_IF);
				setState(537);
				match(K_EXISTS);
				}
				break;
			}
			setState(543);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(540);
				database_name();
				setState(541);
				match(DOT);
				}
				break;
			}
			setState(545);
			index_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SqlParser.K_DROP, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDrop_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDrop_table_stmt(this);
		}
	}

	public final Drop_table_stmtContext drop_table_stmt() throws RecognitionException {
		Drop_table_stmtContext _localctx = new Drop_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_drop_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(K_DROP);
			setState(548);
			match(K_TABLE);
			setState(551);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(549);
				match(K_IF);
				setState(550);
				match(K_EXISTS);
				}
				break;
			}
			setState(556);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(553);
				database_name();
				setState(554);
				match(DOT);
				}
				break;
			}
			setState(558);
			table_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SqlParser.K_DROP, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SqlParser.K_TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_trigger_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDrop_trigger_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDrop_trigger_stmt(this);
		}
	}

	public final Drop_trigger_stmtContext drop_trigger_stmt() throws RecognitionException {
		Drop_trigger_stmtContext _localctx = new Drop_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_drop_trigger_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(K_DROP);
			setState(561);
			match(K_TRIGGER);
			setState(564);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(562);
				match(K_IF);
				setState(563);
				match(K_EXISTS);
				}
				break;
			}
			setState(569);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(566);
				database_name();
				setState(567);
				match(DOT);
				}
				break;
			}
			setState(571);
			trigger_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_view_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SqlParser.K_DROP, 0); }
		public TerminalNode K_VIEW() { return getToken(SqlParser.K_VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_view_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDrop_view_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDrop_view_stmt(this);
		}
	}

	public final Drop_view_stmtContext drop_view_stmt() throws RecognitionException {
		Drop_view_stmtContext _localctx = new Drop_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_drop_view_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			match(K_DROP);
			setState(574);
			match(K_VIEW);
			setState(577);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(575);
				match(K_IF);
				setState(576);
				match(K_EXISTS);
				}
				break;
			}
			setState(582);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(579);
				database_name();
				setState(580);
				match(DOT);
				}
				break;
			}
			setState(584);
			view_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factored_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SqlParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SqlParser.K_RECURSIVE, 0); }
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public Factored_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factored_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFactored_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFactored_select_stmt(this);
		}
	}

	public final Factored_select_stmtContext factored_select_stmt() throws RecognitionException {
		Factored_select_stmtContext _localctx = new Factored_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factored_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(586);
				match(K_WITH);
				setState(588);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(587);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(590);
				common_table_expression();
				setState(595);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(591);
					match(COMMA);
					setState(592);
					common_table_expression();
					}
					}
					setState(597);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(600);
			select_core();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION) {
				{
				{
				setState(601);
				compound_operator();
				setState(602);
				select_core();
				}
				}
				setState(608);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(619);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(609);
				match(K_ORDER);
				setState(610);
				match(K_BY);
				setState(611);
				ordering_term();
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(612);
					match(COMMA);
					setState(613);
					ordering_term();
					}
					}
					setState(618);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(627);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(621);
				match(K_LIMIT);
				setState(622);
				expr(0);
				setState(625);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(623);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(624);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_stmtContext extends ParserRuleContext {
		public TerminalNode K_INTO() { return getToken(SqlParser.K_INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_INSERT() { return getToken(SqlParser.K_INSERT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SqlParser.K_REPLACE, 0); }
		public TerminalNode K_OR() { return getToken(SqlParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SqlParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SqlParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SqlParser.K_IGNORE, 0); }
		public TerminalNode K_VALUES() { return getToken(SqlParser.K_VALUES, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_DEFAULT() { return getToken(SqlParser.K_DEFAULT, 0); }
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Insert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterInsert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitInsert_stmt(this);
		}
	}

	public final Insert_stmtContext insert_stmt() throws RecognitionException {
		Insert_stmtContext _localctx = new Insert_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_insert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(629);
				with_clause();
				}
			}

			setState(649);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				{
				setState(632);
				match(K_INSERT);
				}
				break;
			case 2:
				{
				setState(633);
				match(K_REPLACE);
				}
				break;
			case 3:
				{
				setState(634);
				match(K_INSERT);
				setState(635);
				match(K_OR);
				setState(636);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(637);
				match(K_INSERT);
				setState(638);
				match(K_OR);
				setState(639);
				match(K_ROLLBACK);
				}
				break;
			case 5:
				{
				setState(640);
				match(K_INSERT);
				setState(641);
				match(K_OR);
				setState(642);
				match(K_ABORT);
				}
				break;
			case 6:
				{
				setState(643);
				match(K_INSERT);
				setState(644);
				match(K_OR);
				setState(645);
				match(K_FAIL);
				}
				break;
			case 7:
				{
				setState(646);
				match(K_INSERT);
				setState(647);
				match(K_OR);
				setState(648);
				match(K_IGNORE);
				}
				break;
			}
			setState(651);
			match(K_INTO);
			setState(652);
			table_name();
			setState(664);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(653);
				match(OPEN_PAR);
				setState(654);
				column_name();
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(655);
					match(COMMA);
					setState(656);
					column_name();
					}
					}
					setState(661);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(662);
				match(CLOSE_PAR);
				}
			}

			setState(701);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(666);
				match(K_VALUES);
				setState(667);
				match(OPEN_PAR);
				setState(669);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << K_ABORT) | (1L << K_ACTION) | (1L << K_ADD) | (1L << K_AFTER) | (1L << K_ALL) | (1L << K_ALTER) | (1L << K_ANALYZE) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_ATTACH) | (1L << K_AUTOINCREMENT) | (1L << K_BEFORE) | (1L << K_BEGIN) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASCADE) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_CHECK) | (1L << K_COLLATE) | (1L << K_COLUMN) | (1L << K_COMMIT) | (1L << K_CONFLICT) | (1L << K_CONSTRAINT) | (1L << K_CREATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DATABASE) | (1L << K_DEFAULT) | (1L << K_DEFERRABLE) | (1L << K_DEFERRED) | (1L << K_DELETE) | (1L << K_DESC) | (1L << K_DETACH) | (1L << K_DISTINCT) | (1L << K_DROP))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_EACH - 64)) | (1L << (K_ELSE - 64)) | (1L << (K_END - 64)) | (1L << (K_ESCAPE - 64)) | (1L << (K_EXCEPT - 64)) | (1L << (K_EXCLUSIVE - 64)) | (1L << (K_EXISTS - 64)) | (1L << (K_EXPLAIN - 64)) | (1L << (K_FAIL - 64)) | (1L << (K_FOR - 64)) | (1L << (K_FOREIGN - 64)) | (1L << (K_FROM - 64)) | (1L << (K_FULL - 64)) | (1L << (K_GLOB - 64)) | (1L << (K_GROUP - 64)) | (1L << (K_HAVING - 64)) | (1L << (K_IF - 64)) | (1L << (K_IGNORE - 64)) | (1L << (K_IMMEDIATE - 64)) | (1L << (K_IN - 64)) | (1L << (K_INDEX - 64)) | (1L << (K_INDEXED - 64)) | (1L << (K_INITIALLY - 64)) | (1L << (K_INNER - 64)) | (1L << (K_INSERT - 64)) | (1L << (K_INSTEAD - 64)) | (1L << (K_INTERSECT - 64)) | (1L << (K_INTO - 64)) | (1L << (K_IS - 64)) | (1L << (K_ISNULL - 64)) | (1L << (K_JOIN - 64)) | (1L << (K_KEY - 64)) | (1L << (K_LEFT - 64)) | (1L << (K_LIKE - 64)) | (1L << (K_LIMIT - 64)) | (1L << (K_MATCH - 64)) | (1L << (K_NATURAL - 64)) | (1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OF - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_PLAN - 64)) | (1L << (K_PRAGMA - 64)) | (1L << (K_PRIMARY - 64)) | (1L << (K_QUERY - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REFERENCES - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_REINDEX - 64)) | (1L << (K_RELEASE - 64)) | (1L << (K_RENAME - 64)) | (1L << (K_REPLACE - 64)) | (1L << (K_RESTRICT - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_ROW - 64)) | (1L << (K_SAVEPOINT - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (K_SELECT - 128)) | (1L << (K_SET - 128)) | (1L << (K_TABLE - 128)) | (1L << (K_TEMP - 128)) | (1L << (K_TEMPORARY - 128)) | (1L << (K_THEN - 128)) | (1L << (K_TO - 128)) | (1L << (K_TRANSACTION - 128)) | (1L << (K_TRIGGER - 128)) | (1L << (K_UNION - 128)) | (1L << (K_UNIQUE - 128)) | (1L << (K_UPDATE - 128)) | (1L << (K_USING - 128)) | (1L << (K_VACUUM - 128)) | (1L << (K_VALUES - 128)) | (1L << (K_VIEW - 128)) | (1L << (K_VIRTUAL - 128)) | (1L << (K_WHEN - 128)) | (1L << (K_WHERE - 128)) | (1L << (K_WITH - 128)) | (1L << (K_WITHOUT - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NUMERIC_LITERAL - 128)) | (1L << (BIND_PARAMETER - 128)) | (1L << (STRING_LITERAL - 128)) | (1L << (BLOB_LITERAL - 128)))) != 0)) {
					{
					setState(668);
					expr(0);
					}
				}

				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(671);
					match(COMMA);
					setState(673);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << K_ABORT) | (1L << K_ACTION) | (1L << K_ADD) | (1L << K_AFTER) | (1L << K_ALL) | (1L << K_ALTER) | (1L << K_ANALYZE) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_ATTACH) | (1L << K_AUTOINCREMENT) | (1L << K_BEFORE) | (1L << K_BEGIN) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASCADE) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_CHECK) | (1L << K_COLLATE) | (1L << K_COLUMN) | (1L << K_COMMIT) | (1L << K_CONFLICT) | (1L << K_CONSTRAINT) | (1L << K_CREATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DATABASE) | (1L << K_DEFAULT) | (1L << K_DEFERRABLE) | (1L << K_DEFERRED) | (1L << K_DELETE) | (1L << K_DESC) | (1L << K_DETACH) | (1L << K_DISTINCT) | (1L << K_DROP))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_EACH - 64)) | (1L << (K_ELSE - 64)) | (1L << (K_END - 64)) | (1L << (K_ESCAPE - 64)) | (1L << (K_EXCEPT - 64)) | (1L << (K_EXCLUSIVE - 64)) | (1L << (K_EXISTS - 64)) | (1L << (K_EXPLAIN - 64)) | (1L << (K_FAIL - 64)) | (1L << (K_FOR - 64)) | (1L << (K_FOREIGN - 64)) | (1L << (K_FROM - 64)) | (1L << (K_FULL - 64)) | (1L << (K_GLOB - 64)) | (1L << (K_GROUP - 64)) | (1L << (K_HAVING - 64)) | (1L << (K_IF - 64)) | (1L << (K_IGNORE - 64)) | (1L << (K_IMMEDIATE - 64)) | (1L << (K_IN - 64)) | (1L << (K_INDEX - 64)) | (1L << (K_INDEXED - 64)) | (1L << (K_INITIALLY - 64)) | (1L << (K_INNER - 64)) | (1L << (K_INSERT - 64)) | (1L << (K_INSTEAD - 64)) | (1L << (K_INTERSECT - 64)) | (1L << (K_INTO - 64)) | (1L << (K_IS - 64)) | (1L << (K_ISNULL - 64)) | (1L << (K_JOIN - 64)) | (1L << (K_KEY - 64)) | (1L << (K_LEFT - 64)) | (1L << (K_LIKE - 64)) | (1L << (K_LIMIT - 64)) | (1L << (K_MATCH - 64)) | (1L << (K_NATURAL - 64)) | (1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OF - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_PLAN - 64)) | (1L << (K_PRAGMA - 64)) | (1L << (K_PRIMARY - 64)) | (1L << (K_QUERY - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REFERENCES - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_REINDEX - 64)) | (1L << (K_RELEASE - 64)) | (1L << (K_RENAME - 64)) | (1L << (K_REPLACE - 64)) | (1L << (K_RESTRICT - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_ROW - 64)) | (1L << (K_SAVEPOINT - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (K_SELECT - 128)) | (1L << (K_SET - 128)) | (1L << (K_TABLE - 128)) | (1L << (K_TEMP - 128)) | (1L << (K_TEMPORARY - 128)) | (1L << (K_THEN - 128)) | (1L << (K_TO - 128)) | (1L << (K_TRANSACTION - 128)) | (1L << (K_TRIGGER - 128)) | (1L << (K_UNION - 128)) | (1L << (K_UNIQUE - 128)) | (1L << (K_UPDATE - 128)) | (1L << (K_USING - 128)) | (1L << (K_VACUUM - 128)) | (1L << (K_VALUES - 128)) | (1L << (K_VIEW - 128)) | (1L << (K_VIRTUAL - 128)) | (1L << (K_WHEN - 128)) | (1L << (K_WHERE - 128)) | (1L << (K_WITH - 128)) | (1L << (K_WITHOUT - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NUMERIC_LITERAL - 128)) | (1L << (BIND_PARAMETER - 128)) | (1L << (STRING_LITERAL - 128)) | (1L << (BLOB_LITERAL - 128)))) != 0)) {
						{
						setState(672);
						expr(0);
						}
					}

					}
					}
					setState(679);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(680);
				match(CLOSE_PAR);
				setState(695);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(681);
					match(COMMA);
					setState(682);
					match(OPEN_PAR);
					setState(683);
					expr(0);
					setState(688);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(684);
						match(COMMA);
						setState(685);
						expr(0);
						}
						}
						setState(690);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(691);
					match(CLOSE_PAR);
					}
					}
					setState(697);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(698);
				select_stmt();
				}
				break;
			case 3:
				{
				setState(699);
				match(K_DEFAULT);
				setState(700);
				match(K_VALUES);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_stmtContext extends ParserRuleContext {
		public TerminalNode K_PRAGMA() { return getToken(SqlParser.K_PRAGMA, 0); }
		public Pragma_nameContext pragma_name() {
			return getRuleContext(Pragma_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Pragma_valueContext pragma_value() {
			return getRuleContext(Pragma_valueContext.class,0);
		}
		public Pragma_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterPragma_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitPragma_stmt(this);
		}
	}

	public final Pragma_stmtContext pragma_stmt() throws RecognitionException {
		Pragma_stmtContext _localctx = new Pragma_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pragma_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			match(K_PRAGMA);
			setState(707);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(704);
				database_name();
				setState(705);
				match(DOT);
				}
				break;
			}
			setState(709);
			pragma_name();
			setState(716);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(710);
				match(ASSIGN);
				setState(711);
				pragma_value();
				}
				break;
			case OPEN_PAR:
				{
				setState(712);
				match(OPEN_PAR);
				setState(713);
				pragma_value();
				setState(714);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reindex_stmtContext extends ParserRuleContext {
		public TerminalNode K_REINDEX() { return getToken(SqlParser.K_REINDEX, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Reindex_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reindex_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterReindex_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitReindex_stmt(this);
		}
	}

	public final Reindex_stmtContext reindex_stmt() throws RecognitionException {
		Reindex_stmtContext _localctx = new Reindex_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_reindex_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			match(K_REINDEX);
			setState(729);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(719);
				collation_name();
				}
				break;
			case 2:
				{
				setState(723);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(720);
					database_name();
					setState(721);
					match(DOT);
					}
					break;
				}
				setState(727);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(725);
					table_name();
					}
					break;
				case 2:
					{
					setState(726);
					index_name();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Release_stmtContext extends ParserRuleContext {
		public TerminalNode K_RELEASE() { return getToken(SqlParser.K_RELEASE, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode K_SAVEPOINT() { return getToken(SqlParser.K_SAVEPOINT, 0); }
		public Release_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelease_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelease_stmt(this);
		}
	}

	public final Release_stmtContext release_stmt() throws RecognitionException {
		Release_stmtContext _localctx = new Release_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_release_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			match(K_RELEASE);
			setState(733);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(732);
				match(K_SAVEPOINT);
				}
				break;
			}
			setState(735);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rollback_stmtContext extends ParserRuleContext {
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SqlParser.K_TRANSACTION, 0); }
		public TerminalNode K_TO() { return getToken(SqlParser.K_TO, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public TerminalNode K_SAVEPOINT() { return getToken(SqlParser.K_SAVEPOINT, 0); }
		public Rollback_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollback_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRollback_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRollback_stmt(this);
		}
	}

	public final Rollback_stmtContext rollback_stmt() throws RecognitionException {
		Rollback_stmtContext _localctx = new Rollback_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rollback_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			match(K_ROLLBACK);
			setState(742);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(738);
				match(K_TRANSACTION);
				setState(740);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(739);
					transaction_name();
					}
					break;
				}
				}
			}

			setState(749);
			_la = _input.LA(1);
			if (_la==K_TO) {
				{
				setState(744);
				match(K_TO);
				setState(746);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(745);
					match(K_SAVEPOINT);
					}
					break;
				}
				setState(748);
				savepoint_name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_stmtContext extends ParserRuleContext {
		public TerminalNode K_SAVEPOINT() { return getToken(SqlParser.K_SAVEPOINT, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Savepoint_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSavepoint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSavepoint_stmt(this);
		}
	}

	public final Savepoint_stmtContext savepoint_stmt() throws RecognitionException {
		Savepoint_stmtContext _localctx = new Savepoint_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_savepoint_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			match(K_SAVEPOINT);
			setState(752);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_select_stmtContext extends ParserRuleContext {
		public Select_coreContext select_core() {
			return getRuleContext(Select_coreContext.class,0);
		}
		public TerminalNode K_WITH() { return getToken(SqlParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SqlParser.K_RECURSIVE, 0); }
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public Simple_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSimple_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSimple_select_stmt(this);
		}
	}

	public final Simple_select_stmtContext simple_select_stmt() throws RecognitionException {
		Simple_select_stmtContext _localctx = new Simple_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_simple_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(754);
				match(K_WITH);
				setState(756);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(755);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(758);
				common_table_expression();
				setState(763);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(759);
					match(COMMA);
					setState(760);
					common_table_expression();
					}
					}
					setState(765);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(768);
			select_core();
			setState(779);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(769);
				match(K_ORDER);
				setState(770);
				match(K_BY);
				setState(771);
				ordering_term();
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(772);
					match(COMMA);
					setState(773);
					ordering_term();
					}
					}
					setState(778);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(787);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(781);
				match(K_LIMIT);
				setState(782);
				expr(0);
				setState(785);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(783);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(784);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_stmtContext extends ParserRuleContext {
		public List<Select_or_valuesContext> select_or_values() {
			return getRuleContexts(Select_or_valuesContext.class);
		}
		public Select_or_valuesContext select_or_values(int i) {
			return getRuleContext(Select_or_valuesContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SqlParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SqlParser.K_RECURSIVE, 0); }
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSelect_stmt(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(789);
				match(K_WITH);
				setState(791);
				switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
				case 1:
					{
					setState(790);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(793);
				common_table_expression();
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(794);
					match(COMMA);
					setState(795);
					common_table_expression();
					}
					}
					setState(800);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(803);
			select_or_values();
			setState(809);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION) {
				{
				{
				setState(804);
				compound_operator();
				setState(805);
				select_or_values();
				}
				}
				setState(811);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(822);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(812);
				match(K_ORDER);
				setState(813);
				match(K_BY);
				setState(814);
				ordering_term();
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(815);
					match(COMMA);
					setState(816);
					ordering_term();
					}
					}
					setState(821);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(830);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(824);
				match(K_LIMIT);
				setState(825);
				expr(0);
				setState(828);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(826);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(827);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_or_valuesContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SqlParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public TerminalNode K_FROM() { return getToken(SqlParser.K_FROM, 0); }
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_GROUP() { return getToken(SqlParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SqlParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SqlParser.K_ALL, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode K_HAVING() { return getToken(SqlParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(SqlParser.K_VALUES, 0); }
		public Select_or_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_or_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSelect_or_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSelect_or_values(this);
		}
	}

	public final Select_or_valuesContext select_or_values() throws RecognitionException {
		Select_or_valuesContext _localctx = new Select_or_valuesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_select_or_values);
		int _la;
		try {
			setState(906);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(832);
				match(K_SELECT);
				setState(834);
				switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
				case 1:
					{
					setState(833);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				setState(836);
				result_column();
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(837);
					match(COMMA);
					setState(838);
					result_column();
					}
					}
					setState(843);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(856);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(844);
					match(K_FROM);
					setState(854);
					switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
					case 1:
						{
						setState(845);
						table_or_subquery();
						setState(850);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(846);
							match(COMMA);
							setState(847);
							table_or_subquery();
							}
							}
							setState(852);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 2:
						{
						setState(853);
						join_clause();
						}
						break;
					}
					}
				}

				setState(860);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(858);
					match(K_WHERE);
					setState(859);
					expr(0);
					}
				}

				setState(876);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(862);
					match(K_GROUP);
					setState(863);
					match(K_BY);
					setState(864);
					expr(0);
					setState(869);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(865);
						match(COMMA);
						setState(866);
						expr(0);
						}
						}
						setState(871);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(874);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(872);
						match(K_HAVING);
						setState(873);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(878);
				match(K_VALUES);
				setState(879);
				match(OPEN_PAR);
				setState(880);
				expr(0);
				setState(885);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(881);
					match(COMMA);
					setState(882);
					expr(0);
					}
					}
					setState(887);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(888);
				match(CLOSE_PAR);
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(889);
					match(COMMA);
					setState(890);
					match(OPEN_PAR);
					setState(891);
					expr(0);
					setState(896);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(892);
						match(COMMA);
						setState(893);
						expr(0);
						}
						}
						setState(898);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(899);
					match(CLOSE_PAR);
					}
					}
					setState(905);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmtContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(SqlParser.K_UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(SqlParser.K_SET, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SqlParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SqlParser.K_ABORT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SqlParser.K_REPLACE, 0); }
		public TerminalNode K_FAIL() { return getToken(SqlParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SqlParser.K_IGNORE, 0); }
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public Update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUpdate_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUpdate_stmt(this);
		}
	}

	public final Update_stmtContext update_stmt() throws RecognitionException {
		Update_stmtContext _localctx = new Update_stmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(908);
				with_clause();
				}
			}

			setState(911);
			match(K_UPDATE);
			setState(922);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				setState(912);
				match(K_OR);
				setState(913);
				match(K_ROLLBACK);
				}
				break;
			case 2:
				{
				setState(914);
				match(K_OR);
				setState(915);
				match(K_ABORT);
				}
				break;
			case 3:
				{
				setState(916);
				match(K_OR);
				setState(917);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(918);
				match(K_OR);
				setState(919);
				match(K_FAIL);
				}
				break;
			case 5:
				{
				setState(920);
				match(K_OR);
				setState(921);
				match(K_IGNORE);
				}
				break;
			}
			setState(924);
			qualified_table_name();
			setState(925);
			match(K_SET);
			setState(926);
			column_name();
			setState(927);
			match(ASSIGN);
			setState(928);
			expr(0);
			setState(936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(929);
				match(COMMA);
				setState(930);
				column_name();
				setState(931);
				match(ASSIGN);
				setState(932);
				expr(0);
				}
				}
				setState(938);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(941);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(939);
				match(K_WHERE);
				setState(940);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(SqlParser.K_UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(SqlParser.K_SET, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SqlParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SqlParser.K_ABORT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SqlParser.K_REPLACE, 0); }
		public TerminalNode K_FAIL() { return getToken(SqlParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SqlParser.K_IGNORE, 0); }
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public Update_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUpdate_stmt_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUpdate_stmt_limited(this);
		}
	}

	public final Update_stmt_limitedContext update_stmt_limited() throws RecognitionException {
		Update_stmt_limitedContext _localctx = new Update_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_update_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(943);
				with_clause();
				}
			}

			setState(946);
			match(K_UPDATE);
			setState(957);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				{
				setState(947);
				match(K_OR);
				setState(948);
				match(K_ROLLBACK);
				}
				break;
			case 2:
				{
				setState(949);
				match(K_OR);
				setState(950);
				match(K_ABORT);
				}
				break;
			case 3:
				{
				setState(951);
				match(K_OR);
				setState(952);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(953);
				match(K_OR);
				setState(954);
				match(K_FAIL);
				}
				break;
			case 5:
				{
				setState(955);
				match(K_OR);
				setState(956);
				match(K_IGNORE);
				}
				break;
			}
			setState(959);
			qualified_table_name();
			setState(960);
			match(K_SET);
			setState(961);
			column_name();
			setState(962);
			match(ASSIGN);
			setState(963);
			expr(0);
			setState(971);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(964);
				match(COMMA);
				setState(965);
				column_name();
				setState(966);
				match(ASSIGN);
				setState(967);
				expr(0);
				}
				}
				setState(973);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(976);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(974);
				match(K_WHERE);
				setState(975);
				expr(0);
				}
			}

			setState(996);
			_la = _input.LA(1);
			if (_la==K_LIMIT || _la==K_ORDER) {
				{
				setState(988);
				_la = _input.LA(1);
				if (_la==K_ORDER) {
					{
					setState(978);
					match(K_ORDER);
					setState(979);
					match(K_BY);
					setState(980);
					ordering_term();
					setState(985);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(981);
						match(COMMA);
						setState(982);
						ordering_term();
						}
						}
						setState(987);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(990);
				match(K_LIMIT);
				setState(991);
				expr(0);
				setState(994);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(992);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(993);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vacuum_stmtContext extends ParserRuleContext {
		public TerminalNode K_VACUUM() { return getToken(SqlParser.K_VACUUM, 0); }
		public Vacuum_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vacuum_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterVacuum_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitVacuum_stmt(this);
		}
	}

	public final Vacuum_stmtContext vacuum_stmt() throws RecognitionException {
		Vacuum_stmtContext _localctx = new Vacuum_stmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vacuum_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			match(K_VACUUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_defContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public Column_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumn_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumn_def(this);
		}
	}

	public final Column_defContext column_def() throws RecognitionException {
		Column_defContext _localctx = new Column_defContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_column_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1000);
			column_name();
			setState(1002);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1001);
				type_name();
				}
				break;
			}
			setState(1007);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CHECK) | (1L << K_COLLATE) | (1L << K_CONSTRAINT) | (1L << K_DEFAULT))) != 0) || ((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (K_NOT - 102)) | (1L << (K_NULL - 102)) | (1L << (K_PRIMARY - 102)) | (1L << (K_REFERENCES - 102)) | (1L << (K_UNIQUE - 102)))) != 0)) {
				{
				{
				setState(1004);
				column_constraint();
				}
				}
				setState(1009);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<Signed_numberContext> signed_number() {
			return getRuleContexts(Signed_numberContext.class);
		}
		public Signed_numberContext signed_number(int i) {
			return getRuleContext(Signed_numberContext.class,i);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_type_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1011); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1010);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1013); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1025);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(1015);
				match(OPEN_PAR);
				setState(1016);
				signed_number();
				setState(1017);
				match(CLOSE_PAR);
				}
				break;
			case 2:
				{
				setState(1019);
				match(OPEN_PAR);
				setState(1020);
				signed_number();
				setState(1021);
				match(COMMA);
				setState(1022);
				signed_number();
				setState(1023);
				match(CLOSE_PAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_constraintContext extends ParserRuleContext {
		public TerminalNode K_PRIMARY() { return getToken(SqlParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(SqlParser.K_KEY, 0); }
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode K_NULL() { return getToken(SqlParser.K_NULL, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SqlParser.K_UNIQUE, 0); }
		public TerminalNode K_CHECK() { return getToken(SqlParser.K_CHECK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_DEFAULT() { return getToken(SqlParser.K_DEFAULT, 0); }
		public TerminalNode K_COLLATE() { return getToken(SqlParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(SqlParser.K_CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode K_AUTOINCREMENT() { return getToken(SqlParser.K_AUTOINCREMENT, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_ASC() { return getToken(SqlParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SqlParser.K_DESC, 0); }
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumn_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumn_constraint(this);
		}
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			_la = _input.LA(1);
			if (_la==K_CONSTRAINT) {
				{
				setState(1027);
				match(K_CONSTRAINT);
				setState(1028);
				name();
				}
			}

			setState(1064);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				{
				setState(1031);
				match(K_PRIMARY);
				setState(1032);
				match(K_KEY);
				setState(1034);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(1033);
					_la = _input.LA(1);
					if ( !(_la==K_ASC || _la==K_DESC) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(1036);
				conflict_clause();
				setState(1038);
				_la = _input.LA(1);
				if (_la==K_AUTOINCREMENT) {
					{
					setState(1037);
					match(K_AUTOINCREMENT);
					}
				}

				}
				break;
			case K_NOT:
			case K_NULL:
				{
				setState(1041);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(1040);
					match(K_NOT);
					}
				}

				setState(1043);
				match(K_NULL);
				setState(1044);
				conflict_clause();
				}
				break;
			case K_UNIQUE:
				{
				setState(1045);
				match(K_UNIQUE);
				setState(1046);
				conflict_clause();
				}
				break;
			case K_CHECK:
				{
				setState(1047);
				match(K_CHECK);
				setState(1048);
				match(OPEN_PAR);
				setState(1049);
				expr(0);
				setState(1050);
				match(CLOSE_PAR);
				}
				break;
			case K_DEFAULT:
				{
				setState(1052);
				match(K_DEFAULT);
				setState(1059);
				switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
				case 1:
					{
					setState(1053);
					signed_number();
					}
					break;
				case 2:
					{
					setState(1054);
					literal_value();
					}
					break;
				case 3:
					{
					setState(1055);
					match(OPEN_PAR);
					setState(1056);
					expr(0);
					setState(1057);
					match(CLOSE_PAR);
					}
					break;
				}
				}
				break;
			case K_COLLATE:
				{
				setState(1061);
				match(K_COLLATE);
				setState(1062);
				collation_name();
				}
				break;
			case K_REFERENCES:
				{
				setState(1063);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conflict_clauseContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(SqlParser.K_ON, 0); }
		public TerminalNode K_CONFLICT() { return getToken(SqlParser.K_CONFLICT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SqlParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SqlParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SqlParser.K_IGNORE, 0); }
		public TerminalNode K_REPLACE() { return getToken(SqlParser.K_REPLACE, 0); }
		public Conflict_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conflict_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterConflict_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitConflict_clause(this);
		}
	}

	public final Conflict_clauseContext conflict_clause() throws RecognitionException {
		Conflict_clauseContext _localctx = new Conflict_clauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_conflict_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069);
			_la = _input.LA(1);
			if (_la==K_ON) {
				{
				setState(1066);
				match(K_ON);
				setState(1067);
				match(K_CONFLICT);
				setState(1068);
				_la = _input.LA(1);
				if ( !(_la==K_ABORT || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (K_FAIL - 72)) | (1L << (K_IGNORE - 72)) | (1L << (K_REPLACE - 72)) | (1L << (K_ROLLBACK - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(SqlParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode K_DISTINCT() { return getToken(SqlParser.K_DISTINCT, 0); }
		public TerminalNode K_CAST() { return getToken(SqlParser.K_CAST, 0); }
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_CASE() { return getToken(SqlParser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(SqlParser.K_END, 0); }
		public List<TerminalNode> K_WHEN() { return getTokens(SqlParser.K_WHEN); }
		public TerminalNode K_WHEN(int i) {
			return getToken(SqlParser.K_WHEN, i);
		}
		public List<TerminalNode> K_THEN() { return getTokens(SqlParser.K_THEN); }
		public TerminalNode K_THEN(int i) {
			return getToken(SqlParser.K_THEN, i);
		}
		public TerminalNode K_ELSE() { return getToken(SqlParser.K_ELSE, 0); }
		public Raise_functionContext raise_function() {
			return getRuleContext(Raise_functionContext.class,0);
		}
		public TerminalNode K_IS() { return getToken(SqlParser.K_IS, 0); }
		public TerminalNode K_IN() { return getToken(SqlParser.K_IN, 0); }
		public TerminalNode K_LIKE() { return getToken(SqlParser.K_LIKE, 0); }
		public TerminalNode K_GLOB() { return getToken(SqlParser.K_GLOB, 0); }
		public TerminalNode K_MATCH() { return getToken(SqlParser.K_MATCH, 0); }
		public TerminalNode K_REGEXP() { return getToken(SqlParser.K_REGEXP, 0); }
		public TerminalNode K_AND() { return getToken(SqlParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(SqlParser.K_OR, 0); }
		public TerminalNode K_BETWEEN() { return getToken(SqlParser.K_BETWEEN, 0); }
		public TerminalNode K_COLLATE() { return getToken(SqlParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ESCAPE() { return getToken(SqlParser.K_ESCAPE, 0); }
		public TerminalNode K_ISNULL() { return getToken(SqlParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SqlParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SqlParser.K_NULL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1147);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				{
				setState(1072);
				unary_operator();
				setState(1073);
				expr(21);
				}
				break;
			case 2:
				{
				setState(1075);
				literal_value();
				}
				break;
			case 3:
				{
				setState(1076);
				match(BIND_PARAMETER);
				}
				break;
			case 4:
				{
				setState(1085);
				switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
				case 1:
					{
					setState(1080);
					switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
					case 1:
						{
						setState(1077);
						database_name();
						setState(1078);
						match(DOT);
						}
						break;
					}
					setState(1082);
					table_name();
					setState(1083);
					match(DOT);
					}
					break;
				}
				setState(1087);
				column_name();
				}
				break;
			case 5:
				{
				setState(1088);
				function_name();
				setState(1089);
				match(OPEN_PAR);
				setState(1102);
				switch (_input.LA(1)) {
				case OPEN_PAR:
				case PLUS:
				case MINUS:
				case TILDE:
				case K_ABORT:
				case K_ACTION:
				case K_ADD:
				case K_AFTER:
				case K_ALL:
				case K_ALTER:
				case K_ANALYZE:
				case K_AND:
				case K_AS:
				case K_ASC:
				case K_ATTACH:
				case K_AUTOINCREMENT:
				case K_BEFORE:
				case K_BEGIN:
				case K_BETWEEN:
				case K_BY:
				case K_CASCADE:
				case K_CASE:
				case K_CAST:
				case K_CHECK:
				case K_COLLATE:
				case K_COLUMN:
				case K_COMMIT:
				case K_CONFLICT:
				case K_CONSTRAINT:
				case K_CREATE:
				case K_CROSS:
				case K_CURRENT_DATE:
				case K_CURRENT_TIME:
				case K_CURRENT_TIMESTAMP:
				case K_DATABASE:
				case K_DEFAULT:
				case K_DEFERRABLE:
				case K_DEFERRED:
				case K_DELETE:
				case K_DESC:
				case K_DETACH:
				case K_DISTINCT:
				case K_DROP:
				case K_EACH:
				case K_ELSE:
				case K_END:
				case K_ESCAPE:
				case K_EXCEPT:
				case K_EXCLUSIVE:
				case K_EXISTS:
				case K_EXPLAIN:
				case K_FAIL:
				case K_FOR:
				case K_FOREIGN:
				case K_FROM:
				case K_FULL:
				case K_GLOB:
				case K_GROUP:
				case K_HAVING:
				case K_IF:
				case K_IGNORE:
				case K_IMMEDIATE:
				case K_IN:
				case K_INDEX:
				case K_INDEXED:
				case K_INITIALLY:
				case K_INNER:
				case K_INSERT:
				case K_INSTEAD:
				case K_INTERSECT:
				case K_INTO:
				case K_IS:
				case K_ISNULL:
				case K_JOIN:
				case K_KEY:
				case K_LEFT:
				case K_LIKE:
				case K_LIMIT:
				case K_MATCH:
				case K_NATURAL:
				case K_NO:
				case K_NOT:
				case K_NOTNULL:
				case K_NULL:
				case K_OF:
				case K_OFFSET:
				case K_ON:
				case K_OR:
				case K_ORDER:
				case K_OUTER:
				case K_PLAN:
				case K_PRAGMA:
				case K_PRIMARY:
				case K_QUERY:
				case K_RAISE:
				case K_RECURSIVE:
				case K_REFERENCES:
				case K_REGEXP:
				case K_REINDEX:
				case K_RELEASE:
				case K_RENAME:
				case K_REPLACE:
				case K_RESTRICT:
				case K_RIGHT:
				case K_ROLLBACK:
				case K_ROW:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_SET:
				case K_TABLE:
				case K_TEMP:
				case K_TEMPORARY:
				case K_THEN:
				case K_TO:
				case K_TRANSACTION:
				case K_TRIGGER:
				case K_UNION:
				case K_UNIQUE:
				case K_UPDATE:
				case K_USING:
				case K_VACUUM:
				case K_VALUES:
				case K_VIEW:
				case K_VIRTUAL:
				case K_WHEN:
				case K_WHERE:
				case K_WITH:
				case K_WITHOUT:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
				case BIND_PARAMETER:
				case STRING_LITERAL:
				case BLOB_LITERAL:
					{
					setState(1091);
					switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
					case 1:
						{
						setState(1090);
						match(K_DISTINCT);
						}
						break;
					}
					setState(1093);
					expr(0);
					setState(1098);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1094);
						match(COMMA);
						setState(1095);
						expr(0);
						}
						}
						setState(1100);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case STAR:
					{
					setState(1101);
					match(STAR);
					}
					break;
				case CLOSE_PAR:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1104);
				match(CLOSE_PAR);
				}
				break;
			case 6:
				{
				setState(1106);
				match(OPEN_PAR);
				setState(1107);
				expr(0);
				setState(1108);
				match(CLOSE_PAR);
				}
				break;
			case 7:
				{
				setState(1110);
				match(K_CAST);
				setState(1111);
				match(OPEN_PAR);
				setState(1112);
				expr(0);
				setState(1113);
				match(K_AS);
				setState(1114);
				type_name();
				setState(1115);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				setState(1121);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(1118);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(1117);
						match(K_NOT);
						}
					}

					setState(1120);
					match(K_EXISTS);
					}
				}

				setState(1123);
				match(OPEN_PAR);
				setState(1124);
				select_stmt();
				setState(1125);
				match(CLOSE_PAR);
				}
				break;
			case 9:
				{
				setState(1127);
				match(K_CASE);
				setState(1129);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1128);
					expr(0);
					}
					break;
				}
				setState(1136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1131);
					match(K_WHEN);
					setState(1132);
					expr(0);
					setState(1133);
					match(K_THEN);
					setState(1134);
					expr(0);
					}
					}
					setState(1138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(1142);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(1140);
					match(K_ELSE);
					setState(1141);
					expr(0);
					}
				}

				setState(1144);
				match(K_END);
				}
				break;
			case 10:
				{
				setState(1146);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1247);
					switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1149);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1150);
						match(PIPE2);
						setState(1151);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1152);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(1153);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1154);
						expr(20);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1155);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1156);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1157);
						expr(19);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1158);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1159);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1160);
						expr(18);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1161);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1162);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1163);
						expr(17);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1164);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1177);
						switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
						case 1:
							{
							setState(1165);
							match(ASSIGN);
							}
							break;
						case 2:
							{
							setState(1166);
							match(EQ);
							}
							break;
						case 3:
							{
							setState(1167);
							match(NOT_EQ1);
							}
							break;
						case 4:
							{
							setState(1168);
							match(NOT_EQ2);
							}
							break;
						case 5:
							{
							setState(1169);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(1170);
							match(K_IS);
							setState(1171);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(1172);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(1173);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(1174);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(1175);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(1176);
							match(K_REGEXP);
							}
							break;
						}
						setState(1179);
						expr(16);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1180);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1181);
						match(K_AND);
						setState(1182);
						expr(15);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1183);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1184);
						match(K_OR);
						setState(1185);
						expr(14);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1186);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1187);
						match(K_IS);
						setState(1189);
						switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
						case 1:
							{
							setState(1188);
							match(K_NOT);
							}
							break;
						}
						setState(1191);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1192);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1194);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1193);
							match(K_NOT);
							}
						}

						setState(1196);
						match(K_BETWEEN);
						setState(1197);
						expr(0);
						setState(1198);
						match(K_AND);
						setState(1199);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1201);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1202);
						match(K_COLLATE);
						setState(1203);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1204);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1206);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1205);
							match(K_NOT);
							}
						}

						setState(1208);
						_la = _input.LA(1);
						if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (K_GLOB - 77)) | (1L << (K_LIKE - 77)) | (1L << (K_MATCH - 77)) | (1L << (K_REGEXP - 77)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1209);
						expr(0);
						setState(1212);
						switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
						case 1:
							{
							setState(1210);
							match(K_ESCAPE);
							setState(1211);
							expr(0);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1214);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1219);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(1215);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(1216);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(1217);
							match(K_NOT);
							setState(1218);
							match(K_NULL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1221);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1223);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1222);
							match(K_NOT);
							}
						}

						setState(1225);
						match(K_IN);
						setState(1245);
						switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
						case 1:
							{
							setState(1226);
							match(OPEN_PAR);
							setState(1236);
							switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
							case 1:
								{
								setState(1227);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(1228);
								expr(0);
								setState(1233);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1229);
									match(COMMA);
									setState(1230);
									expr(0);
									}
									}
									setState(1235);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(1238);
							match(CLOSE_PAR);
							}
							break;
						case 2:
							{
							setState(1242);
							switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
							case 1:
								{
								setState(1239);
								database_name();
								setState(1240);
								match(DOT);
								}
								break;
							}
							setState(1244);
							table_name();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Foreign_key_clauseContext extends ParserRuleContext {
		public TerminalNode K_REFERENCES() { return getToken(SqlParser.K_REFERENCES, 0); }
		public Foreign_tableContext foreign_table() {
			return getRuleContext(Foreign_tableContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode K_DEFERRABLE() { return getToken(SqlParser.K_DEFERRABLE, 0); }
		public List<TerminalNode> K_ON() { return getTokens(SqlParser.K_ON); }
		public TerminalNode K_ON(int i) {
			return getToken(SqlParser.K_ON, i);
		}
		public List<TerminalNode> K_MATCH() { return getTokens(SqlParser.K_MATCH); }
		public TerminalNode K_MATCH(int i) {
			return getToken(SqlParser.K_MATCH, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> K_DELETE() { return getTokens(SqlParser.K_DELETE); }
		public TerminalNode K_DELETE(int i) {
			return getToken(SqlParser.K_DELETE, i);
		}
		public List<TerminalNode> K_UPDATE() { return getTokens(SqlParser.K_UPDATE); }
		public TerminalNode K_UPDATE(int i) {
			return getToken(SqlParser.K_UPDATE, i);
		}
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_INITIALLY() { return getToken(SqlParser.K_INITIALLY, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SqlParser.K_DEFERRED, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SqlParser.K_IMMEDIATE, 0); }
		public List<TerminalNode> K_SET() { return getTokens(SqlParser.K_SET); }
		public TerminalNode K_SET(int i) {
			return getToken(SqlParser.K_SET, i);
		}
		public List<TerminalNode> K_NULL() { return getTokens(SqlParser.K_NULL); }
		public TerminalNode K_NULL(int i) {
			return getToken(SqlParser.K_NULL, i);
		}
		public List<TerminalNode> K_DEFAULT() { return getTokens(SqlParser.K_DEFAULT); }
		public TerminalNode K_DEFAULT(int i) {
			return getToken(SqlParser.K_DEFAULT, i);
		}
		public List<TerminalNode> K_CASCADE() { return getTokens(SqlParser.K_CASCADE); }
		public TerminalNode K_CASCADE(int i) {
			return getToken(SqlParser.K_CASCADE, i);
		}
		public List<TerminalNode> K_RESTRICT() { return getTokens(SqlParser.K_RESTRICT); }
		public TerminalNode K_RESTRICT(int i) {
			return getToken(SqlParser.K_RESTRICT, i);
		}
		public List<TerminalNode> K_NO() { return getTokens(SqlParser.K_NO); }
		public TerminalNode K_NO(int i) {
			return getToken(SqlParser.K_NO, i);
		}
		public List<TerminalNode> K_ACTION() { return getTokens(SqlParser.K_ACTION); }
		public TerminalNode K_ACTION(int i) {
			return getToken(SqlParser.K_ACTION, i);
		}
		public Foreign_key_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterForeign_key_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitForeign_key_clause(this);
		}
	}

	public final Foreign_key_clauseContext foreign_key_clause() throws RecognitionException {
		Foreign_key_clauseContext _localctx = new Foreign_key_clauseContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_foreign_key_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1252);
			match(K_REFERENCES);
			setState(1253);
			foreign_table();
			setState(1265);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1254);
				match(OPEN_PAR);
				setState(1255);
				column_name();
				setState(1260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1256);
					match(COMMA);
					setState(1257);
					column_name();
					}
					}
					setState(1262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1263);
				match(CLOSE_PAR);
				}
			}

			setState(1285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_MATCH || _la==K_ON) {
				{
				{
				setState(1281);
				switch (_input.LA(1)) {
				case K_ON:
					{
					setState(1267);
					match(K_ON);
					setState(1268);
					_la = _input.LA(1);
					if ( !(_la==K_DELETE || _la==K_UPDATE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(1277);
					switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
					case 1:
						{
						setState(1269);
						match(K_SET);
						setState(1270);
						match(K_NULL);
						}
						break;
					case 2:
						{
						setState(1271);
						match(K_SET);
						setState(1272);
						match(K_DEFAULT);
						}
						break;
					case 3:
						{
						setState(1273);
						match(K_CASCADE);
						}
						break;
					case 4:
						{
						setState(1274);
						match(K_RESTRICT);
						}
						break;
					case 5:
						{
						setState(1275);
						match(K_NO);
						setState(1276);
						match(K_ACTION);
						}
						break;
					}
					}
					break;
				case K_MATCH:
					{
					setState(1279);
					match(K_MATCH);
					setState(1280);
					name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(1287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1298);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				{
				setState(1289);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(1288);
					match(K_NOT);
					}
				}

				setState(1291);
				match(K_DEFERRABLE);
				setState(1296);
				switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
				case 1:
					{
					setState(1292);
					match(K_INITIALLY);
					setState(1293);
					match(K_DEFERRED);
					}
					break;
				case 2:
					{
					setState(1294);
					match(K_INITIALLY);
					setState(1295);
					match(K_IMMEDIATE);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Raise_functionContext extends ParserRuleContext {
		public TerminalNode K_RAISE() { return getToken(SqlParser.K_RAISE, 0); }
		public TerminalNode K_IGNORE() { return getToken(SqlParser.K_IGNORE, 0); }
		public Error_messageContext error_message() {
			return getRuleContext(Error_messageContext.class,0);
		}
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SqlParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SqlParser.K_FAIL, 0); }
		public Raise_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRaise_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRaise_function(this);
		}
	}

	public final Raise_functionContext raise_function() throws RecognitionException {
		Raise_functionContext _localctx = new Raise_functionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1300);
			match(K_RAISE);
			setState(1301);
			match(OPEN_PAR);
			setState(1306);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(1302);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(1303);
				_la = _input.LA(1);
				if ( !(_la==K_ABORT || _la==K_FAIL || _la==K_ROLLBACK) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1304);
				match(COMMA);
				setState(1305);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1308);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Indexed_columnContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(SqlParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(SqlParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SqlParser.K_DESC, 0); }
		public Indexed_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexed_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterIndexed_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitIndexed_column(this);
		}
	}

	public final Indexed_columnContext indexed_column() throws RecognitionException {
		Indexed_columnContext _localctx = new Indexed_columnContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_indexed_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1310);
			column_name();
			setState(1313);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(1311);
				match(K_COLLATE);
				setState(1312);
				collation_name();
				}
			}

			setState(1316);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(1315);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_constraintContext extends ParserRuleContext {
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode K_CHECK() { return getToken(SqlParser.K_CHECK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_FOREIGN() { return getToken(SqlParser.K_FOREIGN, 0); }
		public TerminalNode K_KEY() { return getToken(SqlParser.K_KEY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(SqlParser.K_CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode K_PRIMARY() { return getToken(SqlParser.K_PRIMARY, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SqlParser.K_UNIQUE, 0); }
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable_constraint(this);
		}
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1320);
			_la = _input.LA(1);
			if (_la==K_CONSTRAINT) {
				{
				setState(1318);
				match(K_CONSTRAINT);
				setState(1319);
				name();
				}
			}

			setState(1358);
			switch (_input.LA(1)) {
			case K_PRIMARY:
			case K_UNIQUE:
				{
				setState(1325);
				switch (_input.LA(1)) {
				case K_PRIMARY:
					{
					setState(1322);
					match(K_PRIMARY);
					setState(1323);
					match(K_KEY);
					}
					break;
				case K_UNIQUE:
					{
					setState(1324);
					match(K_UNIQUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1327);
				match(OPEN_PAR);
				setState(1328);
				indexed_column();
				setState(1333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1329);
					match(COMMA);
					setState(1330);
					indexed_column();
					}
					}
					setState(1335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1336);
				match(CLOSE_PAR);
				setState(1337);
				conflict_clause();
				}
				break;
			case K_CHECK:
				{
				setState(1339);
				match(K_CHECK);
				setState(1340);
				match(OPEN_PAR);
				setState(1341);
				expr(0);
				setState(1342);
				match(CLOSE_PAR);
				}
				break;
			case K_FOREIGN:
				{
				setState(1344);
				match(K_FOREIGN);
				setState(1345);
				match(K_KEY);
				setState(1346);
				match(OPEN_PAR);
				setState(1347);
				column_name();
				setState(1352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1348);
					match(COMMA);
					setState(1349);
					column_name();
					}
					}
					setState(1354);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1355);
				match(CLOSE_PAR);
				setState(1356);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_clauseContext extends ParserRuleContext {
		public TerminalNode K_WITH() { return getToken(SqlParser.K_WITH, 0); }
		public List<Cte_table_nameContext> cte_table_name() {
			return getRuleContexts(Cte_table_nameContext.class);
		}
		public Cte_table_nameContext cte_table_name(int i) {
			return getRuleContext(Cte_table_nameContext.class,i);
		}
		public List<TerminalNode> K_AS() { return getTokens(SqlParser.K_AS); }
		public TerminalNode K_AS(int i) {
			return getToken(SqlParser.K_AS, i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SqlParser.K_RECURSIVE, 0); }
		public With_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterWith_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitWith_clause(this);
		}
	}

	public final With_clauseContext with_clause() throws RecognitionException {
		With_clauseContext _localctx = new With_clauseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_with_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1360);
			match(K_WITH);
			setState(1362);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				setState(1361);
				match(K_RECURSIVE);
				}
				break;
			}
			setState(1364);
			cte_table_name();
			setState(1365);
			match(K_AS);
			setState(1366);
			match(OPEN_PAR);
			setState(1367);
			select_stmt();
			setState(1368);
			match(CLOSE_PAR);
			setState(1378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1369);
				match(COMMA);
				setState(1370);
				cte_table_name();
				setState(1371);
				match(K_AS);
				setState(1372);
				match(OPEN_PAR);
				setState(1373);
				select_stmt();
				setState(1374);
				match(CLOSE_PAR);
				}
				}
				setState(1380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_INDEXED() { return getToken(SqlParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public Qualified_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterQualified_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitQualified_table_name(this);
		}
	}

	public final Qualified_table_nameContext qualified_table_name() throws RecognitionException {
		Qualified_table_nameContext _localctx = new Qualified_table_nameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_qualified_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1384);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				{
				setState(1381);
				database_name();
				setState(1382);
				match(DOT);
				}
				break;
			}
			setState(1386);
			table_name();
			setState(1392);
			switch (_input.LA(1)) {
			case K_INDEXED:
				{
				setState(1387);
				match(K_INDEXED);
				setState(1388);
				match(K_BY);
				setState(1389);
				index_name();
				}
				break;
			case K_NOT:
				{
				setState(1390);
				match(K_NOT);
				setState(1391);
				match(K_INDEXED);
				}
				break;
			case EOF:
			case SCOL:
			case K_LIMIT:
			case K_ORDER:
			case K_SET:
			case K_WHERE:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordering_termContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(SqlParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(SqlParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SqlParser.K_DESC, 0); }
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterOrdering_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitOrdering_term(this);
		}
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1394);
			expr(0);
			setState(1397);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(1395);
				match(K_COLLATE);
				setState(1396);
				collation_name();
				}
			}

			setState(1400);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(1399);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_valueContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SqlParser.STRING_LITERAL, 0); }
		public Pragma_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterPragma_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitPragma_value(this);
		}
	}

	public final Pragma_valueContext pragma_value() throws RecognitionException {
		Pragma_valueContext _localctx = new Pragma_valueContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_pragma_value);
		try {
			setState(1405);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1402);
				signed_number();
				}
				break;
			case OPEN_PAR:
			case K_ABORT:
			case K_ACTION:
			case K_ADD:
			case K_AFTER:
			case K_ALL:
			case K_ALTER:
			case K_ANALYZE:
			case K_AND:
			case K_AS:
			case K_ASC:
			case K_ATTACH:
			case K_AUTOINCREMENT:
			case K_BEFORE:
			case K_BEGIN:
			case K_BETWEEN:
			case K_BY:
			case K_CASCADE:
			case K_CASE:
			case K_CAST:
			case K_CHECK:
			case K_COLLATE:
			case K_COLUMN:
			case K_COMMIT:
			case K_CONFLICT:
			case K_CONSTRAINT:
			case K_CREATE:
			case K_CROSS:
			case K_CURRENT_DATE:
			case K_CURRENT_TIME:
			case K_CURRENT_TIMESTAMP:
			case K_DATABASE:
			case K_DEFAULT:
			case K_DEFERRABLE:
			case K_DEFERRED:
			case K_DELETE:
			case K_DESC:
			case K_DETACH:
			case K_DISTINCT:
			case K_DROP:
			case K_EACH:
			case K_ELSE:
			case K_END:
			case K_ESCAPE:
			case K_EXCEPT:
			case K_EXCLUSIVE:
			case K_EXISTS:
			case K_EXPLAIN:
			case K_FAIL:
			case K_FOR:
			case K_FOREIGN:
			case K_FROM:
			case K_FULL:
			case K_GLOB:
			case K_GROUP:
			case K_HAVING:
			case K_IF:
			case K_IGNORE:
			case K_IMMEDIATE:
			case K_IN:
			case K_INDEX:
			case K_INDEXED:
			case K_INITIALLY:
			case K_INNER:
			case K_INSERT:
			case K_INSTEAD:
			case K_INTERSECT:
			case K_INTO:
			case K_IS:
			case K_ISNULL:
			case K_JOIN:
			case K_KEY:
			case K_LEFT:
			case K_LIKE:
			case K_LIMIT:
			case K_MATCH:
			case K_NATURAL:
			case K_NO:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_OF:
			case K_OFFSET:
			case K_ON:
			case K_OR:
			case K_ORDER:
			case K_OUTER:
			case K_PLAN:
			case K_PRAGMA:
			case K_PRIMARY:
			case K_QUERY:
			case K_RAISE:
			case K_RECURSIVE:
			case K_REFERENCES:
			case K_REGEXP:
			case K_REINDEX:
			case K_RELEASE:
			case K_RENAME:
			case K_REPLACE:
			case K_RESTRICT:
			case K_RIGHT:
			case K_ROLLBACK:
			case K_ROW:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SET:
			case K_TABLE:
			case K_TEMP:
			case K_TEMPORARY:
			case K_THEN:
			case K_TO:
			case K_TRANSACTION:
			case K_TRIGGER:
			case K_UNION:
			case K_UNIQUE:
			case K_UPDATE:
			case K_USING:
			case K_VACUUM:
			case K_VALUES:
			case K_VIEW:
			case K_VIRTUAL:
			case K_WHEN:
			case K_WHERE:
			case K_WITH:
			case K_WITHOUT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1403);
				name();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1404);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_table_expressionContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Common_table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCommon_table_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCommon_table_expression(this);
		}
	}

	public final Common_table_expressionContext common_table_expression() throws RecognitionException {
		Common_table_expressionContext _localctx = new Common_table_expressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1407);
			table_name();
			setState(1419);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1408);
				match(OPEN_PAR);
				setState(1409);
				column_name();
				setState(1414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1410);
					match(COMMA);
					setState(1411);
					column_name();
					}
					}
					setState(1416);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1417);
				match(CLOSE_PAR);
				}
			}

			setState(1421);
			match(K_AS);
			setState(1422);
			match(OPEN_PAR);
			setState(1423);
			select_stmt();
			setState(1424);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Result_columnContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterResult_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitResult_column(this);
		}
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_result_column);
		int _la;
		try {
			setState(1438);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1426);
				match(STAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1427);
				table_name();
				setState(1428);
				match(DOT);
				setState(1429);
				match(STAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1431);
				expr(0);
				setState(1436);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1433);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(1432);
						match(K_AS);
						}
					}

					setState(1435);
					column_alias();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_subqueryContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode K_INDEXED() { return getToken(SqlParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Table_or_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable_or_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable_or_subquery(this);
		}
	}

	public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
		Table_or_subqueryContext _localctx = new Table_or_subqueryContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_table_or_subquery);
		int _la;
		try {
			setState(1487);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1443);
				switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
				case 1:
					{
					setState(1440);
					database_name();
					setState(1441);
					match(DOT);
					}
					break;
				}
				setState(1445);
				table_name();
				setState(1450);
				switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
				case 1:
					{
					setState(1447);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						setState(1446);
						match(K_AS);
						}
						break;
					}
					setState(1449);
					table_alias();
					}
					break;
				}
				setState(1457);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(1452);
					match(K_INDEXED);
					setState(1453);
					match(K_BY);
					setState(1454);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(1455);
					match(K_NOT);
					setState(1456);
					match(K_INDEXED);
					}
					break;
				case EOF:
				case SCOL:
				case CLOSE_PAR:
				case COMMA:
				case K_CROSS:
				case K_EXCEPT:
				case K_GROUP:
				case K_INNER:
				case K_INTERSECT:
				case K_JOIN:
				case K_LEFT:
				case K_LIMIT:
				case K_NATURAL:
				case K_ON:
				case K_ORDER:
				case K_UNION:
				case K_USING:
				case K_WHERE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1459);
				match(OPEN_PAR);
				setState(1469);
				switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
				case 1:
					{
					setState(1460);
					table_or_subquery();
					setState(1465);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1461);
						match(COMMA);
						setState(1462);
						table_or_subquery();
						}
						}
						setState(1467);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(1468);
					join_clause();
					}
					break;
				}
				setState(1471);
				match(CLOSE_PAR);
				setState(1476);
				switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
				case 1:
					{
					setState(1473);
					switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
					case 1:
						{
						setState(1472);
						match(K_AS);
						}
						break;
					}
					setState(1475);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1478);
				match(OPEN_PAR);
				setState(1479);
				select_stmt();
				setState(1480);
				match(CLOSE_PAR);
				setState(1485);
				switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
				case 1:
					{
					setState(1482);
					switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
					case 1:
						{
						setState(1481);
						match(K_AS);
						}
						break;
					}
					setState(1484);
					table_alias();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_clauseContext extends ParserRuleContext {
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public List<Join_operatorContext> join_operator() {
			return getRuleContexts(Join_operatorContext.class);
		}
		public Join_operatorContext join_operator(int i) {
			return getRuleContext(Join_operatorContext.class,i);
		}
		public List<Join_constraintContext> join_constraint() {
			return getRuleContexts(Join_constraintContext.class);
		}
		public Join_constraintContext join_constraint(int i) {
			return getRuleContext(Join_constraintContext.class,i);
		}
		public Join_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterJoin_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitJoin_clause(this);
		}
	}

	public final Join_clauseContext join_clause() throws RecognitionException {
		Join_clauseContext _localctx = new Join_clauseContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_join_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1489);
			table_or_subquery();
			setState(1496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==K_CROSS || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (K_INNER - 87)) | (1L << (K_JOIN - 87)) | (1L << (K_LEFT - 87)) | (1L << (K_NATURAL - 87)))) != 0)) {
				{
				{
				setState(1490);
				join_operator();
				setState(1491);
				table_or_subquery();
				setState(1492);
				join_constraint();
				}
				}
				setState(1498);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_operatorContext extends ParserRuleContext {
		public TerminalNode K_JOIN() { return getToken(SqlParser.K_JOIN, 0); }
		public TerminalNode K_NATURAL() { return getToken(SqlParser.K_NATURAL, 0); }
		public TerminalNode K_LEFT() { return getToken(SqlParser.K_LEFT, 0); }
		public TerminalNode K_INNER() { return getToken(SqlParser.K_INNER, 0); }
		public TerminalNode K_CROSS() { return getToken(SqlParser.K_CROSS, 0); }
		public TerminalNode K_OUTER() { return getToken(SqlParser.K_OUTER, 0); }
		public Join_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterJoin_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitJoin_operator(this);
		}
	}

	public final Join_operatorContext join_operator() throws RecognitionException {
		Join_operatorContext _localctx = new Join_operatorContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_join_operator);
		int _la;
		try {
			setState(1512);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(1499);
				match(COMMA);
				}
				break;
			case K_CROSS:
			case K_INNER:
			case K_JOIN:
			case K_LEFT:
			case K_NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1501);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(1500);
					match(K_NATURAL);
					}
				}

				setState(1509);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(1503);
					match(K_LEFT);
					setState(1505);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(1504);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(1507);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(1508);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1511);
				match(K_JOIN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_constraintContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(SqlParser.K_ON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(SqlParser.K_USING, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Join_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterJoin_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitJoin_constraint(this);
		}
	}

	public final Join_constraintContext join_constraint() throws RecognitionException {
		Join_constraintContext _localctx = new Join_constraintContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_join_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1528);
			switch (_input.LA(1)) {
			case K_ON:
				{
				setState(1514);
				match(K_ON);
				setState(1515);
				expr(0);
				}
				break;
			case K_USING:
				{
				setState(1516);
				match(K_USING);
				setState(1517);
				match(OPEN_PAR);
				setState(1518);
				column_name();
				setState(1523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1519);
					match(COMMA);
					setState(1520);
					column_name();
					}
					}
					setState(1525);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1526);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case CLOSE_PAR:
			case COMMA:
			case K_CROSS:
			case K_EXCEPT:
			case K_GROUP:
			case K_INNER:
			case K_INTERSECT:
			case K_JOIN:
			case K_LEFT:
			case K_LIMIT:
			case K_NATURAL:
			case K_ORDER:
			case K_UNION:
			case K_WHERE:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_coreContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SqlParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public TerminalNode K_FROM() { return getToken(SqlParser.K_FROM, 0); }
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_GROUP() { return getToken(SqlParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SqlParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SqlParser.K_ALL, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode K_HAVING() { return getToken(SqlParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(SqlParser.K_VALUES, 0); }
		public Select_coreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_core; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSelect_core(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSelect_core(this);
		}
	}

	public final Select_coreContext select_core() throws RecognitionException {
		Select_coreContext _localctx = new Select_coreContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_select_core);
		int _la;
		try {
			setState(1604);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1530);
				match(K_SELECT);
				setState(1532);
				switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
				case 1:
					{
					setState(1531);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				setState(1534);
				result_column();
				setState(1539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1535);
					match(COMMA);
					setState(1536);
					result_column();
					}
					}
					setState(1541);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1554);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(1542);
					match(K_FROM);
					setState(1552);
					switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
					case 1:
						{
						setState(1543);
						table_or_subquery();
						setState(1548);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1544);
							match(COMMA);
							setState(1545);
							table_or_subquery();
							}
							}
							setState(1550);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 2:
						{
						setState(1551);
						join_clause();
						}
						break;
					}
					}
				}

				setState(1558);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(1556);
					match(K_WHERE);
					setState(1557);
					expr(0);
					}
				}

				setState(1574);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(1560);
					match(K_GROUP);
					setState(1561);
					match(K_BY);
					setState(1562);
					expr(0);
					setState(1567);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1563);
						match(COMMA);
						setState(1564);
						expr(0);
						}
						}
						setState(1569);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1572);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(1570);
						match(K_HAVING);
						setState(1571);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1576);
				match(K_VALUES);
				setState(1577);
				match(OPEN_PAR);
				setState(1578);
				expr(0);
				setState(1583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1579);
					match(COMMA);
					setState(1580);
					expr(0);
					}
					}
					setState(1585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1586);
				match(CLOSE_PAR);
				setState(1601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1587);
					match(COMMA);
					setState(1588);
					match(OPEN_PAR);
					setState(1589);
					expr(0);
					setState(1594);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1590);
						match(COMMA);
						setState(1591);
						expr(0);
						}
						}
						setState(1596);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1597);
					match(CLOSE_PAR);
					}
					}
					setState(1603);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_operatorContext extends ParserRuleContext {
		public TerminalNode K_UNION() { return getToken(SqlParser.K_UNION, 0); }
		public TerminalNode K_ALL() { return getToken(SqlParser.K_ALL, 0); }
		public TerminalNode K_INTERSECT() { return getToken(SqlParser.K_INTERSECT, 0); }
		public TerminalNode K_EXCEPT() { return getToken(SqlParser.K_EXCEPT, 0); }
		public Compound_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCompound_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCompound_operator(this);
		}
	}

	public final Compound_operatorContext compound_operator() throws RecognitionException {
		Compound_operatorContext _localctx = new Compound_operatorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_compound_operator);
		try {
			setState(1611);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1606);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1607);
				match(K_UNION);
				setState(1608);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1609);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1610);
				match(K_EXCEPT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cte_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Cte_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCte_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCte_table_name(this);
		}
	}

	public final Cte_table_nameContext cte_table_name() throws RecognitionException {
		Cte_table_nameContext _localctx = new Cte_table_nameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_cte_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613);
			table_name();
			setState(1625);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1614);
				match(OPEN_PAR);
				setState(1615);
				column_name();
				setState(1620);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1616);
					match(COMMA);
					setState(1617);
					column_name();
					}
					}
					setState(1622);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1623);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlParser.NUMERIC_LITERAL, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSigned_number(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1628);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1627);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(1630);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(SqlParser.BLOB_LITERAL, 0); }
		public TerminalNode K_NULL() { return getToken(SqlParser.K_NULL, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(SqlParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(SqlParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(SqlParser.K_CURRENT_TIMESTAMP, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitLiteral_value(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1632);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (K_NULL - 104)) | (1L << (NUMERIC_LITERAL - 104)) | (1L << (STRING_LITERAL - 104)) | (1L << (BLOB_LITERAL - 104)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE))) != 0) || _la==K_NOT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Error_messageContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(SqlParser.STRING_LITERAL, 0); }
		public Error_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterError_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitError_message(this);
		}
	}

	public final Error_messageContext error_message() throws RecognitionException {
		Error_messageContext _localctx = new Error_messageContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1636);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_argumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Module_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterModule_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitModule_argument(this);
		}
	}

	public final Module_argumentContext module_argument() throws RecognitionException {
		Module_argumentContext _localctx = new Module_argumentContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_module_argument);
		try {
			setState(1640);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1638);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1639);
				column_def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumn_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumn_alias(this);
		}
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1642);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_ABORT() { return getToken(SqlParser.K_ABORT, 0); }
		public TerminalNode K_ACTION() { return getToken(SqlParser.K_ACTION, 0); }
		public TerminalNode K_ADD() { return getToken(SqlParser.K_ADD, 0); }
		public TerminalNode K_AFTER() { return getToken(SqlParser.K_AFTER, 0); }
		public TerminalNode K_ALL() { return getToken(SqlParser.K_ALL, 0); }
		public TerminalNode K_ALTER() { return getToken(SqlParser.K_ALTER, 0); }
		public TerminalNode K_ANALYZE() { return getToken(SqlParser.K_ANALYZE, 0); }
		public TerminalNode K_AND() { return getToken(SqlParser.K_AND, 0); }
		public TerminalNode K_AS() { return getToken(SqlParser.K_AS, 0); }
		public TerminalNode K_ASC() { return getToken(SqlParser.K_ASC, 0); }
		public TerminalNode K_ATTACH() { return getToken(SqlParser.K_ATTACH, 0); }
		public TerminalNode K_AUTOINCREMENT() { return getToken(SqlParser.K_AUTOINCREMENT, 0); }
		public TerminalNode K_BEFORE() { return getToken(SqlParser.K_BEFORE, 0); }
		public TerminalNode K_BEGIN() { return getToken(SqlParser.K_BEGIN, 0); }
		public TerminalNode K_BETWEEN() { return getToken(SqlParser.K_BETWEEN, 0); }
		public TerminalNode K_BY() { return getToken(SqlParser.K_BY, 0); }
		public TerminalNode K_CASCADE() { return getToken(SqlParser.K_CASCADE, 0); }
		public TerminalNode K_CASE() { return getToken(SqlParser.K_CASE, 0); }
		public TerminalNode K_CAST() { return getToken(SqlParser.K_CAST, 0); }
		public TerminalNode K_CHECK() { return getToken(SqlParser.K_CHECK, 0); }
		public TerminalNode K_COLLATE() { return getToken(SqlParser.K_COLLATE, 0); }
		public TerminalNode K_COLUMN() { return getToken(SqlParser.K_COLUMN, 0); }
		public TerminalNode K_COMMIT() { return getToken(SqlParser.K_COMMIT, 0); }
		public TerminalNode K_CONFLICT() { return getToken(SqlParser.K_CONFLICT, 0); }
		public TerminalNode K_CONSTRAINT() { return getToken(SqlParser.K_CONSTRAINT, 0); }
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_CROSS() { return getToken(SqlParser.K_CROSS, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(SqlParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(SqlParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(SqlParser.K_CURRENT_TIMESTAMP, 0); }
		public TerminalNode K_DATABASE() { return getToken(SqlParser.K_DATABASE, 0); }
		public TerminalNode K_DEFAULT() { return getToken(SqlParser.K_DEFAULT, 0); }
		public TerminalNode K_DEFERRABLE() { return getToken(SqlParser.K_DEFERRABLE, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SqlParser.K_DEFERRED, 0); }
		public TerminalNode K_DELETE() { return getToken(SqlParser.K_DELETE, 0); }
		public TerminalNode K_DESC() { return getToken(SqlParser.K_DESC, 0); }
		public TerminalNode K_DETACH() { return getToken(SqlParser.K_DETACH, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SqlParser.K_DISTINCT, 0); }
		public TerminalNode K_DROP() { return getToken(SqlParser.K_DROP, 0); }
		public TerminalNode K_EACH() { return getToken(SqlParser.K_EACH, 0); }
		public TerminalNode K_ELSE() { return getToken(SqlParser.K_ELSE, 0); }
		public TerminalNode K_END() { return getToken(SqlParser.K_END, 0); }
		public TerminalNode K_ESCAPE() { return getToken(SqlParser.K_ESCAPE, 0); }
		public TerminalNode K_EXCEPT() { return getToken(SqlParser.K_EXCEPT, 0); }
		public TerminalNode K_EXCLUSIVE() { return getToken(SqlParser.K_EXCLUSIVE, 0); }
		public TerminalNode K_EXISTS() { return getToken(SqlParser.K_EXISTS, 0); }
		public TerminalNode K_EXPLAIN() { return getToken(SqlParser.K_EXPLAIN, 0); }
		public TerminalNode K_FAIL() { return getToken(SqlParser.K_FAIL, 0); }
		public TerminalNode K_FOR() { return getToken(SqlParser.K_FOR, 0); }
		public TerminalNode K_FOREIGN() { return getToken(SqlParser.K_FOREIGN, 0); }
		public TerminalNode K_FROM() { return getToken(SqlParser.K_FROM, 0); }
		public TerminalNode K_FULL() { return getToken(SqlParser.K_FULL, 0); }
		public TerminalNode K_GLOB() { return getToken(SqlParser.K_GLOB, 0); }
		public TerminalNode K_GROUP() { return getToken(SqlParser.K_GROUP, 0); }
		public TerminalNode K_HAVING() { return getToken(SqlParser.K_HAVING, 0); }
		public TerminalNode K_IF() { return getToken(SqlParser.K_IF, 0); }
		public TerminalNode K_IGNORE() { return getToken(SqlParser.K_IGNORE, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SqlParser.K_IMMEDIATE, 0); }
		public TerminalNode K_IN() { return getToken(SqlParser.K_IN, 0); }
		public TerminalNode K_INDEX() { return getToken(SqlParser.K_INDEX, 0); }
		public TerminalNode K_INDEXED() { return getToken(SqlParser.K_INDEXED, 0); }
		public TerminalNode K_INITIALLY() { return getToken(SqlParser.K_INITIALLY, 0); }
		public TerminalNode K_INNER() { return getToken(SqlParser.K_INNER, 0); }
		public TerminalNode K_INSERT() { return getToken(SqlParser.K_INSERT, 0); }
		public TerminalNode K_INSTEAD() { return getToken(SqlParser.K_INSTEAD, 0); }
		public TerminalNode K_INTERSECT() { return getToken(SqlParser.K_INTERSECT, 0); }
		public TerminalNode K_INTO() { return getToken(SqlParser.K_INTO, 0); }
		public TerminalNode K_IS() { return getToken(SqlParser.K_IS, 0); }
		public TerminalNode K_ISNULL() { return getToken(SqlParser.K_ISNULL, 0); }
		public TerminalNode K_JOIN() { return getToken(SqlParser.K_JOIN, 0); }
		public TerminalNode K_KEY() { return getToken(SqlParser.K_KEY, 0); }
		public TerminalNode K_LEFT() { return getToken(SqlParser.K_LEFT, 0); }
		public TerminalNode K_LIKE() { return getToken(SqlParser.K_LIKE, 0); }
		public TerminalNode K_LIMIT() { return getToken(SqlParser.K_LIMIT, 0); }
		public TerminalNode K_MATCH() { return getToken(SqlParser.K_MATCH, 0); }
		public TerminalNode K_NATURAL() { return getToken(SqlParser.K_NATURAL, 0); }
		public TerminalNode K_NO() { return getToken(SqlParser.K_NO, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SqlParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SqlParser.K_NULL, 0); }
		public TerminalNode K_OF() { return getToken(SqlParser.K_OF, 0); }
		public TerminalNode K_OFFSET() { return getToken(SqlParser.K_OFFSET, 0); }
		public TerminalNode K_ON() { return getToken(SqlParser.K_ON, 0); }
		public TerminalNode K_OR() { return getToken(SqlParser.K_OR, 0); }
		public TerminalNode K_ORDER() { return getToken(SqlParser.K_ORDER, 0); }
		public TerminalNode K_OUTER() { return getToken(SqlParser.K_OUTER, 0); }
		public TerminalNode K_PLAN() { return getToken(SqlParser.K_PLAN, 0); }
		public TerminalNode K_PRAGMA() { return getToken(SqlParser.K_PRAGMA, 0); }
		public TerminalNode K_PRIMARY() { return getToken(SqlParser.K_PRIMARY, 0); }
		public TerminalNode K_QUERY() { return getToken(SqlParser.K_QUERY, 0); }
		public TerminalNode K_RAISE() { return getToken(SqlParser.K_RAISE, 0); }
		public TerminalNode K_RECURSIVE() { return getToken(SqlParser.K_RECURSIVE, 0); }
		public TerminalNode K_REFERENCES() { return getToken(SqlParser.K_REFERENCES, 0); }
		public TerminalNode K_REGEXP() { return getToken(SqlParser.K_REGEXP, 0); }
		public TerminalNode K_REINDEX() { return getToken(SqlParser.K_REINDEX, 0); }
		public TerminalNode K_RELEASE() { return getToken(SqlParser.K_RELEASE, 0); }
		public TerminalNode K_RENAME() { return getToken(SqlParser.K_RENAME, 0); }
		public TerminalNode K_REPLACE() { return getToken(SqlParser.K_REPLACE, 0); }
		public TerminalNode K_RESTRICT() { return getToken(SqlParser.K_RESTRICT, 0); }
		public TerminalNode K_RIGHT() { return getToken(SqlParser.K_RIGHT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SqlParser.K_ROLLBACK, 0); }
		public TerminalNode K_ROW() { return getToken(SqlParser.K_ROW, 0); }
		public TerminalNode K_SAVEPOINT() { return getToken(SqlParser.K_SAVEPOINT, 0); }
		public TerminalNode K_SELECT() { return getToken(SqlParser.K_SELECT, 0); }
		public TerminalNode K_SET() { return getToken(SqlParser.K_SET, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public TerminalNode K_TEMP() { return getToken(SqlParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SqlParser.K_TEMPORARY, 0); }
		public TerminalNode K_THEN() { return getToken(SqlParser.K_THEN, 0); }
		public TerminalNode K_TO() { return getToken(SqlParser.K_TO, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SqlParser.K_TRANSACTION, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SqlParser.K_TRIGGER, 0); }
		public TerminalNode K_UNION() { return getToken(SqlParser.K_UNION, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SqlParser.K_UNIQUE, 0); }
		public TerminalNode K_UPDATE() { return getToken(SqlParser.K_UPDATE, 0); }
		public TerminalNode K_USING() { return getToken(SqlParser.K_USING, 0); }
		public TerminalNode K_VACUUM() { return getToken(SqlParser.K_VACUUM, 0); }
		public TerminalNode K_VALUES() { return getToken(SqlParser.K_VALUES, 0); }
		public TerminalNode K_VIEW() { return getToken(SqlParser.K_VIEW, 0); }
		public TerminalNode K_VIRTUAL() { return getToken(SqlParser.K_VIRTUAL, 0); }
		public TerminalNode K_WHEN() { return getToken(SqlParser.K_WHEN, 0); }
		public TerminalNode K_WHERE() { return getToken(SqlParser.K_WHERE, 0); }
		public TerminalNode K_WITH() { return getToken(SqlParser.K_WITH, 0); }
		public TerminalNode K_WITHOUT() { return getToken(SqlParser.K_WITHOUT, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1644);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (K_ABORT - 25)) | (1L << (K_ACTION - 25)) | (1L << (K_ADD - 25)) | (1L << (K_AFTER - 25)) | (1L << (K_ALL - 25)) | (1L << (K_ALTER - 25)) | (1L << (K_ANALYZE - 25)) | (1L << (K_AND - 25)) | (1L << (K_AS - 25)) | (1L << (K_ASC - 25)) | (1L << (K_ATTACH - 25)) | (1L << (K_AUTOINCREMENT - 25)) | (1L << (K_BEFORE - 25)) | (1L << (K_BEGIN - 25)) | (1L << (K_BETWEEN - 25)) | (1L << (K_BY - 25)) | (1L << (K_CASCADE - 25)) | (1L << (K_CASE - 25)) | (1L << (K_CAST - 25)) | (1L << (K_CHECK - 25)) | (1L << (K_COLLATE - 25)) | (1L << (K_COLUMN - 25)) | (1L << (K_COMMIT - 25)) | (1L << (K_CONFLICT - 25)) | (1L << (K_CONSTRAINT - 25)) | (1L << (K_CREATE - 25)) | (1L << (K_CROSS - 25)) | (1L << (K_CURRENT_DATE - 25)) | (1L << (K_CURRENT_TIME - 25)) | (1L << (K_CURRENT_TIMESTAMP - 25)) | (1L << (K_DATABASE - 25)) | (1L << (K_DEFAULT - 25)) | (1L << (K_DEFERRABLE - 25)) | (1L << (K_DEFERRED - 25)) | (1L << (K_DELETE - 25)) | (1L << (K_DESC - 25)) | (1L << (K_DETACH - 25)) | (1L << (K_DISTINCT - 25)) | (1L << (K_DROP - 25)) | (1L << (K_EACH - 25)) | (1L << (K_ELSE - 25)) | (1L << (K_END - 25)) | (1L << (K_ESCAPE - 25)) | (1L << (K_EXCEPT - 25)) | (1L << (K_EXCLUSIVE - 25)) | (1L << (K_EXISTS - 25)) | (1L << (K_EXPLAIN - 25)) | (1L << (K_FAIL - 25)) | (1L << (K_FOR - 25)) | (1L << (K_FOREIGN - 25)) | (1L << (K_FROM - 25)) | (1L << (K_FULL - 25)) | (1L << (K_GLOB - 25)) | (1L << (K_GROUP - 25)) | (1L << (K_HAVING - 25)) | (1L << (K_IF - 25)) | (1L << (K_IGNORE - 25)) | (1L << (K_IMMEDIATE - 25)) | (1L << (K_IN - 25)) | (1L << (K_INDEX - 25)) | (1L << (K_INDEXED - 25)) | (1L << (K_INITIALLY - 25)) | (1L << (K_INNER - 25)) | (1L << (K_INSERT - 25)))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (K_INSTEAD - 89)) | (1L << (K_INTERSECT - 89)) | (1L << (K_INTO - 89)) | (1L << (K_IS - 89)) | (1L << (K_ISNULL - 89)) | (1L << (K_JOIN - 89)) | (1L << (K_KEY - 89)) | (1L << (K_LEFT - 89)) | (1L << (K_LIKE - 89)) | (1L << (K_LIMIT - 89)) | (1L << (K_MATCH - 89)) | (1L << (K_NATURAL - 89)) | (1L << (K_NO - 89)) | (1L << (K_NOT - 89)) | (1L << (K_NOTNULL - 89)) | (1L << (K_NULL - 89)) | (1L << (K_OF - 89)) | (1L << (K_OFFSET - 89)) | (1L << (K_ON - 89)) | (1L << (K_OR - 89)) | (1L << (K_ORDER - 89)) | (1L << (K_OUTER - 89)) | (1L << (K_PLAN - 89)) | (1L << (K_PRAGMA - 89)) | (1L << (K_PRIMARY - 89)) | (1L << (K_QUERY - 89)) | (1L << (K_RAISE - 89)) | (1L << (K_RECURSIVE - 89)) | (1L << (K_REFERENCES - 89)) | (1L << (K_REGEXP - 89)) | (1L << (K_REINDEX - 89)) | (1L << (K_RELEASE - 89)) | (1L << (K_RENAME - 89)) | (1L << (K_REPLACE - 89)) | (1L << (K_RESTRICT - 89)) | (1L << (K_RIGHT - 89)) | (1L << (K_ROLLBACK - 89)) | (1L << (K_ROW - 89)) | (1L << (K_SAVEPOINT - 89)) | (1L << (K_SELECT - 89)) | (1L << (K_SET - 89)) | (1L << (K_TABLE - 89)) | (1L << (K_TEMP - 89)) | (1L << (K_TEMPORARY - 89)) | (1L << (K_THEN - 89)) | (1L << (K_TO - 89)) | (1L << (K_TRANSACTION - 89)) | (1L << (K_TRIGGER - 89)) | (1L << (K_UNION - 89)) | (1L << (K_UNIQUE - 89)) | (1L << (K_UPDATE - 89)) | (1L << (K_USING - 89)) | (1L << (K_VACUUM - 89)) | (1L << (K_VALUES - 89)) | (1L << (K_VIEW - 89)) | (1L << (K_VIRTUAL - 89)) | (1L << (K_WHEN - 89)) | (1L << (K_WHERE - 89)) | (1L << (K_WITH - 89)) | (1L << (K_WITHOUT - 89)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1646);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1648);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Database_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Database_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDatabase_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDatabase_name(this);
		}
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1650);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1652);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_or_index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable_or_index_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable_or_index_name(this);
		}
	}

	public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
		Table_or_index_nameContext _localctx = new Table_or_index_nameContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_table_or_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1654);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public New_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterNew_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitNew_table_name(this);
		}
	}

	public final New_table_nameContext new_table_name() throws RecognitionException {
		New_table_nameContext _localctx = new New_table_nameContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_new_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1656);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumn_name(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1658);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Collation_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCollation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCollation_name(this);
		}
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1660);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_tableContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Foreign_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterForeign_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitForeign_table(this);
		}
	}

	public final Foreign_tableContext foreign_table() throws RecognitionException {
		Foreign_tableContext _localctx = new Foreign_tableContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_foreign_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitIndex_name(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1664);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Trigger_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTrigger_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTrigger_name(this);
		}
	}

	public final Trigger_nameContext trigger_name() throws RecognitionException {
		Trigger_nameContext _localctx = new Trigger_nameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_trigger_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1666);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class View_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public View_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterView_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitView_name(this);
		}
	}

	public final View_nameContext view_name() throws RecognitionException {
		View_nameContext _localctx = new View_nameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_view_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1668);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Module_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterModule_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitModule_name(this);
		}
	}

	public final Module_nameContext module_name() throws RecognitionException {
		Module_nameContext _localctx = new Module_nameContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1670);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Pragma_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterPragma_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitPragma_name(this);
		}
	}

	public final Pragma_nameContext pragma_name() throws RecognitionException {
		Pragma_nameContext _localctx = new Pragma_nameContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_pragma_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1672);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Savepoint_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSavepoint_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSavepoint_name(this);
		}
	}

	public final Savepoint_nameContext savepoint_name() throws RecognitionException {
		Savepoint_nameContext _localctx = new Savepoint_nameContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_savepoint_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1674);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_aliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable_alias(this);
		}
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1676);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Transaction_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Transaction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transaction_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTransaction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTransaction_name(this);
		}
	}

	public final Transaction_nameContext transaction_name() throws RecognitionException {
		Transaction_nameContext _localctx = new Transaction_nameContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_transaction_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAny_name(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_any_name);
		try {
			setState(1686);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1680);
				match(IDENTIFIER);
				}
				break;
			case K_ABORT:
			case K_ACTION:
			case K_ADD:
			case K_AFTER:
			case K_ALL:
			case K_ALTER:
			case K_ANALYZE:
			case K_AND:
			case K_AS:
			case K_ASC:
			case K_ATTACH:
			case K_AUTOINCREMENT:
			case K_BEFORE:
			case K_BEGIN:
			case K_BETWEEN:
			case K_BY:
			case K_CASCADE:
			case K_CASE:
			case K_CAST:
			case K_CHECK:
			case K_COLLATE:
			case K_COLUMN:
			case K_COMMIT:
			case K_CONFLICT:
			case K_CONSTRAINT:
			case K_CREATE:
			case K_CROSS:
			case K_CURRENT_DATE:
			case K_CURRENT_TIME:
			case K_CURRENT_TIMESTAMP:
			case K_DATABASE:
			case K_DEFAULT:
			case K_DEFERRABLE:
			case K_DEFERRED:
			case K_DELETE:
			case K_DESC:
			case K_DETACH:
			case K_DISTINCT:
			case K_DROP:
			case K_EACH:
			case K_ELSE:
			case K_END:
			case K_ESCAPE:
			case K_EXCEPT:
			case K_EXCLUSIVE:
			case K_EXISTS:
			case K_EXPLAIN:
			case K_FAIL:
			case K_FOR:
			case K_FOREIGN:
			case K_FROM:
			case K_FULL:
			case K_GLOB:
			case K_GROUP:
			case K_HAVING:
			case K_IF:
			case K_IGNORE:
			case K_IMMEDIATE:
			case K_IN:
			case K_INDEX:
			case K_INDEXED:
			case K_INITIALLY:
			case K_INNER:
			case K_INSERT:
			case K_INSTEAD:
			case K_INTERSECT:
			case K_INTO:
			case K_IS:
			case K_ISNULL:
			case K_JOIN:
			case K_KEY:
			case K_LEFT:
			case K_LIKE:
			case K_LIMIT:
			case K_MATCH:
			case K_NATURAL:
			case K_NO:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_OF:
			case K_OFFSET:
			case K_ON:
			case K_OR:
			case K_ORDER:
			case K_OUTER:
			case K_PLAN:
			case K_PRAGMA:
			case K_PRIMARY:
			case K_QUERY:
			case K_RAISE:
			case K_RECURSIVE:
			case K_REFERENCES:
			case K_REGEXP:
			case K_REINDEX:
			case K_RELEASE:
			case K_RENAME:
			case K_REPLACE:
			case K_RESTRICT:
			case K_RIGHT:
			case K_ROLLBACK:
			case K_ROW:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SET:
			case K_TABLE:
			case K_TEMP:
			case K_TEMPORARY:
			case K_THEN:
			case K_TO:
			case K_TRANSACTION:
			case K_TRIGGER:
			case K_UNION:
			case K_UNIQUE:
			case K_UPDATE:
			case K_USING:
			case K_VACUUM:
			case K_VALUES:
			case K_VIEW:
			case K_VIRTUAL:
			case K_WHEN:
			case K_WHERE:
			case K_WITH:
			case K_WITHOUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1681);
				keyword();
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1682);
				match(OPEN_PAR);
				setState(1683);
				any_name();
				setState(1684);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u009f\u069b\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\3\2\3\2\5\2"+
		"\u00a7\n\2\3\2\5\2\u00aa\n\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4\u00b2\n\4\5\4"+
		"\u00b4\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00d4"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\5\5\u00db\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00e3"+
		"\n\5\3\5\5\5\u00e6\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ef\n\6\3\7\3"+
		"\7\5\7\u00f3\n\7\3\7\3\7\3\7\3\7\3\b\3\b\5\b\u00fb\n\b\3\b\3\b\5\b\u00ff"+
		"\n\b\5\b\u0101\n\b\3\t\3\t\3\t\5\t\u0106\n\t\5\t\u0108\n\t\3\n\3\n\5\n"+
		"\u010c\n\n\3\n\3\n\3\n\7\n\u0111\n\n\f\n\16\n\u0114\13\n\5\n\u0116\n\n"+
		"\3\n\3\n\3\n\5\n\u011b\n\n\3\n\3\n\5\n\u011f\n\n\3\n\6\n\u0122\n\n\r\n"+
		"\16\n\u0123\3\n\3\n\3\n\3\n\3\n\7\n\u012b\n\n\f\n\16\n\u012e\13\n\5\n"+
		"\u0130\n\n\3\n\3\n\3\n\3\n\5\n\u0136\n\n\5\n\u0138\n\n\3\13\3\13\5\13"+
		"\u013c\n\13\3\13\3\13\3\13\3\13\5\13\u0142\n\13\3\13\3\13\3\13\5\13\u0147"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0150\n\13\f\13\16\13\u0153"+
		"\13\13\3\13\3\13\3\13\5\13\u0158\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f"+
		"\u0161\n\f\f\f\16\f\u0164\13\f\3\f\3\f\7\f\u0168\n\f\f\f\16\f\u016b\13"+
		"\f\3\f\3\f\3\f\5\f\u0170\n\f\3\f\3\f\5\f\u0174\n\f\3\r\3\r\5\r\u0178\n"+
		"\r\3\r\3\r\3\r\3\r\5\r\u017e\n\r\3\r\3\r\3\r\5\r\u0183\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u018a\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0193\n\r\f\r\16"+
		"\r\u0196\13\r\5\r\u0198\n\r\5\r\u019a\n\r\3\r\3\r\3\r\3\r\5\r\u01a0\n"+
		"\r\3\r\3\r\3\r\3\r\5\r\u01a6\n\r\3\r\3\r\5\r\u01aa\n\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u01b1\n\r\3\r\3\r\6\r\u01b5\n\r\r\r\16\r\u01b6\3\r\3\r\3\16\3"+
		"\16\5\16\u01bd\n\16\3\16\3\16\3\16\3\16\5\16\u01c3\n\16\3\16\3\16\3\16"+
		"\5\16\u01c8\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u01d4\n\17\3\17\3\17\3\17\5\17\u01d9\n\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\7\17\u01e2\n\17\f\17\16\17\u01e5\13\17\3\17\3\17\5\17\u01e9\n"+
		"\17\3\20\5\20\u01ec\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u01f3\n\20\3\21"+
		"\5\21\u01f6\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u01fd\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\7\21\u0204\n\21\f\21\16\21\u0207\13\21\5\21\u0209\n\21\3"+
		"\21\3\21\3\21\3\21\5\21\u020f\n\21\5\21\u0211\n\21\3\22\3\22\5\22\u0215"+
		"\n\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u021d\n\23\3\23\3\23\3\23\5\23"+
		"\u0222\n\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u022a\n\24\3\24\3\24\3"+
		"\24\5\24\u022f\n\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0237\n\25\3\25"+
		"\3\25\3\25\5\25\u023c\n\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u0244\n"+
		"\26\3\26\3\26\3\26\5\26\u0249\n\26\3\26\3\26\3\27\3\27\5\27\u024f\n\27"+
		"\3\27\3\27\3\27\7\27\u0254\n\27\f\27\16\27\u0257\13\27\5\27\u0259\n\27"+
		"\3\27\3\27\3\27\3\27\7\27\u025f\n\27\f\27\16\27\u0262\13\27\3\27\3\27"+
		"\3\27\3\27\3\27\7\27\u0269\n\27\f\27\16\27\u026c\13\27\5\27\u026e\n\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0274\n\27\5\27\u0276\n\27\3\30\5\30\u0279\n"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u028c\n\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u0294\n\30\f\30\16\30\u0297\13\30\3\30\3\30\5\30\u029b\n\30\3\30\3\30"+
		"\3\30\5\30\u02a0\n\30\3\30\3\30\5\30\u02a4\n\30\7\30\u02a6\n\30\f\30\16"+
		"\30\u02a9\13\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u02b1\n\30\f\30\16"+
		"\30\u02b4\13\30\3\30\3\30\7\30\u02b8\n\30\f\30\16\30\u02bb\13\30\3\30"+
		"\3\30\3\30\5\30\u02c0\n\30\3\31\3\31\3\31\3\31\5\31\u02c6\n\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\5\31\u02cf\n\31\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u02d6\n\32\3\32\3\32\5\32\u02da\n\32\5\32\u02dc\n\32\3\33\3\33\5"+
		"\33\u02e0\n\33\3\33\3\33\3\34\3\34\3\34\5\34\u02e7\n\34\5\34\u02e9\n\34"+
		"\3\34\3\34\5\34\u02ed\n\34\3\34\5\34\u02f0\n\34\3\35\3\35\3\35\3\36\3"+
		"\36\5\36\u02f7\n\36\3\36\3\36\3\36\7\36\u02fc\n\36\f\36\16\36\u02ff\13"+
		"\36\5\36\u0301\n\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0309\n\36\f\36"+
		"\16\36\u030c\13\36\5\36\u030e\n\36\3\36\3\36\3\36\3\36\5\36\u0314\n\36"+
		"\5\36\u0316\n\36\3\37\3\37\5\37\u031a\n\37\3\37\3\37\3\37\7\37\u031f\n"+
		"\37\f\37\16\37\u0322\13\37\5\37\u0324\n\37\3\37\3\37\3\37\3\37\7\37\u032a"+
		"\n\37\f\37\16\37\u032d\13\37\3\37\3\37\3\37\3\37\3\37\7\37\u0334\n\37"+
		"\f\37\16\37\u0337\13\37\5\37\u0339\n\37\3\37\3\37\3\37\3\37\5\37\u033f"+
		"\n\37\5\37\u0341\n\37\3 \3 \5 \u0345\n \3 \3 \3 \7 \u034a\n \f \16 \u034d"+
		"\13 \3 \3 \3 \3 \7 \u0353\n \f \16 \u0356\13 \3 \5 \u0359\n \5 \u035b"+
		"\n \3 \3 \5 \u035f\n \3 \3 \3 \3 \3 \7 \u0366\n \f \16 \u0369\13 \3 \3"+
		" \5 \u036d\n \5 \u036f\n \3 \3 \3 \3 \3 \7 \u0376\n \f \16 \u0379\13 "+
		"\3 \3 \3 \3 \3 \3 \7 \u0381\n \f \16 \u0384\13 \3 \3 \7 \u0388\n \f \16"+
		" \u038b\13 \5 \u038d\n \3!\5!\u0390\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\5!\u039d\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u03a9\n!\f!\16!\u03ac\13"+
		"!\3!\3!\5!\u03b0\n!\3\"\5\"\u03b3\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u03c0\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\""+
		"\u03cc\n\"\f\"\16\"\u03cf\13\"\3\"\3\"\5\"\u03d3\n\"\3\"\3\"\3\"\3\"\3"+
		"\"\7\"\u03da\n\"\f\"\16\"\u03dd\13\"\5\"\u03df\n\"\3\"\3\"\3\"\3\"\5\""+
		"\u03e5\n\"\5\"\u03e7\n\"\3#\3#\3$\3$\5$\u03ed\n$\3$\7$\u03f0\n$\f$\16"+
		"$\u03f3\13$\3%\6%\u03f6\n%\r%\16%\u03f7\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\5%\u0404\n%\3&\3&\5&\u0408\n&\3&\3&\3&\5&\u040d\n&\3&\3&\5&\u0411\n&"+
		"\3&\5&\u0414\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0426"+
		"\n&\3&\3&\3&\5&\u042b\n&\3\'\3\'\3\'\5\'\u0430\n\'\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u043b\n(\3(\3(\3(\5(\u0440\n(\3(\3(\3(\3(\5(\u0446\n(\3(\3"+
		"(\3(\7(\u044b\n(\f(\16(\u044e\13(\3(\5(\u0451\n(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\5(\u0461\n(\3(\5(\u0464\n(\3(\3(\3(\3(\3(\3(\5("+
		"\u046c\n(\3(\3(\3(\3(\3(\6(\u0473\n(\r(\16(\u0474\3(\3(\5(\u0479\n(\3"+
		"(\3(\3(\5(\u047e\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u049c\n(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u04a8\n(\3(\3(\3(\5(\u04ad\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\5(\u04b9\n(\3(\3(\3(\3(\5(\u04bf\n(\3(\3(\3(\3(\3(\5(\u04c6\n(\3(\3"+
		"(\5(\u04ca\n(\3(\3(\3(\3(\3(\3(\7(\u04d2\n(\f(\16(\u04d5\13(\5(\u04d7"+
		"\n(\3(\3(\3(\3(\5(\u04dd\n(\3(\5(\u04e0\n(\7(\u04e2\n(\f(\16(\u04e5\13"+
		"(\3)\3)\3)\3)\3)\3)\7)\u04ed\n)\f)\16)\u04f0\13)\3)\3)\5)\u04f4\n)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0500\n)\3)\3)\5)\u0504\n)\7)\u0506\n)"+
		"\f)\16)\u0509\13)\3)\5)\u050c\n)\3)\3)\3)\3)\3)\5)\u0513\n)\5)\u0515\n"+
		")\3*\3*\3*\3*\3*\3*\5*\u051d\n*\3*\3*\3+\3+\3+\5+\u0524\n+\3+\5+\u0527"+
		"\n+\3,\3,\5,\u052b\n,\3,\3,\3,\5,\u0530\n,\3,\3,\3,\3,\7,\u0536\n,\f,"+
		"\16,\u0539\13,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u0549\n,\f"+
		",\16,\u054c\13,\3,\3,\3,\5,\u0551\n,\3-\3-\5-\u0555\n-\3-\3-\3-\3-\3-"+
		"\3-\3-\3-\3-\3-\3-\3-\7-\u0563\n-\f-\16-\u0566\13-\3.\3.\3.\5.\u056b\n"+
		".\3.\3.\3.\3.\3.\3.\5.\u0573\n.\3/\3/\3/\5/\u0578\n/\3/\5/\u057b\n/\3"+
		"\60\3\60\3\60\5\60\u0580\n\60\3\61\3\61\3\61\3\61\3\61\7\61\u0587\n\61"+
		"\f\61\16\61\u058a\13\61\3\61\3\61\5\61\u058e\n\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u059c\n\62\3\62\5\62\u059f"+
		"\n\62\5\62\u05a1\n\62\3\63\3\63\3\63\5\63\u05a6\n\63\3\63\3\63\5\63\u05aa"+
		"\n\63\3\63\5\63\u05ad\n\63\3\63\3\63\3\63\3\63\3\63\5\63\u05b4\n\63\3"+
		"\63\3\63\3\63\3\63\7\63\u05ba\n\63\f\63\16\63\u05bd\13\63\3\63\5\63\u05c0"+
		"\n\63\3\63\3\63\5\63\u05c4\n\63\3\63\5\63\u05c7\n\63\3\63\3\63\3\63\3"+
		"\63\5\63\u05cd\n\63\3\63\5\63\u05d0\n\63\5\63\u05d2\n\63\3\64\3\64\3\64"+
		"\3\64\3\64\7\64\u05d9\n\64\f\64\16\64\u05dc\13\64\3\65\3\65\5\65\u05e0"+
		"\n\65\3\65\3\65\5\65\u05e4\n\65\3\65\3\65\5\65\u05e8\n\65\3\65\5\65\u05eb"+
		"\n\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u05f4\n\66\f\66\16\66\u05f7"+
		"\13\66\3\66\3\66\5\66\u05fb\n\66\3\67\3\67\5\67\u05ff\n\67\3\67\3\67\3"+
		"\67\7\67\u0604\n\67\f\67\16\67\u0607\13\67\3\67\3\67\3\67\3\67\7\67\u060d"+
		"\n\67\f\67\16\67\u0610\13\67\3\67\5\67\u0613\n\67\5\67\u0615\n\67\3\67"+
		"\3\67\5\67\u0619\n\67\3\67\3\67\3\67\3\67\3\67\7\67\u0620\n\67\f\67\16"+
		"\67\u0623\13\67\3\67\3\67\5\67\u0627\n\67\5\67\u0629\n\67\3\67\3\67\3"+
		"\67\3\67\3\67\7\67\u0630\n\67\f\67\16\67\u0633\13\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\7\67\u063b\n\67\f\67\16\67\u063e\13\67\3\67\3\67\7\67\u0642"+
		"\n\67\f\67\16\67\u0645\13\67\5\67\u0647\n\67\38\38\38\38\38\58\u064e\n"+
		"8\39\39\39\39\39\79\u0655\n9\f9\169\u0658\139\39\39\59\u065c\n9\3:\5:"+
		"\u065f\n:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\5>\u066b\n>\3?\3?\3@\3@\3A\3A"+
		"\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M"+
		"\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3R\3R\3R\3R\5R\u0699\nR\3R\2\3NS\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\2\24\5\2"+
		"<<GGTT\4\2\61\61DD\4\2\7\7ll\3\2\u0085\u0086\4\2\37\37@@\4\2$$>>\7\2\33"+
		"\33JJSS||\177\177\4\2\t\t\16\17\3\2\n\13\3\2\20\23\3\2\24\27\6\2OOcce"+
		"exx\4\2==\u008d\u008d\5\2\33\33JJ\177\177\6\2\668jj\u0098\u0098\u009a"+
		"\u009b\4\2\n\fhh\4\2\u0097\u0097\u009a\u009a\3\2\33\u0096\u07a2\2\u00a6"+
		"\3\2\2\2\4\u00ab\3\2\2\2\6\u00b3\3\2\2\2\b\u00d5\3\2\2\2\n\u00e7\3\2\2"+
		"\2\f\u00f0\3\2\2\2\16\u00f8\3\2\2\2\20\u0102\3\2\2\2\22\u0115\3\2\2\2"+
		"\24\u0139\3\2\2\2\26\u0159\3\2\2\2\30\u0175\3\2\2\2\32\u01ba\3\2\2\2\34"+
		"\u01cd\3\2\2\2\36\u01eb\3\2\2\2 \u01f5\3\2\2\2\"\u0212\3\2\2\2$\u0218"+
		"\3\2\2\2&\u0225\3\2\2\2(\u0232\3\2\2\2*\u023f\3\2\2\2,\u0258\3\2\2\2."+
		"\u0278\3\2\2\2\60\u02c1\3\2\2\2\62\u02d0\3\2\2\2\64\u02dd\3\2\2\2\66\u02e3"+
		"\3\2\2\28\u02f1\3\2\2\2:\u0300\3\2\2\2<\u0323\3\2\2\2>\u038c\3\2\2\2@"+
		"\u038f\3\2\2\2B\u03b2\3\2\2\2D\u03e8\3\2\2\2F\u03ea\3\2\2\2H\u03f5\3\2"+
		"\2\2J\u0407\3\2\2\2L\u042f\3\2\2\2N\u047d\3\2\2\2P\u04e6\3\2\2\2R\u0516"+
		"\3\2\2\2T\u0520\3\2\2\2V\u052a\3\2\2\2X\u0552\3\2\2\2Z\u056a\3\2\2\2\\"+
		"\u0574\3\2\2\2^\u057f\3\2\2\2`\u0581\3\2\2\2b\u05a0\3\2\2\2d\u05d1\3\2"+
		"\2\2f\u05d3\3\2\2\2h\u05ea\3\2\2\2j\u05fa\3\2\2\2l\u0646\3\2\2\2n\u064d"+
		"\3\2\2\2p\u064f\3\2\2\2r\u065e\3\2\2\2t\u0662\3\2\2\2v\u0664\3\2\2\2x"+
		"\u0666\3\2\2\2z\u066a\3\2\2\2|\u066c\3\2\2\2~\u066e\3\2\2\2\u0080\u0670"+
		"\3\2\2\2\u0082\u0672\3\2\2\2\u0084\u0674\3\2\2\2\u0086\u0676\3\2\2\2\u0088"+
		"\u0678\3\2\2\2\u008a\u067a\3\2\2\2\u008c\u067c\3\2\2\2\u008e\u067e\3\2"+
		"\2\2\u0090\u0680\3\2\2\2\u0092\u0682\3\2\2\2\u0094\u0684\3\2\2\2\u0096"+
		"\u0686\3\2\2\2\u0098\u0688\3\2\2\2\u009a\u068a\3\2\2\2\u009c\u068c\3\2"+
		"\2\2\u009e\u068e\3\2\2\2\u00a0\u0690\3\2\2\2\u00a2\u0698\3\2\2\2\u00a4"+
		"\u00a7\5\6\4\2\u00a5\u00a7\5\4\3\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2"+
		"\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00aa\7\2\2\3\u00a9\u00a8\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\3\3\2\2\2\u00ab\u00ac\7\u009f\2\2\u00ac\u00ad\b\3"+
		"\1\2\u00ad\5\3\2\2\2\u00ae\u00b1\7I\2\2\u00af\u00b0\7t\2\2\u00b0\u00b2"+
		"\7q\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00ae\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00d3\3\2\2\2\u00b5\u00d4\5\b"+
		"\5\2\u00b6\u00d4\5\n\6\2\u00b7\u00d4\5\f\7\2\u00b8\u00d4\5\16\b\2\u00b9"+
		"\u00d4\5\20\t\2\u00ba\u00d4\5\22\n\2\u00bb\u00d4\5\24\13\2\u00bc\u00d4"+
		"\5\26\f\2\u00bd\u00d4\5\30\r\2\u00be\u00d4\5\32\16\2\u00bf\u00d4\5\34"+
		"\17\2\u00c0\u00d4\5\36\20\2\u00c1\u00d4\5 \21\2\u00c2\u00d4\5\"\22\2\u00c3"+
		"\u00d4\5$\23\2\u00c4\u00d4\5&\24\2\u00c5\u00d4\5(\25\2\u00c6\u00d4\5*"+
		"\26\2\u00c7\u00d4\5,\27\2\u00c8\u00d4\5.\30\2\u00c9\u00d4\5\60\31\2\u00ca"+
		"\u00d4\5\62\32\2\u00cb\u00d4\5\64\33\2\u00cc\u00d4\5\66\34\2\u00cd\u00d4"+
		"\58\35\2\u00ce\u00d4\5:\36\2\u00cf\u00d4\5<\37\2\u00d0\u00d4\5@!\2\u00d1"+
		"\u00d4\5B\"\2\u00d2\u00d4\5D#\2\u00d3\u00b5\3\2\2\2\u00d3\u00b6\3\2\2"+
		"\2\u00d3\u00b7\3\2\2\2\u00d3\u00b8\3\2\2\2\u00d3\u00b9\3\2\2\2\u00d3\u00ba"+
		"\3\2\2\2\u00d3\u00bb\3\2\2\2\u00d3\u00bc\3\2\2\2\u00d3\u00bd\3\2\2\2\u00d3"+
		"\u00be\3\2\2\2\u00d3\u00bf\3\2\2\2\u00d3\u00c0\3\2\2\2\u00d3\u00c1\3\2"+
		"\2\2\u00d3\u00c2\3\2\2\2\u00d3\u00c3\3\2\2\2\u00d3\u00c4\3\2\2\2\u00d3"+
		"\u00c5\3\2\2\2\u00d3\u00c6\3\2\2\2\u00d3\u00c7\3\2\2\2\u00d3\u00c8\3\2"+
		"\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3"+
		"\u00cc\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00cf\3\2"+
		"\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"\7\3\2\2\2\u00d5\u00d6\7 \2\2\u00d6\u00da\7\u0084\2\2\u00d7\u00d8\5\u0084"+
		"C\2\u00d8\u00d9\7\4\2\2\u00d9\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e5\5\u0086D\2\u00dd\u00de"+
		"\7{\2\2\u00de\u00df\7\u0088\2\2\u00df\u00e6\5\u008aF\2\u00e0\u00e2\7\35"+
		"\2\2\u00e1\u00e3\7\60\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e6\5F$\2\u00e5\u00dd\3\2\2\2\u00e5\u00e0\3\2\2"+
		"\2\u00e6\t\3\2\2\2\u00e7\u00ee\7!\2\2\u00e8\u00ef\5\u0084C\2\u00e9\u00ef"+
		"\5\u0088E\2\u00ea\u00eb\5\u0084C\2\u00eb\u00ec\7\4\2\2\u00ec\u00ed\5\u0088"+
		"E\2\u00ed\u00ef\3\2\2\2\u00ee\u00e8\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee"+
		"\u00ea\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\13\3\2\2\2\u00f0\u00f2\7%\2\2"+
		"\u00f1\u00f3\79\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f5\5N(\2\u00f5\u00f6\7#\2\2\u00f6\u00f7\5\u0084C\2\u00f7"+
		"\r\3\2\2\2\u00f8\u00fa\7(\2\2\u00f9\u00fb\t\2\2\2\u00fa\u00f9\3\2\2\2"+
		"\u00fa\u00fb\3\2\2\2\u00fb\u0100\3\2\2\2\u00fc\u00fe\7\u0089\2\2\u00fd"+
		"\u00ff\5\u00a0Q\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101"+
		"\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u0101\3\2\2\2\u0101\17\3\2\2\2\u0102"+
		"\u0107\t\3\2\2\u0103\u0105\7\u0089\2\2\u0104\u0106\5\u00a0Q\2\u0105\u0104"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0103\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\21\3\2\2\2\u0109\u010b\7\u0095\2\2\u010a\u010c\7"+
		"v\2\2\u010b\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u0112\5`\61\2\u010e\u010f\7\7\2\2\u010f\u0111\5`\61\2\u0110\u010e\3\2"+
		"\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0109\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0121\5l\67\2\u0118\u011a\7\u008b\2\2\u0119"+
		"\u011b\7\37\2\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011f\3"+
		"\2\2\2\u011c\u011f\7\\\2\2\u011d\u011f\7F\2\2\u011e\u0118\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\5l"+
		"\67\2\u0121\u011e\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\u012f\3\2\2\2\u0125\u0126\7o\2\2\u0126\u0127\7*\2"+
		"\2\u0127\u012c\5\\/\2\u0128\u0129\7\7\2\2\u0129\u012b\5\\/\2\u012a\u0128"+
		"\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0125\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130\u0137\3\2\2\2\u0131\u0132\7d\2\2\u0132\u0135\5N(\2\u0133\u0134"+
		"\t\4\2\2\u0134\u0136\5N(\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0138\3\2\2\2\u0137\u0131\3\2\2\2\u0137\u0138\3\2\2\2\u0138\23\3\2\2"+
		"\2\u0139\u013b\7\64\2\2\u013a\u013c\7\u008c\2\2\u013b\u013a\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0141\7V\2\2\u013e\u013f\7R\2"+
		"\2\u013f\u0140\7h\2\2\u0140\u0142\7H\2\2\u0141\u013e\3\2\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0146\3\2\2\2\u0143\u0144\5\u0084C\2\u0144\u0145\7\4\2"+
		"\2\u0145\u0147\3\2\2\2\u0146\u0143\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u0149\5\u0092J\2\u0149\u014a\7m\2\2\u014a\u014b\5\u0086"+
		"D\2\u014b\u014c\7\5\2\2\u014c\u0151\5T+\2\u014d\u014e\7\7\2\2\u014e\u0150"+
		"\5T+\2\u014f\u014d\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0157\7\6"+
		"\2\2\u0155\u0156\7\u0094\2\2\u0156\u0158\5N(\2\u0157\u0155\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\25\3\2\2\2\u0159\u015a\7\64\2\2\u015a\u015b\7\u0084"+
		"\2\2\u015b\u0173\5\u0086D\2\u015c\u015d\7\5\2\2\u015d\u0162\5F$\2\u015e"+
		"\u015f\7\7\2\2\u015f\u0161\5F$\2\u0160\u015e\3\2\2\2\u0161\u0164\3\2\2"+
		"\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0169\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0165\u0166\7\7\2\2\u0166\u0168\5V,\2\u0167\u0165\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\3\2"+
		"\2\2\u016b\u0169\3\2\2\2\u016c\u016f\7\6\2\2\u016d\u016e\7\u0096\2\2\u016e"+
		"\u0170\7\u0097\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0174"+
		"\3\2\2\2\u0171\u0172\7#\2\2\u0172\u0174\5<\37\2\u0173\u015c\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0174\27\3\2\2\2\u0175\u0177\7\64\2\2\u0176\u0178\t\5\2"+
		"\2\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017d"+
		"\7\u008a\2\2\u017a\u017b\7R\2\2\u017b\u017c\7h\2\2\u017c\u017e\7H\2\2"+
		"\u017d\u017a\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0182\3\2\2\2\u017f\u0180"+
		"\5\u0084C\2\u0180\u0181\7\4\2\2\u0181\u0183\3\2\2\2\u0182\u017f\3\2\2"+
		"\2\u0182\u0183\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0189\5\u0094K\2\u0185"+
		"\u018a\7\'\2\2\u0186\u018a\7\36\2\2\u0187\u0188\7[\2\2\u0188\u018a\7k"+
		"\2\2\u0189\u0185\3\2\2\2\u0189\u0186\3\2\2\2\u0189\u0187\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u0199\3\2\2\2\u018b\u019a\7=\2\2\u018c\u019a\7Z\2"+
		"\2\u018d\u0197\7\u008d\2\2\u018e\u018f\7k\2\2\u018f\u0194\5\u008cG\2\u0190"+
		"\u0191\7\7\2\2\u0191\u0193\5\u008cG\2\u0192\u0190\3\2\2\2\u0193\u0196"+
		"\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0197\u018e\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2"+
		"\2\2\u0199\u018b\3\2\2\2\u0199\u018c\3\2\2\2\u0199\u018d\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b\u019f\7m\2\2\u019c\u019d\5\u0084C\2\u019d\u019e\7"+
		"\4\2\2\u019e\u01a0\3\2\2\2\u019f\u019c\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a5\5\u0086D\2\u01a2\u01a3\7K\2\2\u01a3\u01a4\7"+
		"B\2\2\u01a4\u01a6\7\u0080\2\2\u01a5\u01a2\3\2\2\2\u01a5\u01a6\3\2\2\2"+
		"\u01a6\u01a9\3\2\2\2\u01a7\u01a8\7\u0093\2\2\u01a8\u01aa\5N(\2\u01a9\u01a7"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01b4\7(\2\2\u01ac"+
		"\u01b1\5@!\2\u01ad\u01b1\5.\30\2\u01ae\u01b1\5\36\20\2\u01af\u01b1\5<"+
		"\37\2\u01b0\u01ac\3\2\2\2\u01b0\u01ad\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0"+
		"\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\7\3\2\2\u01b3\u01b5\3\2"+
		"\2\2\u01b4\u01b0\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\7D\2\2\u01b9\31\3\2\2\2"+
		"\u01ba\u01bc\7\64\2\2\u01bb\u01bd\t\5\2\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd"+
		"\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c2\7\u0091\2\2\u01bf\u01c0\7R\2"+
		"\2\u01c0\u01c1\7h\2\2\u01c1\u01c3\7H\2\2\u01c2\u01bf\3\2\2\2\u01c2\u01c3"+
		"\3\2\2\2\u01c3\u01c7\3\2\2\2\u01c4\u01c5\5\u0084C\2\u01c5\u01c6\7\4\2"+
		"\2\u01c6\u01c8\3\2\2\2\u01c7\u01c4\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9"+
		"\3\2\2\2\u01c9\u01ca\5\u0096L\2\u01ca\u01cb\7#\2\2\u01cb\u01cc\5<\37\2"+
		"\u01cc\33\3\2\2\2\u01cd\u01ce\7\64\2\2\u01ce\u01cf\7\u0092\2\2\u01cf\u01d3"+
		"\7\u0084\2\2\u01d0\u01d1\7R\2\2\u01d1\u01d2\7h\2\2\u01d2\u01d4\7H\2\2"+
		"\u01d3\u01d0\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d8\3\2\2\2\u01d5\u01d6"+
		"\5\u0084C\2\u01d6\u01d7\7\4\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d5\3\2\2"+
		"\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\5\u0086D\2\u01db"+
		"\u01dc\7\u008e\2\2\u01dc\u01e8\5\u0098M\2\u01dd\u01de\7\5\2\2\u01de\u01e3"+
		"\5z>\2\u01df\u01e0\7\7\2\2\u01e0\u01e2\5z>\2\u01e1\u01df\3\2\2\2\u01e2"+
		"\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6\3\2"+
		"\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\7\6\2\2\u01e7\u01e9\3\2\2\2\u01e8"+
		"\u01dd\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\35\3\2\2\2\u01ea\u01ec\5X-\2"+
		"\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee"+
		"\7=\2\2\u01ee\u01ef\7M\2\2\u01ef\u01f2\5Z.\2\u01f0\u01f1\7\u0094\2\2\u01f1"+
		"\u01f3\5N(\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\37\3\2\2\2"+
		"\u01f4\u01f6\5X-\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7"+
		"\3\2\2\2\u01f7\u01f8\7=\2\2\u01f8\u01f9\7M\2\2\u01f9\u01fc\5Z.\2\u01fa"+
		"\u01fb\7\u0094\2\2\u01fb\u01fd\5N(\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3"+
		"\2\2\2\u01fd\u0210\3\2\2\2\u01fe\u01ff\7o\2\2\u01ff\u0200\7*\2\2\u0200"+
		"\u0205\5\\/\2\u0201\u0202\7\7\2\2\u0202\u0204\5\\/\2\u0203\u0201\3\2\2"+
		"\2\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0209"+
		"\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u01fe\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u020a\3\2\2\2\u020a\u020b\7d\2\2\u020b\u020e\5N(\2\u020c\u020d\t\4\2"+
		"\2\u020d\u020f\5N(\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0211"+
		"\3\2\2\2\u0210\u0208\3\2\2\2\u0210\u0211\3\2\2\2\u0211!\3\2\2\2\u0212"+
		"\u0214\7?\2\2\u0213\u0215\79\2\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2"+
		"\2\u0215\u0216\3\2\2\2\u0216\u0217\5\u0084C\2\u0217#\3\2\2\2\u0218\u0219"+
		"\7A\2\2\u0219\u021c\7V\2\2\u021a\u021b\7R\2\2\u021b\u021d\7H\2\2\u021c"+
		"\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0221\3\2\2\2\u021e\u021f\5\u0084"+
		"C\2\u021f\u0220\7\4\2\2\u0220\u0222\3\2\2\2\u0221\u021e\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\5\u0092J\2\u0224%\3\2\2"+
		"\2\u0225\u0226\7A\2\2\u0226\u0229\7\u0084\2\2\u0227\u0228\7R\2\2\u0228"+
		"\u022a\7H\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022e\3\2"+
		"\2\2\u022b\u022c\5\u0084C\2\u022c\u022d\7\4\2\2\u022d\u022f\3\2\2\2\u022e"+
		"\u022b\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\5\u0086"+
		"D\2\u0231\'\3\2\2\2\u0232\u0233\7A\2\2\u0233\u0236\7\u008a\2\2\u0234\u0235"+
		"\7R\2\2\u0235\u0237\7H\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u023b\3\2\2\2\u0238\u0239\5\u0084C\2\u0239\u023a\7\4\2\2\u023a\u023c"+
		"\3\2\2\2\u023b\u0238\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023e\5\u0094K\2\u023e)\3\2\2\2\u023f\u0240\7A\2\2\u0240\u0243\7\u0091"+
		"\2\2\u0241\u0242\7R\2\2\u0242\u0244\7H\2\2\u0243\u0241\3\2\2\2\u0243\u0244"+
		"\3\2\2\2\u0244\u0248\3\2\2\2\u0245\u0246\5\u0084C\2\u0246\u0247\7\4\2"+
		"\2\u0247\u0249\3\2\2\2\u0248\u0245\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a"+
		"\3\2\2\2\u024a\u024b\5\u0096L\2\u024b+\3\2\2\2\u024c\u024e\7\u0095\2\2"+
		"\u024d\u024f\7v\2\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250"+
		"\3\2\2\2\u0250\u0255\5`\61\2\u0251\u0252\7\7\2\2\u0252\u0254\5`\61\2\u0253"+
		"\u0251\3\2\2\2\u0254\u0257\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2"+
		"\2\2\u0256\u0259\3\2\2\2\u0257\u0255\3\2\2\2\u0258\u024c\3\2\2\2\u0258"+
		"\u0259\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u0260\5l\67\2\u025b\u025c\5n"+
		"8\2\u025c\u025d\5l\67\2\u025d\u025f\3\2\2\2\u025e\u025b\3\2\2\2\u025f"+
		"\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u026d\3\2"+
		"\2\2\u0262\u0260\3\2\2\2\u0263\u0264\7o\2\2\u0264\u0265\7*\2\2\u0265\u026a"+
		"\5\\/\2\u0266\u0267\7\7\2\2\u0267\u0269\5\\/\2\u0268\u0266\3\2\2\2\u0269"+
		"\u026c\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026e\3\2"+
		"\2\2\u026c\u026a\3\2\2\2\u026d\u0263\3\2\2\2\u026d\u026e\3\2\2\2\u026e"+
		"\u0275\3\2\2\2\u026f\u0270\7d\2\2\u0270\u0273\5N(\2\u0271\u0272\t\4\2"+
		"\2\u0272\u0274\5N(\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276"+
		"\3\2\2\2\u0275\u026f\3\2\2\2\u0275\u0276\3\2\2\2\u0276-\3\2\2\2\u0277"+
		"\u0279\5X-\2\u0278\u0277\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u028b\3\2\2"+
		"\2\u027a\u028c\7Z\2\2\u027b\u028c\7|\2\2\u027c\u027d\7Z\2\2\u027d\u027e"+
		"\7n\2\2\u027e\u028c\7|\2\2\u027f\u0280\7Z\2\2\u0280\u0281\7n\2\2\u0281"+
		"\u028c\7\177\2\2\u0282\u0283\7Z\2\2\u0283\u0284\7n\2\2\u0284\u028c\7\33"+
		"\2\2\u0285\u0286\7Z\2\2\u0286\u0287\7n\2\2\u0287\u028c\7J\2\2\u0288\u0289"+
		"\7Z\2\2\u0289\u028a\7n\2\2\u028a\u028c\7S\2\2\u028b\u027a\3\2\2\2\u028b"+
		"\u027b\3\2\2\2\u028b\u027c\3\2\2\2\u028b\u027f\3\2\2\2\u028b\u0282\3\2"+
		"\2\2\u028b\u0285\3\2\2\2\u028b\u0288\3\2\2\2\u028c\u028d\3\2\2\2\u028d"+
		"\u028e\7]\2\2\u028e\u029a\5\u0086D\2\u028f\u0290\7\5\2\2\u0290\u0295\5"+
		"\u008cG\2\u0291\u0292\7\7\2\2\u0292\u0294\5\u008cG\2\u0293\u0291\3\2\2"+
		"\2\u0294\u0297\3\2\2\2\u0295\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0298"+
		"\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u0299\7\6\2\2\u0299\u029b\3\2\2\2\u029a"+
		"\u028f\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u02bf\3\2\2\2\u029c\u029d\7\u0090"+
		"\2\2\u029d\u029f\7\5\2\2\u029e\u02a0\5N(\2\u029f\u029e\3\2\2\2\u029f\u02a0"+
		"\3\2\2\2\u02a0\u02a7\3\2\2\2\u02a1\u02a3\7\7\2\2\u02a2\u02a4\5N(\2\u02a3"+
		"\u02a2\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a6\3\2\2\2\u02a5\u02a1\3\2"+
		"\2\2\u02a6\u02a9\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8"+
		"\u02aa\3\2\2\2\u02a9\u02a7\3\2\2\2\u02aa\u02b9\7\6\2\2\u02ab\u02ac\7\7"+
		"\2\2\u02ac\u02ad\7\5\2\2\u02ad\u02b2\5N(\2\u02ae\u02af\7\7\2\2\u02af\u02b1"+
		"\5N(\2\u02b0\u02ae\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2"+
		"\u02b3\3\2\2\2\u02b3\u02b5\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02b6\7\6"+
		"\2\2\u02b6\u02b8\3\2\2\2\u02b7\u02ab\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9"+
		"\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02c0\3\2\2\2\u02bb\u02b9\3\2"+
		"\2\2\u02bc\u02c0\5<\37\2\u02bd\u02be\7:\2\2\u02be\u02c0\7\u0090\2\2\u02bf"+
		"\u029c\3\2\2\2\u02bf\u02bc\3\2\2\2\u02bf\u02bd\3\2\2\2\u02c0/\3\2\2\2"+
		"\u02c1\u02c5\7r\2\2\u02c2\u02c3\5\u0084C\2\u02c3\u02c4\7\4\2\2\u02c4\u02c6"+
		"\3\2\2\2\u02c5\u02c2\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02ce\5\u009aN\2\u02c8\u02c9\7\b\2\2\u02c9\u02cf\5^\60\2\u02ca\u02cb"+
		"\7\5\2\2\u02cb\u02cc\5^\60\2\u02cc\u02cd\7\6\2\2\u02cd\u02cf\3\2\2\2\u02ce"+
		"\u02c8\3\2\2\2\u02ce\u02ca\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\61\3\2\2"+
		"\2\u02d0\u02db\7y\2\2\u02d1\u02dc\5\u008eH\2\u02d2\u02d3\5\u0084C\2\u02d3"+
		"\u02d4\7\4\2\2\u02d4\u02d6\3\2\2\2\u02d5\u02d2\3\2\2\2\u02d5\u02d6\3\2"+
		"\2\2\u02d6\u02d9\3\2\2\2\u02d7\u02da\5\u0086D\2\u02d8\u02da\5\u0092J\2"+
		"\u02d9\u02d7\3\2\2\2\u02d9\u02d8\3\2\2\2\u02da\u02dc\3\2\2\2\u02db\u02d1"+
		"\3\2\2\2\u02db\u02d5\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\63\3\2\2\2\u02dd"+
		"\u02df\7z\2\2\u02de\u02e0\7\u0081\2\2\u02df\u02de\3\2\2\2\u02df\u02e0"+
		"\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e2\5\u009cO\2\u02e2\65\3\2\2\2\u02e3"+
		"\u02e8\7\177\2\2\u02e4\u02e6\7\u0089\2\2\u02e5\u02e7\5\u00a0Q\2\u02e6"+
		"\u02e5\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e9\3\2\2\2\u02e8\u02e4\3\2"+
		"\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ef\3\2\2\2\u02ea\u02ec\7\u0088\2\2\u02eb"+
		"\u02ed\7\u0081\2\2\u02ec\u02eb\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ee"+
		"\3\2\2\2\u02ee\u02f0\5\u009cO\2\u02ef\u02ea\3\2\2\2\u02ef\u02f0\3\2\2"+
		"\2\u02f0\67\3\2\2\2\u02f1\u02f2\7\u0081\2\2\u02f2\u02f3\5\u009cO\2\u02f3"+
		"9\3\2\2\2\u02f4\u02f6\7\u0095\2\2\u02f5\u02f7\7v\2\2\u02f6\u02f5\3\2\2"+
		"\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fd\5`\61\2\u02f9\u02fa"+
		"\7\7\2\2\u02fa\u02fc\5`\61\2\u02fb\u02f9\3\2\2\2\u02fc\u02ff\3\2\2\2\u02fd"+
		"\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0301\3\2\2\2\u02ff\u02fd\3\2"+
		"\2\2\u0300\u02f4\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0302\3\2\2\2\u0302"+
		"\u030d\5l\67\2\u0303\u0304\7o\2\2\u0304\u0305\7*\2\2\u0305\u030a\5\\/"+
		"\2\u0306\u0307\7\7\2\2\u0307\u0309\5\\/\2\u0308\u0306\3\2\2\2\u0309\u030c"+
		"\3\2\2\2\u030a\u0308\3\2\2\2\u030a\u030b\3\2\2\2\u030b\u030e\3\2\2\2\u030c"+
		"\u030a\3\2\2\2\u030d\u0303\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u0315\3\2"+
		"\2\2\u030f\u0310\7d\2\2\u0310\u0313\5N(\2\u0311\u0312\t\4\2\2\u0312\u0314"+
		"\5N(\2\u0313\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\3\2\2\2\u0315"+
		"\u030f\3\2\2\2\u0315\u0316\3\2\2\2\u0316;\3\2\2\2\u0317\u0319\7\u0095"+
		"\2\2\u0318\u031a\7v\2\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a"+
		"\u031b\3\2\2\2\u031b\u0320\5`\61\2\u031c\u031d\7\7\2\2\u031d\u031f\5`"+
		"\61\2\u031e\u031c\3\2\2\2\u031f\u0322\3\2\2\2\u0320\u031e\3\2\2\2\u0320"+
		"\u0321\3\2\2\2\u0321\u0324\3\2\2\2\u0322\u0320\3\2\2\2\u0323\u0317\3\2"+
		"\2\2\u0323\u0324\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u032b\5> \2\u0326\u0327"+
		"\5n8\2\u0327\u0328\5> \2\u0328\u032a\3\2\2\2\u0329\u0326\3\2\2\2\u032a"+
		"\u032d\3\2\2\2\u032b\u0329\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u0338\3\2"+
		"\2\2\u032d\u032b\3\2\2\2\u032e\u032f\7o\2\2\u032f\u0330\7*\2\2\u0330\u0335"+
		"\5\\/\2\u0331\u0332\7\7\2\2\u0332\u0334\5\\/\2\u0333\u0331\3\2\2\2\u0334"+
		"\u0337\3\2\2\2\u0335\u0333\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u0339\3\2"+
		"\2\2\u0337\u0335\3\2\2\2\u0338\u032e\3\2\2\2\u0338\u0339\3\2\2\2\u0339"+
		"\u0340\3\2\2\2\u033a\u033b\7d\2\2\u033b\u033e\5N(\2\u033c\u033d\t\4\2"+
		"\2\u033d\u033f\5N(\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0341"+
		"\3\2\2\2\u0340\u033a\3\2\2\2\u0340\u0341\3\2\2\2\u0341=\3\2\2\2\u0342"+
		"\u0344\7\u0082\2\2\u0343\u0345\t\6\2\2\u0344\u0343\3\2\2\2\u0344\u0345"+
		"\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u034b\5b\62\2\u0347\u0348\7\7\2\2\u0348"+
		"\u034a\5b\62\2\u0349\u0347\3\2\2\2\u034a\u034d\3\2\2\2\u034b\u0349\3\2"+
		"\2\2\u034b\u034c\3\2\2\2\u034c\u035a\3\2\2\2\u034d\u034b\3\2\2\2\u034e"+
		"\u0358\7M\2\2\u034f\u0354\5d\63\2\u0350\u0351\7\7\2\2\u0351\u0353\5d\63"+
		"\2\u0352\u0350\3\2\2\2\u0353\u0356\3\2\2\2\u0354\u0352\3\2\2\2\u0354\u0355"+
		"\3\2\2\2\u0355\u0359\3\2\2\2\u0356\u0354\3\2\2\2\u0357\u0359\5f\64\2\u0358"+
		"\u034f\3\2\2\2\u0358\u0357\3\2\2\2\u0359\u035b\3\2\2\2\u035a\u034e\3\2"+
		"\2\2\u035a\u035b\3\2\2\2\u035b\u035e\3\2\2\2\u035c\u035d\7\u0094\2\2\u035d"+
		"\u035f\5N(\2\u035e\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u036e\3\2\2"+
		"\2\u0360\u0361\7P\2\2\u0361\u0362\7*\2\2\u0362\u0367\5N(\2\u0363\u0364"+
		"\7\7\2\2\u0364\u0366\5N(\2\u0365\u0363\3\2\2\2\u0366\u0369\3\2\2\2\u0367"+
		"\u0365\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u036c\3\2\2\2\u0369\u0367\3\2"+
		"\2\2\u036a\u036b\7Q\2\2\u036b\u036d\5N(\2\u036c\u036a\3\2\2\2\u036c\u036d"+
		"\3\2\2\2\u036d\u036f\3\2\2\2\u036e\u0360\3\2\2\2\u036e\u036f\3\2\2\2\u036f"+
		"\u038d\3\2\2\2\u0370\u0371\7\u0090\2\2\u0371\u0372\7\5\2\2\u0372\u0377"+
		"\5N(\2\u0373\u0374\7\7\2\2\u0374\u0376\5N(\2\u0375\u0373\3\2\2\2\u0376"+
		"\u0379\3\2\2\2\u0377\u0375\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u037a\3\2"+
		"\2\2\u0379\u0377\3\2\2\2\u037a\u0389\7\6\2\2\u037b\u037c\7\7\2\2\u037c"+
		"\u037d\7\5\2\2\u037d\u0382\5N(\2\u037e\u037f\7\7\2\2\u037f\u0381\5N(\2"+
		"\u0380\u037e\3\2\2\2\u0381\u0384\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0383"+
		"\3\2\2\2\u0383\u0385\3\2\2\2\u0384\u0382\3\2\2\2\u0385\u0386\7\6\2\2\u0386"+
		"\u0388\3\2\2\2\u0387\u037b\3\2\2\2\u0388\u038b\3\2\2\2\u0389\u0387\3\2"+
		"\2\2\u0389\u038a\3\2\2\2\u038a\u038d\3\2\2\2\u038b\u0389\3\2\2\2\u038c"+
		"\u0342\3\2\2\2\u038c\u0370\3\2\2\2\u038d?\3\2\2\2\u038e\u0390\5X-\2\u038f"+
		"\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u039c\7\u008d"+
		"\2\2\u0392\u0393\7n\2\2\u0393\u039d\7\177\2\2\u0394\u0395\7n\2\2\u0395"+
		"\u039d\7\33\2\2\u0396\u0397\7n\2\2\u0397\u039d\7|\2\2\u0398\u0399\7n\2"+
		"\2\u0399\u039d\7J\2\2\u039a\u039b\7n\2\2\u039b\u039d\7S\2\2\u039c\u0392"+
		"\3\2\2\2\u039c\u0394\3\2\2\2\u039c\u0396\3\2\2\2\u039c\u0398\3\2\2\2\u039c"+
		"\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u039f\5Z"+
		".\2\u039f\u03a0\7\u0083\2\2\u03a0\u03a1\5\u008cG\2\u03a1\u03a2\7\b\2\2"+
		"\u03a2\u03aa\5N(\2\u03a3\u03a4\7\7\2\2\u03a4\u03a5\5\u008cG\2\u03a5\u03a6"+
		"\7\b\2\2\u03a6\u03a7\5N(\2\u03a7\u03a9\3\2\2\2\u03a8\u03a3\3\2\2\2\u03a9"+
		"\u03ac\3\2\2\2\u03aa\u03a8\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03af\3\2"+
		"\2\2\u03ac\u03aa\3\2\2\2\u03ad\u03ae\7\u0094\2\2\u03ae\u03b0\5N(\2\u03af"+
		"\u03ad\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0A\3\2\2\2\u03b1\u03b3\5X-\2\u03b2"+
		"\u03b1\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03bf\7\u008d"+
		"\2\2\u03b5\u03b6\7n\2\2\u03b6\u03c0\7\177\2\2\u03b7\u03b8\7n\2\2\u03b8"+
		"\u03c0\7\33\2\2\u03b9\u03ba\7n\2\2\u03ba\u03c0\7|\2\2\u03bb\u03bc\7n\2"+
		"\2\u03bc\u03c0\7J\2\2\u03bd\u03be\7n\2\2\u03be\u03c0\7S\2\2\u03bf\u03b5"+
		"\3\2\2\2\u03bf\u03b7\3\2\2\2\u03bf\u03b9\3\2\2\2\u03bf\u03bb\3\2\2\2\u03bf"+
		"\u03bd\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03c2\5Z"+
		".\2\u03c2\u03c3\7\u0083\2\2\u03c3\u03c4\5\u008cG\2\u03c4\u03c5\7\b\2\2"+
		"\u03c5\u03cd\5N(\2\u03c6\u03c7\7\7\2\2\u03c7\u03c8\5\u008cG\2\u03c8\u03c9"+
		"\7\b\2\2\u03c9\u03ca\5N(\2\u03ca\u03cc\3\2\2\2\u03cb\u03c6\3\2\2\2\u03cc"+
		"\u03cf\3\2\2\2\u03cd\u03cb\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03d2\3\2"+
		"\2\2\u03cf\u03cd\3\2\2\2\u03d0\u03d1\7\u0094\2\2\u03d1\u03d3\5N(\2\u03d2"+
		"\u03d0\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03e6\3\2\2\2\u03d4\u03d5\7o"+
		"\2\2\u03d5\u03d6\7*\2\2\u03d6\u03db\5\\/\2\u03d7\u03d8\7\7\2\2\u03d8\u03da"+
		"\5\\/\2\u03d9\u03d7\3\2\2\2\u03da\u03dd\3\2\2\2\u03db\u03d9\3\2\2\2\u03db"+
		"\u03dc\3\2\2\2\u03dc\u03df\3\2\2\2\u03dd\u03db\3\2\2\2\u03de\u03d4\3\2"+
		"\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03e1\7d\2\2\u03e1"+
		"\u03e4\5N(\2\u03e2\u03e3\t\4\2\2\u03e3\u03e5\5N(\2\u03e4\u03e2\3\2\2\2"+
		"\u03e4\u03e5\3\2\2\2\u03e5\u03e7\3\2\2\2\u03e6\u03de\3\2\2\2\u03e6\u03e7"+
		"\3\2\2\2\u03e7C\3\2\2\2\u03e8\u03e9\7\u008f\2\2\u03e9E\3\2\2\2\u03ea\u03ec"+
		"\5\u008cG\2\u03eb\u03ed\5H%\2\u03ec\u03eb\3\2\2\2\u03ec\u03ed\3\2\2\2"+
		"\u03ed\u03f1\3\2\2\2\u03ee\u03f0\5J&\2\u03ef\u03ee\3\2\2\2\u03f0\u03f3"+
		"\3\2\2\2\u03f1\u03ef\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2G\3\2\2\2\u03f3"+
		"\u03f1\3\2\2\2\u03f4\u03f6\5\u0080A\2\u03f5\u03f4\3\2\2\2\u03f6\u03f7"+
		"\3\2\2\2\u03f7\u03f5\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u0403\3\2\2\2\u03f9"+
		"\u03fa\7\5\2\2\u03fa\u03fb\5r:\2\u03fb\u03fc\7\6\2\2\u03fc\u0404\3\2\2"+
		"\2\u03fd\u03fe\7\5\2\2\u03fe\u03ff\5r:\2\u03ff\u0400\7\7\2\2\u0400\u0401"+
		"\5r:\2\u0401\u0402\7\6\2\2\u0402\u0404\3\2\2\2\u0403\u03f9\3\2\2\2\u0403"+
		"\u03fd\3\2\2\2\u0403\u0404\3\2\2\2\u0404I\3\2\2\2\u0405\u0406\7\63\2\2"+
		"\u0406\u0408\5\u0080A\2\u0407\u0405\3\2\2\2\u0407\u0408\3\2\2\2\u0408"+
		"\u042a\3\2\2\2\u0409\u040a\7s\2\2\u040a\u040c\7a\2\2\u040b\u040d\t\7\2"+
		"\2\u040c\u040b\3\2\2\2\u040c\u040d\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u0410"+
		"\5L\'\2\u040f\u0411\7&\2\2\u0410\u040f\3\2\2\2\u0410\u0411\3\2\2\2\u0411"+
		"\u042b\3\2\2\2\u0412\u0414\7h\2\2\u0413\u0412\3\2\2\2\u0413\u0414\3\2"+
		"\2\2\u0414\u0415\3\2\2\2\u0415\u0416\7j\2\2\u0416\u042b\5L\'\2\u0417\u0418"+
		"\7\u008c\2\2\u0418\u042b\5L\'\2\u0419\u041a\7.\2\2\u041a\u041b\7\5\2\2"+
		"\u041b\u041c\5N(\2\u041c\u041d\7\6\2\2\u041d\u042b\3\2\2\2\u041e\u0425"+
		"\7:\2\2\u041f\u0426\5r:\2\u0420\u0426\5t;\2\u0421\u0422\7\5\2\2\u0422"+
		"\u0423\5N(\2\u0423\u0424\7\6\2\2\u0424\u0426\3\2\2\2\u0425\u041f\3\2\2"+
		"\2\u0425\u0420\3\2\2\2\u0425\u0421\3\2\2\2\u0426\u042b\3\2\2\2\u0427\u0428"+
		"\7/\2\2\u0428\u042b\5\u008eH\2\u0429\u042b\5P)\2\u042a\u0409\3\2\2\2\u042a"+
		"\u0413\3\2\2\2\u042a\u0417\3\2\2\2\u042a\u0419\3\2\2\2\u042a\u041e\3\2"+
		"\2\2\u042a\u0427\3\2\2\2\u042a\u0429\3\2\2\2\u042bK\3\2\2\2\u042c\u042d"+
		"\7m\2\2\u042d\u042e\7\62\2\2\u042e\u0430\t\b\2\2\u042f\u042c\3\2\2\2\u042f"+
		"\u0430\3\2\2\2\u0430M\3\2\2\2\u0431\u0432\b(\1\2\u0432\u0433\5v<\2\u0433"+
		"\u0434\5N(\27\u0434\u047e\3\2\2\2\u0435\u047e\5t;\2\u0436\u047e\7\u0099"+
		"\2\2\u0437\u0438\5\u0084C\2\u0438\u0439\7\4\2\2\u0439\u043b\3\2\2\2\u043a"+
		"\u0437\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043d\5\u0086"+
		"D\2\u043d\u043e\7\4\2\2\u043e\u0440\3\2\2\2\u043f\u043a\3\2\2\2\u043f"+
		"\u0440\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u047e\5\u008cG\2\u0442\u0443"+
		"\5\u0082B\2\u0443\u0450\7\5\2\2\u0444\u0446\7@\2\2\u0445\u0444\3\2\2\2"+
		"\u0445\u0446\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u044c\5N(\2\u0448\u0449"+
		"\7\7\2\2\u0449\u044b\5N(\2\u044a\u0448\3\2\2\2\u044b\u044e\3\2\2\2\u044c"+
		"\u044a\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u0451\3\2\2\2\u044e\u044c\3\2"+
		"\2\2\u044f\u0451\7\t\2\2\u0450\u0445\3\2\2\2\u0450\u044f\3\2\2\2\u0450"+
		"\u0451\3\2\2\2\u0451\u0452\3\2\2\2\u0452\u0453\7\6\2\2\u0453\u047e\3\2"+
		"\2\2\u0454\u0455\7\5\2\2\u0455\u0456\5N(\2\u0456\u0457\7\6\2\2\u0457\u047e"+
		"\3\2\2\2\u0458\u0459\7-\2\2\u0459\u045a\7\5\2\2\u045a\u045b\5N(\2\u045b"+
		"\u045c\7#\2\2\u045c\u045d\5H%\2\u045d\u045e\7\6\2\2\u045e\u047e\3\2\2"+
		"\2\u045f\u0461\7h\2\2\u0460\u045f\3\2\2\2\u0460\u0461\3\2\2\2\u0461\u0462"+
		"\3\2\2\2\u0462\u0464\7H\2\2\u0463\u0460\3\2\2\2\u0463\u0464\3\2\2\2\u0464"+
		"\u0465\3\2\2\2\u0465\u0466\7\5\2\2\u0466\u0467\5<\37\2\u0467\u0468\7\6"+
		"\2\2\u0468\u047e\3\2\2\2\u0469\u046b\7,\2\2\u046a\u046c\5N(\2\u046b\u046a"+
		"\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u0472\3\2\2\2\u046d\u046e\7\u0093\2"+
		"\2\u046e\u046f\5N(\2\u046f\u0470\7\u0087\2\2\u0470\u0471\5N(\2\u0471\u0473"+
		"\3\2\2\2\u0472\u046d\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0472\3\2\2\2\u0474"+
		"\u0475\3\2\2\2\u0475\u0478\3\2\2\2\u0476\u0477\7C\2\2\u0477\u0479\5N("+
		"\2\u0478\u0476\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u047b"+
		"\7D\2\2\u047b\u047e\3\2\2\2\u047c\u047e\5R*\2\u047d\u0431\3\2\2\2\u047d"+
		"\u0435\3\2\2\2\u047d\u0436\3\2\2\2\u047d\u043f\3\2\2\2\u047d\u0442\3\2"+
		"\2\2\u047d\u0454\3\2\2\2\u047d\u0458\3\2\2\2\u047d\u0463\3\2\2\2\u047d"+
		"\u0469\3\2\2\2\u047d\u047c\3\2\2\2\u047e\u04e3\3\2\2\2\u047f\u0480\f\26"+
		"\2\2\u0480\u0481\7\r\2\2\u0481\u04e2\5N(\27\u0482\u0483\f\25\2\2\u0483"+
		"\u0484\t\t\2\2\u0484\u04e2\5N(\26\u0485\u0486\f\24\2\2\u0486\u0487\t\n"+
		"\2\2\u0487\u04e2\5N(\25\u0488\u0489\f\23\2\2\u0489\u048a\t\13\2\2\u048a"+
		"\u04e2\5N(\24\u048b\u048c\f\22\2\2\u048c\u048d\t\f\2\2\u048d\u04e2\5N"+
		"(\23\u048e\u049b\f\21\2\2\u048f\u049c\7\b\2\2\u0490\u049c\7\30\2\2\u0491"+
		"\u049c\7\31\2\2\u0492\u049c\7\32\2\2\u0493\u049c\7^\2\2\u0494\u0495\7"+
		"^\2\2\u0495\u049c\7h\2\2\u0496\u049c\7U\2\2\u0497\u049c\7c\2\2\u0498\u049c"+
		"\7O\2\2\u0499\u049c\7e\2\2\u049a\u049c\7x\2\2\u049b\u048f\3\2\2\2\u049b"+
		"\u0490\3\2\2\2\u049b\u0491\3\2\2\2\u049b\u0492\3\2\2\2\u049b\u0493\3\2"+
		"\2\2\u049b\u0494\3\2\2\2\u049b\u0496\3\2\2\2\u049b\u0497\3\2\2\2\u049b"+
		"\u0498\3\2\2\2\u049b\u0499\3\2\2\2\u049b\u049a\3\2\2\2\u049c\u049d\3\2"+
		"\2\2\u049d\u04e2\5N(\22\u049e\u049f\f\20\2\2\u049f\u04a0\7\"\2\2\u04a0"+
		"\u04e2\5N(\21\u04a1\u04a2\f\17\2\2\u04a2\u04a3\7n\2\2\u04a3\u04e2\5N("+
		"\20\u04a4\u04a5\f\b\2\2\u04a5\u04a7\7^\2\2\u04a6\u04a8\7h\2\2\u04a7\u04a6"+
		"\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04e2\5N(\t\u04aa"+
		"\u04ac\f\7\2\2\u04ab\u04ad\7h\2\2\u04ac\u04ab\3\2\2\2\u04ac\u04ad\3\2"+
		"\2\2\u04ad\u04ae\3\2\2\2\u04ae\u04af\7)\2\2\u04af\u04b0\5N(\2\u04b0\u04b1"+
		"\7\"\2\2\u04b1\u04b2\5N(\b\u04b2\u04e2\3\2\2\2\u04b3\u04b4\f\13\2\2\u04b4"+
		"\u04b5\7/\2\2\u04b5\u04e2\5\u008eH\2\u04b6\u04b8\f\n\2\2\u04b7\u04b9\7"+
		"h\2\2\u04b8\u04b7\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba"+
		"\u04bb\t\r\2\2\u04bb\u04be\5N(\2\u04bc\u04bd\7E\2\2\u04bd\u04bf\5N(\2"+
		"\u04be\u04bc\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04e2\3\2\2\2\u04c0\u04c5"+
		"\f\t\2\2\u04c1\u04c6\7_\2\2\u04c2\u04c6\7i\2\2\u04c3\u04c4\7h\2\2\u04c4"+
		"\u04c6\7j\2\2\u04c5\u04c1\3\2\2\2\u04c5\u04c2\3\2\2\2\u04c5\u04c3\3\2"+
		"\2\2\u04c6\u04e2\3\2\2\2\u04c7\u04c9\f\6\2\2\u04c8\u04ca\7h\2\2\u04c9"+
		"\u04c8\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb\u04df\7U"+
		"\2\2\u04cc\u04d6\7\5\2\2\u04cd\u04d7\5<\37\2\u04ce\u04d3\5N(\2\u04cf\u04d0"+
		"\7\7\2\2\u04d0\u04d2\5N(\2\u04d1\u04cf\3\2\2\2\u04d2\u04d5\3\2\2\2\u04d3"+
		"\u04d1\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4\u04d7\3\2\2\2\u04d5\u04d3\3\2"+
		"\2\2\u04d6\u04cd\3\2\2\2\u04d6\u04ce\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7"+
		"\u04d8\3\2\2\2\u04d8\u04e0\7\6\2\2\u04d9\u04da\5\u0084C\2\u04da\u04db"+
		"\7\4\2\2\u04db\u04dd\3\2\2\2\u04dc\u04d9\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd"+
		"\u04de\3\2\2\2\u04de\u04e0\5\u0086D\2\u04df\u04cc\3\2\2\2\u04df\u04dc"+
		"\3\2\2\2\u04e0\u04e2\3\2\2\2\u04e1\u047f\3\2\2\2\u04e1\u0482\3\2\2\2\u04e1"+
		"\u0485\3\2\2\2\u04e1\u0488\3\2\2\2\u04e1\u048b\3\2\2\2\u04e1\u048e\3\2"+
		"\2\2\u04e1\u049e\3\2\2\2\u04e1\u04a1\3\2\2\2\u04e1\u04a4\3\2\2\2\u04e1"+
		"\u04aa\3\2\2\2\u04e1\u04b3\3\2\2\2\u04e1\u04b6\3\2\2\2\u04e1\u04c0\3\2"+
		"\2\2\u04e1\u04c7\3\2\2\2\u04e2\u04e5\3\2\2\2\u04e3\u04e1\3\2\2\2\u04e3"+
		"\u04e4\3\2\2\2\u04e4O\3\2\2\2\u04e5\u04e3\3\2\2\2\u04e6\u04e7\7w\2\2\u04e7"+
		"\u04f3\5\u0090I\2\u04e8\u04e9\7\5\2\2\u04e9\u04ee\5\u008cG\2\u04ea\u04eb"+
		"\7\7\2\2\u04eb\u04ed\5\u008cG\2\u04ec\u04ea\3\2\2\2\u04ed\u04f0\3\2\2"+
		"\2\u04ee\u04ec\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u04f1\3\2\2\2\u04f0\u04ee"+
		"\3\2\2\2\u04f1\u04f2\7\6\2\2\u04f2\u04f4\3\2\2\2\u04f3\u04e8\3\2\2\2\u04f3"+
		"\u04f4\3\2\2\2\u04f4\u0507\3\2\2\2\u04f5\u04f6\7m\2\2\u04f6\u04ff\t\16"+
		"\2\2\u04f7\u04f8\7\u0083\2\2\u04f8\u0500\7j\2\2\u04f9\u04fa\7\u0083\2"+
		"\2\u04fa\u0500\7:\2\2\u04fb\u0500\7+\2\2\u04fc\u0500\7}\2\2\u04fd\u04fe"+
		"\7g\2\2\u04fe\u0500\7\34\2\2\u04ff\u04f7\3\2\2\2\u04ff\u04f9\3\2\2\2\u04ff"+
		"\u04fb\3\2\2\2\u04ff\u04fc\3\2\2\2\u04ff\u04fd\3\2\2\2\u0500\u0504\3\2"+
		"\2\2\u0501\u0502\7e\2\2\u0502\u0504\5\u0080A\2\u0503\u04f5\3\2\2\2\u0503"+
		"\u0501\3\2\2\2\u0504\u0506\3\2\2\2\u0505\u0503\3\2\2\2\u0506\u0509\3\2"+
		"\2\2\u0507\u0505\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u0514\3\2\2\2\u0509"+
		"\u0507\3\2\2\2\u050a\u050c\7h\2\2\u050b\u050a\3\2\2\2\u050b\u050c\3\2"+
		"\2\2\u050c\u050d\3\2\2\2\u050d\u0512\7;\2\2\u050e\u050f\7X\2\2\u050f\u0513"+
		"\7<\2\2\u0510\u0511\7X\2\2\u0511\u0513\7T\2\2\u0512\u050e\3\2\2\2\u0512"+
		"\u0510\3\2\2\2\u0512\u0513\3\2\2\2\u0513\u0515\3\2\2\2\u0514\u050b\3\2"+
		"\2\2\u0514\u0515\3\2\2\2\u0515Q\3\2\2\2\u0516\u0517\7u\2\2\u0517\u051c"+
		"\7\5\2\2\u0518\u051d\7S\2\2\u0519\u051a\t\17\2\2\u051a\u051b\7\7\2\2\u051b"+
		"\u051d\5x=\2\u051c\u0518\3\2\2\2\u051c\u0519\3\2\2\2\u051d\u051e\3\2\2"+
		"\2\u051e\u051f\7\6\2\2\u051fS\3\2\2\2\u0520\u0523\5\u008cG\2\u0521\u0522"+
		"\7/\2\2\u0522\u0524\5\u008eH\2\u0523\u0521\3\2\2\2\u0523\u0524\3\2\2\2"+
		"\u0524\u0526\3\2\2\2\u0525\u0527\t\7\2\2\u0526\u0525\3\2\2\2\u0526\u0527"+
		"\3\2\2\2\u0527U\3\2\2\2\u0528\u0529\7\63\2\2\u0529\u052b\5\u0080A\2\u052a"+
		"\u0528\3\2\2\2\u052a\u052b\3\2\2\2\u052b\u0550\3\2\2\2\u052c\u052d\7s"+
		"\2\2\u052d\u0530\7a\2\2\u052e\u0530\7\u008c\2\2\u052f\u052c\3\2\2\2\u052f"+
		"\u052e\3\2\2\2\u0530\u0531\3\2\2\2\u0531\u0532\7\5\2\2\u0532\u0537\5T"+
		"+\2\u0533\u0534\7\7\2\2\u0534\u0536\5T+\2\u0535\u0533\3\2\2\2\u0536\u0539"+
		"\3\2\2\2\u0537\u0535\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u053a\3\2\2\2\u0539"+
		"\u0537\3\2\2\2\u053a\u053b\7\6\2\2\u053b\u053c\5L\'\2\u053c\u0551\3\2"+
		"\2\2\u053d\u053e\7.\2\2\u053e\u053f\7\5\2\2\u053f\u0540\5N(\2\u0540\u0541"+
		"\7\6\2\2\u0541\u0551\3\2\2\2\u0542\u0543\7L\2\2\u0543\u0544\7a\2\2\u0544"+
		"\u0545\7\5\2\2\u0545\u054a\5\u008cG\2\u0546\u0547\7\7\2\2\u0547\u0549"+
		"\5\u008cG\2\u0548\u0546\3\2\2\2\u0549\u054c\3\2\2\2\u054a\u0548\3\2\2"+
		"\2\u054a\u054b\3\2\2\2\u054b\u054d\3\2\2\2\u054c\u054a\3\2\2\2\u054d\u054e"+
		"\7\6\2\2\u054e\u054f\5P)\2\u054f\u0551\3\2\2\2\u0550\u052f\3\2\2\2\u0550"+
		"\u053d\3\2\2\2\u0550\u0542\3\2\2\2\u0551W\3\2\2\2\u0552\u0554\7\u0095"+
		"\2\2\u0553\u0555\7v\2\2\u0554\u0553\3\2\2\2\u0554\u0555\3\2\2\2\u0555"+
		"\u0556\3\2\2\2\u0556\u0557\5p9\2\u0557\u0558\7#\2\2\u0558\u0559\7\5\2"+
		"\2\u0559\u055a\5<\37\2\u055a\u0564\7\6\2\2\u055b\u055c\7\7\2\2\u055c\u055d"+
		"\5p9\2\u055d\u055e\7#\2\2\u055e\u055f\7\5\2\2\u055f\u0560\5<\37\2\u0560"+
		"\u0561\7\6\2\2\u0561\u0563\3\2\2\2\u0562\u055b\3\2\2\2\u0563\u0566\3\2"+
		"\2\2\u0564\u0562\3\2\2\2\u0564\u0565\3\2\2\2\u0565Y\3\2\2\2\u0566\u0564"+
		"\3\2\2\2\u0567\u0568\5\u0084C\2\u0568\u0569\7\4\2\2\u0569\u056b\3\2\2"+
		"\2\u056a\u0567\3\2\2\2\u056a\u056b\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u0572"+
		"\5\u0086D\2\u056d\u056e\7W\2\2\u056e\u056f\7*\2\2\u056f\u0573\5\u0092"+
		"J\2\u0570\u0571\7h\2\2\u0571\u0573\7W\2\2\u0572\u056d\3\2\2\2\u0572\u0570"+
		"\3\2\2\2\u0572\u0573\3\2\2\2\u0573[\3\2\2\2\u0574\u0577\5N(\2\u0575\u0576"+
		"\7/\2\2\u0576\u0578\5\u008eH\2\u0577\u0575\3\2\2\2\u0577\u0578\3\2\2\2"+
		"\u0578\u057a\3\2\2\2\u0579\u057b\t\7\2\2\u057a\u0579\3\2\2\2\u057a\u057b"+
		"\3\2\2\2\u057b]\3\2\2\2\u057c\u0580\5r:\2\u057d\u0580\5\u0080A\2\u057e"+
		"\u0580\7\u009a\2\2\u057f\u057c\3\2\2\2\u057f\u057d\3\2\2\2\u057f\u057e"+
		"\3\2\2\2\u0580_\3\2\2\2\u0581\u058d\5\u0086D\2\u0582\u0583\7\5\2\2\u0583"+
		"\u0588\5\u008cG\2\u0584\u0585\7\7\2\2\u0585\u0587\5\u008cG\2\u0586\u0584"+
		"\3\2\2\2\u0587\u058a\3\2\2\2\u0588\u0586\3\2\2\2\u0588\u0589\3\2\2\2\u0589"+
		"\u058b\3\2\2\2\u058a\u0588\3\2\2\2\u058b\u058c\7\6\2\2\u058c\u058e\3\2"+
		"\2\2\u058d\u0582\3\2\2\2\u058d\u058e\3\2\2\2\u058e\u058f\3\2\2\2\u058f"+
		"\u0590\7#\2\2\u0590\u0591\7\5\2\2\u0591\u0592\5<\37\2\u0592\u0593\7\6"+
		"\2\2\u0593a\3\2\2\2\u0594\u05a1\7\t\2\2\u0595\u0596\5\u0086D\2\u0596\u0597"+
		"\7\4\2\2\u0597\u0598\7\t\2\2\u0598\u05a1\3\2\2\2\u0599\u059e\5N(\2\u059a"+
		"\u059c\7#\2\2\u059b\u059a\3\2\2\2\u059b\u059c\3\2\2\2\u059c\u059d\3\2"+
		"\2\2\u059d\u059f\5|?\2\u059e\u059b\3\2\2\2\u059e\u059f\3\2\2\2\u059f\u05a1"+
		"\3\2\2\2\u05a0\u0594\3\2\2\2\u05a0\u0595\3\2\2\2\u05a0\u0599\3\2\2\2\u05a1"+
		"c\3\2\2\2\u05a2\u05a3\5\u0084C\2\u05a3\u05a4\7\4\2\2\u05a4\u05a6\3\2\2"+
		"\2\u05a5\u05a2\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05ac"+
		"\5\u0086D\2\u05a8\u05aa\7#\2\2\u05a9\u05a8\3\2\2\2\u05a9\u05aa\3\2\2\2"+
		"\u05aa\u05ab\3\2\2\2\u05ab\u05ad\5\u009eP\2\u05ac\u05a9\3\2\2\2\u05ac"+
		"\u05ad\3\2\2\2\u05ad\u05b3\3\2\2\2\u05ae\u05af\7W\2\2\u05af\u05b0\7*\2"+
		"\2\u05b0\u05b4\5\u0092J\2\u05b1\u05b2\7h\2\2\u05b2\u05b4\7W\2\2\u05b3"+
		"\u05ae\3\2\2\2\u05b3\u05b1\3\2\2\2\u05b3\u05b4\3\2\2\2\u05b4\u05d2\3\2"+
		"\2\2\u05b5\u05bf\7\5\2\2\u05b6\u05bb\5d\63\2\u05b7\u05b8\7\7\2\2\u05b8"+
		"\u05ba\5d\63\2\u05b9\u05b7\3\2\2\2\u05ba\u05bd\3\2\2\2\u05bb\u05b9\3\2"+
		"\2\2\u05bb\u05bc\3\2\2\2\u05bc\u05c0\3\2\2\2\u05bd\u05bb\3\2\2\2\u05be"+
		"\u05c0\5f\64\2\u05bf\u05b6\3\2\2\2\u05bf\u05be\3\2\2\2\u05c0\u05c1\3\2"+
		"\2\2\u05c1\u05c6\7\6\2\2\u05c2\u05c4\7#\2\2\u05c3\u05c2\3\2\2\2\u05c3"+
		"\u05c4\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5\u05c7\5\u009eP\2\u05c6\u05c3"+
		"\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05d2\3\2\2\2\u05c8\u05c9\7\5\2\2\u05c9"+
		"\u05ca\5<\37\2\u05ca\u05cf\7\6\2\2\u05cb\u05cd\7#\2\2\u05cc\u05cb\3\2"+
		"\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05ce\3\2\2\2\u05ce\u05d0\5\u009eP\2\u05cf"+
		"\u05cc\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0\u05d2\3\2\2\2\u05d1\u05a5\3\2"+
		"\2\2\u05d1\u05b5\3\2\2\2\u05d1\u05c8\3\2\2\2\u05d2e\3\2\2\2\u05d3\u05da"+
		"\5d\63\2\u05d4\u05d5\5h\65\2\u05d5\u05d6\5d\63\2\u05d6\u05d7\5j\66\2\u05d7"+
		"\u05d9\3\2\2\2\u05d8\u05d4\3\2\2\2\u05d9\u05dc\3\2\2\2\u05da\u05d8\3\2"+
		"\2\2\u05da\u05db\3\2\2\2\u05dbg\3\2\2\2\u05dc\u05da\3\2\2\2\u05dd\u05eb"+
		"\7\7\2\2\u05de\u05e0\7f\2\2\u05df\u05de\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0"+
		"\u05e7\3\2\2\2\u05e1\u05e3\7b\2\2\u05e2\u05e4\7p\2\2\u05e3\u05e2\3\2\2"+
		"\2\u05e3\u05e4\3\2\2\2\u05e4\u05e8\3\2\2\2\u05e5\u05e8\7Y\2\2\u05e6\u05e8"+
		"\7\65\2\2\u05e7\u05e1\3\2\2\2\u05e7\u05e5\3\2\2\2\u05e7\u05e6\3\2\2\2"+
		"\u05e7\u05e8\3\2\2\2\u05e8\u05e9\3\2\2\2\u05e9\u05eb\7`\2\2\u05ea\u05dd"+
		"\3\2\2\2\u05ea\u05df\3\2\2\2\u05ebi\3\2\2\2\u05ec\u05ed\7m\2\2\u05ed\u05fb"+
		"\5N(\2\u05ee\u05ef\7\u008e\2\2\u05ef\u05f0\7\5\2\2\u05f0\u05f5\5\u008c"+
		"G\2\u05f1\u05f2\7\7\2\2\u05f2\u05f4\5\u008cG\2\u05f3\u05f1\3\2\2\2\u05f4"+
		"\u05f7\3\2\2\2\u05f5\u05f3\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f8\3\2"+
		"\2\2\u05f7\u05f5\3\2\2\2\u05f8\u05f9\7\6\2\2\u05f9\u05fb\3\2\2\2\u05fa"+
		"\u05ec\3\2\2\2\u05fa\u05ee\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fbk\3\2\2\2"+
		"\u05fc\u05fe\7\u0082\2\2\u05fd\u05ff\t\6\2\2\u05fe\u05fd\3\2\2\2\u05fe"+
		"\u05ff\3\2\2\2\u05ff\u0600\3\2\2\2\u0600\u0605\5b\62\2\u0601\u0602\7\7"+
		"\2\2\u0602\u0604\5b\62\2\u0603\u0601\3\2\2\2\u0604\u0607\3\2\2\2\u0605"+
		"\u0603\3\2\2\2\u0605\u0606\3\2\2\2\u0606\u0614\3\2\2\2\u0607\u0605\3\2"+
		"\2\2\u0608\u0612\7M\2\2\u0609\u060e\5d\63\2\u060a\u060b\7\7\2\2\u060b"+
		"\u060d\5d\63\2\u060c\u060a\3\2\2\2\u060d\u0610\3\2\2\2\u060e\u060c\3\2"+
		"\2\2\u060e\u060f\3\2\2\2\u060f\u0613\3\2\2\2\u0610\u060e\3\2\2\2\u0611"+
		"\u0613\5f\64\2\u0612\u0609\3\2\2\2\u0612\u0611\3\2\2\2\u0613\u0615\3\2"+
		"\2\2\u0614\u0608\3\2\2\2\u0614\u0615\3\2\2\2\u0615\u0618\3\2\2\2\u0616"+
		"\u0617\7\u0094\2\2\u0617\u0619\5N(\2\u0618\u0616\3\2\2\2\u0618\u0619\3"+
		"\2\2\2\u0619\u0628\3\2\2\2\u061a\u061b\7P\2\2\u061b\u061c\7*\2\2\u061c"+
		"\u0621\5N(\2\u061d\u061e\7\7\2\2\u061e\u0620\5N(\2\u061f\u061d\3\2\2\2"+
		"\u0620\u0623\3\2\2\2\u0621\u061f\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0626"+
		"\3\2\2\2\u0623\u0621\3\2\2\2\u0624\u0625\7Q\2\2\u0625\u0627\5N(\2\u0626"+
		"\u0624\3\2\2\2\u0626\u0627\3\2\2\2\u0627\u0629\3\2\2\2\u0628\u061a\3\2"+
		"\2\2\u0628\u0629\3\2\2\2\u0629\u0647\3\2\2\2\u062a\u062b\7\u0090\2\2\u062b"+
		"\u062c\7\5\2\2\u062c\u0631\5N(\2\u062d\u062e\7\7\2\2\u062e\u0630\5N(\2"+
		"\u062f\u062d\3\2\2\2\u0630\u0633\3\2\2\2\u0631\u062f\3\2\2\2\u0631\u0632"+
		"\3\2\2\2\u0632\u0634\3\2\2\2\u0633\u0631\3\2\2\2\u0634\u0643\7\6\2\2\u0635"+
		"\u0636\7\7\2\2\u0636\u0637\7\5\2\2\u0637\u063c\5N(\2\u0638\u0639\7\7\2"+
		"\2\u0639\u063b\5N(\2\u063a\u0638\3\2\2\2\u063b\u063e\3\2\2\2\u063c\u063a"+
		"\3\2\2\2\u063c\u063d\3\2\2\2\u063d\u063f\3\2\2\2\u063e\u063c\3\2\2\2\u063f"+
		"\u0640\7\6\2\2\u0640\u0642\3\2\2\2\u0641\u0635\3\2\2\2\u0642\u0645\3\2"+
		"\2\2\u0643\u0641\3\2\2\2\u0643\u0644\3\2\2\2\u0644\u0647\3\2\2\2\u0645"+
		"\u0643\3\2\2\2\u0646\u05fc\3\2\2\2\u0646\u062a\3\2\2\2\u0647m\3\2\2\2"+
		"\u0648\u064e\7\u008b\2\2\u0649\u064a\7\u008b\2\2\u064a\u064e\7\37\2\2"+
		"\u064b\u064e\7\\\2\2\u064c\u064e\7F\2\2\u064d\u0648\3\2\2\2\u064d\u0649"+
		"\3\2\2\2\u064d\u064b\3\2\2\2\u064d\u064c\3\2\2\2\u064eo\3\2\2\2\u064f"+
		"\u065b\5\u0086D\2\u0650\u0651\7\5\2\2\u0651\u0656\5\u008cG\2\u0652\u0653"+
		"\7\7\2\2\u0653\u0655\5\u008cG\2\u0654\u0652\3\2\2\2\u0655\u0658\3\2\2"+
		"\2\u0656\u0654\3\2\2\2\u0656\u0657\3\2\2\2\u0657\u0659\3\2\2\2\u0658\u0656"+
		"\3\2\2\2\u0659\u065a\7\6\2\2\u065a\u065c\3\2\2\2\u065b\u0650\3\2\2\2\u065b"+
		"\u065c\3\2\2\2\u065cq\3\2\2\2\u065d\u065f\t\n\2\2\u065e\u065d\3\2\2\2"+
		"\u065e\u065f\3\2\2\2\u065f\u0660\3\2\2\2\u0660\u0661\7\u0098\2\2\u0661"+
		"s\3\2\2\2\u0662\u0663\t\20\2\2\u0663u\3\2\2\2\u0664\u0665\t\21\2\2\u0665"+
		"w\3\2\2\2\u0666\u0667\7\u009a\2\2\u0667y\3\2\2\2\u0668\u066b\5N(\2\u0669"+
		"\u066b\5F$\2\u066a\u0668\3\2\2\2\u066a\u0669\3\2\2\2\u066b{\3\2\2\2\u066c"+
		"\u066d\t\22\2\2\u066d}\3\2\2\2\u066e\u066f\t\23\2\2\u066f\177\3\2\2\2"+
		"\u0670\u0671\5\u00a2R\2\u0671\u0081\3\2\2\2\u0672\u0673\5\u00a2R\2\u0673"+
		"\u0083\3\2\2\2\u0674\u0675\5\u00a2R\2\u0675\u0085\3\2\2\2\u0676\u0677"+
		"\5\u00a2R\2\u0677\u0087\3\2\2\2\u0678\u0679\5\u00a2R\2\u0679\u0089\3\2"+
		"\2\2\u067a\u067b\5\u00a2R\2\u067b\u008b\3\2\2\2\u067c\u067d\5\u00a2R\2"+
		"\u067d\u008d\3\2\2\2\u067e\u067f\5\u00a2R\2\u067f\u008f\3\2\2\2\u0680"+
		"\u0681\5\u00a2R\2\u0681\u0091\3\2\2\2\u0682\u0683\5\u00a2R\2\u0683\u0093"+
		"\3\2\2\2\u0684\u0685\5\u00a2R\2\u0685\u0095\3\2\2\2\u0686\u0687\5\u00a2"+
		"R\2\u0687\u0097\3\2\2\2\u0688\u0689\5\u00a2R\2\u0689\u0099\3\2\2\2\u068a"+
		"\u068b\5\u00a2R\2\u068b\u009b\3\2\2\2\u068c\u068d\5\u00a2R\2\u068d\u009d"+
		"\3\2\2\2\u068e\u068f\5\u00a2R\2\u068f\u009f\3\2\2\2\u0690\u0691\5\u00a2"+
		"R\2\u0691\u00a1\3\2\2\2\u0692\u0699\7\u0097\2\2\u0693\u0699\5~@\2\u0694"+
		"\u0695\7\5\2\2\u0695\u0696\5\u00a2R\2\u0696\u0697\7\6\2\2\u0697\u0699"+
		"\3\2\2\2\u0698\u0692\3\2\2\2\u0698\u0693\3\2\2\2\u0698\u0694\3\2\2\2\u0699"+
		"\u00a3\3\2\2\2\u00f0\u00a6\u00a9\u00b1\u00b3\u00d3\u00da\u00e2\u00e5\u00ee"+
		"\u00f2\u00fa\u00fe\u0100\u0105\u0107\u010b\u0112\u0115\u011a\u011e\u0123"+
		"\u012c\u012f\u0135\u0137\u013b\u0141\u0146\u0151\u0157\u0162\u0169\u016f"+
		"\u0173\u0177\u017d\u0182\u0189\u0194\u0197\u0199\u019f\u01a5\u01a9\u01b0"+
		"\u01b6\u01bc\u01c2\u01c7\u01d3\u01d8\u01e3\u01e8\u01eb\u01f2\u01f5\u01fc"+
		"\u0205\u0208\u020e\u0210\u0214\u021c\u0221\u0229\u022e\u0236\u023b\u0243"+
		"\u0248\u024e\u0255\u0258\u0260\u026a\u026d\u0273\u0275\u0278\u028b\u0295"+
		"\u029a\u029f\u02a3\u02a7\u02b2\u02b9\u02bf\u02c5\u02ce\u02d5\u02d9\u02db"+
		"\u02df\u02e6\u02e8\u02ec\u02ef\u02f6\u02fd\u0300\u030a\u030d\u0313\u0315"+
		"\u0319\u0320\u0323\u032b\u0335\u0338\u033e\u0340\u0344\u034b\u0354\u0358"+
		"\u035a\u035e\u0367\u036c\u036e\u0377\u0382\u0389\u038c\u038f\u039c\u03aa"+
		"\u03af\u03b2\u03bf\u03cd\u03d2\u03db\u03de\u03e4\u03e6\u03ec\u03f1\u03f7"+
		"\u0403\u0407\u040c\u0410\u0413\u0425\u042a\u042f\u043a\u043f\u0445\u044c"+
		"\u0450\u0460\u0463\u046b\u0474\u0478\u047d\u049b\u04a7\u04ac\u04b8\u04be"+
		"\u04c5\u04c9\u04d3\u04d6\u04dc\u04df\u04e1\u04e3\u04ee\u04f3\u04ff\u0503"+
		"\u0507\u050b\u0512\u0514\u051c\u0523\u0526\u052a\u052f\u0537\u054a\u0550"+
		"\u0554\u0564\u056a\u0572\u0577\u057a\u057f\u0588\u058d\u059b\u059e\u05a0"+
		"\u05a5\u05a9\u05ac\u05b3\u05bb\u05bf\u05c3\u05c6\u05cc\u05cf\u05d1\u05da"+
		"\u05df\u05e3\u05e7\u05ea\u05f5\u05fa\u05fe\u0605\u060e\u0612\u0614\u0618"+
		"\u0621\u0626\u0628\u0631\u063c\u0643\u0646\u064d\u0656\u065b\u065e\u066a"+
		"\u0698";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}