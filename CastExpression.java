public class CastExpression {
    private String type;
    private Expression expr;

    public CastExpression(String type, Expression expr) {
        this.type = type;
        this.expr = expr;
    }
        
    public String toString(int t) {
        return "((" + type + ")" + expr.toString(0) + ")";
    }
}
