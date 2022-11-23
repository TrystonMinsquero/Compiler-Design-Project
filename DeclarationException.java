public class DeclarationException extends ParseException {
    protected Declaration declaration;

    public DeclarationException(Declaration d, String message) {
        super(message);
        declaration = d;
    }

    @Override
    public String toString() {
        return error + " in declaration " + declaration.toString(0);
    }
    
}