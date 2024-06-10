## Notes

### Recursion

##### Function calls return finally to the place they were called.

###### !!! Important !!!

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

1. Identify if problem could be breoken down into smaller problems
2. Write recurrence relation if needed
3. Draw thre recursion tree
4. About the tree :
   a. See the flow of the functions, and how they are called.
   b. Identify and focus on left tree calls (firstly lest side will be evaluated (in fibo(n-1)+fibo(n-2), fibo(n-1) will be called first))
   and the left tree calls
   c. Until the left tree call completes right side won't be called
   d. See how the values are returned 'at each step!'
   e. See where the function call comes out of.

#### Types of recurrence relation

1. Linear (fibo(n-1) + fibo(n-2))
2. Divide and Conquer (Binary Search)
   f(n) = O(1) + f(n/2) -> Recurrence Relation for Binary Search, O(1) denotes some constant time comparison/operation and since the search space is reduced by a factor(of 2 here), which is very fast.
