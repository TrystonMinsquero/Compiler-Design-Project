public class AssignStatement extends Statement {
    private Name name;
    private Expression expr;

    public AssignStatement(Name n, Expression e) {
        name = n;
        expr = e;
    }

    public AssignStatement(String n, Expression e) {
        name = new Name(n);
        expr = e;
    }

    public String toString(int t) {
        return getTabs(t) + name.toString(0) + " = " + expr.toString(0) + ";\n"; 
    }

    @Override
    public void analyzeType() throws ParseException {
        Type type = symbolTable.get(name.getId());
        if(type == null) {
            throw new StatementException(this, "Variable " + name.getId() + " not found");
        }
        if(type.isFinal())
            throw new StatementException(this, "Variable " + name.getId() + " is final");
        if(!expr.getType().isImplictly(type)) {
            throw new StatementException(this, "Variable " + name.getId() + " cannot be coerced to " + expr.getType());
        }
    }
}
