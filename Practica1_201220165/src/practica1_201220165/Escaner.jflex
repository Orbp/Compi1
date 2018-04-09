package practica1_201220165;
import java_cup.runtime.Symbol;

%%

%{
    //Código de usuario
    String cadena= "";
%}

%cupsym tabla_simbolos
%cup
%class lexico
%public
%line
%char
%column
%full
%state CADENA
%ignorecase

//SIMBOLOS
IGUAL = "="
CORCHETEABRIR = "["
COMA = ","
CORCHETECERRAR = "]"
MAS = "+"
MENOS = "-"
CONCATENACION = "&"
PUNTO = "."
POR = "*"
DIV = "/"
PARENTESISABRIR = "("
PARENTESISCERRAR = ")"
MENOR = "<"
MENORIGUAL = "<="
MAYOR = ">"
MAYORIGUAL = ">="
DIFERENTE = "<>"

//RESERVADAS
MODULE = "Module"
END = "End"
AS = "As"
PUBLICO = "Public"
PRIVADO = "Private"
DIM = "Dim"
ESTATICO = "Static"
BOOL = "boolean"
CHAR = "char"
DOUBLE = "double"
INTEGER = "int"
LONG = "long"
STRING = "String"
CONSOLE = "Console"
READLINE = "Readline"
TRUE = "True"
FALSE = "False"
SUB = "Sub"
BYVAL = "ByVal"
FUNCTION = "Function"
EXIT = "Exit"
WHILE = "While"
FOR = "For"
WRITELINE = "WriteLine"
IF = "If"
THEN = "Then"
ELSEIF = "ElseIf"
ELSE = "Else"
NEXT = "Next"
TO = "To"
STEP = "Step"
DO = "Do"
LOOP = "Loop"
UNTIL = "Until"
SELECT = "Select"
CASE = "Case"
RETURN = "Return"
AND = "&&"
OR = "||"
NOT = "!"
MAIN = "main"


//EXPRESIONES
NUMERO = [0-9]+
ID = [A-Za-zñÑ][_0-9A-Za-zñÑ]*
ESPACIO = [\ \r\t\f\f]
ENTER = [\ \n]
%%

