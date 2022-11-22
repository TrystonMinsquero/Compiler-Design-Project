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
	AddToStatement.java BlockStatement.java ArgDeclaration.java \
	ArgDeclarations.java Declaration.java Declarations.java \
	FieldDeclaration.java FieldDeclarations.java MethodDeclaration.java \
	MethodDeclarations.java MemberDeclarations.java TypeEnum.java \
	TypeCheckingTest.java Type.java SymbolTable.java ParseException.java \
	MethodType.java ExpressionException.java DeclarationException.java

run: badLogic toThings redefining returns valid

all: Lexer.java parser.java $(FILE:java=class)

test.txt: all
		$(JAVA) -cp $(CP) TypeCheckingTest test.txt > test-output.txt
		cat test.txt
		cat -n test-output.txt

badLogic: all
		$(JAVA) -cp $(CP) TypeCheckingTest badDec.as > badDec-output.txt
		cat badDec.as
		cat -n badDec-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badInc.as > badInc-output.txt
		cat badInc.as
		cat -n badInc-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badNegation.as > badNegation-output.txt
		cat badNegation.as
		cat -n badNegation-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badString.as > badString-output.txt
		cat badString.as
		cat -n badString-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badTernaryCond.as > badTernaryCond-output.txt
		cat badTernaryCond.as
		cat -n badTernaryCond-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badTernaryTypes.as > badTernaryTypes-output.txt
		cat badTernaryTypes.as
		cat -n badTernaryTypes-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest incompatBinary.as > incompatBinary-output.txt
		cat incompatBinary.as
		cat -n incompatBinary-output.txt
		
	
toThings: all
		$(JAVA) -cp $(CP) TypeCheckingTest boolToFloat.as > boolToFloat-output.txt
		cat boolToFloat.as
		cat -n boolToFloat-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest boolToInt.as > boolToInt-output.txt
		cat boolToInt.as
		cat -n boolToInt-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest charToFloat.as > charToFloat-output.txt
		cat charToFloat.as
		cat -n charToFloat-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest charToInt.as > charToInt-output.txt
		cat charToInt.as
		cat -n charToInt-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest floatToInt.as > floatToInt-output.txt
		cat floatToInt.as
		cat -n floatToInt-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest intArrayToBoolArray.as > intArrayToBoolArray-output.txt
		cat intArrayToBoolArray.as
		cat -n intArrayToBoolArray-output.txt

		
redefines: all
		$(JAVA) -cp $(CP) TypeCheckingTest reassignFinal.as > reassignFinal-output.txt
		cat reassignFinal.as
		cat -n reassignFinal-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest redefMethod.as > redefMethod-output.txt
		cat redefMethod.as
		cat -n redefMethod-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest redefVar.as > redefVar-output.txt
		cat redefVar.as
		cat -n redefVar-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest redefVarAsMethod.as > redefVarAsMethod-output.txt
		cat redefVarAsMethod.as
		cat -n redefVarAsMethod-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest callNonExistFunc.as > callNonExistFunc-output.txt
		cat callNonExistFunc.as
		cat -n callNonExistFunc-output.txt


returns: all
		$(JAVA) -cp $(CP) TypeCheckingTest noReturn.as > noReturn-output.txt
		cat noReturn.as
		cat -n noReturn-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest returnTypeBad.as > returnTypeBad-output.txt
		cat returnTypeBad.as
		cat -n returnTypeBad-output.txt

valid: all
		$(JAVA) -cp $(CP) TypeCheckingTest fullValidProgram.as > fullValidProgram-output.txt
		cat fullValidProgram.as
		cat -n fullValidProgram-output.txt



# Part 2 Phase 2 Tests
# Phase2_empty.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase2_empty.txt > Phase2_empty-output.txt
# 		cat Phase2_empty.txt
# 		cat -n Phase2_empty-output.txt

# Phase2_fields.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase2_fields.txt > Phase2_fields-output.txt
# 		cat Phase2_fields.txt
# 		cat -n Phase2_fields-output.txt

# Phase2_full.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase2_full.txt > Phase2_full-output.txt
# 		cat Phase2_full.txt
# 		cat -n Phase2_full-output.txt

# Phase2_methods.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase2_methods.txt > Phase2_methods-output.txt
# 		cat Phase2_methods.txt
# 		cat -n Phase2_methods-output.txt

# Part 2 Phase 1 Tests
# Phase1_expressions.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase1_expressions.txt > Phase1_expressions-output.txt
# 		cat Phase1_expressions.txt
# 		cat -n output.txt

# Phase1_order_of_ops.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase1_order_of_ops.txt > Phase1_order_of_ops-output.txt
# 		cat Phase1_order_of_ops.txt
# 		cat -n output.txt

# Phase1_statements.txt: all
# 		$(JAVA) -cp $(CP) ScannerTest Phase1_statements.txt > Phase1_statements-output.txt
# 		cat Phase1_statements.txt
# 		cat -n output.txt

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
