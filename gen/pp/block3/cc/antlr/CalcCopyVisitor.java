// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block3/cc/antlr\CalcCopy.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcCopyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcCopyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code par}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(CalcCopyParser.ParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(CalcCopyParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalcCopyParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(CalcCopyParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(CalcCopyParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code power}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(CalcCopyParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(CalcCopyParser.PlusContext ctx);
}