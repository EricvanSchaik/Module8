package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class SentenceUsageCopy {
	public static void main(String[] args) {
		parse("all, smart, undergraduate students love all compilers.");
	}

	public static void parse(String text) {
		CharStream stream = CharStreams.fromString(text);
		Lexer lexer = new SentenceCopyLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		SentenceParser parser = new SentenceParser(tokens);
		ParseTree tree = parser.sentence();
		System.out.println(tree.toStringTree(parser));
	}
}