<YYINITIAL> {IGUAL}             {return new Symbol(tabla_simbolos.tigual, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CORCHETEABRIR}     {return new Symbol(tabla_simbolos.tcorabierto, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {COMA}              {return new Symbol(tabla_simbolos.tcoma, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CORCHETECERRAR}    {return new Symbol(tabla_simbolos.tcorcerrar, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAS}               {return new Symbol(tabla_simbolos.tmas, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MENOS}             {return new Symbol(tabla_simbolos.tmenos, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CONCATENACION}     {return new Symbol(tabla_simbolos.tconcate, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PUNTO}             {return new Symbol(tabla_simbolos.tpunto, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {POR}               {return new Symbol(tabla_simbolos.tpor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DIV}               {return new Symbol(tabla_simbolos.tdiv, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PARENTESISABRIR}   {return new Symbol(tabla_simbolos.tparabrir, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PARENTESISCERRAR}  {return new Symbol(tabla_simbolos.tparcerrar, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MENOR}             {return new Symbol(tabla_simbolos.tmenor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MENORIGUAL}        {return new Symbol(tabla_simbolos.tmenorigual, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAYOR}             {return new Symbol(tabla_simbolos.tmayor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAYORIGUAL}        {return new Symbol(tabla_simbolos.tmayorigual, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DIFERENTE}         {return new Symbol(tabla_simbolos.tdiferente, yycolumn, yyline, new String(yytext()));}

<YYINITIAL> {MODULE}            {return new Symbol(tabla_simbolos.tmodule, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {END}               {return new Symbol(tabla_simbolos.tend, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {AS}                {return new Symbol(tabla_simbolos.tas, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PUBLICO}           {return new Symbol(tabla_simbolos.tpublic, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PRIVADO}           {return new Symbol(tabla_simbolos.tprivate, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DIM}               {return new Symbol(tabla_simbolos.tdim, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ESTATICO}          {return new Symbol(tabla_simbolos.tstatic, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {BOOL}              {return new Symbol(tabla_simbolos.tboolean, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CHAR}              {return new Symbol(tabla_simbolos.tchar, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DOUBLE}            {return new Symbol(tabla_simbolos.tdouble, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {INTEGER}           {return new Symbol(tabla_simbolos.tinteger, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {LONG}              {return new Symbol(tabla_simbolos.tlong, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {STRING}            {return new Symbol(tabla_simbolos.tstring, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CONSOLE}           {return new Symbol(tabla_simbolos.tconsole, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {READLINE}          {return new Symbol(tabla_simbolos.treadline, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {TRUE}              {return new Symbol(tabla_simbolos.ttrue, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FALSE}             {return new Symbol(tabla_simbolos.tfalse, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {SUB}               {return new Symbol(tabla_simbolos.tsub, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {BYVAL}             {return new Symbol(tabla_simbolos.tbyval, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FUNCTION}          {return new Symbol(tabla_simbolos.tfunction, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {EXIT}              {return new Symbol(tabla_simbolos.texit, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {WHILE}             {return new Symbol(tabla_simbolos.twhile, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FOR}               {return new Symbol(tabla_simbolos.tfor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {WRITELINE}         {return new Symbol(tabla_simbolos.twriteline, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {IF}                {return new Symbol(tabla_simbolos.tif, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {THEN}              {return new Symbol(tabla_simbolos.tthen, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ELSEIF}            {return new Symbol(tabla_simbolos.telseif, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ELSE}              {return new Symbol(tabla_simbolos.telse, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NEXT}              {return new Symbol(tabla_simbolos.tnext, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {TO}                {return new Symbol(tabla_simbolos.tto, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {STEP}              {return new Symbol(tabla_simbolos.tstep, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DO}                {return new Symbol(tabla_simbolos.tdo, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {LOOP}              {return new Symbol(tabla_simbolos.tloop, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {UNTIL}             {return new Symbol(tabla_simbolos.tuntil, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {SELECT}            {return new Symbol(tabla_simbolos.tselect, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CASE}              {return new Symbol(tabla_simbolos.tcase, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {RETURN}            {return new Symbol(tabla_simbolos.treturn, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {AND}               {return new Symbol(tabla_simbolos.tand, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {OR}                {return new Symbol(tabla_simbolos.tor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NOT}               {return new Symbol(tabla_simbolos.tnot, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAIN}              {return new Symbol(tabla_simbolos.tmain, yycolumn, yyline, new String(yytext()));}

<YYINITIAL> {NUMERO}            {return new Symbol(tabla_simbolos.tnumero, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ID}                {return new Symbol(tabla_simbolos.tid, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> [\"]                {yybegin(CADENA); cadena+="\"";;}
<YYINITIAL> {ESPACIO}           {/*Espacios en blanco se ignoran*/}
<YYINITIAL> {ENTER}             {/*Salto de linea se ignora*/}

<YYINITIAL> .                   {
                                    System.out.println("Error Lexico: " + yytext() + ", en " + (yycolumn + 1) + ", " + (yyline + 1));
                                    Ventana.errores.add("Lexico-" + yytext() + "-" + (yycolumn + 1) + "-" + (yyline + 1));
                                }

<CADENA>                        {
                                    [\"] { String tmp=cadena+"\""; cadena=""; yybegin(YYINITIAL);  return new Symbol(tabla_simbolos.tcadena, yychar,yyline,tmp); }
                                    [\n] {String tmp=cadena; cadena="";  
                                            System.out.println("Se esperaba cierre de cadena (\")."); 
                                            yybegin(YYINITIAL);
                                        }
                                    [^\"] { cadena+=yytext();}
}