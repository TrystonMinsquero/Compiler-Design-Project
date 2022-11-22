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
        // return "(" + e1.toString(0) + " " + op + " " + e2.toString(0) + ")";
        return "(\n" + getTabs(t+1) + e1.toString(0) + " " + op + " " + e2.toString(0) + "\n" + getTabs(t) + ")\n";
    }

    @Override
    public Type getType() throws ParseException {
        Type t1 = e1.getType();
        Type t2 = e2.getType();
        switch(op) {
            case "+":
                if(t1.isString() && t2.isImplictly(Type.STRING))
                    return Type.STRING;
            case "-":
            case "*":
            case "/":
                if(t1.isImplictly(Type.INT) && t2.isImplictly(Type.INT))
                    return Type.INT;
                else if(t1.isImplictly(Type.FLOAT) || t2.isImplictly(Type.FLOAT))
                    return Type.FLOAT;
                throw new ExpressionException(this, "Type mismatch " + t1.toString() + " and " + t2.toString());
            case "<>":
            case "==":
            case "<":
            case ">":
            case "<=":
            case ">=":
                if(t1.isNumeric() && t2.isNumeric())
                    return Type.BOOL;
                throw new ExpressionException(this, "Type mismatch " + t1.toString() + " and " + t2.toString());
            case "&&":
            case "||":
                if(t1.isImplictly(Type.BOOL) && t2.isImplictly(Type.BOOL))
                    return Type.BOOL;
                throw new ExpressionException(this, "Type mismatch " + t1.toString() + " and " + t2.toString());
            default:
                throw new ExpressionException(this, "Unknown operator " + op);            
        }
    }
}
