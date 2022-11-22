public abstract class Declaration extends Token{
    protected String type;
    protected String name;

    public Declaration(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Type getType() throws ParseException;

}
