package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.*;

import static org.junit.Assert.assertEquals;

public class CalcCopyTest {
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final CalculatorCopy calc = new CalculatorCopy();

	@Test
	public void test() {
		test(Type.NUM, "2^3");
		test(Type.BOOL, "3=3");
		test(Type.STR, "'e'^2");
		test(Type.ERR, "3='e'");
	}

	@Test
	public void testAttr() {
		testAttr(Type.NUM, "2^3");
		testAttr(Type.BOOL, "3=3");
		testAttr(Type.STR, "'e'^2");
		testAttr(Type.ERR, "3='e'");
	}

	private void test(Type expected, String expr) {
		ParseTree tree = parseCalc(expr);
		this.calc.init();
		this.walker.walk(this.calc, tree);
		assertEquals(expected, this.calc.type(tree));
	}

	private void testAttr(Type expected, String expr) {
		assertEquals(expected, parseCalcAttr(expr).type);
	}

	private ParseTree parseCalc(String text) {
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CalcCopyLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcCopyParser parser = new CalcCopyParser(tokens);
		return parser.expr();
	}

	private CalcAttrCopyParser.TermContext parseCalcAttr(String text) {
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CalcAttrCopyLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcAttrCopyParser parser = new CalcAttrCopyParser(tokens);
		return parser.term();
	}
}
