abstract class Token {

    protected static SymbolTable symbolTable;

    protected String getTabs(int t)
    {
        String tabs = "";
        for (int i = 0; i < t; i++)
            tabs = tabs + "\t";
        return tabs;
    }
  
    public abstract String toString(int t);

    public abstract void analyzeType() throws ParseException;
  }