public class UnaryExpression extends Expression {
    
    private String op;
    private Expression expr;

    public UnaryExpression(String op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public String toString(int t) {
        return "(" + op + expr.toString(0) + ")";
    }
    
}
