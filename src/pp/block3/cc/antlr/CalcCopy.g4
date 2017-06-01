grammar CalcCopy;

import CalcVocabCopy;

expr : expr PWR expr   # power
     | expr PLUS expr  # plus
     | expr EQ expr    # equal
     | LPAR expr RPAR  # par
     | NUM             # number
     | BOOL            # boolean
     | STR             # string
     ;
