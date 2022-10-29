public class WhileStatement extends Statement {
    private Expression condition;
    private Statements statements;

    public WhileStatement(Expression e, Statements s) {
        condition = e;
        statements = s;
    }

    public String toString(int t) {
        return getTabs(t) + "while (" + condition.toString(0) + ") {\n" +
            statements.toString(t+1) 
            + getTabs(t) + "}\n";
    }
}
