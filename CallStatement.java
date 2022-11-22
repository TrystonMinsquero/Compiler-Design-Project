import java.util.List;

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

    @Override
    public void analyzeType() throws ParseException {
        MethodType type = (MethodType) symbolTable.get(name);
        if (type == null) {
            throw new StatementException(this, "Method " + name + " not found");
        }
        List<Type> args = arguments.getTypes();
        if(type.checkArgs(args)) {
            throw new StatementException(this, "Method " + name + " called with wrong arguments");
        }
    }
}
