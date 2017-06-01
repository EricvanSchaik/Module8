// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Tree.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TreeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TreeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TreeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TreeParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link TreeParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(TreeParser.NodeContext ctx);
}