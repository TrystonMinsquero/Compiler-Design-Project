public class ReadStatement extends Statement{
    private NameArgs names;

    public ReadStatement(NameArgs n) {
        names = n;
    }

    public String toString(int t) {
        return getTabs(t) + "read(" + names.toString(0) + ");\n";
    }
}
