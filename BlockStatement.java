public class BlockStatement extends Statement{
    private Statements statements;
    private String semiColon;

    public BlockStatement(String optionalSemiColon) {
        statements = new Statements();
        semiColon = optionalSemiColon;
    }

    public BlockStatement(Statements s, String optionalSemiColon) {
        statements = s;
        semiColon = optionalSemiColon;
    }

    public String toString(int t) {
        return getTabs(t) + "{\n" 
            + statements.toString(t+1) 
            + getTabs(t) + "}" + semiColon + "\n";
    }
}
