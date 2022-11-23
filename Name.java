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

    @Override
    public String toString() {
        return indexExpr == null ? id : id + "[" + indexExpr.toString(0) + "]";
    }

    public String getId() {
        return id;
    }

    public Expression getIndexExpr() {
        return indexExpr;
    }

    @Override
    public void analyzeType() throws ParseException {
        if (symbolTable.get(id) == null) {
            throw new ParseException("Undefined variable " + id);
        }
    }

    public Type getType() throws ParseException {
        Type t = symbolTable.get(id);
        if (t == null) {
            throw new ParseException("Undefined variable");
        }
        if(indexExpr != null) {
            if(!t.isArray()) {
                throw new ParseException("Variable " + id + " is not an array (is " + t.toString());
            }
            if(!indexExpr.getType().isImplictly(Type.INT)) {
                throw new ParseException("Array index must be an integer");
            }
            return new Type(t.getTypeEnum()); // make it no longer an array
        }
        return new Type(t.getTypeEnum());
    }
}
