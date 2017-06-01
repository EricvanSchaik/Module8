grammar Tabular;

table : BEGIN row* END;
row : (entry '&')* entry '\\\\';
entry : TEXT?;

TEXT : (~[ \t\n\r\\{}$&#^_~%]+ WS+ ~[ \t\n\r\\{}$&#^_~%]+) | ~[ \t\n\r\\{}$&#^_~%]+;
WS : [ \t\n\r]+ -> skip;
COMMENT : '%' ~('\n')* '\n' -> skip;
BEGIN: '\\begin{tabular}{' ARGUMENT* '}';
END: '\\end{tabular}';
ARGUMENT: [lcr];