class Program extends Token {
    private Clas clas;

    //Constructor
    public Program(Clas c) {
        clas = c;
    }
  
    public String toString(int t) {
      return "Program:\n" + clas.toString(t+1) + "\n";
    }
  }