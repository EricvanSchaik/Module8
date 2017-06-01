import Data.Char
import Data.List


-- Exercise 1
myfilter :: (a -> Bool) -> [a] -> [a]
myfilter f [] = []
myfilter f (x:xs) = if (f x) then [x] ++ myfilter f (xs) else myfilter f (xs)

myfoldl :: (a -> b -> a) -> a -> [b] -> a
myfoldl f x [] = x
myfoldl f x [y] = f x y
myfoldl f x (y:ys) = myfoldl f (f x y) ys

myfoldr :: (a -> b -> b) -> b -> [a] -> b
myfoldr f x [] = x
myfoldr f x [y] = f y x
myfoldr f x y = myfoldr f (f (last y) x) (init y)

myzipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
myzipWith f x [] = []
myzipWith f [] y = []
myzipWith f (x:xs) (y:ys) = [f x y] ++ myzipWith f xs ys


-- Exercise 2a
database :: [([Char], Integer, [Char], [Char])]
database = [("henk", 50, "Male", "Amsterdam"), ("ingrid", 52, "Female", "Amsterdam"), ("ivanka", 33, "Female", "Washington")]


-- Exercise 2b
getName :: (a, b, c, d) -> a
getName (x,_,_,_) = x

getAge :: (a, b, c, d) -> b
getAge (_,x,_,_) = x

getSexe :: (a, b, c, d) -> c
getSexe (_,_,x,_) = x

getResidence :: (a, b, c, d) -> d
getResidence (_,_,_,x) = x


-- Exercise 2c
incAgeRec :: Num a => a -> [(b, a, c, d)] -> [(b, a, c, d)]
incAgeRec n [] = []
incAgeRec n ((name, age, sexe, residence):xs) = [(name, age+n, sexe, residence)] ++ incAgeRec n xs

incAgeLCompr :: Num a => a -> [(b, a, c, d)] -> [(b, a, c, d)]
incAgeLCompr n x = [(name, age+n, sexe, residence) | (name, age, sexe, residence) <- x]

incAgeHOrd :: Num a => a -> [(b, a, c, d)] -> [(b, a, c, d)]
incAgeHOrd1 n (name, age, sexe, residence) = (name, age+n, sexe, residence)
incAgeHOrd n x = map (incAgeHOrd1 n) x


-- Exercise 2d
namesWomenRec :: (Ord b, Num b) => [(a, b, [Char], d)] -> [a]
namesWomenRec [] = []
namesWomenRec ((name, age, sexe, residence):xs)
    | age > 30 && age < 40 && sexe == "Female" = name : namesWomenRec xs
    | otherwise = [] ++ namesWomenRec xs

namesWomenLCompr :: (Ord b, Num b) => [(a, b, [Char], d)] -> [a]
namesWomenLCompr x = [name | (name, age, sexe, residence) <- x, age > 30, age < 40, sexe == "Female"]

namesWomenHOrd :: (Ord b, Num b) => [(a, b, [Char], d)] -> [a]
namesWomenHOrd x = map getName (filter (\(name, age, sexe, residence) -> age > 30 && age < 40 && sexe == "Female") x)


-- Exercise 2e
getAgeByName :: Num b => [Char] -> [([Char], b, c, d)] -> b
getAgeByName s [] = 0
getAgeByName s ((a, b, c, d):xs)
    | map (toLower) s == a = b
    | otherwise = getAgeByName s xs


-- Exercise 2f
sortByAge :: [([Char], Integer, [Char], [Char])] -> [([Char], Integer, [Char], [Char])]
sortByAge x = sortByAge1 (sort (sortByAge1 x))
sortByAge1 x = map (\(a, b, c, d) -> (b, a, c, d)) x


-- Exercise 3a
sieve :: [Integer]
sieve = sieve1 [2..]
sieve1 [] = []
sieve1 (x:xs) = x : sieve1 [y | y <- xs, y`mod`x /= 0 ]


-- Exercise 3a1
isPrime :: Integer -> Bool
isPrime x = elem x (take (fromIntegral x) sieve)


-- Exercise 3a2
firstPrimes :: Int -> [Integer]
firstPrimes n = take n sieve


-- Exercise 3a3
smallerPrimes :: Integer -> [Integer]
smallerPrimes n = takeWhile (<n) sieve


-- Exercise 3b
dividers :: Integer -> [Integer]
dividers m = [x | x <- [1..m], m`mod`x == 0]

altPrime :: Integer -> Bool
altPrime m = dividers m == [1, m]


-- Exercise 4a
pyth :: Integer -> [(Integer, Integer, Integer)]
pyth n = [(a, b, c) | a <- [1..n], b <- [1..n], c <- [1..n], a^2 + b^2 == c^2]


-- Exercise 4b
pyth' :: Integer -> [(Integer, Integer, Integer)]
pyth' n = map listToTuple (removeDuplicates (map sortTuple (pyth n)))
removeDuplicates [x] = [x]
removeDuplicates (x:xs)
    | elem x xs = [] ++ removeDuplicates xs
    | otherwise = [x] ++ removeDuplicates xs
sortTuple (a, b, c) = sort [a, b, c]
listToTuple [a, b, c] = (a, b, c)


-- Exercise 5a
increasing :: [Integer] -> Bool
increasing [x] = True
icreasing (x1:x2:xs)
    | x1 < x2 = increasing (x2:xs)
    | otherwise = False


-- Exercise 5b
weakIncr :: [Int] -> Bool
weakIncr [x] = True
weakIncr x
    | last x > (sum (init x) `div` (length (init x))) = weakIncr (init x)
    | otherwise = False


-- Exercise 6a
sublist :: Eq a => [a] -> [a] -> Bool -> Bool
sublist xs [] = False
sublist [x] (y:ys) = x == y
sublist (x:xs) (y:ys)
    | x == y = sublist xs ys
    | otherwise = sublist (x:xs) ys


-- Exercise 6b
--partialSublist :: Eq a => [a] -> [a] -> Bool
--partialSublist xs [] = False
--partialSublist [x] (y:ys) = x == y
--partialSublist