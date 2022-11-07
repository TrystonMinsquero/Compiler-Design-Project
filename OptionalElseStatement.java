public class OptionalElseStatement extends BlockStatement {

    public OptionalElseStatement() {
        super("");
    }

    public OptionalElseStatement(FieldDeclarations f, Statements s) {
        super("else", null, f, s);
    }

    @Override
    public String toString(int t) {
        return blockType == "" ? "" : super.toString(t);
    }
}
