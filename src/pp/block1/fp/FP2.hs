import Data.List
import Data.List.Split
import Data.Char

-- OPGAVE 1 
myfilter :: (t1 -> Bool) -> (t -> t1) -> [t] -> [t]
myfilter f g [] = []
myfilter f g (x:xs) = if (f (g x)) then [x] ++ myfilter f g xs else myfilter f g xs

myfoldl :: (t1 -> t -> t1) -> t1 -> [t] -> t1
myfoldl f y [] = y
myfoldl f y [x] = f y x
myfoldl f y (x:xs) = myfoldl f (f y x) xs

myfoldr :: (a -> t -> t) -> t -> [a] -> t
myfoldr f y [] = y
myfoldr f y [x] = f x y
myfoldr f y xs = myfoldr f (f (last xs) y) (init xs)

myzipWith :: (t1 -> t -> a) -> [t1] -> [t] -> [a]
myzipWith f xs [] = []
myzipWith f [] ys = []
myzipWith f [x] [y] = [f x y]
myzipWith f (x:xs) (y:ys) = [f x y] ++ myzipWith f xs ys

-- OPGAVE 2
getName :: (t3, t2, t1, t) -> t3
getName (x,_,_,_) = x

getAge :: (t3, t2, t1, t) -> t2
getAge (_,x,_,_) = x

getSexe :: (t3, t2, t1, t) -> t1
getSexe (_,_,x,_) = x

getResidence :: (t3, t2, t1, t) -> t
getResidence (_,_,_,x) = x

-- 2A
database :: [([Char], Integer, [Char], [Char])]
database = [("piet", 20, "Male", "Utrecht"), ("anna", 32, "Female", "Groningen"), ("henk", 30, "Male", "Enschede"), ("marie", 1, "Female", "Nijmegen")]

search :: [Char] -> Int -> ([Char], Integer, [Char], [Char])
search name n 
  | n == length database = error "Not in database"
  | getName (database!!n) == name = database!!n 
  | otherwise = search name (n+1) 

lowerString :: [Char] -> [Char]  
lowerString str = [toLower new | new<-str]

-- 2B
extractPerson :: [Char] -> ([Char], Integer, [Char], [Char])
extractPerson name = search (lowerString name) 0

extractName :: [Char] -> [Char]
extractName name = getName (search (lowerString name) 0)

-- 2E
extractAge :: [Char] -> Integer
extractAge name = getAge (search (lowerString name) 0)

extractSexe :: [Char] -> [Char]
extractSexe name = getSexe (search (lowerString name) 0)

extractResidence :: [Char] -> [Char]
extractResidence name = getResidence (search (lowerString name) 0)

-- 2C
incAge1 :: Num t3 => t3 -> [(t2, t3, t1, t)] -> [(t2, t3, t1, t)]
incAge1 n [] = []
incAge1 n ((name, age, sexe, residence):xs) = [(name, (age+n), sexe, residence)] ++ incAge1 n xs

incAge2 :: Integer -> [([Char], Integer, [Char], [Char])]
incAge2 n = [(name, (age+n), sexe, residence) | (name, age, sexe, residence)<- database]

