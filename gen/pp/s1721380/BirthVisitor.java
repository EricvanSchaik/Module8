// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Birth.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BirthParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BirthVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BirthParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(BirthParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link BirthParser#enter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnter(BirthParser.EnterContext ctx);
	/**
	 * Visit a parse tree produced by {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeget(BirthParser.BegetContext ctx);
	/**
	 * Visit a parse tree produced by {@link BirthParser#sex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSex(BirthParser.SexContext ctx);
}