public class LiteralExpression extends Expression{
    private String value;
    private String type;

    public LiteralExpression(int i) {
        this.value = String.valueOf(i);
        this.type = "int";
    }

    public LiteralExpression(float f) {
        this.value = String.valueOf(f);
        this.type = "float";
    }

    public LiteralExpression(boolean b) {
        this.value = String.valueOf(b);
        this.type = "bool";
    }

    public LiteralExpression(char c) {
        this.value = String.valueOf(c);
        this.type = "char";
    }

    public LiteralExpression(String s, String type) {
        this.value = s;
        this.type = type;
    }


    public String toString(int t) {
        return value;
    }
}
