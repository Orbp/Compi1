package cliente;

import java_cup.runtime.Symbol;

%%

%{
    String cadena = "";
    String comentario = "";
%}

%cupsym tabla_simbolos_json
%cup
%class lexico
%public
%line
%char
%column
%full
%state CADENA
%ignorecase

LLA = "{"
LLC = "}"
CA = "["
CC = "]"
DP = ":"
COMA = ","
SCORE = "Score"
CLASES = "Clases"
NOMBRE = "Nombre"
VARIABLES = "Variables"
TIPO = "Tipo"
FUNCION = "Funcion"
CLASE = "Clase"
METODOS = "Metodos"
PARAMETROS = "Parametros"
COMENTARIOS = "Comentarios"
TEXTO = "Texto"

NUMERO = [0-9]+("."[0-9]+)?
ESPACIO = [\ \r\t\f\f]
ENTER = [\ \n]
%%

<YYINITIAL> {LLA}               {return new Symbol(tabla_simbolos_json.tllaveabrir, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {LLC}               {return new Symbol(tabla_simbolos_json.tllavecerrar, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CA}                {return new Symbol(tabla_simbolos_json.tcorcheteabrir, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CC}                {return new Symbol(tabla_simbolos_json.tcorchetecerrar, yycolumn, yyline, new String(yytext()));}
<YYINITIAL>	{DP}				{return new Symbol(tabla_simbolos_json.tdospuntos, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {COMA}              {return new Symbol(tabla_simbolos_json.tcoma, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {SCORE}             {return new Symbol(tabla_simbolos_json.tscore, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CLASES}            {return new Symbol(tabla_simbolos_json.tclases, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {NOMBRE}            {return new Symbol(tabla_simbolos_json.tnombre, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {VARIABLES}         {return new Symbol(tabla_simbolos_json.tvariables, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {TIPO}              {return new Symbol(tabla_simbolos_json.ttipo, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {FUNCION}           {return new Symbol(tabla_simbolos_json.tfuncion, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {CLASE}             {return new Symbol(tabla_simbolos_json.tclase, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {METODOS}           {return new Symbol(tabla_simbolos_json.tmetodos, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {PARAMETROS}        {return new Symbol(tabla_simbolos_json.tparametros, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> {COMENTARIOS}       {return new Symbol(tabla_simbolos_json.tcomentarios, yycolumn, yyline, new String(yytext()));}
<YYINITIAL>	{TEXTO}				{return new Symbol(tabla_simbolos_json.ttexto, yycolumn, yyline, new String(yytext()));}

<YYINITIAL> {NUMERO}            {return new Symbol(tabla_simbolos_json.tnumero, yycolumn, yyline, new String(yytext()));}
<YYINITIAL> [\"]                {yybegin(CADENA); cadena += "\"";}
<YYINITIAL> {ESPACIO}           {/*Se ignoran*/}
<YYINITIAL> {ENTER}             {/*Se ignoran*/}

<YYINITIAL> .                   {System.out.println("Error Lexico: " + yytext()+ ", en columna: " + (yycolumn + 1) + " y en la fila: " + (yyline + 1));}

<CADENA>                        {
                                    [\"]    {String temp = cadena + "\""; cadena = ""; yybegin(YYINITIAL); return new Symbol(tabla_simbolos_json.tcadena, yychar, yyline, temp);}
                                    [^\"]   {cadena += yytext();}
                                }