package cliente;

import java_cup.runtime.Symbol;

%%

%{
    String cadena = "";
    String comentario = "";
    String texto = "";
%}

%cupsym tabla_sim_cpreport
%cup
%class lexico_cpreport
%public
%line
%char
%column
%full
%state CADENA
%state COMENTARIOMULTI
%state COMENTARIO
%state CPREPORT
%state ETIQUETA
%state CADENAHTML
%ignorecase

MAYOR = ">"
MENOR = "<"
HTML = "html"
HEAD = "head"
BODY = "body"
TITLE = "title"
TABLE = "table"
TH = "th"
TD = "td"
TR = "tr"
DIV = "div"
PARRAFO = [p]
BR = "br"
HR = "hr"
COLOR = "color"
TEXTCOLOR = "textcolor"
ALIGN = "align"
FONT = "font"
RESULT = "RESULT"
SCORE = "score"
VARIABLES = "variables"
PUNTO = "."
CA = "["
CC = "]"
NOMBRE = "nombre"
PUNTOYCOMA = ";"
CANTIDAD = "cantidad"
METODOS = "metodos"
CLASES = "clases"
INT = "int"
CHAR = "char"
FLOAT = "float"
STRING = "String"
BOOLEAN = "boolean"
TRUE = "true"
FALSE = "false"
ASIGNAR = "="
MAS = "+"
RESTA = "-"
DIVISION = "/"
MULTIPLICACION = "*"
MODULO = "%"
PA = "("
PC = ")"
MENOR = "<"
MAYOR = ">"
MENORIGUAL = "<="
MAYORIGUAL = ">="
IGUAL = "=="
NOIGUAL = "!="
AND = "&&"
OR = "||"
NOT = "!"
PRINT = "Print"
TIPO = "tipo"
FUNCION = "funcion"
CLASE = "clase"
PARAMETROS = "parametros"
NUMERO = [0-9]+("."[0-9]+)?
ID = ["_"|A-Za-zÑñ]["_"|0-9|a-zA-ZñÑ]*
CARACTER = "'"[[:letter:] | [:digit:] | "\\n" | "\\r" | "\\t" | "\\f" | " " | "\\'" | "\\\"" | "\\\\" | "\\b"]"'"   
ESPACIO = [\ \r\t\f\f]
ENTER = [\ \n]
HID = [h]([0-9]+)
INICIOCOMENTARIOMULTI = "</"
COMENTARIOMULTICERRAR = "/>"
INICIOCPREPORT = "$$"
INICIOCOMENTARIO = "->"
COMA = ","
TEXTO = ([:letter:] | [:digit:] | "@" | "!" | "#" | "," | "." | "?" | ";" | ":")+ 

%%

