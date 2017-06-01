package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 01-May-17.
 */
public class ScannerEric implements Scanner {

    public List<String> scan(State dfa, String text) {
        List<String> tokens = new ArrayList<>();
        State start = dfa;
        String token = "";
        List<State> visited = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (dfa.hasNext(text.charAt(i))) {
                token += text.charAt(i);
                visited.add(dfa);
                dfa = dfa.getNext(text.charAt(i));
            }
            else {
                if (dfa.isAccepting()) {
                    tokens.add(token);
                    visited = new ArrayList<>();
                    if (start.hasNext(text.charAt(i))) {
                        dfa = start;
                        token = String.valueOf(text.charAt(i));
                        dfa = dfa.getNext(text.charAt(i));
                    }
                }
                else {
                    int j = 0;
                    while (!dfa.isAccepting()) {
                        j++;
                        dfa = visited.get(visited.size() - j);
                    }
                    token = token.substring(0, token.length()-j);
                    tokens.add(token);
                    i = i - j;
                    if (start.hasNext(text.charAt(i))) {
                        dfa = start;
                        token = String.valueOf(text.charAt(i));
                        dfa = dfa.getNext(text.charAt(i));
                    }
                }
            }
        }
        if (dfa.isAccepting()) {
            tokens.add(token);
        }
        return tokens;
    }
}
