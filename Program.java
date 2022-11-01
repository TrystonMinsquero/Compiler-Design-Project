//Program.java

class Program extends Token {
    private Statements statements;
    //Constructor
    public Program(Statements s) {
        statements = s;
    }
  
    public String toString(int t) {
      return "Program:\n" + statements.toString(t+1) + "\n";
    }
  }