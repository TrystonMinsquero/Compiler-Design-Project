public abstract class Declaration extends Token{
    protected String type;
    protected String name;

    public Declaration(String type, String name) {
        this.type = type;
        this.name = name;
    }

}
