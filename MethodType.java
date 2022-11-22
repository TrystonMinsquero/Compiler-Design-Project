import java.util.HashMap;
import java.util.List;

public class MethodType extends Type {
    private TypeEnum returnTypeEnum;
    private HashMap<String, Type> paramTypes;

    public MethodType(TypeEnum type) {
        super(TypeEnum.METHOD);
        returnTypeEnum = type;
        paramTypes = new HashMap<String, Type>();
    }

    public MethodType(TypeEnum type, HashMap<String, Type> args) {
        super(TypeEnum.METHOD);
        returnTypeEnum = type;
        this.paramTypes = args;
    }

    public TypeEnum getReturnTypeEnum() {
        return returnTypeEnum;
    }

    public Type getReturnType() {
        return new Type(returnTypeEnum);
    }

    public boolean checkArgs(List<Type> args) {
        if (args.size() != paramTypes.size()) {
            return false;
        }
        int i = 0;
        for (Type t : paramTypes.values()) {
            if (!t.equals(args.get(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean equals(MethodType other) {
        if (returnTypeEnum != other.returnTypeEnum)
            return false;
        if (paramTypes.size() != other.paramTypes.size())
            return false;
        for (String key : paramTypes.keySet()) {
            if (!other.paramTypes.containsKey(key))
                return false;
            if (!paramTypes.get(key).equals(other.paramTypes.get(key)))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "(";
        for (Type t : paramTypes.values()) {
            s += t.toString() + ", ";
        }
        if(paramTypes.values().size() > 0) {
            s = s.substring(0, s.length() - 2);
        }
        s += ") -> " + returnTypeEnum.toString();
        return s;
    }

    
}
