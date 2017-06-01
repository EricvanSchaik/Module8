package pp.block4.cc.cfg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;

import java.io.File;
import java.io.IOException;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;
	private ParseTreeProperty<Node> entrances = new ParseTreeProperty<>();
	private ParseTreeProperty<Node> exits = new ParseTreeProperty<>();

	/** Builds the CFG for a program contained in a given file. */
	public Graph build(File file) {
		Graph result = null;
		ErrorListener listener = new ErrorListener();
		try {
			CharStream chars = CharStreams.fromPath(file.toPath());
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ParseTree tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = buildTree(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph buildTree(ParseTree tree) {
		this.graph = new Graph();
		ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
		parseTreeWalker.walk(this, tree);
		return graph;
	}

	@Override
	public void exitDecl(FragmentParser.DeclContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
	}

	@Override
	public void exitAssignStat(FragmentParser.AssignStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
	}

	@Override
	public void exitIfStat(FragmentParser.IfStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		Node fake = addNode(ctx, ctx.getText() + "(fake)");
		entrances.put(ctx, node);
		exits.put(ctx, fake);
		node.addEdge(entrances.get(ctx.stat(0)));
		fake.addEdge(exits.get(ctx.stat(0)));
		if (ctx.stat(1) != null) {
			node.addEdge(entrances.get(ctx.stat(1)));
			exits.get(ctx.stat(1)).addEdge(fake);
		}
		else {
			node.addEdge(fake);
		}
	}

	@Override
	public void exitWhileStat(FragmentParser.WhileStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
		node.addEdge(entrances.get(ctx.stat()));
		node.addEdge(exits.get(ctx.stat()));
	}

	@Override
	public void exitBlockStat(FragmentParser.BlockStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
		//Link the entrance of every statement in the block statement to the exit of the previous statement.
		Node exit = node;
		for (FragmentParser.StatContext statement: ctx.stat()) {
			exit.addEdge(entrances.get(statement));
			exit = exits.get(statement);
		}
		exit.addEdge(node);
	}

	@Override
	public void exitPrintStat(FragmentParser.PrintStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
	}

	@Override
	public void exitBreakStat(FragmentParser.BreakStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
	}

	@Override
	public void exitContStat(FragmentParser.ContStatContext ctx) {
		Node node = addNode(ctx, ctx.getText());
		entrances.put(ctx, node);
		exits.put(ctx, node);
	}

	@Override
	public void exitProgram(FragmentParser.ProgramContext ctx) {
		Node exit = exits.get(ctx.stat(0));
		for (FragmentParser.StatContext statement: ctx.stat().subList(1, ctx.stat().size())) {
			exit.addEdge(entrances.get(statement));
			exit = exits.get(statement);
		}
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
