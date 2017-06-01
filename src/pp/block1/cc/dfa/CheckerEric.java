package pp.block1.cc.dfa;

/**
 * Created by Eric on 01-May-17.
 */
public class CheckerEric implements Checker {

    public boolean accepts(State start, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (start.hasNext(word.charAt(i))) {
                start = start.getNext(word.charAt(i));
            } else {
                return false;
            }
        }
        return start.isAccepting();
    }
}