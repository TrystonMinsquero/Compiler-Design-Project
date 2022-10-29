public class LiteralExpression extends Expression{
    private String value;
    private String type;

    public LiteralExpression(boolean b) {
        this.value = String.valueOf(b);
        this.type = "bool";
    }

    public LiteralExpression(String s, String type) {
        this.value = s;
        this.type = type;
    }

    public String toString(int t) {
        return value;
    }
}
