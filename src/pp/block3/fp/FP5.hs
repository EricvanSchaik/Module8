import FP_Core
import FPPrac.Trees

-- OPGAVE 2
codeGen2 :: Expr -> [Instr]
codeGen2 (Const x)          = [PushConst x]
codeGen2 (BinExpr operator x1 x2) = codeGen2 (x1) ++ codeGen2 (x2) ++ [Calc operator]
codeGen2 (Var v)            = [PushAddr v]

instance CodeGen Expr where 
  codeGen expr = codeGen2 expr ++ [EndProg]

-- OPGAVE 3
instance PP Expr where 
  pp (Const x) = RoseNode (show x) []
  pp (BinExpr operator x1 x2) = RoseNode (show operator) ([pp x1] ++ [pp x2])
  pp (Var v) = RoseNode (show v) []

instance PP Stmnt where 
  pp (Assign v e) = RoseNode (show v) ([pp e])


-- OPGAVE 4 Zie FP_Core

-- OPGAVE 5
codeGen5 :: Stmnt -> [Instr]
codeGen5 (Assign v e) = codeGen2 e ++ [Store v]
codeGen5 (Repeat e s) = codeGen2 e ++ [PushPC] ++  foldl (++) [] (map codeGen5 s) ++ [EndRep]
instance CodeGen Stmnt where 
  codeGen stmnt = codeGen5 stmnt

-- OPGAVE 6
class CodeGen x where
  codeGen :: x -> [Instr]

class PP x where
  pp :: x -> RoseTree

-- OPGAVE 7 Zie FP_Core

-- OPGAVE 8
s = [Assign 1 (Const 0),
     Assign 2 (Const 1), 
	 Repeat (Const 10) 
	    [ Assign 1 (BinExpr Add (Var 1) (Var 2)), 
		  Assign 2 (BinExpr Add (Var 2) (Const 1))
		]
    ]
pr = (foldl (++) [] (map codeGen s)) ++ [EndProg]
test2      = putStr
           $ unlines
           $ map show
           $ takeWhile (\(pc,_,_,_) -> pc /= -1)

           $ scanl (core pr) (0,0, emptyHeap,emptyStack) clock