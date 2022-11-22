public class ReturnStatement extends Statement {
    private Expression expr;

    public ReturnStatement() {
        expr = null;
    }

    public ReturnStatement(Expression expr) {
        this.expr = expr;
    }

    public String toString(int t) {
        if (expr == null) {
            return getTabs(t) + "return;\n";
        } else {
            return getTabs(t) + "return " + expr.toString(0) + ";\n";
        }
    }

    @Override
    public void analyzeType() throws ParseException {
        TypeEnum returnType = symbolTable.getReturnType();
        if (returnType == null) {
            throw new StatementException(this,"Return statement outside of function");
        }
        if (returnType == TypeEnum.VOID && expr != null) {
            throw new StatementException(this, "Return statement with expression in void function");
        }
        if (returnType != TypeEnum.VOID && expr == null) {
            throw new StatementException(this, "Return statement without expression in non-void function");
        }
        if (expr != null) {
            expr.analyzeType();
            if (!expr.getType().isImplictly(returnType)) {
                throw new StatementException(this, "Return type " + expr.getType() + " does not match function return type " + returnType);
            }
        }
    }
}