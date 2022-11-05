public class ArgDeclarations extends Declarations{
    public String toString(int t) {
        String ret = "";
        for(Declaration d : declerations)
            ret += d.toString(0) + ", ";

        return ret.substring(0, ret.length()-2);
    }
}
