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

FILE=    Lexer.java      parser.java    sym.java \
    LexerTest.java

run: basicFails.txt basicTerminals.txt basicRegex.txt

all: Lexer.java parser.java $(FILE:java=class)

basicTerminals.txt: all
		$(JAVA) -cp $(CP) LexerTest basicTerminals.txt > basicTerminals-output.txt
		cat -n basicTerminals.txt
		cat -n basicTerminals-output.txt
		
basicFails.txt: all
		$(JAVA) -cp $(CP) LexerTest basicFails.txt > basicFails-output.txt
		cat -n basicFails.txt
		cat -n basicFails-output.txt

basicRegex.txt: all
		$(JAVA) -cp $(CP) LexerTest basicRegex.txt > basicRegex-output.txt
		cat -n basicRegex.txt
		cat -n basicRegex-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
