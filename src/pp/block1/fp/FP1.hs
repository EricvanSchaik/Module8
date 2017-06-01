import Data.Char

-- OPGAVE 1
f x = 2*x^2 + 3*x - 5

-- OPGAVE 2A
codeA :: Char -> Char
codeA x
  | (96<ord x && ord x<(120)) || (64<ord x && ord x<(88))  = chr ((ord x)+3)
  | ((119)<ord x && ord x<123) || ((87)<ord x && ord x<91) = chr ((ord x)-23)
  | otherwise              = x

-- OPGAVE 2B
code :: Char -> Int -> Char
code x n
  | (96<ord x && ord x<(123-y)) || (64<ord x && ord x<(91-y))  = chr ((ord x)+y)
  | ((122-y)<ord x && ord x<123) || ((90-y)<ord x && ord x<91) = chr ((ord x)-(26-y))
  | otherwise              = x
  where 
    y = n `mod` 26

-- OPGAVE 3
amount :: (Num t1, Eq t1, Fractional t) => t1 -> t -> t -> t
amount n a r 
  | n==0      = a
  | n==1      = a*(1+(r/100)) 
  | otherwise = amount 1 (amount (n-1) a r) r
  
-- OPGAVE 4
root1 :: (Floating t, Ord t) => t -> t -> t -> t
root1 a b c 
  | (b^2 - 4*a*c) < 0 = error "negative discriminant"
  | otherwise         = (-b + sqrt(b^2 - 4*a*c))/(2*a)
  
root2 :: (Floating t, Ord t) => t -> t -> t -> t
root2 a b c
  | (b^2 - 4*a*c) < 0 = error "negative discriminant"
  | otherwise         = (-b - sqrt(b^2 - 4*a*c))/(2*a)

-- OPGAVE 5
extrX :: Fractional a => a -> a -> t -> a
extrX a b c = -b/(2*a)

extrY :: Fractional a => a -> a -> a -> a
extrY a b c = a*(extrX a b c)^2 + b*(extrX a b c) + c

-- OPGAVE 6
mylength :: Num t => [t1] -> t
mylength [] = 0
mylength (x:xs) = 1 + mylength xs

mysum :: Num t => [t] -> t
mysum [] = 0
mysum (x:xs) = x + mysum xs

myreverse :: [t] -> [t]
myreverse [] = []
myreverse (x:xs) = myreverse xs ++ [x]

mytake :: (Num t, Ord t) => [a] -> t -> [a]
mytake [] n = []
mytake xs 0 = []
mytake (x:xs) n 
  | n>mylength (x:xs)  = (x:xs)
  | otherwise          = [x] ++ mytake xs (n-1)

myelem :: Eq t => [t] -> t -> Bool
myelem [] n = False
myelem (x:xs) n 
  | n==x      = True
  | otherwise = myelem xs n  

myconcat :: [[t]] -> [t]
myconcat [] = []
myconcat (x:xs) = x ++ myconcat xs

mymaximum :: Ord a => [a] -> a
mymaximum [] = error "Empty list"
mymaximum [x] = x
mymaximum (x1:x2:xs)
  | x1 > x2   = mymaximum (x1:xs)
  | otherwise = mymaximum (x2:xs)

myzip :: [t] -> [t] -> [[t]]
myzip [][] = []
myzip _ [] = []
myzip [] ys = []
myzip (x:xs)(y:ys) = [[x,y]] ++ myzip xs ys

-- OPGAVE 7
-- r :: (Ord t, Num t) => t -> t -> [t]
r :: Num t => t -> t -> [t]
r a d = [a] ++ r (a+d) d
--  | a>200     = []
--  | otherwise = [a] ++ r (a+d) d

r1 :: (Num a, Ord a) => a -> a -> Int -> a
r1 a d n = (r a d)!!(n-1)

total :: (Ord t, Num t) => t -> t -> Int -> Int -> t
total a d i j 
  | i == j      = r1 a d j
  | otherwise   = (r1 a d i) + (total a d (i+1) j)

-- OPGAVE 8
allEqual :: Eq a => [a] -> Bool
allEqual [] = True
allEqual [x] = True
allEqual (x1:x2:xs) 
  | x1 == x2  = allEqual(x1:xs)
  | otherwise = False
 
isAS :: (Eq a, Num a) => [a] -> Bool 
isAS [] = False
isAS [x] = False
isAS [x,y] = True
isAS (x1:x2:x3:xs) = allEqual [(x2-x1), (x3-x2)] && isAS(x2:x3:xs) 
-- isAS (x1:x2:x3:xs) = (x2-x1)==(x3-x2) && isAS(x2:x3:xs)

-- OPGAVE 9
equalRowLength :: Foldable t => [t a] -> Bool
equalRowLength [] = True
equalRowLength [x] = True
equalRowLength (x1:x2:xs) = (length x1 == length x2) && equalRowLength (x2:xs) 
 
totalRowAmount :: (Foldable t, Num a) => [t a] -> [a]
totalRowAmount [] = []
totalRowAmount [x] = [sum x]
totalRowAmount (x:xs) = [sum x] ++ totalRowAmount xs 

transpose :: [[a]] -> [[a]]
transpose ([]:_) = [] 
transpose xs = [map head xs] ++ transpose (map tail xs)

totalColumnAmount :: Num t => [[t]] -> [t]
totalColumnAmount [[]] = []
totalColumnAmount xs = totalRowAmount (transpose xs)

