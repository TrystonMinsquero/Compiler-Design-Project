public record MethodEnd(
    ArgDeclarations args, 
    FieldDeclarations fields, 
    Statements statements, 
    String optionalSemi) 
    {}
