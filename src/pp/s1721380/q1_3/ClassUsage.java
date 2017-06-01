package pp.s1721380.q1_3;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import pp.s1721380.ClassLexer;
import pp.s1721380.ClassParser;

public class ClassUsage {
	public static void main(String[] args) {
		parse("class example");
	}

	public static void parse(String text) {
		// Convert the input text to a character stream
		CharStream stream = CharStreams.fromString(text);
		// Build a lexer on top of the character stream
		Lexer lexer = new ClassLexer(stream);
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		ClassParser parser = new ClassParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.c();
		// Print the (formatted) parse tree
		System.out.println(tree.toStringTree(parser));
	}
}
