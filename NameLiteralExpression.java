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
        return t;
    }
    
}
