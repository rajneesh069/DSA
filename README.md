# Notes

## !!!Some important things!!!

### 1. `char to int conversion : char - '0'`

### 2. number of digits in a number(say, a) = (int)(Math.log(a)) + 1

3. Linear Search program in which the list has not been passed as an argument, it contains a very important concept that the function call returns finally to the place where it was called:

```java
static ArrayList<Integer> search(int[] arr, int target, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (start == arr.length) {
            return list;
        }
        if (arr[start] == target) {
            list.add(start);
        }

        ArrayList<Integer> ansFromBelow = search(arr, target, ++start); // very clever line!
        list.addAll(ansFromBelow);

        return list;
    }
```

## Binary Search tid-bits

1. You find target when start = end = target.
2. Create an `ans` variable to store the potential answer.
3. To find the last occurence of a repeated element in a sorted array, use `start = mid+1` in the `else` statement to break the loop and make sure you're storing the answer in that only.
4. To find the first occurence, use `end = mid-1` to break the loop.

#### Following example illustrates those useful insights :

```java
    public class BSTidBits{
        public static void main(String[] args){

        }

        static int binarySearch(int[] arr, int target){
            int ans = -1;
            int start = 0;
            int end = arr.length-1;
            while(start<=end){
                int mid = start + (end - start)/2;
                if(arr[mid] < target){
                    start = mid+1;
                }else if(arr[mid] > target){
                    end = mid-1;
                }else{
                    start = mid+1;
                    //gives the last occurence of the repeated element, and of course
                    //helps in breaking the loop as start will exceed end.
                    ans = mid;
                }
            }
        }
    }

```

## Recursion

### Do not overthink. Overthink about recursion after solving the problem.

##### Function calls return finally to the place they were called.

##### !!! Important !!!

```java
public class Main{
    public static void main(String[] args){
        int ans = someFunction();
        System.out.println("ans: "+ans);
    }

    static int someFunction(){
        return 69;
    }
}
```

After execution of `someFunction()`, it'll return(5 here) to that line(`int a = someFunction()`) defined above and ans will be assigned the return value of `someFunction()`.

1. Identify if problem could be broken down into smaller problems.
2. Write recurrence relation if needed.
3. Draw the recursion tree.
4. About the tree :
   a. See the flow of the functions, and how they are called.

   b. Identify and focus on left tree calls (firstly left side will be evaluated (in fibo(n-1)+fibo(n-2), fibo(n-1) will be called first)) and right tree calls.

   c. Until the left tree call completes, right side won't be called.

   d. See how the values are returned 'at each step'!

   e. See where the function call comes out.

#### Types of recurrence relation

1. Linear (fibo(n-1) + fibo(n-2))
2. Divide and Conquer (Binary Search)
   f(n) = O(1) + f(n/2) -> Recurrence Relation for Binary Search, O(1) denotes some constant time comparison/operation and since the search space is reduced by a factor(of 2 here), it is very fast.

#### Variables in Recursion :

1. Arguments -> think about it
2. Return type -> easy to figure out
3. Body of the function -> think about it

Here's the example of Binary Search :

This is the starting code, following code snippets will be updated to show the thinking process according to the points that follow through.

```java
public class BinarySearch{
    public static void main(String[] args){

    }

    //we'll return the index, so return type is int.
    static int search(int[] arr, int target){
    }
}

```

In the above code snippet we can clearly see that return type is easy to figure out. Now we'll try to think about the arguments, i.e., what arguments to pass and what should be their data type.

Now in the body of the function we'll need three varibles of `int` type which are : `start`, `end` and `mid`, and the next function call will require the `start` and `end` of the previous call hence we'll need to pass them in the arguments of the function as well (`mid` would be evaluated in the body itself, so needs not to be passed).

`Whatever you'll put in the arguments is going to go in the next function call, remember that!`

And since we want to divide the array in half(see the recurrence relation) then obviously we'll need the previous `end` and `start` and the only way to get it is : through arguments!

