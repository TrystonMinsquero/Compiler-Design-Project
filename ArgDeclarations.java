public class ArgDeclarations extends Declarations{

    public ArgDeclarations(ArgDeclaration ad) {
        super(ad);
    }

    public ArgDeclarations() {
        super();
    }

    public String toString(int t) {
        String ret = "";
        for(Declaration d : declerations)
            ret += d.toString(0) + ", ";
        if(ret.length() > 0)
            return ret.substring(0, ret.length()-2);
        return ret;
    }
}
