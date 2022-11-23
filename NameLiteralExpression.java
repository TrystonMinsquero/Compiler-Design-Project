public class NameLiteralExpression extends LiteralExpression{

    private Name name;

    public NameLiteralExpression(Name n) {
        super(n.getId(), "variable");
        name = n;
    }

    @Override
    public Type getType() throws ParseException {
        Type t = name.getType();
        if (t == null) {
            throw new ExpressionException(this, "Symbol " + name.getId() + " is not defined");
        }
        if(name.getIndexExpr() == null) {
            return t;
        }
        if(!t.isArray()) {
            throw new ParseException("Variable is " + name.getId() + " not an array (is " + t.toString() + ")" , symbolTable);
        }
        if(!name.getIndexExpr().getType().isImplictly(Type.INT)) {
            throw new ExpressionException(this, "Array index must be an integer");
        }
        return new Type(t.getTypeEnum()); // make it no longer an array
    }
    
}
