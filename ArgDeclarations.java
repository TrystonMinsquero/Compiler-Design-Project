import java.util.HashMap;

public class ArgDeclarations extends Declarations{

    public ArgDeclarations(ArgDeclaration ad) {
        super(ad);
    }

    public ArgDeclarations() {
        super();
    }

    public HashMap<String, Type> getArgs() throws ParseException {
        HashMap<String, Type> args = new HashMap<String, Type>();
        for (Declaration d : declarations) {
            args.put(d.getName(), d.getType());
        }
        return args;
    }

    public String toString(int t) {
        String ret = "";
        for(Declaration d : declarations)
            ret += d.toString(0) + ", ";
        if(ret.length() > 0)
            return ret.substring(0, ret.length()-2);
        return ret;
    }
}
