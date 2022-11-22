public class ArgDeclaration extends Declaration {
    private boolean isArray;

    public ArgDeclaration(String type, String id) {
        super(type, id);
        isArray = false;
    }

    public ArgDeclaration(String type, String id, boolean isArray) {
        super(type, id);
        this.isArray = isArray;
    }

    public String toString(int t) {
        return type + " " + name + (isArray ? "[]" : "");
    }

    @Override
    public void analyzeType() throws ParseException {
        if (getType() == null) {
            throw new ParseException("Undefined type");
        }
        symbolTable.addSymbol(name, getType());
    }

    @Override
    public Type getType() throws ParseException {
        return new Type(Type.parseTypeEnum(type), isArray);
    }
    
}
