public class BinaryOperator extends Token {
    private String op;

    public BinaryOperator(String op) {
        this.op = op;
    }

    public String toString(int t) {
        return op;
    }
}
