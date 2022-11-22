public abstract class Expression extends Token {
    
    @Override
    public void analyzeType() throws ParseException {
        Type type = getType();
        if (type == null)
            throw new ExpressionException(this, "Undefined type");
    }
    
    public abstract Type getType() throws ParseException;
}
