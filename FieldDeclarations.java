class FieldDeclarations extends Declarations {
    public String toString(int t) {
        if(declerations.size() == 0) {
            return "";
        }
        String ret = getTabs(t) + "Fields:\n";
        for(Declaration d : declerations)
            ret += d.toString(t+1);
        return ret;
    }
}