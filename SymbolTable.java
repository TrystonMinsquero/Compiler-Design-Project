import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
        throw new ParseException("Method " + s + " not found with given arguments\n"
                + "Arguments: " + Arrays.toString(args.toArray()));
    }
    
    public TypeEnum getReturnType() throws ParseException {
        for (HashMap<String, Type> map : table) {
            for(Type t : map.values()) {
                if(t.isMethod()) {
                    return t.getMethodType().getReturnTypeEnum();
                }
            }
        }
        throw new ParseException("Not in a method");
    }

    @Override
    public String toString() {
        String s = "";
        int i = 0;
        Iterator<HashMap<String, Type>> it = table.descendingIterator();
        while (it.hasNext()) {
            s += getTabs(i) + "Scope " + i + ":\n";
            HashMap<String, Type> map = it.next();
            for (String key : map.keySet()) {
                s += getTabs(i+1) + key + " : " + map.get(key) + "\n";
            }
            i++;
        }
        return s;
    }

    private String getTabs(int i) {
        String s = "";
        for(int j = 0; j < i; j++) {
            s += "\t";
        }
        return s;
    }
}
