package pp.block2.cc.test;

import org.junit.Test;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

import java.util.*;

import static org.junit.Assert.*;

public class LLCalcTest {
	Grammar sentenceG = Grammars.makeSentence();
	// Define the non-terminals
	NonTerm subj = sentenceG.getNonterminal("Subject");
	NonTerm obj = sentenceG.getNonterminal("Object");
	NonTerm sent = sentenceG.getNonterminal("Sentence");
	NonTerm mod = sentenceG.getNonterminal("Modifier");
	// Define the terminals
	Term adj = sentenceG.getTerminal(Sentence.ADJECTIVE);
	Term noun = sentenceG.getTerminal(Sentence.NOUN);
	Term verb = sentenceG.getTerminal(Sentence.VERB);
	Term end = sentenceG.getTerminal(Sentence.ENDMARK);
	// Now add the last rule, causing the grammar to fail
	Grammar sentenceXG = Grammars.makeSentence();
	{    sentenceXG.addRule(mod, mod, mod);
	}
	LLCalc sentenceXLL = createCalc(sentenceXG);

	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testSentenceOrigLL1() {
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(sentenceG).isLL1());
	}

	@Test
	public void testSentenceXFirst() {
		Map<Symbol, Set<Term>> first = sentenceXLL.getFirst();
		assertEquals(set(adj, noun), first.get(sent));
		assertEquals(set(adj, noun), first.get(subj));
		assertEquals(set(adj, noun), first.get(obj));
		assertEquals(set(adj), first.get(mod));
	}
	
	@Test
	public void testSentenceXFollow() {
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = sentenceXLL.getFollow();
		assertEquals(set(Symbol.EOF), follow.get(sent));
		assertEquals(set(verb), follow.get(subj));
		assertEquals(set(end), follow.get(obj));
		assertEquals(set(noun, adj), follow.get(mod));
	}
	
	@Test
	public void testSentenceXFirstPlus() {
		Map<Rule, Set<Term>> firstp = sentenceXLL.getFirstp();
		List<Rule> subjRules = sentenceXG.getRules(subj);
		assertEquals(set(noun), firstp.get(subjRules.get(0)));
		assertEquals(set(adj), firstp.get(subjRules.get(1)));
	}
	
	@Test
	public void testSentenceXLL1() {
		assertFalse(sentenceXLL.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		return new MyLLCalc(g);
	}

	Grammar g = Grammars.makeIf();
	NonTerm stat = g.getNonterminal("Stat");
	NonTerm elsePart = g.getNonterminal("ElsePart");
	Term assign = g.getTerminal(If.ASSIGN);
	Term IF = g.getTerminal(If.IF);
	Term expr = g.getTerminal(If.COND);
	Term then = g.getTerminal(If.THEN);
	Term ELSE = g.getTerminal(If.ELSE);
	Term eof = Symbol.EOF;
	Term empty = Symbol.EMPTY;
	LLCalc IfSentence = createCalc(g);

	@Test
	public void testIfFirst() {
		Map<Symbol, Set<Term>> first = IfSentence.getFirst();
		assertEquals(set(assign, IF), first.get(stat));
		assertEquals(set(empty, ELSE), first.get(elsePart));
	}

	@Test
	public void testIfFollow() {
		Map<NonTerm, Set<Term>> follow = IfSentence.getFollow();
		assertEquals(set(eof, ELSE), follow.get(stat));
		assertEquals(set(eof, ELSE), follow.get(elsePart));
	}

	@Test
	public void testIfFirstPlus() {
		Map<Rule, Set<Term>> firstp = IfSentence.getFirstp();
		List<Rule> elsePartRules = g.getRules(elsePart);
		assertEquals(set(ELSE), firstp.get(elsePartRules.get(0)));
		assertEquals(set(eof, empty, ELSE), firstp.get(elsePartRules.get(1)));
	}

	@Test
	public void testIfLL1() {
		assertFalse(IfSentence.isLL1());
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}


}
