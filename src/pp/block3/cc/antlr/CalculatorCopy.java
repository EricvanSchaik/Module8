package pp.block3.cc.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class CalculatorCopy extends CalcCopyBaseListener {
	/** Map storing the val attribute for all parse tree nodes. */
	private ParseTreeProperty<Type> types;

	/** Initialises the calculator before using it to walk a tree. */
	public void init() {
		this.types = new ParseTreeProperty<Type>();
	}

	@Override
	public void exitPower(CalcCopyParser.PowerContext ctx) {
		if (type(ctx.expr(1)) == Type.NUM && (type(ctx.expr(0)) == Type.NUM || type(ctx.expr(0)) == Type.STR)) {
			set(ctx, type(ctx.expr(0)));
		}
		else {
			set(ctx, Type.ERR);
		}
	}

	@Override
	public void exitPlus(CalcCopyParser.PlusContext ctx) {
		if (type(ctx.expr(0)) == type(ctx.expr(1))) {
			set(ctx, type(ctx.expr(0)));
		}
		else {
			set(ctx, Type.ERR);
		}
	}

	@Override
	public void exitEqual(CalcCopyParser.EqualContext ctx) {
		if (type(ctx.expr(0)) == type(ctx.expr(1))) {
			set(ctx, Type.BOOL);
		}
		else {
			set(ctx, Type.ERR);
		}
	}

	@Override
	public void exitPar(CalcCopyParser.ParContext ctx) {
		set(ctx, type(ctx.expr()));
	}

	@Override
	public void exitNumber(CalcCopyParser.NumberContext ctx) {
		set(ctx, Type.NUM);
	}

	@Override
	public void exitBoolean(CalcCopyParser.BooleanContext ctx) {
		set(ctx, Type.BOOL);
	}

	@Override
	public void exitString(CalcCopyParser.StringContext ctx) {
		set(ctx, Type.STR);
	}

	/** Sets the type attribute of a given node. */
	private void set(ParseTree node, Type type) {
		this.types.put(node, type);
	}

	/** Retrieves the type attribute of a given node. */
	public Type type(ParseTree node) {
		return this.types.get(node);
	}
}
