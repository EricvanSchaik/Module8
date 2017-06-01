package pp.s1721380.q1_4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.s1721380.TreeBaseListener;
import pp.s1721380.TreeLexer;
import pp.s1721380.TreeParser;

/**
 * Created by Eric on 25-5-2017.
 */

public class MyTreeListener extends TreeBaseListener {

    private ParseTreeProperty<Double> upperNode = new ParseTreeProperty<>();
    private ParseTreeProperty<Double> lowerNode = new ParseTreeProperty<>();
    private ParseTreeProperty<Boolean> isOrdered = new ParseTreeProperty<>();

    public Boolean isOrdered(String text) {
        TreeParser parser = new TreeParser(new CommonTokenStream(new TreeLexer(new ANTLRInputStream(text))));
        ParseTree tree = parser.prog();
        new ParseTreeWalker().walk(this, tree);
        return isOrdered.get(tree);
    }

    @Override
    public void enterNode(TreeParser.NodeContext ctx) {
        if (ctx.getChild(1) == null) {
        } else if (ctx.getChild(5) == null) {
            if (ctx.getChild(2).getText().equals("<")) {
                lowerNode.put(ctx.getChild(1), (lowerNode.get(ctx)));
                upperNode.put(ctx.getChild(1), Double.parseDouble(ctx.getChild(3).getText()));
            } else {
                lowerNode.put(ctx.getChild(3), Double.parseDouble(ctx.getChild(1).getText()));
                upperNode.put(ctx.getChild(3), (upperNode.get(ctx)));
            }
        } else {
            lowerNode.put(ctx.getChild(1), lowerNode.get(ctx));
            upperNode.put(ctx.getChild(1), Double.parseDouble(ctx.getChild(3).getText()));
            lowerNode.put(ctx.getChild(5), Double.parseDouble(ctx.getChild(3).getText()));
            upperNode.put(ctx.getChild(5), upperNode.get(ctx));
        }
    }

    @Override
    public void exitNode(TreeParser.NodeContext ctx) {
        if (ctx.getChild(1) == null) {
            if ((lowerNode.get(ctx) <= Double.parseDouble(ctx.getChild(0).getText())) && (upperNode.get(ctx) >= Double.parseDouble(ctx.getChild(0).getText()))) {
                isOrdered.put(ctx, true);
            } else {
                isOrdered.put(ctx, false);
            }
        } else if (ctx.getChild(5) == null) {
            if (ctx.getChild(2).getText().equals("<")) {
                if ((isOrdered.get(ctx.getChild(1)) == true) && (lowerNode.get(ctx) <= Double.parseDouble(ctx.getChild(3).getText())) && (upperNode.get(ctx) >= Double.parseDouble(ctx.getChild(3).getText()))) {
                    isOrdered.put(ctx, true);
                } else {
                    isOrdered.put(ctx, false);
                }
            } else {
                if ((isOrdered.get(ctx.getChild(3)) == true) && (lowerNode.get(ctx) <= Double.parseDouble(ctx.getChild(1).getText())) && (upperNode.get(ctx) >= Double.parseDouble(ctx.getChild(1).getText()))) {
                    isOrdered.put(ctx, true);
                } else {
                    isOrdered.put(ctx, false);
                }
            }
        } else {
            if ((isOrdered.get(ctx.getChild(1)) == true) && (isOrdered.get(ctx.getChild(5)) == true) && (lowerNode.get(ctx) <= Double.parseDouble(ctx.getChild(3).getText())) && (upperNode.get(ctx) >= Double.parseDouble(ctx.getChild(3).getText()))) {
                isOrdered.put(ctx, true);
            } else {
                isOrdered.put(ctx, false);
            }
        }
    }

    @Override
    public void enterProg(TreeParser.ProgContext ctx) {
        upperNode.put(ctx.getChild(0), Double.POSITIVE_INFINITY);
        lowerNode.put(ctx.getChild(0), Double.NEGATIVE_INFINITY);
    }

    @Override
    public void exitProg(TreeParser.ProgContext ctx) {
        isOrdered.put(ctx, isOrdered.get(ctx.getChild(0)));
    }

}