`mid` here is the variable which will be in the body of the function because it will be specific(based on `start` and `end`) for each function.

##### Whichever variable is needed in the future function calls pass them as arguments/parameters of the function and whichever are specific to a function call need to be kept in the body.

```java
public class BinarySearch{
    public static void main(String[] args){

    }

    //start and end are required in the future function calls hence they are provided in the argument itself.
    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2; //body variable
        if(arr[mid] ==  target){
            return mid;
        }else if(target < arr[mid]){
            end = mid-1;
            search(arr, target, start, end); //function call made with updated end variable
        }else{
            start = mid+1;
            search(arr, target, start, end); //function call made with updated start variable
        }

    }
}

```

##### But there's an error in the above code, can you spot it?

#### It is that whenever we call the function we don't return anything and whenever you have a return type always return the function.

##### Final code :

```java
public class BinarySearch{
    public static void main(String[] args){

    }

    //start and end are required in the future function calls hence they are provided in the argument itself.
    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2; //body variable
        if(arr[mid] ==  target){
            return mid;
        }else if(target < arr[mid]){
            end = mid-1;
           return search(arr, target, start, end);
           //function call made with updated end variable and added the return statement
        }else{
            start = mid+1;
           return search(arr, target, start, end);
           //function call made with updated start variable and added the return statement
        }

    }
}

```

## Time Complexity

### Time Complexity != Time Taken

#### It is actually how (in what fashion) the time increases as the input size increases.

1. Constants and less power terms are ignored while writing the function in the big O notation. We are not interested in actual time, but how does it grow when `dataset is large`.
2. Always look for worst case time complexity.

#### General trend : O(1) < O(log(n)) < O(n) < O(n<sup>2</sup>) < O(2<sup>n</sup>)

Other time complexities like `nlog(n)` exist too, we'll have to figure out the trend accordingly if asked to compare.
Exponential time complexity is the worst as even for the small amount of data it will take a lot of time.

#### Big-O notation gives the upper bound, i.e., the time complexity won't exceed the function inside it.

For example, O(N<sup>3</sup>) means that the algorithm could have time complexities of the order of 1, N<sup>2</sup>, NlogN, logN but shouldn't exceed N<sup>3</sup>.

f(N) = O(g(N))
lim (N -> inf) f(N)/g(N) < inf

#### Big-Omega gives the lower bound, i.e., the time complexity should be atleast the function inside it.

Opposite of Big-O

f(N) = O(g(N))
lim (N -> inf) f(N)/g(N) > 0

#### Theta Notation gives the upper and lower bound both, like if the upper and lower bound both are N<sup>2</sup> for an alogrithm then Theta(N<sup>2</sup>) will represent that.

Theta(N<sup>2</sup>)
inf > lim (N -> inf) f(N)/g(N) > 0

##### Little O Notation gives the loose upper bound, not strict like Big O.

Little O is the less than and Big O is less than or equal to.

#### Little omega gives the loose lower bound, not strict like Big Omega.

Little omega is less than and Big Omega is less than or equal to.

## Space Complexity

It is the `input` space and the `auxiliary` space. In interviews we can't do anything about the input space hence we care about `auxiliary` space.

### Recursive Algorithms

Space complexity = Height of the tree, and remember that the interlinked function calls will be in the stack at the same time NOT the unlinked ones!

For fibonacci, the space complexity is O(n).

Types of Recurrence relations :

1. Linear
2. Divide and Conquer

Recursions have recurrence relations, i.e., can be represented in the form of an equation.

#### Divide and Conquer Recurrence Relation :

##### Form : T(x) = a1*T(b1*x+e1*(x)) + a2*T(b2*x+e2*(x)) +....+ak*T(bk*x+ek\*(x)) + g(x);

For binary search : a1 = 1, b1 = 1/2, e1(x) = 0, g(x) = c

