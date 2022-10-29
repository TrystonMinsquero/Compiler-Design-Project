public class Name extends Token{
    private String id;
    private Expression indexExpr;

    public Name(String id) {
        this.id = id;
        this.indexExpr = null;
    }

    public Name(String id, Expression indexExpr) {
        this.id = id;
        this.indexExpr = indexExpr;
    }

    public String toString(int t) {
        return indexExpr == null ? id : id + "[" + indexExpr.toString(0) + "]";
    }
}
