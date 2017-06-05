package pp.block4.cc.iloc;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.iloc.model.*;

/**
 * Created by Eric on 31-May-17.
 */
public class CalcCompilerEric extends CalcCompiler {

    private ParseTreeProperty<Reg> registers = new ParseTreeProperty<>();
    private int registerNumber = 0;

    @Override
    public Program compile(ParseTree tree) {
        prog = new Program();
        new ParseTreeWalker().walk(this, tree);
        emit(OpCode.out, new Str(""), new Reg("r_" + (registerNumber - 1)));
        return prog;
    }

    private void addRegister(ParseTree ctx) {
        registers.put(ctx, new Reg("r_" + registerNumber));
        registerNumber++;
    }

    @Override
    public void exitNumber(CalcParser.NumberContext ctx) {
        addRegister(ctx);
        emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), registers.get(ctx));
    }

    @Override
    public void exitPar(CalcParser.ParContext ctx) {
        addRegister(ctx);
        emit(OpCode.i2i, registers.get(ctx.expr()), registers.get(ctx));
    }

    @Override
    public void exitPlus(CalcParser.PlusContext ctx) {
        addRegister(ctx);
        emit(OpCode.add, registers.get(ctx.expr(0)), registers.get(ctx.expr(1)), registers.get(ctx));
    }

    @Override
    public void exitMinus(CalcParser.MinusContext ctx) {
        addRegister(ctx);
        emit(OpCode.rsubI, registers.get(ctx.expr()), new Num(0), registers.get(ctx));
    }

    @Override
    public void exitTimes(CalcParser.TimesContext ctx) {
        addRegister(ctx);
        emit(OpCode.mult, registers.get(ctx.expr(0)), registers.get(ctx.expr(1)), registers.get(ctx));
    }
}
