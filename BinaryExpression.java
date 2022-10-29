public class BinaryExpression {
    private BinaryOperator op;
    private Expression e1;
    private Expression e2;

    public BinaryExpression(BinaryOperator operator, Expression e1, Expression e2) {
        this.op = operator;
        this.e1 = e1;
        this.e2 = e2;
    }

    public String toString(int t) {
        return "(" + e1.toString(0) + " " + op.toString(0) + " " + e2.toString(0) + ")";
    }
}
