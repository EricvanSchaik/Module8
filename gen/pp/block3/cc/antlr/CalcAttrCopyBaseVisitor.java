// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block3/cc/antlr\CalcAttrCopy.g4 by ANTLR 4.7
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link CalcAttrCopyVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class CalcAttrCopyBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements CalcAttrCopyVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTerm(CalcAttrCopyParser.TermContext ctx) { return visitChildren(ctx); }
}