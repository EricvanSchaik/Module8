package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.*;
import pp.block3.cc.antlr.CalcAttrParser.ExprContext;

import static org.junit.Assert.assertEquals;

public class CalcTest {
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final Calculator calc = new Calculator();

	@Test
	public void test() {
		test(5, "3+2");
		test(7, "1+2*3");
		test(9, "(1+2)*3");
		test(-1, "-3+2");
		test(-5, "1+2*-3");
		test(3, "(-1+2)*3");
	}

	private void test(int expected, String expr) {
		assertEquals(expected, parseCalcAttr(expr).val);
		ParseTree tree = parseCalc(expr);
		this.calc.init();
		this.walker.walk(this.calc, tree);
		assertEquals(expected, this.calc.val(tree));
	}

	private ParseTree parseCalc(String text) {
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CalcLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		return parser.expr();
	}

	private ExprContext parseCalcAttr(String text) {
		CharStream chars = CharStreams.fromString(text);
		Lexer lexer = new CalcAttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcAttrParser parser = new CalcAttrParser(tokens);
		return parser.expr();
	}
}
