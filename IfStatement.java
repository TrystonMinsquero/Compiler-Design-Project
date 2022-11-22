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

    @Override
    public Type evaluateReturnType(Type returnType) throws ParseException {
        Type type = super.evaluateReturnType(returnType);
        if (elseStatement != null) {
            Type elseType = elseStatement.evaluateReturnType(returnType);
            if (elseType != null && type != null) {
                return type;
            } else {
                return null;
            }
        }
        return null; // possibility of no return statement so return null
    }
}
