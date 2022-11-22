public class FloatLiteralExpression extends LiteralExpression {
    private Float floatValue;

    public FloatLiteralExpression(String s, String type) {
        super(s, type);
    }

    public FloatLiteralExpression(Float f) {
        super(String.valueOf(f), "float");
        floatValue = f;
    }

    public float getValue() {
        return floatValue.floatValue();
    }
    
}
