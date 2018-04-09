package servidor;

import java_cup.runtime.Symbol;

%%

%{
    String cadena = "";
    String comentario = "";
    String claseactual = "";
    public void setclase(String pactual){
        claseactual = pactual;
    }
    String proyectoactual = "";
    String proyectoactualnombre = "";
    Proyecto proyecto1 = new Proyecto();
    Proyecto proyecto2 = new Proyecto();

    public Proyecto getProyecto1(){
        return proyecto1;
    }

    public Proyecto getProyecto2(){
        return proyecto2;
    }
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
%state COMENTARIOMULTI
%state COMENTARIO

PYC = ";"
CA = "{"
CC = "}"
POR = "*"
PUNTO = "."
PA = "("
PC = ")"
IGUAL = "="
IMPORT = "import"
CLASE = "class"
INT = "int"
BOOL = "boolean"
STRING = "String"
CHAR = "char"
DOUBLE = "double"
OBJECT = "Object"
IF = "if"
ELSE = "else"
FOR = "for"
WHILE = "while"
DO = "do"
SWITCH = "switch"
DP = ":"
PRIVATE = "private"
PUBLIC = "public"
PROTECTED = "protected"
FINAL = "final"
BREAK = "break"
RETURN = "return"
NEW = "new"
CASE = "case"
DEFAULT = "default"
MAS = "+"
MENOS = "-"
DIV = "/"
AND = "&&"
OR = "||"
NOT = "!"
VOID = "void"
COMA = ","
THIS = "this"
MENOR = "<"
MAYOR = ">"
MENORIGUAL = "<="
MAYORIGUAL = ">="
IGUALA = "=="
DIFERENTE = "!="
FALSE = "false"
TRUE = "true"
COMEN = "//"
COMENMULTIABRIR = "/*"
COMENMULTICERRAR = "*/"
ABSTRACT = "abstract"
FINALLY = "finally"
CONTINUE = "continue"
INTERFACE = "interface"
THROW = "throw"
NATIVE = "native"
TRY = "try"
CATCH = "catch"
IMPLEMENTS = "implements"
PACKAGE = "package"
SUPER = "super"
EXTENDS = "extends"
THROWS = "throws"
PRINTLN = "println"
OVERRIDE = "@Override"
NULO = "null"
MAIN = "main"
SYSTEM = "System"
OUT = "out"
STATIC = "static"
ARG = "[]"

NUMERO = [0-9]+("."[0-9]+)?
ID = [A-Za-zñÑ][_0-9A-Za-zñÑ]*
CARACTER = "'"[:PRINTABLE: | "\\n" | "\\r" | "\\t" | "\\f" | " " | "\\'" | "\\\"" | "\\\\" | "\\b"]"'"
ESPACIO = [\ \r\t\f\f]
ENTER = [\ \n]
%%

<YYINITIAL> {PYC}               {return new Symbol(tabla_simbolos.tpuntoycoma, yycolumn, yyline, ";");}
<YYINITIAL> {CA}                {return new Symbol(tabla_simbolos.tllaveabrir, yycolumn, yyline, "{");}
<YYINITIAL> {CC}                {return new Symbol(tabla_simbolos.tllavecerrar, yycolumn, yyline, "}");}
<YYINITIAL> {POR}               {return new Symbol(tabla_simbolos.tpor, yycolumn, yyline, "*");}
<YYINITIAL> {PUNTO}             {return new Symbol(tabla_simbolos.tpunto, yycolumn, yyline, ".");}
<YYINITIAL> {PA}                {return new Symbol(tabla_simbolos.tparentesisabrir, yycolumn, yyline, "(");}
<YYINITIAL> {MAIN}              {return new Symbol(tabla_simbolos.tmain, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {STATIC}            {return new Symbol(tabla_simbolos.tstatic, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ARG}               {return new Symbol(tabla_simbolos.targ, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PC}                {return new Symbol(tabla_simbolos.tparentesiscerrar, yycolumn, yyline, ")");}
<YYINITIAL> {IGUAL}             {return new Symbol(tabla_simbolos.tigual, yycolumn, yyline, "=");}
<YYINITIAL> {IMPORT}            {return new Symbol(tabla_simbolos.timport, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CLASE}             {return new Symbol(tabla_simbolos.tclase, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {INT}               {return new Symbol(tabla_simbolos.tint, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {BOOL}              {return new Symbol(tabla_simbolos.tbool, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {STRING}            {return new Symbol(tabla_simbolos.tstring, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CHAR}              {return new Symbol(tabla_simbolos.tchar, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DOUBLE}            {return new Symbol(tabla_simbolos.tdouble, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {IF}                {return new Symbol(tabla_simbolos.tif, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ELSE}              {return new Symbol(tabla_simbolos.telse, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FOR}               {return new Symbol(tabla_simbolos.tfor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {WHILE}             {return new Symbol(tabla_simbolos.twhile, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DO}                {return new Symbol(tabla_simbolos.tdo, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {SWITCH}            {return new Symbol(tabla_simbolos.tswitch, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DP}                {return new Symbol(tabla_simbolos.tdp, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PRIVATE}           {return new Symbol(tabla_simbolos.tprivate, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PUBLIC}            {return new Symbol(tabla_simbolos.tpublic, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PROTECTED}         {return new Symbol(tabla_simbolos.tprotected, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FINAL}             {return new Symbol(tabla_simbolos.tfinal, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {BREAK}             {return new Symbol(tabla_simbolos.tbreak, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {RETURN}            {return new Symbol(tabla_simbolos.treturn, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NEW}               {return new Symbol(tabla_simbolos.tnew, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CASE}              {return new Symbol(tabla_simbolos.tcase, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DEFAULT}           {return new Symbol(tabla_simbolos.tdefault, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAS}               {return new Symbol(tabla_simbolos.tmas, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MENOS}             {return new Symbol(tabla_simbolos.tmenos, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DIV}               {return new Symbol(tabla_simbolos.tdiv, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {AND}               {return new Symbol(tabla_simbolos.tand, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {OR}                {return new Symbol(tabla_simbolos.tor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NOT}               {return new Symbol(tabla_simbolos.tnot, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {COMA}              {return new Symbol(tabla_simbolos.tcoma, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {THIS}              {return new Symbol(tabla_simbolos.tthis, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MENOR}             {return new Symbol(tabla_simbolos.tmenor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAYOR}             {return new Symbol(tabla_simbolos.tmayor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MENORIGUAL}        {return new Symbol(tabla_simbolos.tmenorigual, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {MAYORIGUAL}        {return new Symbol(tabla_simbolos.tmayorigual, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {IGUALA}            {return new Symbol(tabla_simbolos.tiguala, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {DIFERENTE}         {return new Symbol(tabla_simbolos.tdiferente, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FALSE}             {return new Symbol(tabla_simbolos.tfalse, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {TRUE}              {return new Symbol(tabla_simbolos.ttrue, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CARACTER}          {return new Symbol(tabla_simbolos.tcaracter, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ABSTRACT}          {return new Symbol(tabla_simbolos.tabstract, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FINALLY}           {return new Symbol(tabla_simbolos.tfinally, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CONTINUE}          {return new Symbol(tabla_simbolos.tcontinue, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {INTERFACE}         {return new Symbol(tabla_simbolos.tinterface, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {THROW}             {return new Symbol(tabla_simbolos.tthrow, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NATIVE}            {return new Symbol(tabla_simbolos.tnative, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {TRY}               {return new Symbol(tabla_simbolos.ttry, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CATCH}             {return new Symbol(tabla_simbolos.tcatch, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {IMPLEMENTS}        {return new Symbol(tabla_simbolos.timplements, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PACKAGE}           {return new Symbol(tabla_simbolos.tpackage, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {SUPER}             {return new Symbol(tabla_simbolos.tsuper, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {EXTENDS}           {return new Symbol(tabla_simbolos.textends, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {THROWS}            {return new Symbol(tabla_simbolos.tthrows, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {OVERRIDE}          {return new Symbol(tabla_simbolos.toverride, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NULO}		{return new Symbol(tabla_simbolos.tnull, yycolumn, yyline, new String(yytext()));}

<YYINITIAL> {NUMERO}            {return new Symbol(tabla_simbolos.tnumero, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ID}                {return new Symbol(tabla_simbolos.tid, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> [\"]                {yybegin(CADENA); cadena += "\"";}
<YYINITIAL> {COMEN}             {yybegin(COMENTARIO);   comentario += "\"";}
<YYINITIAL> {COMENMULTIABRIR}   {yybegin(COMENTARIOMULTI);  comentario += "\"";}
<YYINITIAL> {ESPACIO}           {/* Se ignoran */}
<YYINITIAL> {ENTER}             {/* Se ignoran */}

<YYINITIAL> .                   {
                                    //System.out.println("Error Lexico: " + yytext()+ ", en columna: " + (yycolumn + 1) + " y en la fila: " + (yyline + 1) + " en la clase " + claseactual + " del proyecto " + proyectoactualnombre);
                                    Conexion.errores.add("Lexico-" + yytext() + "-" + (yycolumn + 1) + "-" + (yyline + 1) + "-" + claseactual + "-" + proyectoactualnombre);
                                }

<CADENA>                        {
                                    [\"]    {String temp = cadena + "\""; cadena = ""; yybegin(YYINITIAL); return new Symbol(tabla_simbolos.tcadena, yychar, yyline, temp);}
                                    [^\"]   {cadena += yytext();}
                                }

<COMENTARIO>                    {
                                    [\n]    {
                                                String temp = comentario + "\""; comentario = ""; 
                                                yybegin(YYINITIAL); 
                                                System.out.println("Comentario lineal: "  + temp); 
                                                if(proyectoactual.equals("Proyecto 1")){
                                                    Comentario comen = new Comentario();
                                                    comen.setTexto(temp);
                                                    proyecto1.AgregarComentario(comen);
                                                }else{
                                                    Comentario comen = new Comentario();
                                                    comen.setTexto(temp);
                                                    proyecto2.AgregarComentario(comen);
                                                }
                                            }                                                    
                                    [^\n]   {comentario += yytext();}
                                }

<COMENTARIOMULTI>               {
                                    {COMENMULTICERRAR}  {
                                                            String temp = comentario + "\""; 
                                                            comentario = ""; yybegin(YYINITIAL); 
                                                            System.out.println("Comentario multilinea: " + temp);
                                                            if(proyectoactual.equals("Proyecto 1")){
                                                                Comentario comen = new Comentario();
                                                                comen.setTexto(temp);
                                                                proyecto1.AgregarComentario(comen);
                                                            }else{
                                                                Comentario comen = new Comentario();
                                                                comen.setTexto(temp);
                                                                proyecto2.AgregarComentario(comen);
                                                            }
                                                        }
                                    [^"*/"]   {comentario += yytext();}
                                }