lexer grammar CC13;

STRING : QUOTATION NO_QUOTES QUOTATION;
fragment QUOTATION : '\'';
fragment NO_QUOTES : (~('\''))*;
