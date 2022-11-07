public class IfStatement extends BlockStatement {
    private OptionalElseStatement elseStatement;

    public IfStatement(FieldDeclarations f, Statements s, Expression c, OptionalElseStatement e) {
        super(f, s);
        elseStatement = e;
    }

    @Override
    public String toString(int t) {
        return super.toString(t) + (elseStatement != null ? elseStatement.toString(t) : "");
    }
}
