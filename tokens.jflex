/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.  Here the lexer is driven by the simple Java test
 * program in ./PascalLexerTest.java, q.v.  See 330 Lecture Notes 2 and the
 * Assignment 2 writeup for further discussion.
 *
 */


import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

%}


/*-*
 * PATTERN DEFINITIONS:
 */
 // any non-whitespace 
character = [[[^\n]&&[^\t]]&&[[[^\r]&&[^\\]]&&[[^\"]&&[^']]]]|\\n|\\t|\\r|\\\\|\\\"|\\'
 // any non-whitespace, non-comment
id = [a-zA-Z]+[0-9]*
intlit = [+|-]?[0-9]+
charlit = '{character}'
floatlit = [+|\-]?[0-9]+\.[0-9]+
stringlit = \"{character}*\"
whitespace = [ \n\t\r]
type = int|float|char|bool
comment = \\\*[^\*\\]*\*\\|\\\\.*


    
%%
/**
 * LEXICAL RULES:
 */
{comment}       {return newSym(sym.COMMENT);}
class           {return newSym(sym.CLASS, "class");}
//types
void     		{return newSym(sym.VOID, "void");}
int 	    	{return newSym(sym.INT, "int");}
float	    	{return newSym(sym.FLOAT, "float");}
bool	    	{return newSym(sym.BOOL, "bool");}
char	    	{return newSym(sym.CHAR, "char");}
final           {return newSym(sym.FINAL, "final");}
//flow
if              {return newSym(sym.IF, "if");}
else            {return newSym(sym.ELSE, "else");}
while           {return newSym(sym.WHILE, "while");}
//functions
return          {return newSym(sym.RETURN, "return");}
print           {return newSym(sym.PRINT, "print");}
printline       {return newSym(sym.PRINT, "printline");}
read            {return newSym(sym.READ, "read");}

"{"             {return newSym(sym.LBRACE);}
"}"             {return newSym(sym.RBRACE);}
";"             {return newSym(sym.SEMI, ";");}
"("             {return newSym(sym.LPAREN, "(");}
")"             {return newSym(sym.RPAREN, ")");}
"["             {return newSym(sym.LBRACKET, "[");}
"]"             {return newSym(sym.RBRACKET, "]");}



//operators
"*"             {return newSym(sym.ASTERISK, "*");}
"/"             {return newSym(sym.SLASH, "/");}
"+"             {return newSym(sym.PLUS, "+");}
"-"             {return newSym(sym.MINUS, "-");}
"<"             {return newSym(sym.LTHAN, "<");}
">"             {return newSym(sym.GTHAN, ">");}
"<="            {return newSym(sym.LTHANEQ, "<=");}
">="            {return newSym(sym.GTHANEQ, ">=");}
"=="            {return newSym(sym.EQUAL, "==");}
"<>"            {return newSym(sym.NOTEQUAL, "<>");}
"~"             {return newSym(sym.NOT, "~");}
"?"             {return newSym(sym.QUESTION, "?");}
"||"            {return newSym(sym.OR, "||");}
"&&"            {return newSym(sym.AND, "&&");}
"++"            {return newSym(sym.INCREMENT, "++");}
"--"            {return newSym(sym.DECREMENT, "--");}
"="             {return newSym(sym.ASSIGN, "=");}
":"             {return newSym(sym.COLON, ":");}
","             {return newSym(sym.COMMA, ",");}
true	    	{return newSym(sym.TRUE, "true"); }
false	    	{return newSym(sym.FALSE, "false");}

// "\\\*"          {return newSym(sym.COMMENTBEGIN, "\\\*");}
// "\*\\"          {return newSym(sym.COMMENTEND, "\*\\");}
{id}            {return newSym(sym.ID, yytext());}
{intlit}        {return newSym(sym.INTLIT, new Integer(yytext()));}
{floatlit}      {return newSym(sym.FLOATLIT, new Float(yytext()));}
{charlit}       {return newSym(sym.CHARLIT, yytext());}
{stringlit}     {return newSym(sym.STRINGLIT, yytext());}
{whitespace}    {/* ignore whitespace */}
.               { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); } 


// utd lang
// start           {return newSym(sym.START, "start");}
// end             {return newSym(sym.END, "end");}
// in              {return newSym(sym.IN, "in");}
// out             {return newSym(sym.OUT, "out");}
// ":)"            {return newSym(sym.SMILE, ":)");}
// "("             {return newSym(sym.LPAREN, "(");}
// ")"             {return newSym(sym.RPAREN, ")");}
// ":"             {return newSym(sym.COLON, ":");}
// number          {return newSym(sym.NUMBER, "number");}
// string          {return newSym(sym.STRING, "string");}
// flag            {return newSym(sym.FLAG, "flag");}
// main            {return newSym(sym.MAIN, "main");}
// "<-"            {return newSym(sym.ASSIGN, "<-");}
// read            {return newSym(sym.READ, "read");}
// write           {return newSym(sym.WRITE, "write");}
// call            {return newSym(sym.CALL, "call");}
// when            {return newSym(sym.WHEN, "when");}
// do              {return newSym(sym.DO, "do");}
// done            {return newSym(sym.DONE, "done");}
// "-"             {return newSym(sym.MINUS, "-");}
// "+"             {return newSym(sym.PLUS, "+");}
// "*"             {return newSym(sym.MULTIPLY, "*");}
// "/"             {return newSym(sym.DIVIDE, "/");}
// up              {return newSym(sym.UP, "up");}
// down            {return newSym(sym.DOWN, "down");}
// flip            {return newSym(sym.FLIP, "flip");}
// "?"             {return newSym(sym.QUESTION, "?");}
// {id}            {return newSym(sym.ID, yytext());}
// {number}        {return newSym(sym.NUMBERLIT, new Integer(yytext()));}
// {string}        {return newSym(sym.STRINGLIT, yytext());}
// {whitespace}    { /* Ignore whitespace. */ }
// .               { System.out.println("Illegal char, '" + yytext() +
//                     "' line: " + yyline + ", column: " + yychar); } 