import java.util.List;

public class PrintStatement extends CallStatement {
    private boolean newline;

    public PrintStatement(boolean n) {
        super("print" + (n ? "line" : ""));
        newline = n;
    }
    public PrintStatement(Args a, boolean n) {
        super("print" + (n ? "line" : ""), a);
        newline = n;
    }

    @Override
    public void analyzeType() throws ParseException {
        super.analyzeType();
        List<Expression> args = arguments.getArgs();
        if(newline == false && args.size() < 1) {
            throw new StatementException(this, "print() called with no arguments");
        }
        for (Expression expr : args) {
            Type t = expr.getType();
            if(t == null) {
                throw new StatementException(this, "Undefined type");
            }
            if(t.isArray()) {
                throw new StatementException(this, "Cannot print a non-dereferenced array");
            }
            if(t.isVoid()) {
                throw new StatementException(this, "Cannot print a void");
            }
            if(t.isMethod() && t.getMethodType().getReturnType().isVoid()) {
                throw new StatementException(this, "Cannot print a void");
            }
        }
    }

}
