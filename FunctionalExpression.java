public class FunctionalExpression extends Expression {
    private String id;
    private Args args;

    public FunctionalExpression(String id) {
        this.id = id;
        this.args = new Args();
    }

    public FunctionalExpression(String id, Args args) {
        this.id = id;
        this.args = args;
    }

    public String toString(int t) {
        return "(" + id + "(" + args.toString(0) + "))";
    }

    @Override
    public Type getType() throws ParseException {
        MethodType mt = symbolTable.getMethod(id, args.getTypes());
        if (mt == null) {
            throw new ExpressionException(this, "Method " + id + " not found");
        }
        return mt.getReturnType();
    }
}
