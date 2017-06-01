package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.CC13;

public class CC13Test {
	private static LexerTester tester = new LexerTester(CC13.class);

	@Test
	public void succeedingTest() {
		tester.correct("'asfasdgasdf'");
		tester.correct("'asf46576ufsa'");
		tester.yields("'asdfadsg'", CC13.STRING);
		tester.wrong("asgasfsfg");
	}
}
