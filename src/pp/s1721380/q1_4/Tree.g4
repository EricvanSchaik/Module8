grammar Tree;

prog : node ;

node
  : NUM
  | LPAR node LEFT NUM  RPAR
  | LPAR NUM RIGHT node RPAR
  | LPAR node LEFT NUM RIGHT node RPAR
  ; 
  
LPAR  : '(';
RPAR  : ')';
LEFT  : '<';
RIGHT : '>';

NUM : [0-9]+;

WS : [ \t\r\n]+ -> skip;
