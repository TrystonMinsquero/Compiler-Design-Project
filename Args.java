import java.util.LinkedList;
import java.util.List;

public class Args extends Token {
    private List<Expression> args;

    public Args(List<Expression> args) {
        this.args = args;
    }

    public Args() {
        args = new LinkedList<Expression>();
    }

    public Args(Expression e) {
        args = new LinkedList<Expression>();
        args.add(e);
    }

    public Args prepend(Expression e) {
        args.add(0, e);
        return this;
    }

    public String toString(int t) {
        String s = "";
        for(Expression e : args) {
            s += e.toString(0) + ", ";
        }
        // Remove the last comma and space
        if(s.length() > 0) {
            s = s.substring(0, s.length() - 2);
        }
        return s;
    }

    @Override
    public void analyzeType() throws ParseException {
        for (Expression e : args) {
            e.analyzeType();
        }
        
    }

    public List<Type> getTypes() throws ParseException {
        List<Type> types = new LinkedList<Type>();
        for (Expression e : args) {
            types.add(e.getType());
        }
        return types;
    }
}
