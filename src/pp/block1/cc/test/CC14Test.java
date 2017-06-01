package pp.block1.cc.test;

import org.junit.Test;
import pp.block1.cc.antlr.CC14;

public class CC14Test {
	private static LexerTester tester = new LexerTester(CC14.class);

	@Test
	public void succeedingTest() {
		tester.correct("Laaa   ");
		tester.correct("LaaaaLaLaa Laaaa LaLiLaa");
		tester.yields("Laaa   LaaLaaa Li ", CC14.TOKEN);
		tester.wrong("123456");
	}
}
