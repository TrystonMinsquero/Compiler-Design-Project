public class UnaryExpression extends Expression {
    
    private String op;
    private Expression expr;

    public UnaryExpression(String op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public String toString(int t) {
        return "(" + op + expr.toString(0) + ")";
    }

    @Override
    public Type getType() throws ParseException {
        if(op.equals("~")) {
            if(expr.getType().isImplictly(Type.BOOL))
                return Type.BOOL;
            throw new ExpressionException(this, expr.toString(0) + "cannot be coercised to a boolean");
        }
        else if (op.equals("+") || op.equals("-")) {
            if(!expr.getType().isNumeric())
                throw new ExpressionException(this, expr.toString(0) + " is not numeric");
            return expr.getType();
        }
        throw new ExpressionException(this, "Invalid operand for operator " + op);
            
    }
    
}
