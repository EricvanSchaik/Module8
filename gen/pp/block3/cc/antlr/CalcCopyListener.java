// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block3/cc/antlr\CalcCopy.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcCopyParser}.
 */
public interface CalcCopyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPar(CalcCopyParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPar(CalcCopyParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(CalcCopyParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(CalcCopyParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalcCopyParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalcCopyParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(CalcCopyParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(CalcCopyParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(CalcCopyParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(CalcCopyParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(CalcCopyParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(CalcCopyParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlus(CalcCopyParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CalcCopyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlus(CalcCopyParser.PlusContext ctx);
}