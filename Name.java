public class Name extends Token{
    private String id;
    private String indexExpr;

    public Name(String id) {
        this.id = id;
        this.indexExpr = null;
    }

    public Name(String id, String indexExpr) {
        this.id = id;
        this.indexExpr = indexExpr;
    }

    public String toString(int t) {
        return indexExpr == null ? id : id + "[" + indexExpr + "]";
    }
}
