// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Birth.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BirthParser}.
 */
public interface BirthListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BirthParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(BirthParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(BirthParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link BirthParser#enter}.
	 * @param ctx the parse tree
	 */
	void enterEnter(BirthParser.EnterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#enter}.
	 * @param ctx the parse tree
	 */
	void exitEnter(BirthParser.EnterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 */
	void enterBeget(BirthParser.BegetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#beget}.
	 * @param ctx the parse tree
	 */
	void exitBeget(BirthParser.BegetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BirthParser#sex}.
	 * @param ctx the parse tree
	 */
	void enterSex(BirthParser.SexContext ctx);
	/**
	 * Exit a parse tree produced by {@link BirthParser#sex}.
	 * @param ctx the parse tree
	 */
	void exitSex(BirthParser.SexContext ctx);
}