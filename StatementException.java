public class StatementException extends ParseException {
    protected Statement statement;

    public StatementException(Statement s, String message) {
        super(message);
        statement = s;
    }

    @Override
    public String toString() {
        return error + " in statement " + statement.toString(0);
    }   
}
