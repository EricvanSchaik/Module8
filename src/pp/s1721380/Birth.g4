grammar Birth;
/** Branch of a family tree. */
branch : ( enter | beget )+ ;
/** Figures may enter with unknown parenthood. */
enter : ENTER sex ID (COMMA ID)* ;
/** Figures may be born from mother and father. */
beget : ID COMMA ID BEGET sex ID (COMMA ID)*  |  LEFT branch RIGHT ;
/** Persons are always male or female. */
sex : MALE | FEMALE ;

COMMA : ',';
LEFT  : '[';
RIGHT : ']';

BEGET  : 'beget';
ENTER  : 'enter';
MALE   : 'male';
FEMALE : 'female';

ID : [A-Z][a-z]* ;

WS : [ \t\n\r]+ -> skip;