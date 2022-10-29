public class AssignStatement extends Statement {
    private Name id_name;
    private Expression expr;

    public AssignStatement(Name n, Expression e) {
        id_name = n;
        expr = e;
    }

    public String toString(int t) {
        return getTabs(t) + id_name + " = " + expr.toString(0) + ";\n"; }
}
