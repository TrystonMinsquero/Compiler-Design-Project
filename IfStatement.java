public class IfStatement extends Statement {
    private Expression condition;
    private Statements statements;
    private OptionalElseStatement elseStatement;

    public IfStatement(Expression c, Statements s, OptionalElseStatement e) {
        condition = c;
        statements = s;
        elseStatement = e;
    }

    public String toString(int t) {
        return getTabs(t) + "if ( " + condition.toString(0) + " ) {\n" 
        + statements.toString(t+1)
        + getTabs(t) + "}\n" 
        + elseStatement.toString(t);
    }
}
