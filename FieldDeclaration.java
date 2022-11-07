public class FieldDeclaration extends Declaration {
    // cannot be final if array decleration
    private String optionalFinal; // either "final " or ""
    
    // expression is null if array decleration
    // otherwise it is the expression to initialize the field
    private Expression optionalExpression;

    // expression is null if regular variable decleration
    // otherwise it is the int that is the size of the array
    private IntLiteralExpression optionalIntLiteralExpression;

    public FieldDeclaration(String type, String id, String optionalFinal, Expression optionalExpression) {
        super(type, id);
        this.optionalFinal = optionalFinal + " "; // add space to make toString easier
        this.optionalExpression = optionalExpression;
        optionalIntLiteralExpression = null;
    }

    public FieldDeclaration(String type, String id, IntLiteralExpression optionalIntLiteralExpression) {
        super(type, id);
        this.optionalIntLiteralExpression = optionalIntLiteralExpression;
        optionalFinal = "";
        optionalExpression = null;
    }

    public String toString(int t) {
        String s = getTabs(t) + optionalFinal + type + " " + name;
        if(optionalIntLiteralExpression != null) {
            s += " [ " + optionalIntLiteralExpression.toString(0) + " ]";
        }
        else if (optionalExpression != null) {
            s += " = " + optionalExpression.toString(0);
        }
        return s + ";\n";
    }
}