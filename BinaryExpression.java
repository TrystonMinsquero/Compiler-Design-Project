public class BinaryExpression {
    private String op;
    private Expression e1;
    private Expression e2;

    public BinaryExpression(String operator, Expression e1, Expression e2) {
        this.op = operator;
        this.e1 = e1;
        this.e2 = e2;
    }

    public String toString(int t) {
        return "(" + e1.toString(0) + " " + op + " " + e2.toString(0) + ")";
    }
}
