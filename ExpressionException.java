public class ExpressionException extends ParseException {
    
    protected Expression expression;
    public ExpressionException(String message) {
        super(message);
    }

    public ExpressionException(Expression e, String message) {
        super(message);
        expression = e;
    }

    @Override
    public String toString() {
        return error + " in expression " + expression.toString(0);
    }
    
}
