package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.CC12;

public class CC12Test {
	private static LexerTester tester = new LexerTester(CC12.class);

	@Test
	public void succeedingTest() {
		tester.correct("a12345");
		tester.correct("abcdef");
		tester.yields("abcdef", CC12.WORD);
		tester.wrong("123456");
	}
}
