package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 17-May-17.
 */
public class DeclUse extends DeclUseBaseListener {

    private SymbolTable symbolTable = new MySymbolTable();
    private List<String> errors = new ArrayList<>();

    @Override
    public void enterSeries(DeclUseParser.SeriesContext context) {
        symbolTable.openScope();
    }

    @Override
    public void exitSeries(DeclUseParser.SeriesContext context) {
        symbolTable.closeScope();
    }

    @Override
    public void enterDecl(DeclUseParser.DeclContext context) {
        if (!symbolTable.add(context.getText().substring(2))) {
            errors.add("Couldn't add the variable on line " + context.ID().getSymbol().getLine() + ", position " + context.ID().getSymbol().getCharPositionInLine());
        }
    }

    @Override
    public void enterUse(DeclUseParser.UseContext context) {
        if (!symbolTable.contains(context.getText().substring(2))) {
            errors.add("Couldn't use the variable on line " + context.ID().getSymbol().getLine() + ", position " + context.ID().getSymbol().getCharPositionInLine());
        }
    }

    public List getErrors() {
        return errors;
    }

}
