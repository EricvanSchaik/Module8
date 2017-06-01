package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.symbol.DeclUse;
import pp.block3.cc.symbol.DeclUseLexer;
import pp.block3.cc.symbol.DeclUseParser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eric on 17-May-17.
 */
public class DeclUseTest {

    private DeclUse declUse;
    private ParseTreeWalker walker = new ParseTreeWalker();
    private List<String> errors;

    private ParseTree parseDeclUse(String program) {
        CharStream chars = CharStreams.fromString(program);
        Lexer lexer = new DeclUseLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        DeclUseParser parser = new DeclUseParser(tokens);
        return parser.program();
    }

    private void testDeclUse(List<String> expected, String program) {
        ParseTree tree = parseDeclUse(program);
        declUse = new DeclUse();
        walker.walk(declUse, tree);
        assertEquals(expected, declUse.getErrors());
    }

    @Test
    public void test() {
        errors = new ArrayList<>();
        testDeclUse(errors, "(D: aap (U: aap D: noot D: aap (U: noot ) (D: noot U: noot )) U: aap )");
        errors.add("Couldn't add the variable on line 1, position 11");
        testDeclUse(errors, "(D: aap D: aap)");
        errors = new ArrayList<>();
        errors.add("Couldn't add the variable on line 1, position 11");
        errors.add("Couldn't use the variable on line 1, position 43");
        System.out.println(errors);
        testDeclUse(errors, "(D: aap D: aap U: aap (D: noot U: noot) U: noot)");
    }

}
