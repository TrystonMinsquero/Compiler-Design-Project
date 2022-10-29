public class AssignStatement extends Statement {
    private String name;
    private Expression expr;

    public AssignStatement(Name n, Expression e) {
        name = n.toString(0);
        expr = e;
    }

    public AssignStatement(String n, Expression e) {
        name = n;
        expr = e;
    }

    public String toString(int t) {
        return getTabs(t) + name + " = " + expr.toString(0) + ";\n"; }
}
