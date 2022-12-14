public class CallStatement extends Statement {
    protected String name;
    protected Args arguments;

    public CallStatement(String n) {
        name = n;
        arguments = new Args();
    }

    public CallStatement(String n, Args a) {
        name = n;
        arguments = a;
    }

    public String toString(int t) {
        return getTabs(t) + name + "(" + arguments.toString(0) + ");\n";
    }
}
