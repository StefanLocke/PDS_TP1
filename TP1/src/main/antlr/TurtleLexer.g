lexer grammar TurtleLexer;

options {
  language = Java;
}

@header {
  package TP1;
}

// ignore whitespaces
WS : (' '|'\n'|'\t'|'\r'|'\u000C')+ -> skip
   ;

fragment ASCII  : ~('\n'|'"'|'<'|'>');

CHEVRONLEFT : '<';
CHEVRONRIGHT : '>';
NOM : [&A-Za-z0-9' '-]+;
GUI : '"';
PTV : ';';
PT : '.';
VRG : ',';
