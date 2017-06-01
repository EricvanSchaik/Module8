package pp.block4.cc.cfg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;
import pp.block4.cc.cfg.FragmentParser.ContStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;

import java.io.File;
import java.io.IOException;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
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
			ProgramContext tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ProgramContext tree) {
		this.graph = new Graph();
		ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
		parseTreeWalker.walk(this, tree);
		return graph;
	}

	@Override
	public void enterBreakStat(BreakStatContext ctx) {
		entrances.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterContStat(ContStatContext ctx) {
		entrances.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterProgram(ProgramContext ctx) {
		Node node = addNode(ctx.stat(0), ctx.stat(0).getText());
		exits.put(ctx.stat(0), node);
		for (FragmentParser.StatContext statement: ctx.stat().subList(1, ctx.stat().size())) {
			Node entrance = addNode(statement, statement.getText() + "(entrance)");
			entrances.put(statement, entrance);
			node.addEdge(entrance);
			Node exit = addNode(statement, statement.getText() + "(exit)");
			exits.put(statement, exit);
			node.addEdge(entrance);
			node = exit;
		}
	}

	@Override
	public void enterBlockStat(FragmentParser.BlockStatContext ctx) {
		Node node = entrances.get(ctx);
		for (FragmentParser.StatContext statement: ctx.stat()) {
			Node entrance = addNode(statement, statement.getText() + "(entrance)");
			Node exit = addNode(statement, statement.getText() + "(exit)");
			entrances.put(statement, entrance);
			exits.put(statement, exit);
			node.addEdge(entrance);
			node = exit;
		}
		node.addEdge(exits.get(ctx));
	}

	@Override
	public void enterDecl(FragmentParser.DeclContext ctx) {
		entrances.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterAssignStat(FragmentParser.AssignStatContext ctx) {
		entrances.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterIfStat(FragmentParser.IfStatContext ctx) {
		Node entrance = addNode(ctx.stat(0), ctx.stat(0).getText() + "(entrance)");
		Node exit = addNode(ctx.stat(0), ctx.stat(0).getText() + "(exit)");
		entrances.put(ctx.stat(0), entrance);
		exits.put(ctx.stat(0), exit);
		entrances.get(ctx).addEdge(entrance);
		exits.get(ctx).addEdge(exit);
		if (ctx.stat(1) != null) {
			entrance = addNode(ctx.stat(1), ctx.stat(1).getText() + "(entrance)");
			entrances.put(ctx.stat(1), entrance);
			entrances.get(ctx).addEdge(entrance);
			exit = addNode(ctx.stat(1), ctx.stat(1).getText() + "(exit)");
			exits.put(ctx.stat(1), exit);
			exits.get(ctx).addEdge(exit);
		}
	}

	@Override
	public void enterWhileStat(FragmentParser.WhileStatContext ctx) {
		Node entrance = addNode(ctx.stat(), ctx.stat().getText());
		Node exit = addNode(ctx.stat(), ctx.stat().getText());
		entrances.put(ctx.stat(), entrance);
		exits.put(ctx.stat(), exit);
		entrance.addEdge(entrances.get(ctx));
		exit.addEdge(exits.get(ctx));
		entrances.get(ctx).addEdge(exits.get(ctx));
	}

	@Override
	public void enterPrintStat(FragmentParser.PrintStatContext ctx) {
		entrances.get(ctx).addEdge(exits.get(ctx));
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
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
