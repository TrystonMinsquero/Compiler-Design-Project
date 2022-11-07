public class IfStatement extends BlockStatement {
    private OptionalElseStatement elseStatement;

    public IfStatement(Expression c, FieldDeclarations f, Statements s, OptionalElseStatement e) {
        super("if", c, f, s);
        elseStatement = e;
    }

    @Override
    public String toString(int t) {
        return super.toString(t) + (elseStatement != null ? elseStatement.toString(t) : "");
    }
}
