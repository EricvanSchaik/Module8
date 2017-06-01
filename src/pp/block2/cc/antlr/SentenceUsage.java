package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import pp.block3.cc.tabular.MyErrorListener;

public class SentenceUsage {
	public static void main(String[] args) {
		parse("all smart undergraduate students love all compilers.");
		parse("all students love love.");
	}

	public static void parse(String text) {
		// Convert the input text to a character stream
		CharStream stream = CharStreams.fromString(text);
		// Build a lexer on top of the character stream
		Lexer lexer = new SentenceLexer(stream);
		lexer.removeErrorListeners();
		BaseErrorListener errorListener = new MyErrorListener();
		lexer.addErrorListener(errorListener);
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		SentenceParser parser = new SentenceParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.sentence();
		// Print the (formatted) parse tree
		System.out.println(tree.toStringTree(parser));
	}
}
