public class Class extends Token {
    protected String id;
    protected FieldDeclarations fields;
    protected MethodDeclarations methods;
    
    public Class(String id, FieldDeclarations fields, MethodDeclarations methods) {
        this.id = id;
        this.fields = fields;
        this.methods = methods;
    }

    public String toString(int t) {
        String ret = getTabs(t) + "class " + id + " {\n";
        ret += fields.toString(t+1);
        ret += methods.toString(t+1);
        ret += "}\n";
        return ret;
    }
}