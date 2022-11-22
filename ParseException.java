public class ParseException extends Exception {
    protected String error;
    protected SymbolTable symbolTable;
    
    public ParseException(String message) {
        error = message;
        symbolTable = null;
    }

    public ParseException(String message, SymbolTable st) {
      error = message;
      symbolTable = st;
  }

    public String toString()
    {
      if(symbolTable == null)
        return error;

      String s = error + "\nSymbol Table:\n";
      s += symbolTable.toString();
      return s;
    }
}
