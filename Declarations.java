import java.util.LinkedList;
import java.util.List;

public abstract class Declarations extends Token{

    protected List<Declaration> declerations;
    
    public Declarations() {
        declerations = new LinkedList<Declaration>();
    }

    public Declarations(Declaration d) {
        declerations = new LinkedList<Declaration>();
        declerations.add( d);
    }

    public Declarations prepend(Declaration d) {
        declerations.add(0, d);
        return this;
    }

    public Declarations prepend(Declarations d) {
        for(Declaration dec : d.declerations)
            declerations.add(0, dec);
        return this;
    }
    
    public String toString(int t) {
        String ret = "";
        boolean printedFields = false;
        boolean printedMethods = false;
        for(Declaration d : declerations) {
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
    
}