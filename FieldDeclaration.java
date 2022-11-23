public class FieldDeclaration extends Declaration {
    // cannot be final if array decleration
    private String optionalFinal; // either "final " or ""
    
    // expression is null if array decleration
    // otherwise it is the expression to initialize the field
    private Expression optionalExpression;

    // expression is null if regular variable decleration
    // otherwise it is the int that is the size of the array
    private IntLiteralExpression optionalArraySizeExpr;

    public FieldDeclaration(String type, String id, String optionalFinal, Expression optionalExpression) {
        super(type, id);
        this.optionalFinal = optionalFinal != "" ? optionalFinal + " " : ""; // add space to make toString easier
        this.optionalExpression = optionalExpression;
        optionalArraySizeExpr = null;
    }

    // public FieldDeclaration(String type, String id, String optionalFinal, FieldEnd fieldRecord) {
    //     super(type, id);
    //     this.optionalFinal = optionalFinal == "" ? optionalFinal + " " : ""; // add space to make toString easier
    //     this.optionalExpression = fieldRecord.optionalExpression();
    //     optionalIntLiteralExpression = fieldRecord.optionalIntLiteralExpression();
    // }


    public FieldDeclaration(String type, String id, IntLiteralExpression optionalIntLiteralExpression) {
        super(type, id);
        this.optionalArraySizeExpr = optionalIntLiteralExpression;
        optionalFinal = "";
        optionalExpression = null;
    }

    public String toString(int t) {
        String s = getTabs(t) + optionalFinal + type + " " + name;
        if(optionalArraySizeExpr != null) {
            s += " [ " + optionalArraySizeExpr.toString(0) + " ]";
        }
        else if (optionalExpression != null) {
            s += " = " + optionalExpression.toString(0);
        }
        return s + ";\n";
    }

    @Override
    public void analyzeType() throws ParseException {
        Type t = getType();
        System.out.println("Got " + name + " " + t.toString());
        if(t != null)
            symbolTable.addSymbol(name, t);
    }

    @Override
    public Type getType() throws ParseException {
        
        TypeEnum typeEnum = Type.parseTypeEnum(type);
        if(optionalArraySizeExpr != null) { // is array
            optionalArraySizeExpr.analyzeType();
            Type t = optionalArraySizeExpr.getType();
            if(!t.isImplictly(Type.INT)) {
                throw new DeclarationException(this, "Array size must be an int (currently is " + t.toString() + ")");
            }
            if(optionalArraySizeExpr.getValue() < 0) {
                throw new DeclarationException(this, "Array size must be positive (currently is " + optionalArraySizeExpr.getValue() + ")");
            }
            return new Type(typeEnum, optionalArraySizeExpr.getValue());
        }
        else if(optionalExpression != null) {
            optionalExpression.analyzeType();
            if(!optionalExpression.getType().isImplictly(typeEnum)) {
                throw new DeclarationException(this, "Type mismatch with " + typeEnum.toString() + " and " + optionalExpression.getType().toString());
            }
        }
        return new Type(typeEnum, !optionalFinal.equals(""));
    }
}