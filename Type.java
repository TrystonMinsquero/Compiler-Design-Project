public class Type {
    private TypeEnum typeEnum;
    private boolean isFinal;
    private int arraySize = -1;

    public static final Type INT = new Type(TypeEnum.INT);
    public static final Type FLOAT = new Type(TypeEnum.FLOAT);
    public static final Type BOOL = new Type(TypeEnum.BOOL);
    public static final Type STRING = new Type(TypeEnum.STRING);
    public static final Type VOID = new Type(TypeEnum.VOID);
    
    //#region Constructors

    public Type(TypeEnum type) {
        this.typeEnum = type;
        this.isFinal = false;
        this.arraySize = -1;
    }

    public Type(TypeEnum type, boolean isFinal) {
        this.typeEnum = type;
        this.isFinal = isFinal;
        this.arraySize = -1;
    }
    
    public Type(TypeEnum type, int arraySize) {
        this.typeEnum = type;
        this.isFinal = false;
        this.arraySize = arraySize;
    }

    //#endregion

    //#region Getters
    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isArray() {
        return arraySize >= 0;
    }

    public int getArraySize() {
        return arraySize;
    }

    public boolean isMethod() {
        return typeEnum == TypeEnum.METHOD;
    }

    public MethodType getMethodType() {
        return (MethodType) this;
    }

    public boolean isNumeric() {
        return (typeEnum == TypeEnum.INT || typeEnum == TypeEnum.FLOAT) && !isArray();
    }

    public boolean isBoolean() {
        return typeEnum == TypeEnum.BOOL && !isArray();
    }

    public boolean isString() {
        return typeEnum == TypeEnum.STRING && !isArray();
    }

    public boolean isPrimitive() {
        return typeEnum != TypeEnum.METHOD && typeEnum != TypeEnum.VOID && !isArray();
    }

    public boolean isVoid() {
        return typeEnum == TypeEnum.VOID && !isArray();
    }

    public boolean isInt() {
        return typeEnum == TypeEnum.INT && !isArray();
    }

    public boolean isFloat() {
        return typeEnum == TypeEnum.FLOAT && !isArray();
    }

//#endregion

    public static TypeEnum parseTypeEnum(String typeString) throws ParseException {
        try {
            return TypeEnum.valueOf(typeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ParseException("Unknown type: " + typeString);
        }
    }

    public static Type parseType(String typeString) throws ParseException {
        return new Type(parseTypeEnum(typeString));
    }

    public boolean equalsType(Type t) {
        return this.typeEnum == t.typeEnum && !(this.isArray() ^ t.isArray());
    }

    public boolean isImplictly(TypeEnum targetTypeEnum) {
        return isImplictly(new Type(targetTypeEnum));
    }

    public boolean isImplictly(Type targetType) {
        if (this.equalsType(targetType))
            return true;
        if (this.isInt() && targetType.isFloat())
            return true;
        if(targetType.isString() && !this.isArray())
            return true;
        return false;
    }

    @Override
    public String toString() {
        if (isArray())
            return typeEnum.toString() + "[]";
        return typeEnum.toString();
    }

}
