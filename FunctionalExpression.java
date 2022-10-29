public class FunctionalExpression extends Expression {
    private String id;
    private Args args;

    public FunctionalExpression(Name id) {
        this.id = id.toString();
        this.args = null;
    }

    public FunctionalExpression(Name id, Args args) {
        this.id = id.toString();
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
