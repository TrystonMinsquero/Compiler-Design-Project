import java.util.LinkedList;
import java.util.List;

//StatementsList.java

class Statements extends Token {
    private List<Statement> statements;
    //Constructor
    public Statements() {
        statements = new LinkedList<Statement>();
    }

    public Statements prepend(Statement s) {
        statements.add(0, s);
        return this;
    }

    public Statements append(Statement s) {
        statements.add(s);
        return this;
    }
  
    public String toString(int t) {
      String s = /*getTabs(t) + "Statements:\n"*/ "";
      for (Statement st : statements)
        s = s + st.toString(t+1);
      return s;
    }

    @Override
    public void analyzeType() throws ParseException {
      for (Statement statement : statements) {
        statement.analyzeType();
      }
      
    }
  }