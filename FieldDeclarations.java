class FieldDeclarations extends Declarations {
    public String toString(int t) {
        if(declarations.size() == 0) {
            return "";
        }
        String ret = /* getTabs(t) + "Fields:\n"*/ "";
        for(Declaration d : declarations)
            ret += d.toString(t+1);
        return ret;
    }
}