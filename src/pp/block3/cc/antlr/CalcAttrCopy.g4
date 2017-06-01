grammar CalcAttrCopy;

import CalcVocabCopy;

term returns [ Type type ]
     : e0=term PWR e1=term
       { if (($e1.type == Type.NUM) && ($e0.type == Type.NUM || $e0.type == Type.STR)) {
          $type = $e0.type; }
         else { $type = Type.ERR; }
       }
     | e0=term PLUS e1=term
       { if ( $e0.type == $e1.type ) {
          $type = $e0.type; }
         else { $type = Type.ERR; }
        }
     | e0=term EQ e1=term
       { if ( $e0.type == $e1.type ) {
          $type = Type.BOOL; }
         else { $type = Type.ERR; }
        }
     | LPAR e=term RPAR
       { $type = $e.type; }
     | NUM
       { $type = Type.NUM; }
     | BOOL
       { $type = Type.BOOL; }
     | STR
       { $type = Type.STR; }
     ;
