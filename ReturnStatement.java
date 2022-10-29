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
}