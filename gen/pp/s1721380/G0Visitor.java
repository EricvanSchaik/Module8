// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\G0.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link G0Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface G0Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link G0Parser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(G0Parser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link G0Parser#p}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitP(G0Parser.PContext ctx);
	/**
	 * Visit a parse tree produced by {@link G0Parser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(G0Parser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link G0Parser#y}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY(G0Parser.YContext ctx);
	/**
	 * Visit a parse tree produced by {@link G0Parser#i}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI(G0Parser.IContext ctx);
}