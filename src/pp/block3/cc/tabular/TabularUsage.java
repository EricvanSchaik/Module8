package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;

import java.io.IOException;

/**
 * Created by Eric on 17-May-17.
 */
public class TabularUsage {

    public static void main(String[] args) {
        scan("C:\\Users\\Eric\\IdeaProjects\\Module8\\src\\pp\\block3\\cc\\tabular\\tabular-1.tex");
        scan("C:\\Users\\Eric\\IdeaProjects\\Module8\\src\\pp\\block3\\cc\\tabular\\tabular-2.tex");
        scan("C:\\Users\\Eric\\IdeaProjects\\Module8\\src\\pp\\block3\\cc\\tabular\\tabular-3.tex");
        scan("C:\\Users\\Eric\\IdeaProjects\\Module8\\src\\pp\\block3\\cc\\tabular\\tabular-4.tex");
        scan("C:\\Users\\Eric\\IdeaProjects\\Module8\\src\\pp\\block3\\cc\\tabular\\tabular-5.tex");
    }

    public static void scan(String fileName) {
        try {
            CharStream stream = CharStreams.fromFileName(fileName);
            Lexer lexer = new TabularLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MyErrorListener());
            for (Token token : lexer.getAllTokens()) {
                System.out.print(token.toString() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
