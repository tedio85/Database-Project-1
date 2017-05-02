package stage1;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
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

public class StmtMaker implements SqlListener{

	private Stmt statement = null;
	
	
	public Stmt getStatement() {
		if(statement == null)
			throw new NullPointerException("Statement not created yet");
		return statement;
	}
	
	public void resetStatement() {
		statement = null;
	}
	
	@Override
	public void exitCreate_table_stmt(Create_table_stmtContext ctx) {
		
		CreateTableStmt newStatement = new CreateTableStmt();
		
		// set table_name
		newStatement.setTable_name(ctx.table_name().getText());
		
		// set column_def -> column_name type_name
		for(Column_defContext context : ctx.column_def()) {
			
			List<NameContext> names = context.type_name().name();
			String type_name = names.get(0).getText();
			boolean isPrimaryKey = false;
			
			if(names.size() == 2) {
				switch(names.get(1).getText().toLowerCase()) {
				case "primary_key": isPrimaryKey = true;	break;
				default: type_name += " " + names.get(1).getText().replaceAll("[()]","");
				}
			}
			else if(names.size() == 3) {
				type_name += " " + names.get(1).getText().replaceAll("[()]","");
				isPrimaryKey = true;
			}
			
			Column_def cd = new Column_def(context.column_name().getText(), type_name, isPrimaryKey);
			newStatement.addColumn_def(cd);
		}
		
		//newStatement.show();
		statement = newStatement;
	}
	
	@Override
	public void exitInsert_stmt(Insert_stmtContext ctx) {
		
		InsertStmt newStatement = new InsertStmt();
		
		
		// set table name
		newStatement.setTable_name(ctx.table_name().getText());

		List<Column_nameContext> column_names = ctx.column_name();
		List<ExprContext> exprs  = ctx.expr();
		
		/*
		 * 	get the column_names
		 *  	if column_name == null, use default attribute order
		 *  	if column_name != null, then # of column_name must equal # of expr
		 */
		List<String> column_names_extracted= new ArrayList<String>();
		if(column_names.isEmpty()) {
			newStatement.setUsingDefaultAttrOrder(true);
			for(int i=0;i<exprs.size();i++)
				column_names_extracted.add("YOU SHOULD NOT USE THIS!");
		}
		else {
			newStatement.setUsingDefaultAttrOrder(false);
			if(column_names.size() != exprs.size())	
				throw new IllegalArgumentException("# of column_name must equal # of expr");
			for(Column_nameContext cnc : column_names)
				column_names_extracted.add(cnc.getText());
		}
		
		for(int i=0;i<exprs.size();i++) {
			ColNameValuePair cnvp = new ColNameValuePair(column_names_extracted.get(i), 
														 exprs.get(i).getText());
			newStatement.addNameValuePair(cnvp);
		}
		//newStatement.show();
		statement = newStatement;
	}
	
	@Override
	public void exitSelect_core(Select_coreContext ctx) {

		
	}
	
	/* ------------------------Unused-------------------- */
	
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterParse(ParseContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitParse(ParseContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterError(ErrorContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitError(ErrorContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSql_stmt(Sql_stmtContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSql_stmt(Sql_stmtContext ctx) {
		// TODO Auto-generated method stub
		
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
	public void enterCreate_table_stmt(Create_table_stmtContext ctx) {
		
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
	public void enterInsert_stmt(Insert_stmtContext ctx) {
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
	public void enterColumn_def(Column_defContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitColumn_def(Column_defContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterType_name(Type_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitType_name(Type_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterColumn_constraint(Column_constraintContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitColumn_constraint(Column_constraintContext ctx) {
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
	public void enterExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitExpr(ExprContext ctx) {
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
	public void enterRaise_function(Raise_functionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRaise_function(Raise_functionContext ctx) {
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
	public void enterResult_column(Result_columnContext ctx) {
		
	}

	@Override
	public void exitResult_column(Result_columnContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterTable_or_subquery(Table_or_subqueryContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitTable_or_subquery(Table_or_subqueryContext ctx) {
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
	public void enterSelect_core(Select_coreContext ctx) {
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
	public void enterSigned_number(Signed_numberContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSigned_number(Signed_numberContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterLiteral_value(Literal_valueContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitLiteral_value(Literal_valueContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterUnary_operator(Unary_operatorContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitUnary_operator(Unary_operatorContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterError_message(Error_messageContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitError_message(Error_messageContext ctx) {
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

	@Override
	public void enterKeyword(KeywordContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitKeyword(KeywordContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterName(NameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitName(NameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterFunction_name(Function_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitFunction_name(Function_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterDatabase_name(Database_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitDatabase_name(Database_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterTable_name(Table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitTable_name(Table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterTable_or_index_name(Table_or_index_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitTable_or_index_name(Table_or_index_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterNew_table_name(New_table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitNew_table_name(New_table_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterColumn_name(Column_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitColumn_name(Column_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterCollation_name(Collation_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitCollation_name(Collation_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterForeign_table(Foreign_tableContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitForeign_table(Foreign_tableContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterIndex_name(Index_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitIndex_name(Index_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterTrigger_name(Trigger_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitTrigger_name(Trigger_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterView_name(View_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitView_name(View_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterModule_name(Module_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitModule_name(Module_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterPragma_name(Pragma_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitPragma_name(Pragma_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSavepoint_name(Savepoint_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSavepoint_name(Savepoint_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterTable_alias(Table_aliasContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitTable_alias(Table_aliasContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterTransaction_name(Transaction_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitTransaction_name(Transaction_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterAny_name(Any_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitAny_name(Any_nameContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
