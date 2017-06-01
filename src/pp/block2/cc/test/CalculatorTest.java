package pp.block2.cc.test;

import org.junit.*;
import pp.block2.cc.antlr.Calculator;

import java.math.BigInteger;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setCalculator() {
		this.calculator = new Calculator();
	}

	@Test
	public void testParenthesis() {
		Assert.assertEquals(9, calculator.evaluate("(1+2)*3").intValue());
		Assert.assertEquals(7, calculator.evaluate("1+(2*3)").intValue());
		Assert.assertEquals(7, calculator.evaluate("1+2*3").intValue());
		Assert.assertEquals(72, calculator.evaluate("((72))").intValue());
	}

	@Test
	public void testPower() {
		Assert.assertEquals(1, calculator.evaluate("1^2").intValue());
		Assert.assertEquals(2, calculator.evaluate("2^1").intValue());
		Assert.assertEquals(4, calculator.evaluate("2^2").intValue());
		Assert.assertEquals(256, calculator.evaluate("2^2^3").intValue());
		Assert.assertEquals(null, calculator.evaluate("2^"));
		Assert.assertEquals(new BigInteger("2417851639229258349412354"), calculator.evaluate("2^3^4+2"));
		Assert.assertEquals(256, calculator.evaluate("10^(-2)").intValue());
	}

	@Test
	public void testNegation() {
		Assert.assertEquals(-72, calculator.evaluate("-72").intValue());
		Assert.assertEquals(72, calculator.evaluate("72").intValue());
	}

	@Test
	public void testMultiplication() {
		Assert.assertEquals(2, calculator.evaluate("1*2").intValue());
		Assert.assertEquals(6, calculator.evaluate("1*2*3").intValue());
		Assert.assertEquals(14, calculator.evaluate("7*2").intValue());
	}

	@Test
	public void testSubtraction() {
		Assert.assertEquals(2, calculator.evaluate("7-5").intValue());
		Assert.assertEquals(-2, calculator.evaluate("5-7").intValue());
	}

	@Test
	public void testAddition() {
		Assert.assertEquals(12, calculator.evaluate("7+5").intValue());
		Assert.assertEquals(-2, calculator.evaluate("-7+5").intValue());
	}

	@Test
	public void testNumber() {
		Assert.assertEquals(6, calculator.evaluate("6").intValue());
	}

}
