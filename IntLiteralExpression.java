public class IntLiteralExpression extends LiteralExpression{

    public IntLiteralExpression(String s, String type) {
        super(s, type);
    }

    public IntLiteralExpression(Integer i) {
        super(String.valueOf(i), "int");
    }

}
