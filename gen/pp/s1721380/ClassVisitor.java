// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Class.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ClassVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ClassParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(ClassParser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#p}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitP(ClassParser.PContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(ClassParser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#y}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY(ClassParser.YContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#i}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI(ClassParser.IContext ctx);
}