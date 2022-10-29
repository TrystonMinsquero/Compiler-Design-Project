public class AssignStatement extends Statement {
    private String id;
    private Expression expr;

    public AssignStatement(String n, Expression e) {
        id = n;
        expr = e;
    }

    public String toString(int t) {
        return getTabs(t) + id + " = " + expr.toString(0) + ";\n"; }
}
