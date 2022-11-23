public class ParseException extends Exception {
    protected String error;
    
    public ParseException(String message) {
        error = message;
    }
    
    public String toString()
    {
      return error;
    }
}
