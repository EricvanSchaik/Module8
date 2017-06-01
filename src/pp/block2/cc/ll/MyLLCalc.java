package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

/**
 * Created by eric.
 */
public class MyLLCalc implements LLCalc {
    public Grammar grammar;
    public Map<Symbol, Set<Term>> first;
    public Map<NonTerm, Set<Term>> follow;
    public Map<Rule, Set<Term>> firstp;

    public MyLLCalc(Grammar grammar) {
        this.grammar = grammar;
    }

    public Map<Symbol, Set<Term>> getFirst() {
        if (this.first == null) {
            first = new HashMap<>();
            for (Term terminal : this.grammar.getTerminals()) {
                Set<Term> set = new HashSet<>();
                set.add(terminal);
                first.put(terminal, set);
            }
            for (NonTerm nonTerminal : this.grammar.getNonterminals()) {
                first.put(nonTerminal, new HashSet<>());
            }
            boolean changing = true;
            while (changing) {
                changing = false;
                for (Rule rule : grammar.getRules()) {
                    if (!first.get(rule.getLHS()).containsAll(getRHSFirst(first, rule.getRHS()))) {
                        first.get(rule.getLHS()).addAll(getRHSFirst(first, rule.getRHS()));
                        changing = true;
                    }
                }
            }
        }
        return this.first;
    }

    public Map<NonTerm, Set<Term>> getFollow() {
        if (this.follow == null) {
            Map<Symbol, Set<Term>> first = getFirst();
            follow = new HashMap<>();
            boolean changing = true;

            for (NonTerm nonTerminals : grammar.getNonterminals()) {
                follow.put(nonTerminals, new HashSet<>());
            }
            follow.get(grammar.getStart()).add(Symbol.EOF);

            while (changing) {
                changing = false;
                for (Rule rule : grammar.getRules()) {
                    NonTerm lhs = rule.getLHS();
                    List<Symbol> rhs = rule.getRHS();
                    Set<Term> trailer = new HashSet<>(follow.get(lhs));
                    for (int i = rhs.size()-1; i >= 0; i--) {
                        Symbol symbol = rhs.get(i);
                        if (symbol instanceof NonTerm) {
                            Set<Term> followbi = follow.get(symbol);
                            if (!followbi.containsAll(trailer)) {
                                followbi.addAll(trailer);
                                changing = true;
                            }
                        }
                        if (first.get(symbol).contains(Symbol.EMPTY)) {
                            HashSet<Term> newTrailer = new HashSet<>(first.get(symbol));
                            newTrailer.remove(Symbol.EMPTY);
                            trailer.addAll(newTrailer);
                        }
                        else {
                            trailer.clear();
                            trailer.addAll(first.get(symbol));
                        }
                    }
                }
            }
        }
        return this.follow;
    }

    public Map<Rule, Set<Term>> getFirstp() {
        if (this.firstp == null) {
            firstp = new HashMap<>();
            Map<Symbol, Set<Term>> first = getFirst();
            Map<NonTerm, Set<Term>> follow = getFollow();

            for (Rule rule : grammar.getRules()) {
                Set<Term> firstp2 = getRHSFirst(first, rule.getRHS());
                if (firstp2.contains(Symbol.EMPTY)) {
                    firstp2.addAll(follow.get(rule.getLHS()));
                }
                firstp.put(rule, firstp2);
            }
        }
        return this.firstp;
    }

    public boolean isLL1() {
        Map<Rule, Set<Term>> firstp = getFirstp();
        System.out.println(firstp);
        for (Rule rule : grammar.getRules()) {
            for (Rule otherRule : grammar.getRules()) {
                if (rule == otherRule) continue;
                if (rule.getLHS().equals(otherRule.getLHS())) {
                    if (!Collections.disjoint(firstp.get(rule), firstp.get(otherRule))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Set<Term> getRHSFirst(Map<Symbol, Set<Term>> first, List<Symbol> rhs) {
        Set<Term> terminals = new HashSet<>();
        terminals.add(Symbol.EMPTY);
        boolean canBeEmpty = true;
        for (Symbol symbol : rhs) {
            Set<Term> newTerminals = first.get(symbol);
            terminals.addAll(newTerminals);
            canBeEmpty = newTerminals.contains(Symbol.EMPTY);
            if (!canBeEmpty) break;
        }
        if (!canBeEmpty) terminals.remove(Symbol.EMPTY);
        return terminals;
    }
}