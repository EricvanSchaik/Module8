grammar MyDsl;

mydsl: declaration*;
declaration: device | rule;
device: 'Device' ID 'can be' STATE (',' STATE)*;
rule: 'Rule' STRING 'when' STATE 'then' STATE;

STATE: STRING;
ID: STRING;
STRING: ~[ \t\n\r\\{}$&#^_~%]*;