package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;

/**
 * Created by Eric on 17-May-17.
 */
public class Tabular2HTMLListener extends TabularBaseListener {

    private String html = "";
    private MyErrorListener myErrorListener = new MyErrorListener();

    public MyErrorListener getMyErrorListener() {
        return myErrorListener;
    }

    public String getHtml() {
        return html;
    }

    @Override
    public void enterTable(TabularParser.TableContext ctx) {
        html = html.concat("<html><body><table border = \"1\">");
    }

    @Override
    public void exitTable(TabularParser.TableContext ctx) {
        html = html.concat("</table></body></html>");
    }

    @Override
    public void enterRow(TabularParser.RowContext ctx) {
        html = html.concat("<tr>");
    }

    @Override
    public void exitRow(TabularParser.RowContext ctx) {
        html = html.concat("</tr>");
    }

    @Override
    public void enterEntry(TabularParser.EntryContext ctx) {
        html = html.concat("<td>");
        html = html.concat(ctx.getText());
    }

    @Override
    public void exitEntry(TabularParser.EntryContext ctx) {
        html = html.concat("</td>");
    }

    public static void main(String[] args) {
        if (args.length < 1 || (new File(args[0])).isDirectory()) {
            System.out.println("give filename");
        }
        else {
            try {
                CharStream stream = CharStreams.fromFileName(args[0]);
                Lexer lexer = new TabularLexer(stream);
                lexer.removeErrorListeners();
                MyErrorListener myErrorListener = new MyErrorListener();
                lexer.addErrorListener(myErrorListener);
                TokenStream tokenStream = new CommonTokenStream(lexer);
                TabularParser tabularParser = new TabularParser(tokenStream);
                tabularParser.removeErrorListeners();
                tabularParser.addErrorListener(myErrorListener);
                Tabular2HTMLListener tabular2HTMLListener = new Tabular2HTMLListener();
                new ParseTreeWalker().walk(tabular2HTMLListener, tabularParser.table());
                if (tabular2HTMLListener.getMyErrorListener().getErrors().isEmpty()) {
                    System.out.println(tabular2HTMLListener.getHtml());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
