public class LiteralExpression extends Expression{
    private String value;
    private String type;

    public LiteralExpression(String s, String type) {
        this.value = s;
        this.type = type;
    }

    public String toString(int t) {
        return value;
    }
}
