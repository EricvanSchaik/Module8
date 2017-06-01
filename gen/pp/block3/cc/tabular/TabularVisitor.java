// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TabularParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TabularVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(TabularParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TabularParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(TabularParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link TabularParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(TabularParser.EntryContext ctx);
}