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

    public String toString(int t) {
        String ret = getTabs(t) + type + " " + id + "(" + argDeclarations.toString(0) + ") {\n";
        ret += fieldDeclarations.toString(t+1);
        ret += statements.toString(t+1);
        ret += getTabs(t) + "}" + optionalSemi + "\n";
        return ret;
    }
}
