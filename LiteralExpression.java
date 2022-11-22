public class LiteralExpression extends Expression{
    protected String value;
    protected String type;

    public LiteralExpression(boolean b) {
        this.value = String.valueOf(b);
        this.type = "bool";
    }

    public LiteralExpression(String s, String type) {
        this.value = s;
        this.type = type;
    }

    public LiteralExpression(Name n) {
        this.value = n.getId();
        this.type = "variable";
    }

    public String toString(int t) {
        return "(" + value + ")";
    }
    
    @Override
    public Type getType() throws ParseException {
        if(type.equals("variable")) {
            Type t = symbolTable.get(value);
            if(t == null)
                throw new ExpressionException(this, "Variable " + value + " not found");
            return t;
        }
        return Type.parseType(type);
    }
}