incAge3 :: Integer -> [([Char], Integer, [Char], [Char])]
incAge3' n (name, age, sexe, residence) =  (name, (age+n), sexe, residence)
incAge3 n = map (incAge3' n) database

-- 2D
women1 :: (Ord a, Num a) => [(a1, a, [Char], t)] -> [a1]
women1 [] = []
women1 ((name, age, sexe, residence):xs) 
  | (30<age) && (age<40) && (sexe=="Female")  = name : women1 xs
  | otherwise                                 = [] ++ women1 xs  

women2 :: [[Char]]  
women2 = [getName (name, age, sexe, residence) | (name,age,sexe,residence)<-database, sexe=="Female", age>30, age<40]

women3' :: (Ord a, Num a) => (t1, a, [Char], t) -> Bool
women3' (name, age, sexe, residence) = (30<age) && (age<40) && (sexe=="Female")    

women3 :: [[Char]]
women3 = map getName (filter women3' database) 

-- 2F
sorting :: Ord t2 => [(t3, t2, t1, t)] -> [(t3, t2, t1, t)]
sorting [] = []
sorting [x] = [x]
sorting (x:xs) = sorting [a | a<-xs, getAge(a)<=getAge(x)] ++ [x] ++ sorting [a| a<-xs, getAge(a)>getAge(x)]
  
-- OPGAVE 3A 
-- 1
sieve :: Integral t => [t] -> [t]
sieve [] = []
sieve (p:xs) = p : sieve [x|x<-xs, x`mod`p /= 0]

-- 2
isPrime :: Integral t => t -> Bool
isPrime n = n `elem` (sieve [2..n])

-- 3
firstPrimes :: Integral a => Int -> [a]
firstPrimes n = take n (sieve [2..]) 

-- 4
smaller :: Ord t => t -> [t] -> [t]
smaller n [] = []
smaller n (x:xs) 
 | x < n      = [x] ++ smaller n xs
 | otherwise  = []

smallPrime :: Integral t => t -> [t]
smallPrime n = smaller n (sieve [2..n])

-- OPGAVE 3B 
dividers :: Integral t => t -> [t]
dividers 0 = [1..]
dividers m = divide m
  where 
    divide 0 = []
    divide n
      | m `mod` n == 0  = [n] ++ divide (n-1)
      | otherwise       = divide (n-1)

isPrimeAlt :: Integral a => a -> Bool
isPrimeAlt m 
  | length (dividers m) == 2  = True
  | otherwise                 = False
  
-- OPGAVE 4A
pyth :: (Num t, Eq t, Enum t) => t -> [(t, t, t)]
pyth n = [(a,b,c)|a<-[1..(n-1)], b<-[1..(n-1)], c<-[1..(n-1)], (a^2)+(b^2)==(c^2)]

pyth2 :: [(Integer, Integer, Integer)]
pyth2 = [(a,b,c)|a<-[1..], b<-[1..], c<-[1..], (a^2)+(b^2)==(c^2)]

-- OPGAVE 4B
get1 :: (t2, t1, t) -> t2
get1 (x,_,_) = x

get2 :: (t1, t2, t) -> t2
get2 (_,x,_) = x

get3 :: (t1, t, t2) -> t2
get3 (_,_,x) = x

double :: (Integral t1, Integral t, Integral a) => (t1, t, a) -> [(t1, t, a)] -> Bool
double x [] = False
double x xs 
  | x == (head xs) = double x (tail xs)
  | (get1 x`mod`get1 (head xs) == 0) && (get2 x`mod`get2 (head xs) == 0) && (get3 x`mod`get3 (head xs) == 0) = True
  | (get1 (head xs)`mod`get1 x == 0) && (get2 (head xs)`mod`get2 x == 0) && (get3 (head xs)`mod`get3 x == 0) = True
  | otherwise = double x (tail xs)
 
removeDouble :: (Integral a, Integral t, Integral t1) => [(t1, t, a)] -> [(t1, t, a)]
removeDouble [] = [] 
removeDouble xs
  | double (last xs) xs == True   = removeDouble (init xs) ++ []
  | double (last xs) xs == False  = removeDouble (init xs) ++ [last xs]

pyth' :: Integral a => a -> [(a, a, a)]
pyth' n = removeDouble [(a,b,c)|a<-[1..(n-1)], b<-[1..(n-1)], c<-[1..(n-1)], (a^2)+(b^2)==(c^2), a<=b]

-- OPGAVE 5A 
increasing :: Ord a => [a] -> Bool
increasing [] = True
increasing [x] = True
increasing (x:xs)
  | x < (head xs) = increasing xs
  | otherwise = False
  
-- OPGAVE 5B 
avarage :: (Ord t, Fractional t) => t -> t -> [t] -> Bool
avarage a n [] = True
avarage a n (x:xs) 
  | x > a  = avarage (((a*n)+x)/(n+1)) (n+1) xs
  | otherwise = False

weakIncr :: (Fractional t, Ord t) => [t] -> Bool
weakIncr [] = True
weakIncr (x:xs) = avarage x 1 xs

-- OPGAVE 6A 
sublistb :: Eq a => [a] -> [a] -> Bool
sublistb [] ys = True
sublistb xs [] = False
sublistb (x:xs) (y:ys)
  | x == y = sublistb xs ys
  | otherwise = False

sublist :: Eq a => [a] -> [a] -> Bool
sublist xs [] = False
sublist [] ys = True
sublist (x:xs) (y:ys) 
  | x == y  = sublistb xs ys
  | otherwise = sublist (x:xs) ys

-- OPGAVE 6B 
lbid :: Eq a => [a] -> [a] -> Bool
lbid [] [] = True
lbid xs [] = False
lbid [] ys = True
lbid (x:xs) (y:ys)
  | x == y    = lbid xs ys
  | otherwise = lbid (x:xs) ys
  
-- OPGAVE 7A 
bubble :: Ord a => [a] -> [a]
bubble [] = []
bubble [x] = [x]
bubble (x:y:xs)
  | x>y = [y] ++ bubble (x:xs) 
  | otherwise   = [x] ++ bubble (y:xs)

bsort' :: Ord a => Int -> [a] -> [a]
bsort' n xs
  | n == length xs = xs
  | otherwise      = bsort' (n+1) (bubble xs) 

bsort :: Ord a => [a] -> [a]  
bsort [] = [] 
bsort [x] = [x] 
bsort xs = bsort' 1 xs

-- OPGAVE 7B 
mmsort :: Ord a => [a] -> [a]
mmsort [] = []
mmsort [x] = [x]
mmsort xs = [minimum xs] ++ mmsort (xs \\ ([minimum xs] ++ [maximum xs])) ++ [maximum xs]
  
-- OPGAVE 7C 
ins :: Ord a => [a] -> a -> [a]
ins [] y = [y]
ins xs y = [x | x<-xs, x<=y] ++ [y] ++ [x | x<-xs, x>y]

isort :: Ord a => [a] -> [a]
isort [] = []
isort [x] = [x]
isort xs = foldl ins [] xs

-- OPGAVE 7D 
merge :: Ord a => [a] -> [a] -> [a]
merge [] [] = []
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys) 
  | x<=y  = [x] ++ merge xs (y:ys)
  | otherwise = [y] ++ merge (x:xs) ys
  
fsthalf :: [a] -> [a]
fsthalf xs = take (length xs `div` 2) xs

sndhalf :: [a] -> [a]
sndhalf xs = drop (length xs `div` 2) xs

msort :: Ord a => [a] -> [a]
msort [] = []  
msort [x] = [x]
msort xs = merge (msort (fsthalf xs)) (msort (sndhalf xs))

-- OPGAVE 7E 
qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort [x] = [x]
qsort (x:xs) = qsort [a | a<-xs, a<=x] ++ [x] ++ qsort [a| a<-xs, a>x]