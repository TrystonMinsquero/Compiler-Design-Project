class Program extends Token {
    private Class clas;

    //Constructor
    public Program(Class c) {
        clas = c;
    }
  
    public String toString(int t) {
      return "Program:\n" + clas.toString(t+1) + "\n";
    }
  }