<YYINITIAL> {MENOR}                 {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tmenor, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {INICIOCPREPORT}        {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tiniciocpreport, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NUMERO}                {return new Symbol(tabla_sim_cpreport.tnumero, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {ESPACIO}               {/* Se ignoran */}
<YYINITIAL> {ENTER}                 {/* Se ignoran */}
<YYINITIAL> {TEXTO}                 {return new Symbol(tabla_sim_cpreport.ttexto, yycolumn, yyline, yytext());}

<YYINITIAL> .                   {System.out.println("Error Lexico: " + yytext()+ ", en columna: " + (yycolumn + 1) + " y en la fila: " + (yyline + 1));
                                Ventana.errores.add("Lexico-" + yytext() +"-" + String.valueOf((yycolumn +1)) + "-" + String.valueOf((yyline + 1)));}


<ETIQUETA>  {MAYOR}                 {yybegin(YYINITIAL); return new Symbol(tabla_sim_cpreport.tmayor, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {HID}                   {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.ttitulo, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {HTML}                  {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.thtml, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {HEAD}                  {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.thead, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {BODY}                  {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tbody, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {TITLE}                 {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.ttitle, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {TABLE}                 {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.ttable, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {TH}                    {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tth, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {TD}                    {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.ttd, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {PARRAFO}               {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tparrafo, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {TR}                    {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.ttr, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {DIV}                   {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tdiv, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {BR}                    {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tbr, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {HR}                    {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.thr, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {COLOR}                 {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tcolor, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {TEXTCOLOR}             {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.ttextcolor, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {ALIGN}                 {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.talign, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {FONT}                  {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tfont, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {DIVISION}              {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tdiagonal, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {ESPACIO}               {yybegin(ETIQUETA); /* Se ignoran */}
<ETIQUETA>  {ENTER}                 {yybegin(ETIQUETA); /* Se ignoran */}
<ETIQUETA>  {NUMERO}                {return new Symbol(tabla_sim_cpreport.tnum, yycolumn, yyline, new String(yytext()));}
<ETIQUETA>  {ASIGNAR}               {yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tasignar, yycolumn, yyline, yytext());}
<ETIQUETA>  [\"]                    {yybegin(CADENAHTML); cadena = "\"";}

<ETIQUETA> .                   {System.out.println("Error Lexico: " + yytext()+ ", en columna: " + (yycolumn + 1) + " y en la fila: " + (yyline + 1));
                                yybegin(YYINITIAL);
                                Ventana.errores.add("Lexico-" + yytext() +"-" + String.valueOf((yycolumn +1)) + "-" + String.valueOf((yyline + 1)));}

<CADENAHTML>                    {
                                    [\"]    {String temp = cadena + "\""; cadena = ""; yybegin(ETIQUETA); return new Symbol(tabla_sim_cpreport.tcadena, yychar, yyline, temp);}
                                    [^\"]   {cadena += yytext();}
                                }
<CADENA>                        {
                                    [\"]    {String temp = cadena + "\""; cadena = ""; yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tcadena, yychar, yyline, temp);}
                                    [^\"]   {cadena += yytext();}
                                }

<CPREPORT>  {RESULT}                {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tresult, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {SCORE}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tscore, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {VARIABLES}             {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tvariables, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {PUNTO}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tpunto, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {CA}                    {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tcorcheteabrir, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {CC}                    {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tcorchetecerrar, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {NOMBRE}                {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tnombre, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {PUNTOYCOMA}            {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tpuntoycoma, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {CANTIDAD}              {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tcantidad, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {METODOS}               {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmetodos, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {CLASES}                {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tclases, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {INT}                   {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tint, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {CHAR}                  {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tchar, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {FLOAT}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tfloat, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {STRING}                {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tstring, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {BOOLEAN}               {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tboolean, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {TRUE}                  {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.ttrue, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {FALSE}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tfalse, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {ASIGNAR}               {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tasignar, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MAS}                   {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmas, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {RESTA}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tresta, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {COMA}                  {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tcoma, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {DIVISION}              {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tdivision, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MULTIPLICACION}        {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmultiplicacion, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MODULO}                {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmodulo, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {PA}                    {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tparentesisabrir, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {PC}                    {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tparentesiscerrar, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MENORIGUAL}            {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmenorigual, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MAYORIGUAL}            {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmayorigual, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {IGUAL}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tigual, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MAYOR}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmayor, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {MENOR}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tmenor, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {NOIGUAL}               {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tnoigual, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {AND}                   {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tand, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {OR}                    {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tor, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {NOT}                   {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tnot, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {PRINT}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tprint, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {TIPO}                  {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.ttipo, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {FUNCION}               {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tfuncion, yycolumn, yyline, yytext());}
<CPREPORT>  {CLASE}                 {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tclase, yycolumn, yyline, yytext());}
<CPREPORT>  {PARAMETROS}            {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tparametros, yycolumn, yyline, yytext());}
<CPREPORT>  {ID}                    {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tid, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {INICIOCOMENTARIOMULTI} {yybegin(COMENTARIOMULTI); comentario += "</";}
<CPREPORT>  {INICIOCOMENTARIO}      {yybegin(COMENTARIO); comentario += "->";}
<CPREPORT>  [\"]                    {yybegin(CADENA); cadena += "\"";}
<CPREPORT>  {CARACTER}              {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tcaracter, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {INICIOCPREPORT}        {yybegin(YYINITIAL); return new Symbol(tabla_sim_cpreport.tiniciocpreport, yycolumn, yyline, new String(yytext()));}
<CPREPORT>  {ESPACIO}               {/* Se ignoran */}
<CPREPORT>  {ENTER}                 {/* Se ignoran */}
<CPREPORT>  {NUMERO}                {yybegin(CPREPORT); return new Symbol(tabla_sim_cpreport.tnumero, yycolumn, yyline, new String(yytext()));}

<CPREPORT> .                   {System.out.println("Error Lexico: " + yytext()+ ", en columna: " + (yycolumn + 1) + " y en la fila: " + (yyline + 1));
                                yybegin(YYINITIAL);
                                Ventana.errores.add("Lexico-" + yytext() +"-" + String.valueOf((yycolumn +1)) + "-" + String.valueOf((yyline + 1)));}


<COMENTARIO>                    {
                                    [\n]    {
                                                String temp = comentario + ""; comentario = ""; 
                                                yybegin(CPREPORT); 
                                                System.out.println("Comentario lineal: "  + temp); 
                                                return new Symbol(tabla_sim_cpreport.tcomentario, yycolumn, yyline, new String(temp));
                                            }
                                    [^\n]   {comentario += yytext();}
                                }

<COMENTARIOMULTI>               {
                                    {COMENTARIOMULTICERRAR}  
                                            {
                                                String temp = comentario + "/>";
                                                comentario = "";
                                                yybegin(CPREPORT);
                                                System.out.println("Comentario multilinea: " + temp);
                                                return new Symbol(tabla_sim_cpreport.tcomentariomulti, yycolumn, yyline, new String(temp));
                                            }
                                    [^"/>"] {
                                                comentario += yytext();
                                            }
                                }