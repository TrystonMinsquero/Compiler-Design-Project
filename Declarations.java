import java.util.LinkedList;
import java.util.List;

public abstract class Declarations extends Token{

    protected List<Declaration> declarations;
    
    public Declarations() {
        declarations = new LinkedList<Declaration>();
    }

    public Declarations(Declaration d) {
        declarations = new LinkedList<Declaration>();
        declarations.add( d);
    }

    public Declarations prepend(Declaration d) {
        declarations.add(0, d);
        return this;
    }

    public Declarations prepend(Declarations d) {
        for(Declaration dec : d.declarations)
            declarations.add(0, dec);
        return this;
    }
    
    public String toString(int t) {
        String ret = "";
        boolean printedFields = false;
        boolean printedMethods = false;
        for(Declaration d : declarations) {
            if(d instanceof FieldDeclaration) {
                if(!printedFields) {
                    ret += getTabs(t) + "Fields:\n";
                    printedFields = true;
                }
            } else if(d instanceof MethodDeclaration) {
                if(!printedMethods) {
                    ret += getTabs(t) + "Methods:\n";
                    printedMethods = true;
                }
            }
            ret += d.toString(t+1);
        }
        return ret;
    }

    public void analyzeType() throws ParseException {
        for(Declaration d : declarations)
            d.analyzeType();
    }
    
}