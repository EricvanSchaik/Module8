import Data.Char


-- Exercise 1
f x = 2*x^2 + 3*x - 5


-- Exercise 2
code :: Char -> Char
code x
    | (96 < ord x && ord x < 120) || (64 < ord x && ord x < 88) = chr ((ord x) + 3)
    | (119 < ord x && ord x < 123) || (87 < ord x && ord x < 91) = chr ((ord x ) - 23)
    | otherwise = x

gencode :: Char -> Int -> Char
gencode x n
    | (96 < ord x && ord x < (123 - y)) || (64 < ord x && ord x < (91 - y)) = chr ((ord x) + y)
    | ((122 - y) < ord x && ord x < 123) || ((90 - y) < ord x && ord x < 91) = chr ((ord x) + y)
    | otherwise = x
    where y = n `mod` 26


-- Exercise 3
amount :: (Num t, Eq t, Fractional t) => t -> t -> t -> t
amount a r 1 = a*(1 + r/100)
amount a r n = (amount a r (n - 1))*(1 + r/100)


-- Exercise 4
discr :: (Floating t, Ord t) => t -> t -> t -> t
discr a b c = b^2 - 4*a*c
root1 :: (Floating t, Ord t) => t -> t -> t -> t
root1 a b c
    | (discr a b c ) < 0 = error "negative discriminant"
    | otherwise = (-b - sqrt(discr a b c ))/(2*a)
root2 :: (Floating t, Ord t) => t -> t -> t -> t
root2 a b c
    | (discr a b c ) < 0 = error "negative discriminant"
    | otherwise = (-b + sqrt(discr a b c ))/(2*a)


-- Exercise 5
extrX :: Fractional t => t -> t -> t -> t
extrX a b c = -b/(2*a)

extrY :: Fractional t => t -> t -> t -> t
extrY a b c = a*x^2 + b*x + c
    where x = extrX a b c


-- Exercise 6
mylength :: Num t => [t1] -> t
mylength [x] = 1
mylength (x:xs) = 1 + mylength xs

mysum :: Num t => [t] -> t
mysum [x] = x
mysum (x:xs) = x + mysum xs

myreverse :: Num t => [t] -> [t]
myreverse [x] = [x]
myreverse (x:xs) = myreverse xs ++ [x]

mytake :: (Num t, Eq t) => [t1] -> t -> [t1]
mytake [x] n = [x]
mytake (x:xs) 1 = [x]
mytake (x:xs) n = [x] ++ mytake xs (n - 1)

myelem :: Eq t => [t] -> t -> Bool
myelem [x] y = x == y
myelem (x:xs) y
    | x == y = True
    | otherwise = myelem xs y

myconcat :: [[t]] -> [t]
myconcat [x] = x
myconcat (x:xs) = x ++ myconcat xs

mymaximum :: Ord t => [t] -> t
mymaximum [x] = x
mymaximum (x1:x2:xs)
    | x1 > x2 = mymaximum (x1:xs)
    | otherwise = mymaximum (x2:xs)

myzip :: [t] -> [t] -> [[t]]
myzip x [] = []
myzip [] x = []
myzip (x1:x1s) (x2:x2s) = [[x1, x2]] ++ myzip x1s x2s


-- Exercise 7
r :: Num t => t -> t -> [t]
r a d = [a] ++ r (a + d) d

r1 :: Num t => t -> t -> Int -> t
r1 a d n = (r a d)!!(n - 1)

total :: Num t => t -> t -> Int -> Int -> t
total a d i j
    | i < j = (r1 a d i) + (total a d (i + 1) j)
    | otherwise = r1 a d i


-- Exercise 8
allEqual :: Eq t => [t] -> Bool
allEqual [] = True
allEqual [x] = True
allEqual (x1:x2:xs) = x1 == x2 && allEqual (x2:xs)

isAS :: (Num t, Eq t) => [t] -> Bool
isAS [] = True
isAS [x] = True
isAS [x1,x2] = True
isAS (x1:x2:x3:xs) = allEqual [(x2-x1), (x3-x2)] && isAS(x2:x3:xs)


-- Exercise 9
equalRowLength :: Num a => [[a]] -> Bool
equalRowLength [] = True
equalRowLength [x] = True
equalRowLength (x1:x2:xs) = length x1 == length x2 && equalRowLength (x2:xs)

sumOfRows :: Num a => [[a]] -> [a]
sumOfRows [] = []
sumOfRows [x] = [sum x]
sumOfRows (x:xs) = [sum x] ++ sumOfRows xs

transposeMatrix :: [[a]] -> [[a]]
transposeMatrix ([]:_) = []
transposeMatrix x = [map head x] ++ transposeMatrix (map tail x)

sumOfColumns :: Num a => [[a]] -> [a]
sumOfColumns x = sumOfRows (transposeMatrix x)