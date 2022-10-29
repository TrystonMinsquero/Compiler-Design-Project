public class FloatLiteralExpression extends LiteralExpression {

    public FloatLiteralExpression(String s, String type) {
        super(s, type);
    }

    public FloatLiteralExpression(Float f) {
        super(String.valueOf(f), "float");
    }
    
}
