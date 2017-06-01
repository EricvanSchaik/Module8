package pp.block2.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.*;

import java.math.BigInteger;

public class Calculator extends ArithmeticBaseListener {

	private ParseTreeProperty<BigInteger> values;
	private Boolean error;

	public Calculator() {
		this.values = new ParseTreeProperty<>();
		this.error = false;
	}

	public BigInteger evaluate(String text) {
		Lexer lexer = new ArithmeticLexer(new ANTLRInputStream(text));
		ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.expr();
		new ParseTreeWalker().walk(this, tree);
		return error ? null : values.get(tree);
	}

	@Override
	public void exitParenthesis(ArithmeticParser.ParenthesisContext tree) {
		if (values.get(tree.getChild(1)) == null) { return; }
		BigInteger value = values.get(tree.getChild(1));
		values.put(tree, value);
	}
	@Override
	public void exitPower(ArithmeticParser.PowerContext tree) {
		if (values.get(tree.getChild(2)) == null) { return; }
		BigInteger value = values.get(tree.getChild(0)).pow(values.get(tree.getChild(2)).intValue());
		values.put(tree, value);
	}

	@Override
	public void exitNegation(ArithmeticParser.NegationContext tree) {
		if (values.get(tree.getChild(1)) == null) { return; }
		BigInteger value = BigInteger.ZERO.subtract(values.get(tree.getChild(1)));
		values.put(tree, value);
	}
	@Override
	public void exitMultiplication(ArithmeticParser.MultiplicationContext tree) {
		if (values.get(tree.getChild(2)) == null) { return; }
		BigInteger value = values.get(tree.getChild(0)).multiply(values.get(tree.getChild(2)));
		values.put(tree, value);
	}
	@Override
	public void exitAddition(ArithmeticParser.AdditionContext tree) {
		if (values.get(tree.getChild(2)) == null) { return; }
		BigInteger value = values.get(tree.getChild(0)).add(values.get(tree.getChild(2)));
		values.put(tree, value);
	}

	@Override
	public void exitSubtraction(ArithmeticParser.SubtractionContext tree) {
		if (values.get(tree.getChild(2)) == null) { return; }
		BigInteger value = values.get(tree.getChild(0)).subtract(values.get(tree.getChild(2)));
		values.put(tree, value);
	}
	@Override
	public void exitNumber(ArithmeticParser.NumberContext tree) {
		BigInteger value = values.get(tree.getChild(0));
		values.put(tree, value);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		try {
			values.put(node, new BigInteger(node.getText()));
		} catch (NumberFormatException e) {

		}
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		error = true;
	}

	public ParseTreeProperty<BigInteger> getValues() {
		return values;
	}

}
