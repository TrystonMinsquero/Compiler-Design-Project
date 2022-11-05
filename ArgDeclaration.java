public class ArgDeclaration extends Declaration {

    public ArgDeclaration(String type, String id) {
        super(type, id);
    }

    public String toString(int t) {
        return type + " " + id;
    }
}
