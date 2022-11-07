public class MemberDeclarations extends Declarations {
    // private FieldDeclarations fields;
    // private MethodDeclarations methods;

    // public MemberDeclarations() {
    //     fields = new FieldDeclarations();
    //     methods = new MethodDeclarations();
    // }

    // public MemberDeclarations(FieldDeclarations fields) {
    //     this.fields = fields;
    //     this.methods = new MethodDeclarations();
    // }

    // public MemberDeclarations(MethodDeclarations methods) {
    //     this.fields = new FieldDeclarations();
    //     this.methods = methods;
    // }

    // public MemberDeclarations(FieldDeclarations fields, MethodDeclarations methods) {
    //     this.fields = fields;
    //     this.methods = methods;
    // }

    // public MemberDeclarations prepend(FieldDeclaration field) {
    //     fields = (FieldDeclarations) fields.prepend(field);
    //     return this;
    // }

    // public MemberDeclarations prepend(MethodDeclaration method) {
    //     methods = (MethodDeclarations) methods.prepend(method);
    //     return this;
    // }

    // public MemberDeclarations prepend(MethodDeclarations methods) {
    //     methods = (MethodDeclarations) this.methods.prepend(methods);
    //     return this;
    // }

    // public MemberDeclarations prepend(FieldDeclarations fields) {
    //     fields = (FieldDeclarations) this.fields.prepend(fields);
    //     return this;
    // }

    public String toString(int t) {
        String ret = "";
        boolean printedFields = false;
        boolean printedMethods = false;
        for(Declaration d : declerations) {
            if(!printedFields && d instanceof FieldDeclaration) {
                ret += getTabs(t) + "Fields:\n";
                printedFields = true;
            }
            if(!printedMethods && d instanceof MethodDeclaration) {
                ret += getTabs(t) + "Methods:\n";
                printedMethods = true;
            }
            ret += d.toString(t+1);
        }
        return ret;
    }


}
