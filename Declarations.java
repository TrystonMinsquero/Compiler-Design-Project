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
    
    public String toString(int t) {
        String ret = "";
        for(Declaration d : declerations)
            ret += d.toString(t+1);
        return ret;
    }
    
}