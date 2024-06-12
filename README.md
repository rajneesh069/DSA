# Notes

## Binary Search tid-bits

1. You find target when start = end = target.
2. Create an `ans` variable to store the potential answer.
3. To find the last occurence of a repeated element in a sorted array, use `start = mid+1` in the `else` statement to break the loop and make sure you're storing the answer in that only.
4. To find the last occurence, use `end = mid-1` to break the loop.

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

1. Identify if problem could be broken down into smaller problems
2. Write recurrence relation if needed
3. Draw the recursion tree
4. About the tree :
   a. See the flow of the functions, and how they are called.
   b. Identify and focus on left tree calls (firstly left side will be evaluated (in fibo(n-1)+fibo(n-2), fibo(n-1) will be called first)) and right tree calls
   c. Until the left tree call completes, right side won't be called
   d. See how the values are returned 'at each step!'
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

Now in the body of the function we'll need three varibles of `int` type which are : `start`, `end` and `mid`, and the next function call will require the `start` and `end` of the previous call hence we'll need to pass them in the arguments of the function (`mid` would be evaluated in the body itself so needs not to be passed).

`Whatever you'll put in the arguments is going to go in the next function call, remember that!`

And since we want to divide the array in half(see the recurrence relation) then obviously we'll need the previous `end` and `start` and the only way to get it is : through arguments!

`mid` here is the variable which will be in the body of the function because it will be specific(calculated for each function based on `start` and `end`) for each function.

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
           return  search(arr, target, start, end);
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

#### General trend : O(1) < O(log(n)) < O(n) < O(n^2) < O(2^n)

Other time complexities like `nlog(n)` exist too, we'll have to figure out the trend accordingly if asked to compare.
Exponential time complexity is the worst as even for the small amount of data it will take a lot of time.

#### Big-O notation gives the upper bound, i.e., the time complexity won't exceed the function inside it.

For example, O(N^3) means that the algorithm could have time complexities of the order of 1, N^2, NlogN, logN but shouldn't exceed N^3.

f(N) = O(g(N))
lim (N -> inf) f(N)/g(N) < inf

#### Big-Omega gives the lower bound, i.e., the time complexity should be atleast the function inside it.

Opposite of Big-O

f(N) = O(g(N))
lim (N -> inf) f(N)/g(N) > 0

#### Theta Notation gives the upper and lower bound both, like if the upper and lower bound both are N^2 for an alogrithm then Theta(N^2) will represent that.

Theta(N^2)
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

## Bit Manipulation

### AND(&)

1. If you do '&' operation with 1, then the bits remain same.
   1 & a = a

### XOR(^)

1. If you do '^' operation with 1, it gives the complement of that number.
2. a ^ a = 0
3. a ^ 0 = a

### Left shift operator(<<)

1. a<<1 = a*2 -> a << b = a * 2^b(generally true unless there's an overflow). Multiplies by 2.
   Add 0 when you need an extra bit
   Eg. 1010 << 1 = 10100 which is 20 in decimal.
2. 1 << (n-1) = 1 \* 2^(n-1)

### Right shift operator(>>)

1. a>>b = a/(2^b), divides by 2.(always true)
   1010 >> 1 = 0101, which is 5 in decimal. Leading zeroes are ignored in every number system.

Examples :

1. Find ith bit in a number
   Ans. Use masking.
   110101, find the 3rd bit(from right obviously)
   110101 & (1<<2) = 1.
   1 << (n-1) -> and with this value, and here n = 3;
   110101
   &000100
   This will give 1.

2. Set ith bit
   110101, set the 4th bit.
   OR it with the proper mask, i.e., (1<<3) OR 110101

3. Reset ith bit
   110101, reset the 5th bit.
   AND it with the complement of the mask, i.e., !(1<<4) & 110101
