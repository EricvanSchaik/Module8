grammar Calc;

import CalcVocab;

expr : MINUS expr      # neg
     | expr TIMES expr # times
     | expr PLUS expr  # plus
     | LPAR expr RPAR  # par
     | NUMBER          # number
     ;
