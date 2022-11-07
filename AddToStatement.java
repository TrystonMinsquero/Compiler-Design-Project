public class AddToStatement extends Statement{
    private Name name;
    private LiteralExpression expr;

    public AddToStatement(Name n, LiteralExpression e) {
        name = n;
        expr = e;
    }

    public AddToStatement(Name n, Integer num) {
        name = n;
        expr = new IntLiteralExpression(num);
    }
    
    public String toString(int t) {
        String s = getTabs(t) + name.toString(0);
        if(expr instanceof IntLiteralExpression) {
            int value = ((IntLiteralExpression)expr).getValue();
            switch(value) {
                case 1:
                    return s + "++;\n";
                case -1:
                    return s + "--;\n";
            }
        }
        return s + " += " + expr.toString(0) + ";\n";
    }
    
}
