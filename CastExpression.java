public class CastExpression extends Expression{
    private String type;
    private Expression expr;

    public CastExpression(String type, Expression expr) {
        this.type = type;
        this.expr = expr;
    }
        
    public String toString(int t) {
        return "((" + type + ")" + expr.toString(0) + ")";
    }

    @Override
    public Type getType() throws ParseException {
        Type t = Type.parseType(type);
        if(t.isPrimitive())
            return t;
        else
            throw new ExpressionException(this, "Cannot cast to " + type);
    }
}
