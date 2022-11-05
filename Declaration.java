public abstract class Declaration extends Token{
    protected String type;
    protected String id;

    public Declaration(String type, String id) {
        this.type = type;
        this.id = id;
    }

}
