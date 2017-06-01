package pp.block3.cc.symbol;

import java.util.HashMap;
import java.util.*;

/**
 * Created by Eric on 17-May-17.
 */
public class MySymbolTable implements SymbolTable {

    protected Map<String, Set<Integer>> map = new HashMap<>();
    protected Integer currentScope = 0;

    /**
     * Adds a next deeper scope level.
     */
    @Override
    public void openScope() {
        currentScope++;
    }

    /**
     * Removes the deepest scope level.
     *
     * @throws RuntimeException if the table only contains the outer scope.
     */
    @Override
    public void closeScope() {
        if (currentScope == 0) {
            throw new RuntimeException();
        }
        else {
            for (String s: map.keySet()) {
                if (map.get(s).contains(currentScope)) {
                    map.get(s).remove(currentScope);
                }
            }
            currentScope--;
        }
    }

    /**
     * Tries to declare a given identifier in the deepest scope level.
     *
     * @param id
     * @return <code>true</code> if the identifier was added,
     * <code>false</code> if it was already declared in this scope.
     */
    @Override
    public boolean add(String id) {
        if (!map.containsKey(id)) {
            Set<Integer> set = new HashSet<>();
            set.add(currentScope);
            map.put(id, set);
            return true;
        }
        else if (map.get(id).contains(currentScope)) {
            return false;
        }
        else {
            map.get(id).add(currentScope);
            return true;
        }
    }

    /**
     * Tests if a given identifier is in the scope of any declaration.
     *
     * @param id
     * @return <code>true</code> if there is any enclosing scope in which
     * the identifier is declared; <code>false</code> otherwise.
     */
    @Override
    public boolean contains(String id) {
        if (!map.containsKey(id)) {
            return false;
        }
        else {
            for (Integer i: map.get(id)) {
                if (i <= currentScope) {
                    return true;
                }
            }
            return false;
        }
    }
}
