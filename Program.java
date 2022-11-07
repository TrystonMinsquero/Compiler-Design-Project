class Program extends Token {
    private String classID;
    private MemberDeclarations memberDeclerations;

    public Program(String className, MemberDeclarations memberDeclerations) {
        this.classID = className;
        this.memberDeclerations = memberDeclerations;
    }

    // //Constructor
    // public Program(String className, FieldDeclarations fields, MethodDeclarations methods) {
    //     classID = className;
    //     memberDeclerations = new MemberDeclarations(fields, methods);
    // }
  
    public String toString(int t) {
        String ret = getTabs(t) + "class " + classID + " {\n";
        ret += memberDeclerations.toString(t+1);
        ret += "}\n";
        return ret;
    }
  }