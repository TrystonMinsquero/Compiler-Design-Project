public class IntLiteralExpression extends LiteralExpression{
    private Integer integer;

    public IntLiteralExpression(String s, String type) {
        super(s, type);
    }

    public IntLiteralExpression(Integer i) {
        super(String.valueOf(i), "int");
        integer = i;
    }

    public int getValue() {
        return integer.intValue();
    }

    @Override
    public Type getType() throws ParseException {
        return Type.INT;
    }

}
