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

    @Override
    public Type getType() throws ParseException {
        if(!condition.getType().isImplictly(Type.BOOL))
            throw new ExpressionException(this, condition.toString(0) + " is not boolean");
        Type t1 = trueExpr.getType();
        Type t2 = falseExpr.getType();
        if(t1.isImplictly(t2))
            return t2;
        else if(t2.isImplictly(t1))
            return t1;
        else
            throw new ExpressionException(this, "Type mismatch " + t1.toString() + " and " + t2.toString());
    }
}
