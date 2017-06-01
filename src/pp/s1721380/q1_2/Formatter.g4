grammar Formatter;

formatter: '%' ARGINDEX? FLAG* WIDTH? PRECISION? conversion;
conversion: GENERAL | CHARACTER | INTEGRAL | FLOAT;

ARGINDEX: ('1'..'9') ('0'..'9')* '$';
FLAG: '-' | '#' | '+' | ' ' | '0' | ',' | '(';
WIDTH: ('1'..'9') ('0'..'9')*;
PRECISION: '.' ('0'..'9')+;
GENERAL: B | H | S;
fragment B: 'b' | 'B';
fragment H: 'h' | 'H';
fragment S: 's' | 'S';
CHARACTER: C;
fragment C: 'c' | 'C';
INTEGRAL: 'd' | 'o'| X;
fragment X: 'x' | 'X';
FLOAT: 'f' | E | G | A;
fragment E: 'e' | 'E';
fragment G: 'g' | 'G';
fragment A: 'a' | 'A';