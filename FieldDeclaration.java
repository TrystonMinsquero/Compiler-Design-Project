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
        this.optionalFinal = optionalFinal != "" ? optionalFinal + " " : ""; // add space to make toString easier
        this.optionalExpression = optionalExpression;
        optionalIntLiteralExpression = null;
    }

    // public FieldDeclaration(String type, String id, String optionalFinal, FieldEnd fieldRecord) {
    //     super(type, id);
    //     this.optionalFinal = optionalFinal == "" ? optionalFinal + " " : ""; // add space to make toString easier
    //     this.optionalExpression = fieldRecord.optionalExpression();
    //     optionalIntLiteralExpression = fieldRecord.optionalIntLiteralExpression();
    // }


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

    @Override
    public void analyzeType() throws ParseException {
        if(optionalIntLiteralExpression != null) {
            optionalIntLiteralExpression.analyzeType();
            if(!optionalIntLiteralExpression.getType().equals(Type.INT)) {
                throw new DeclarationException(this, "Array size must be an int (is " + optionalIntLiteralExpression.getType() + ")");
            }
            symbolTable.addSymbol(name, getType());
            return;
        }
        else if(optionalExpression != null) {
            optionalExpression.analyzeType();
            if(!optionalExpression.getType().equals(Type.parseType(type))) {
                throw new DeclarationException(this, "Type mismatch");
            }
        }
        symbolTable.addSymbol(name, getType());
    }

    @Override
    public Type getType() throws ParseException {
        if(optionalIntLiteralExpression != null) {
            return new Type(Type.parseTypeEnum(type), optionalIntLiteralExpression.getValue());
        }
        else {
            return new Type(Type.parseTypeEnum(type), optionalFinal != "");
        }
    }
}