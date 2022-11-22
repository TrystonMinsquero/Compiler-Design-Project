import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SymbolTable {
    LinkedList<HashMap<String, Type>> table;

    public SymbolTable() {
        table = new LinkedList<HashMap<String, Type>>();
    }

    public void startScope() {
        table.addFirst(new HashMap<String, Type>());
    }

    public void endScope() {
        table.removeFirst();
    }

    public void addSymbol(String s, Type t) throws ParseException {
        if (table.getFirst().containsKey(s)) {
            throw new ParseException("Symbol " + s + " already defined");
        }
        table.getFirst().put(s, t);
    }

    public Type get(String s) throws ParseException {
        for (HashMap<String, Type> map : table) {
            if (map.containsKey(s)) {
                return map.get(s);
            }
        }
        throw new ParseException("Symbol " + s + " not found");
    }

    public MethodType getMethod(String s, List<Type> args) throws ParseException {
        for (HashMap<String, Type> map : table) {
            if (map.containsKey(s) && map.get(s).isMethod()) {
                if (map.get(s) instanceof MethodType) {
                    MethodType methodType = (MethodType) map.get(s);
                    if (methodType.checkArgs(args)) {
                        return methodType;
                    }
                }
            }
        }
        throw new ParseException("Method " + s + " not found with given arguments");
    }
    
    public TypeEnum getReturnType() throws ParseException {
        TypeEnum returnType = null;
        for(Type value : table.getFirst().values()) {
            if(returnType != null && value.getTypeEnum() == TypeEnum.METHOD) {
                throw new ParseException("Two methods in the same scope");
            }
            if(value.getTypeEnum() == TypeEnum.METHOD) {
                returnType = ((MethodType)value).getReturnTypeEnum();
            }
        }
        throw new ParseException("Not in a method");
    }
}
