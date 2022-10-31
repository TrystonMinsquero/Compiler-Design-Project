public class FunctionalExpression extends Expression {
    private String id;
    private Args args;

    public FunctionalExpression(String id) {
        this.id = id;
        this.args = new Args();
    }

    public FunctionalExpression(String id, Args args) {
        this.id = id;
        this.args = args;
    }

    public String toString(int t) {
        return "(" + id + "(" + args.toString(0) + "))";
    }

    
}
