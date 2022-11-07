class Program extends Token {
    private String classID;
    private FieldDeclarations fields;
    private MethodDeclarations methods;


    //Constructor
    public Program(String className, FieldDeclarations fields, MethodDeclarations methods) {
        classID = className;
        this.fields = fields;
        this.methods = methods;
    }
  
    public String toString(int t) {
        String ret = getTabs(t) + "class " + classID + " {\n";
        ret += fields.toString(t+1);
        ret += methods.toString(t+1);
        ret += "}\n";
        return ret;
    }
  }