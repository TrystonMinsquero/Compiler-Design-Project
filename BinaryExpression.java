public class BinaryExpression extends Expression {
    private String op;
    private Expression e1;
    private Expression e2;

    public BinaryExpression(String operator, Expression e1, Expression e2) {
        this.op = operator;
        this.e1 = e1;
        this.e2 = e2;
    }

    public String toString(int t) {
        return "(" + e1.toString(0) + " " + op + " " + e2.toString(0) + ")";
    }

    @Override
    public Type getType() throws ParseException {
        if(op.equals("+"))
            if(e1.getType().isString() || e2.getType().isString())
                return Type.STRING;        
        if("+-*/".contains(op)){
            if(!e1.getType().isNumeric())
                throw new ExpressionException(this, e1.toString(0) + " is not numeric");
            if(!e2.getType().isNumeric())
                throw new ExpressionException(this, e2.toString(0) + " is not numeric");
            TypeEnum t1 = e1.getType().getTypeEnum();
            TypeEnum t2 = e2.getType().getTypeEnum();
            if (t1 == TypeEnum.INT && t2 == TypeEnum.INT) {
                return Type.INT;
            } else if (t1 == TypeEnum.FLOAT || t2 == TypeEnum.FLOAT) {
                return Type.FLOAT;
            }
        }
        if("==<>=".contains(op)) {
            if(e1.getType().isNumeric() && e2.getType().isNumeric())
                return Type.BOOL;
        }
        if("&&||".contains(op)) {
            if(e1.getType().isBoolean() && e2.getType().isBoolean())
                return Type.BOOL;
        }
        throw new ExpressionException(this, "Invalid operands for operator " + op);
    }
}