## Bitwise Operators and Bit Manipulation

1. n & (-n) gives us the position right most set bit.
2. XOR from 0 to a :
   1. a % 4 == 0 : a
   2. a % 4 == 1 : 1
   3. a % 4 == 2 : a + 1
   4. a % 4 == 3 : 0
3. bit ^ 1 = flipped bit
4. To find ith set bit in 'n', do (1<<(i-1)) & (n) : This is masking and is used at many places.

### AND(&)

1. If you do '&' operation with 1, then the bits remain same.
   1 & a = a

### XOR(^)

1. If you do '^' operation with 1, it gives the complement of that number.
2. a ^ a = 0
3. a ^ 0 = a

### Left shift operator(<<)

1. a<<1 = a*2 -> a << b = a * 2<sup>b</sup>(generally true unless there's an overflow).

   Multiplies by 2.

   Add 0 when you need an extra bit

   Eg. 1010 << 1 = 10100 which is 20 in decimal.

2. 1 << (n-1) = 1 \* 2<sup>(n-1)</sup>

### Right shift operator(>>)

1. a>>b = a/(2<sup>b</sup>), divides by 2.(always true)
   1010 >> 1 = 0101, which is 5 in decimal.

   Leading zeroes are ignored in every number system.

Examples :

1. a<sup>b</sup> in O(log(b)) time complexity using right shift operator

   ```java
   // O(log(b)) -> time complexity

    public static int pow(int base, int index) {
       int ans = 1;
       while (index != 0) {
           if ((index & 1) != 0) {
               ans = ans * base;
           }
           base *= base;
           index = index >> 1;
       }
       return ans;
   }
   ```

2. Find ith bit in a number
   Ans. Use masking.

   "110101, find the 3rd bit(from right obviously)

   110101 & (1<<2) = 1.

   1 << (n-1) -> and with this value, and here n = 3;

   0110101
   &000100

   This will give 1.

3. Set ith bit

   110101, set the 4th bit.

   OR it with the proper mask, i.e., (1<<3) OR 110101

4. Reset ith bit

   110101, reset the 5th bit.

   AND it with the complement of the mask, i.e., !(1<<4) & 110101

#### Time complexity of Sieve Of Eratostheneses = O(N\*log(logN))

## Modulo Properties

1. (a+b)%m = ((a%m) + (b%m))%m
2. (a-b)%m = ((a%m) - (b%m)+m)%m
3. (a\*b)%m = ((a%m)\*(b%m))%m
4. (a/b)%m = ((a%m)\*((b<sup>-1</sup>)%m))%m

   (b<sup>-1</sup>)%m is known as multiplicative modulo inverse.
   It also means that `b` and `m` are co-primes.

5. (a%m)%m = a % m
6. m<sup>x</sup> % m = 0, for all x > 0.
7. If p is a prime number which is not a divisor of b then ab<sup>p-1</sup>%p = a%p, due to Fermat's little theorem.

## GCD/HCF

Definition : HCF of 2 numbers(say, a and b) is the `minimum positive` value of the equation `ax+by`, where `x and y are integers`.

Whatever HCF you'll get will be `common`.

So, suppose 3x + 9y = 18, then the GCD of 3 and 9 will be 3 and will come out as `common`, so the equation reduces to x+3y = 6, i.e., 18 is divisible by 3. That gives us the solution to die-hard problem that yes using 3L and 9L bucket we can form 18L of water, because 3 came out as common and gave us an integer so combination of x and y will be there.

For, 2x+4y = 5 however, we can't do it, as 2 will be HCF and come out as common from the equation which won't divide 5 hence no combination of x and y will ever result in 5 as an answer.

If GCD is 1, then you can form any type RHS from the combination of x and y.

### Euclid's algorithm : gcd(a,b) = gcd(rem(b,a),a)

## LCM

Definition : Minimum number dvisible by both the numbers.

HCF \* LCM = Product of 2 numbers
