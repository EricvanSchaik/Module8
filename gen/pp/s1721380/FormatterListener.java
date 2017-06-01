// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Formatter.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormatterParser}.
 */
public interface FormatterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormatterParser#formatter}.
	 * @param ctx the parse tree
	 */
	void enterFormatter(FormatterParser.FormatterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormatterParser#formatter}.
	 * @param ctx the parse tree
	 */
	void exitFormatter(FormatterParser.FormatterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormatterParser#conversion}.
	 * @param ctx the parse tree
	 */
	void enterConversion(FormatterParser.ConversionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormatterParser#conversion}.
	 * @param ctx the parse tree
	 */
	void exitConversion(FormatterParser.ConversionContext ctx);
}