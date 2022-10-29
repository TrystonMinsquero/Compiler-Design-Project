public class FunctionalExpression extends Expression {
    private String id;
    private Args args;

    public FunctionalExpression(String id) {
        this.id = id;
        this.args = null;
    }

    public FunctionalExpression(String id, Args args) {
        this.id = id;
        this.args = args;
    }

    public String toString(int t) {
        if (args == null) {
            return id + "()";
        } else {
            return id + "(" + args.toString(0) + ")";
        }
    }

    
}
