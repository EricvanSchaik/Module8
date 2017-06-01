lexer grammar CalcVocabCopy;

PLUS   : '+';
LPAR   : '(';
RPAR   : ')';
EQ     : '=';
PWR    : '^';

NUM    : [0-9]+;
BOOL   : 'true' | 'false';
STR    : '\'' [a-zA-Z]+ '\'';

// ignore whitespace
WS : [ \t\n\r] -> skip;