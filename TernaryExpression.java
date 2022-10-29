public class TernaryExpression extends Expression{
    private Expression condition;
    private Expression trueExpr;
    private Expression falseExpr;

    public TernaryExpression(Expression condition, Expression trueExpr, Expression falseExpr) {
        this.condition = condition;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
    }

    public String toString(int t) {
        return "(" + condition.toString(0) + " ? " + trueExpr.toString(0) + " : " + falseExpr.toString(0) + ")";
    }
}
