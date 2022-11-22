public class MethodDeclaration extends Declaration{
    
    protected ArgDeclarations argDeclarations;
    protected FieldDeclarations fieldDeclarations;
    protected Statements statements;
    protected String optionalSemi;
    
    public MethodDeclaration(String returnType, String id, ArgDeclarations argDeclarations, FieldDeclarations fieldDeclarations, Statements statements, String optionalSemi) {
        super(returnType, id);
        this.argDeclarations = argDeclarations;
        this.fieldDeclarations = fieldDeclarations;
        this.statements = statements;
        this.optionalSemi = optionalSemi;
    }

    // public MethodDeclaration(String returnType, String id, MethodEnd methodRecord) {
    //     super(returnType, id);
    //     this.argDeclarations = methodRecord.args();
    //     this.fieldDeclarations = methodRecord.fields();
    //     this.statements = methodRecord.statements();
    //     this.optionalSemi = methodRecord.optionalSemi();
    // }

    public String toString(int t) {
        String ret = getTabs(t) + type + " " + name + "(" + argDeclarations.toString(0) + ") {\n";
        ret += fieldDeclarations.toString(t+1);
        ret += statements.toString(t+1);
        ret += getTabs(t) + "}" + optionalSemi + "\n";
        return ret;
    }

    @Override
    public Type getType() throws ParseException {
        return new MethodType(Type.parseTypeEnum(type), argDeclarations.getArgs());
    }

    @Override
    public void analyzeType() throws ParseException {
        symbolTable.addSymbol(name, getType());        
        symbolTable.startScope();
        argDeclarations.analyzeType();
        fieldDeclarations.analyzeType();
        statements.analyzeType();
        checkReturnStatements();


        symbolTable.endScope();
    }

    private void checkReturnStatements() throws ParseException {
        Type returnType = ((MethodType)getType()).getReturnType();
        Type evaluatedReturnType = statements.evaluateReturnType(returnType);
        if (evaluatedReturnType == null && !returnType.isVoid()) {
            throw new DeclarationException(this, "Missing return statement");
        }
        if (evaluatedReturnType != null && !evaluatedReturnType.isImplictly(returnType)) {
            throw new DeclarationException(this, "Return type (" + evaluatedReturnType.toString() + ") does not match method type (" + returnType.toString() + ")");
        }
        
    }
}
