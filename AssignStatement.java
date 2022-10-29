public class AssignStatement extends Statement {
    private Name name;
    private Expression expr;

    public AssignStatement(Name n, Expression e) {
        name = n;
        expr = e;
    }

    public String toString(int t) {
        return getTabs(t) + name.toString(0) + " = " + expr.toString(0) + ";\n"; }
}
