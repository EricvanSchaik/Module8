// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TabularParser}.
 */
public interface TabularListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(TabularParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(TabularParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(TabularParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(TabularParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(TabularParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(TabularParser.EntryContext ctx);
}