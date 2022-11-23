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
        System.out.println("NameLiteralExpression: " + name.toString() + " " + t.toString());
        
        return t; // make it no longer an array
    }
    
}
