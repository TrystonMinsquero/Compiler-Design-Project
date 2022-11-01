public class OptionalElseStatement extends Statement {
    private Statements statements;

    public OptionalElseStatement() {
        statements = null;
    }

    public OptionalElseStatement(Statements s) {
        statements = s;
    }

    public String toString(int t) {
        return statements == null ? "" :
        getTabs(t) + "else {\n" + statements.toString(t+1) + getTabs(t) + "}\n";
    }
}
