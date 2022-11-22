public class BlockStatement extends Statement{
    protected String blockType;
    protected Expression condition;
    protected FieldDeclarations fields;
    protected Statements statements;
    private String semiColon;

    public BlockStatement(String optionalSemiColon) {
        blockType = "";
        condition = null;
        fields = new FieldDeclarations();
        statements = new Statements();
        semiColon = optionalSemiColon;
    }

    public BlockStatement(FieldDeclarations f, Statements s, String optionalSemiColon) {
        blockType = "";
        condition = null;
        fields = f;
        statements = s;
        semiColon = optionalSemiColon;
    }

    public BlockStatement(String b, Expression c, FieldDeclarations f, Statements s, String optionalSemiColon) {
        blockType = b;
        condition = c;
        fields = f;
        statements = s;
        semiColon = optionalSemiColon;
    }

    public BlockStatement(String b, Expression c, FieldDeclarations f, Statements s) {
        blockType = b;
        condition = c;
        fields = f;
        statements = s;
        semiColon = "";
    }


    public BlockStatement(FieldDeclarations f, Statements s) {
        fields = f;
        statements = s;
        semiColon = "";
    }

    public String toString(int t) {
        String s = getTabs(t) + blockType 
            + (condition == null ? "" : "( " + condition.toString(0) + " )")
            + (blockType != "" ? " " : "" ) + "{\n"
            + fields.toString(t+1)
            + statements.toString(t+1)
            + getTabs(t) + "}" + semiColon + "\n";
        return s;
    }

    @Override
    public void analyzeType() throws ParseException {
        symbolTable.startScope();
        if (condition != null) {
            condition.analyzeType();
            if (condition.getType() != Type.BOOL) {
                throw new StatementException(this, "Condition must be boolean");
            }
        }
        fields.analyzeType();
        statements.analyzeType();
        symbolTable.endScope();

        
    }
}
