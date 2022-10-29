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
        this.value = n.toString(0);
        this.type = "variable";
    }

    public String toString(int t) {
        return value;
    }
}
