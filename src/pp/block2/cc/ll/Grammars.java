/**
 * 
 */
package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence.g4 lexer grammar
		// Make sure you take the token constantss from the right class!
		SymbolFactory fact = new SymbolFactory(Sentence.class);
		Term noun = fact.getTerminal(Sentence.NOUN);
		Term verb = fact.getTerminal(Sentence.VERB);
		Term adj = fact.getTerminal(Sentence.ADJECTIVE);
		Term end = fact.getTerminal(Sentence.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}

	public static Grammar makeIf() {
		// nonTerms
		NonTerm stat = new NonTerm("Stat");
		NonTerm elsePart = new NonTerm("ElsePart");
		// terms
		SymbolFactory fact = new SymbolFactory(If.class);
		Term assign = fact.getTerminal(If.ASSIGN);
		Term IF = fact.getTerminal(If.IF);
		Term expr = fact.getTerminal(If.COND);
		Term then = fact.getTerminal(If.THEN);
		Term ELSE = fact.getTerminal(If.ELSE);
		Grammar g = new Grammar(stat);
		g.addRule(stat, assign);
		g.addRule(stat, IF, expr, then, stat, elsePart);
		g.addRule(elsePart, ELSE, stat);
		g.addRule(elsePart);
		return g;
	}

	public static Grammar makeAbc() {
		// Define the non-terminals
		NonTerm L = new NonTerm("L");
		NonTerm Q = new NonTerm("Q");
		NonTerm R = new NonTerm("R");
		NonTerm R1 = new NonTerm("R1");
		// Define the terminals, using the Sentence.g4 lexer grammar
		// Make sure you take the token constantss from the right class!
		SymbolFactory fact = new SymbolFactory(Abc.class);
		Term a = fact.getTerminal(Abc.A);
		Term b = fact.getTerminal(Abc.B);
		Term c = fact.getTerminal(Abc.C);
		// Build the context free grammar
		Grammar g = new Grammar(L);
		g.addRule(L, R, a);
		g.addRule(L, Q, b, a);
		g.addRule(Q, b, b, c);
		g.addRule(Q, b, c);
		g.addRule(R, a, b, a, R1);
		g.addRule(R, c, a, b, a, R1);
		g.addRule(R1, b, c, R1);
		g.addRule(R1);
		return g;
	}

}
