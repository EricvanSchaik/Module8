// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Formatter.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link FormatterVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class FormatterBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements FormatterVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFormatter(FormatterParser.FormatterContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitConversion(FormatterParser.ConversionContext ctx) { return visitChildren(ctx); }
}