import java.util.LinkedHashMap;

public class ArgDeclarations extends Declarations{

    public ArgDeclarations(ArgDeclaration ad) {
        super(ad);
    }

    public ArgDeclarations() {
        super();
    }

    public LinkedHashMap<String, Type> getArgs() throws ParseException {
        LinkedHashMap<String, Type> args = new LinkedHashMap<String, Type>();
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
