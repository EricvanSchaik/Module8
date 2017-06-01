// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Tree.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TreeParser}.
 */
public interface TreeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TreeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TreeParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TreeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TreeParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNode(TreeParser.NodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TreeParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNode(TreeParser.NodeContext ctx);
}