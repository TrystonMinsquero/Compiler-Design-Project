public class MethodDeclarations extends Declarations{

    public String toString(int t) {
        String ret = getTabs(t) + "Methods:\n";
        for(Declaration d : declerations)
            ret += d.toString(t+1);
        return ret;
    }
}
