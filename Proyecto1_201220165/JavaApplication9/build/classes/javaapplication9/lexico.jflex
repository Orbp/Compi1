package javaapplication9;

import java_cup.runtime.Symbol;

%%

%{
    
%}

%cupsym tabla_simbolos
%cup
%class lexico
%public
%line
%char
%column
%full
%ignorecase

MAS = "+"
MENOS = "-"
POR = "*"
DIVISION = "/"
PA = "("
PC = ")"
ELEVAR = "^"

NUMERO = [0-9]+
DECIMAL = [0-9]+("."[0-9]+)
%%

<YYINITIAL> {MAS}       {return new Symbol(tabla_simbolos.tmas, yycolumn, yyline, "+");}
<YYINITIAL> {MENOS}     {return new Symbol(tabla_simbolos.tmenos, yycolumn, yyline, "-");}
<YYINITIAL> {POR}       {return new Symbol(tabla_simbolos.tpor, yycolumn, yyline, "*");}
<YYINITIAL> {DIVISION}  {return new Symbol(tabla_simbolos.tdivision, yycolumn, yyline, "/");}
<YYINITIAL> {PA}        {return new Symbol(tabla_simbolos.tpa, yycolumn, yyline, "(");}
<YYINITIAL> {PC}        {return new Symbol(tabla_simbolos.tpc, yycolumn, yyline, ")");}
<YYINITIAL> {ELEVAR}    {return new Symbol(tabla_simbolos.televar, yycolumn, yyline, "^");}

<YYINITIAL> {NUMERO}    {return new Symbol(tabla_simbolos.tnumero, yycolumn, yyline, yytext());}
<YYINITIAL> {DECIMAL}   {return new Symbol(tabla_simbolos.tdecimal, yycolumn, yyline, yytext());}

<YYINITIAL> .           {System.out.println("Error lexico: " + yytext() + ", en columna: " + (yycolumn + 1) + " y en fila: " + (yyline + 1));}
