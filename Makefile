JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=	Lexer.java parser.java sym.java \
    LexerTest.java ScannerTest.java Token.java \
	Program.java Statements.java Statement.java \
	Expression.java UnaryExpression.java \
	BinaryExpression.java TernaryExpression.java \
	FunctionalExpression.java CastExpression.java \
	AssignStatement.java Args.java Name.java BinaryOperator.java\
	IntLiteralExpression.java FloatLiteralExpression.java \
	IfStatement.java OptionalElseStatement.java WhileStatement.java \
	CallStatement.java ReturnStatement.java NameArgs.java ReadStatement.java \
	AddToStatement.java BlockStatement.java Class.java ArgDeclaration.java \
	ArgDeclarations.java Declaration.java Declarations.java \
	FieldDeclaration.java FieldDeclarations.java MethodDeclaration.java \
	MethodDeclarations.java

run: Phase2_empty.txt

Phase2_empty.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase2_empty.txt > Phase2_empty-output.txt
		cat Phase2_empty.txt
		cat -n Phase2_empty-output.txt

Phase2_fields.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase2_fields.txt > Phase2_fields-output.txt
		cat Phase2_fields.txt
		cat -n Phase2_fields-output.txt

Phase2_full.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase2_full.txt > Phase2_full-output.txt
		cat Phase2_full.txt
		cat -n Phase2_full-output.txt

Phase2_methods.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase2_methods.txt > Phase2_methods-output.txt
		cat Phase2_methods.txt
		cat -n Phase2_methods-output.txt
		
Phase1_expressions.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_expressions.txt > Phase1_expressions-output.txt
		cat Phase1_expressions.txt
		cat -n output.txt

Phase1_order_of_ops.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_order_of_ops.txt > Phase1_order_of_ops-output.txt
		cat Phase1_order_of_ops.txt
		cat -n output.txt

Phase1_statements.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_statements.txt > Phase1_statements-output.txt
		cat Phase1_statements.txt
		cat -n output.txt

# Part 1 tests
# basicTerminals.txt: all
# 		$(JAVA) -cp $(CP) LexerTest basicTerminals.txt > basicTerminals-output.txt
# 		cat -n basicTerminals.txt
# 		cat -n basicTerminals-output.txt
		
# basicFails.txt: all
# 		$(JAVA) -cp $(CP) LexerTest basicFails.txt > basicFails-output.txt
# 		cat -n basicFails.txt
# 		cat -n basicFails-output.txt

# basicRegex.txt: all
# 		$(JAVA) -cp $(CP) LexerTest basicRegex.txt > basicRegex-output.txt
# 		cat -n basicRegex.txt
# 		cat -n basicRegex-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
