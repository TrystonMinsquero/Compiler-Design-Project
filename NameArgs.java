import java.util.LinkedList;
import java.util.List;

public class NameArgs extends Token {
    private List<Name> args;

    public NameArgs(List<Name> args) {
        this.args = args;
    }

    public NameArgs() {
        args = new LinkedList<Name>();
    }

    public NameArgs(Name n) {
        args = new LinkedList<Name>();
        args.add(n);
    }

    public NameArgs prepend(Name n) {
        args.add(0, n);
        return this;
    }

    public String toString(int t) {
        String s = "";
        for(Name n : args) {
            s += n.toString(0) + ", ";
        }
        // Remove the last comma and space
        if(s.length() > 0) {
            s = s.substring(0, s.length() - 2);
        }
        return s;
    }

    @Override
    public void analyzeType() throws ParseException {
        for (Name name : args) {
            name.analyzeType();
            Type t = name.getType();
            if(t.isFinal()) {
                throw new StatementException("Cannot read a final variable");
            }
            if(t.isArray() && name.getIndexExpr() == null) {
                throw new StatementException("Cannot read a non-dereferenced array");
            }
            if(!t.isPrimitive()) {
                throw new StatementException("Cannot read a non-primitive (method) variable");
            }
        }
        
    }
}
