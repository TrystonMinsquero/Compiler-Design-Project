public class AddToStatement extends Statement{
    private Name name;
    private LiteralExpression expr;

    public AddToStatement(Name n, LiteralExpression e) {
        name = n;
        expr = e;
    }
    
    public String toString(int t) {
        String s = getTabs(t) + name.toString(0);
        if(expr instanceof IntLiteralExpression) {
            int value = Integer.parseInt(expr.toString(0));
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
