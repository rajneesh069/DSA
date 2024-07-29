# Notes

## !!!Some important things!!!

### - Always use pen and paper and dry run it!

#### - `char to int conversion : char - '0'`

#### - `number of digits in a number(say, a) = (int)(Math.log(a)) + 1`

#### - Once you identify that the question is from a certain algo, stick to it and tweak it as per needs.

### Linear Search Recursion

Linear Search program in which the list has not been passed as an argument, it contains a very important concept that the function call returns finally to the place where it was called:

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
5. If asked for searching in a sorted array(or `if sorted array mentioned`) then `think of Binary Search.` Or the time complexity of O(log(N)) is required.

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

### Cyclic sort

1. Array contains elements from (1,n) or (0, n) then you can think of cyclic sort.
2. Could be the case that some element is missing in between the range, then also cyclic sort could be applied.

## Recursion

### It helps breaking large problems into smaller ones and then solve them.

- Divide the problem into smaller chunks and solve them to reach the answer/goal.

### Do not overthink. Overthink about recursion after solving the problem.

#### Function calls return finally to the place they were called.

### Basic Concept of recursion

```java
package javaPlayground.revision1.recursion;

public class Main {
    public static void main(String[] args) {
        message(0);
        message2(0);
    }

    private static void message(int n) {
        if (n == 5) { // base condition
            return;
        }
        System.out.println("Hello this is the message function.\s" + n); // prints the message
        message(++n); // calls itself till its 5
    }

    private static void message2(int n) {
        if (n == 5) { // base condition
            return;
        }
        message2(n+1); // calls itself till its 5
        System.out.println("Hello this is the message function.\s" + n); // prints the message
    }
}

```

### !!! Important !!!

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

After execution of `someFunction()`, it'll return(69 here) to that line(`int a = someFunction()`) defined above and ans will be assigned the return value of `someFunction()`.

1. `Identify if problem could be broken down into smaller problems.`
2. Write recurrence relation if needed.
3. Draw the recursion tree.
4. About the tree :

   a. See the flow of the functions, and how they are called.

   b. Identify and focus on left tree calls (firstly left side will be evaluated (in fibo(n-1)+fibo(n-2), fibo(n-1) will be called first)) and right tree calls.

   c. Until the left tree call completes, right side won't be called.

   d. See how the values are returned 'at each step'!

   e. See where the function call comes out.

#### Types of recurrence relations

1. Linear : (fibo(n-1) + fibo(n-2))
2. Divide and Conquer (e.g. Binary Search) :
   f(n) = O(1) + f(n/2) -> Recurrence Relation for Binary Search, O(1) denotes some constant time comparison/operation and since the search space is reduced by a factor(of 2 here), it is very fast.

#### Variables in Recursion

1. Arguments (updated value is passed from previous function to the current function) -> think about it
2. Return type -> easy to figure out
3. Body of the function (variable's value doesn't persist and is re-calculated each time) -> think about it

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

#### Whichever variable is needed in the future function calls pass them as arguments/parameters of the function and whichever are specific to a function call should be kept in the body.

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

#### But there's an error in the above code, can you spot it?

### It is that whenever we call the function we don't return anything and `whenever you have a return type always return the function`.

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

### Some standard approaches/problems in recursion

#### Sum of digits of a number

```java
package javaPlayground.revision1.recursion;

public class SumOfDigits {
    /*
     * Approach to hold answers from previous recursion calls and then
     * add/concatenate them to the current one.
     */
    public static void main(String[] args) {
        System.out.println(digitSum(12345));
        System.out.println(digitSum(12345, 0));
    }

    static int digitSum(int num) {
        return num == 0 ? 0 : (num % 10) + digitSum(num / 10);
        // return in every function call is : digit + digitSum(num/10);
        // except when num==0 then its 0.

        /*
         * Recursive tree :
         * Call 1: 5 + digitSum(1234); --> 5 + 10 = 15 <-- eventually returns this
         * Call 2: 4 + digitSum(123); --> 4 + 6 = 10
         * Call 3: 3 + digitSum(12); --> 3 + 3 = 6
         * Call 4: 2 + digitSum(1); --> 2 + 1 = 3
         * Call 5: 1 + digitSum(0); --> 1 + 0 = 1
         * Call 6: return 0;
         *
         */

        // Then it traces back the recursion adding the answer from the previous
        // function call to the current one eventually returning from Call 1 as 15.
    }

    static int digitSum(int num, int sum) {
        // Pretty self explanatory, we maintained a sum across the function calls and
        // then returned it in the base condition as an answer
        if (num == 0) {
            return sum;
        }
        int digit = num % 10;
        sum += digit;
        return digitSum(num / 10, sum);
    }

    // This is the analogy of recursive method to the iterative method.
    static int iterativeMethodDigitSum(int num) {
        int sum = 0; // sum maintained across the loop by being created outside its scope
        while (num != 0) { // base condition to exit
            int digit = num % 10; // variable which needs not to be maintained
            sum += digit;
            num /= 10;
        }
        return sum; // return the final answer
    }

    /*
     * 1. since sum is maintained across the loop calls, hence put in function
     * parameters
     * 2. digit needs not to be maintained so its in the loop body.
     * 3. num==0 exits the loop hence the base condition in function body
     */
}

```

#### Counting Zeroes in a number

```java
package javaPlayground.revision1.recursion;

public class CountZeroes {
    public static void main(String[] args) {

    }

    // Approach 1 -> maintaining the count across the function calls by
    // parameterizing it

    static int countZeroes(int num, int count) {
        if (num == 0) {
            return count;
        }
        int digit = num % 10;
        if (digit == 0) {
            count++;
        }
        return countZeroes(num / 10, count);
    }

    /*
     * Working :-
     * let num = 1020, count =0;
     * Call 1: countZeroes(1020, 0)
     * Call 2: countZeroes(102, 1)
     * Call 3: countZeroes(10, 1)
     * Call 4: countZeroes(1, 2)
     * Call 5: countZeroes(0, 2)
     * Call 6: countZeroes(0, 2) -> returns count, i.e, 2;
     * Since every function call's return statement exited at line number 19, i.e.,
     * at this statement : return countZeroes(num / 10, count); -> the last line
     * hence the calls before 6 will also go back at that line return the value from
     * previous calls and simply exit the function, and we'll get 2.
     *
     */

    // Approach 2 : adding the count from previous calls while holding the current
    // one
    static int countZeroes(int num) {
        int currentCount = 0;
        if (num == 0) {
            return currentCount;
        }
        int digit = num % 10;
        if (digit == 0) {
            currentCount++;
        }
        int previousCount = countZeroes(num / 10); // every function call before last one
        // will come back to this line, then go below add both the variables and return.
        return currentCount + previousCount;
    }
    // Approach 2 has already been discussed in sum of digits question.
}

```

#### Fibonacci Sequence using recursion

```java
package javaPlayground.revision1.recursion;

public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibo(3));
    }

    private static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}

```

#### Rotated Binary Search using Recursion

```java
package recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(pivotElementWithDuplicateElementsIndex(arr, 0, arr.length - 1));
    }

    static int pivotElementWithDuplicateElementsIndex(int[] arr, int start, int end) {
        if (start > end) {
            return start - 1;
        }
        int mid = start + (end - start) / 2;
        if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid >= 1 && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        } else if (arr[mid] < arr[start]) {
            end = mid - 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else if (arr[mid] == arr[end] && arr[mid] == arr[start]) {
            if (start < end && arr[start] > arr[start + 1]) {
                return start;
            }
            start++;
            end--;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else {
            start = mid + 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        }
    }

    // Second approach
    /*
     * static int pivotElementWithDuplicateElementsIndex(int[] arr, int start, int end) {
        if (start > end) {
            return start - 1;
        }
        int mid = start + (end - start) / 2;
        if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid >= 1 && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        } else if (arr[mid] > arr[start]) {
            start = mid + 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else if (arr[start] == arr[mid] && arr[mid] != arr[end]) {
            start = mid + 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else if (arr[mid] == arr[end] && arr[mid] == arr[start]) {
            if (start < end && arr[start] > arr[start + 1]) {
                return start;
            }
            start++;
            end--;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else {
            end = mid - 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        }
    }
     */
}

```

#### Remove A Character from string

```java
package javaPlayground.revision1.recursion;

public class RemoveACharacter {
    public static void main(String[] args) {
        String up = new String("baccd");
        System.out.println(removeAChar(up));

    }

    static String removeAChar(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.charAt(0) == 'c') {
            return removeAChar(up.substring(1));
        }
        return up.charAt(0) + removeAChar(up.substring(1)); // holding the answer of
        // current call and then adding to it when the previous calls return the
        // answer
    }
}

```

### Subsequences of a string : Processed(p) and Unprocessed(up) Strings Approach

```java
package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class SubSequence {
    // For subsequences, its always processed(p) and unprocessed(up) strings
    public static void main(String[] args) {
        String up = "abc";
        String p = "";
        // subsequences(up, p);
        // ArrayList<String> ans = subsequences(up, p, new ArrayList<String>());
        // System.out.println(ans);
        System.out.println(subsequencesList(up, p));
    }

    // Approach 1
    static void subsequences(String up, String p) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsequences(up.substring(1), p + (ch));
        subsequences(up.substring(1), p);
    }

    // Approach 2
    static ArrayList<String> subsequences(String up, String p, ArrayList<String> list) {
        if (up.isEmpty()) { // You get the answer when the "up" is empty.
            if (!p.isEmpty())
                list.add(p); // add it to the list and return it
            return list;
        }
        char ch = up.charAt(0);
        subsequences(up.substring(1), p + (ch), list);
        subsequences(up.substring(1), p, list);
        return list;
    }

    // Approach 3
    static ArrayList<String> subsequencesList(String up, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (up.isEmpty()) {
            current.add(p);
            return current;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsequencesList(up.substring(1), p + (ch));
        ArrayList<String> right = subsequencesList(up.substring(1), p);
        left.addAll(right);
        return left;
    }
}

```

### Subsets of an array `without` duplicate elements : Iterative Approach

```java
package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class SubsetsOfAnArrayWithUniqueElements {
    public static void main(String[] args) {
        int[] arr = { 1, 2 };
        // subsets : {}, {1}, {2}, {1,2}
        System.out.println(subsetsOfAnArray(arr));
    }
    // we use iterative approach in this case as the recursive one needs
    // backtracking and is less intuitive as well

    static ArrayList<ArrayList<Integer>> subsetsOfAnArray(int[] arr) {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>()); // [ [] ]
        for (int i = 0; i < arr.length; i++) {
            int n = outerList.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> innerList = new ArrayList<>(outerList.get(j)); // copy of the outer list elements
                innerList.add(arr[i]);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}

```

### Subsets of an array with duplicate elements : Iterative Approach

```java
package javaPlayground.revision1.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsOfAnArrayWithDuplicateElements {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        System.out.println(subsets(arr));
    }

    static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        Arrays.sort(arr); // sort the array first
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int start = 0, end = outerList.size() - 1;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (start < end && i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outerList.size() - 1;
            // int n = outerList.size();
            for (int j = start; j <= end; j++) {
                ArrayList<Integer> innerList = new ArrayList<>(outerList.get(j));
                innerList.add(arr[i]);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}
```

### Permutations of a string : Processed and Unprocessed Strings Approach

```java
package javaPlayground.revision1.recursion;

public class Permuatations {
    public static void main(String[] args) {
        String up = new String("abc");
        String p = new String("");
        permuatations(up, p);
    }

    static void permuatations(String up, String p) {
        // since there will be variable function(recursive) calls at each step
        // hence we'll use loops to handle them
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) { // loop to fill spaces
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permuatations(up.substring(1), f + ch + s);
        }
    }
}

```

### Dice Roll Problem using Processed and Unprocessed Strings Approach

```java
package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        System.out.println(diceList(3, ""));
    }

    static void dice(int target, String p) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) { // loop for other combinations
            dice(target - i, p + i);
        }
    }

    // Another approach to hold the answer in prev and then add it to the current
    // array list
    static ArrayList<String> diceList(int target, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (target == 0) {
            current.add(p);
            return current;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            ArrayList<String> prev = diceList(target - i, p + i);
            current.addAll(prev);
        }

        return current;
    }
}

```

### Phone Pad Problem using Processed and Unprocessed Strings Approach

```java
package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        String up = new String("234");
        String p = new String("");
        phonePadCombinations(p, up);
    }

    static void phonePadCombinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int n = (int) (up.charAt(0) - '0');
        if (n == 7) {
            for (int i = 3 * (n - 2); i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        } else if (n == 8) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        } else if (n == 9) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        } else {
            for (int i = 3 * (n - 2); i < 3 * (n - 1); i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        }
    }

    static ArrayList<String> phonePadCombinationsList(String p, String up) {
        ArrayList<String> currentList = new ArrayList<>();
        if (up.isEmpty()) {
            currentList.add(p);
            return currentList;
        }
        int n = (int) (up.charAt(0) - '0');
        if (n == 7) {
            for (int i = 3 * (n - 2); i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        } else if (n == 8) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        } else if (n == 9) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 2; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        } else {
            for (int i = 3 * (n - 2); i < 3 * (n - 1); i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        }
        return currentList;
    }

}

```

- Backtracking in Recursion

- Backtracking is simply used to maintain the state of recursion, i.e., for the same function when the recursion comes back up to it from the stack then the variable's in the body/parameters need to be same.

- For example, when we pass some string/array using reference then the actual string/array is being modified in each function call hence when the recursion comes back up in the tree to run some code below the call then the actual string/array for that function would have been modified which would result in unexpected behavior. So to reset it to the original state, i.e., to the state in which the recursion started for that string/array we revert the changes.

This preserves the actual state of the recursion and allows us to traverse through the recursive tree properly.

- Maze traversal is the best example for this.

- Or when we pass some array/string/variable and we need to come back up in the function to perform some operation on it then we might need to use backtracking if the operations are needed to be performed on the previous version of the variable, i.e., the one with which the recursion was called.

- It's nothing different from recursion, just a fancy name.

## Backtracking

- We revert back the changes while returning to the original function calls in recursion.

### Some standard problems to better understand the concept

### Maze Traversal with Down and Right Paths

```java
package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // mazeTraversal(0, 0, "");
        System.out.println(mazeTraversalList(0, 0, ""));
    }

    static void mazeTraversal(int row, int col, String p) {
        if (row == 2 && col == 2) {
            System.out.println(p);
            return;
        }

        /*
         * You cannot stand at row == 2 || col == 2 because then one of the
         * if conditions would be satisfied and you'll make a move but rather
         * once you reach at 2, the further moves in that direction are blocked!
         */

        if (row < 2) {
            // p = p+ 'D'; Don't do this as it changes 'p' for the whole body.
            mazeTraversal(row + 1, col, p + 'D');
        }

        if (col < 2) {
            // p = p + 'R'; Don't do this as it changes 'p' for the whole body.
            mazeTraversal(row, col + 1, p + 'R');
        }
    }

    static ArrayList<String> mazeTraversalList(int row, int col, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (row == 2 && col == 2) {
            current.add(p);
            return current;
        }

        // Here left and right refer to the calls in recursion tree and not paths.
        if (row < 2) {
            ArrayList<String> left = mazeTraversalList(row + 1, col, p + 'D');
            current.addAll(left);
        }

        if (col < 2) {
            ArrayList<String> right = mazeTraversalList(row, col + 1, p + 'R');
            current.addAll(right);
        }

        return current;
    }
}

```

### Maze Traversal with Down, Right and Diagonal Paths

```java
package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class MazeWithDiagonal {
    public static void main(String[] args) {
        // mazeTraversal(2, 2, "");
        System.out.println(mazeTraversalArrayList(2, 2, ""));
    }

    static void mazeTraversal(int row, int col, String p) {
        if (row == 0 && col == 0) {
            System.out.println(p);
            return;
        }

        /*
         * You cannot stand at row == 0 || col == 0 because then one of the
         * if conditions would be satisfied and you'll make a move but rather
         * once you reach at 0, the further moves in that direction are blocked!
         */

        if (row > 0 && col > 0) {
            mazeTraversal(row - 1, col - 1, p + 'D'); // D : Diagonal
        }

        if (row > 0) {
            mazeTraversal(row - 1, col, p + 'V'); // V : Vertically down
        }

        if (col > 0) {
            mazeTraversal(row, col - 1, p + 'R'); // R : Right
        }

    }

    static ArrayList<String> mazeTraversalArrayList(int row, int col, String p) {
        ArrayList<String> currentPaths = new ArrayList<>();
        if (row == 0 && col == 0) {
            currentPaths.add(p);
            return currentPaths;
        }

        if (row > 0 && col > 0) {
            ArrayList<String> diagonalPath = mazeTraversalArrayList(row - 1, col - 1, p + 'D');
            currentPaths.addAll(diagonalPath);
        }

        if (row > 0) {
            ArrayList<String> downPath = mazeTraversalArrayList(row - 1, col, p + 'V');
            currentPaths.addAll(downPath);
        }
        if (col > 0) {
            ArrayList<String> rightPath = mazeTraversalArrayList(row, col - 1, p + 'R');
            currentPaths.addAll(rightPath);
        }

        return currentPaths;
    }
}

```

### Maze Traversal with obstacles in the path

```java
package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        // mazeWithObstacles(2, 2, "");
        System.out.println(mazeWithObstaclesArrayList(2, 2, ""));
    }

    static void mazeWithObstacles(int row, int col, String p) {
        if (row == 0 && col == 0) {
            System.out.println(p);
            return;
        }

        if (row == 1 && col == 1) { // obstacle at (1,1)
            return;
        }

        if (row > 0 && col > 0) {
            mazeWithObstacles(row - 1, col - 1, p + "D");
        }

        if (row > 0) {
            mazeWithObstacles(row - 1, col, p + 'V');
        }

        if (col > 0) {
            mazeWithObstacles(row, col - 1, p + 'R');
        }
    }

    static ArrayList<String> mazeWithObstaclesArrayList(int row, int col, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (row == 0 && col == 0) {
            current.add(p);
            return current;
        }

        if (row == 1 && col == 1) {
            return current;
        }
        if (row > 0 && col > 0) {
            ArrayList<String> diagonal = mazeWithObstaclesArrayList(row - 1, col - 1, p + 'D');
            current.addAll(diagonal);
        }
        if (row > 0) {
            ArrayList<String> down = mazeWithObstaclesArrayList(row - 1, col, p + 'V');
            current.addAll(down);
        }
        if (col > 0) {
            ArrayList<String> right = mazeWithObstaclesArrayList(row, col - 1, p + 'R');
            current.addAll(right);
        }
        return current;
    }
}

```

### Maze Traversal with all paths allowed, i.e., Up, Down, Left and Right

```java
package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class MazeWithAllPathsAllowed {
    public static void main(String[] args) {
        boolean[][] path = new boolean[3][3];
        mazeTraversalWithAllPaths(2, 2, "", path);
        System.out.println(mazeTraversalWithAllPathsList(2, 2, "", path));
    }

    static void mazeTraversalWithAllPaths(int row, int col, String p, boolean[][] path) {
        if (row == 0 && col == 0) {
            path[row][col] = false;
            System.out.println(p);
            return;
        }
        if (path[row][col] == true) { // return if already visited so that you don't get into infinite loop
            return;
        }

        path[row][col] = true; // as soon as you visit the cell, mark it true
        if (row > 0) {
            mazeTraversalWithAllPaths(row - 1, col, p + 'D', path);

        }
        if (row < 2) {
            mazeTraversalWithAllPaths(row + 1, col, p + 'U', path);
        }
        if (col > 0) {
            mazeTraversalWithAllPaths(row, col - 1, p + 'R', path);
        }
        if (col < 2) {
            mazeTraversalWithAllPaths(row, col + 1, p + 'L', path);
        }
        path[row][col] = false; // backtrack, i.e., revert the changes you made for the future calls
    }

    static ArrayList<String> mazeTraversalWithAllPathsList(int row, int col, String p, boolean[][] path) {
        ArrayList<String> current = new ArrayList<>();
        if (row == 0 && col == 0) {
            path[row][col] = false;
            current.add(p);
            return current;
        }
        if (path[row][col] == true) { // return if already visited so that you don't get into infinite loop
            return current;
        }

        path[row][col] = true; // as soon as you visit the cell, mark it true
        if (row > 0) {
            ArrayList<String> down = mazeTraversalWithAllPathsList(row - 1, col, p + 'D', path);
            current.addAll(down);
        }
        if (row < 2) {
            ArrayList<String> up = mazeTraversalWithAllPathsList(row + 1, col, p + 'U', path);
            current.addAll(up);
        }
        if (col > 0) {
            ArrayList<String> right = mazeTraversalWithAllPathsList(row, col - 1, p + 'R', path);
            current.addAll(right);
        }
        if (col < 2) {
            ArrayList<String> left = mazeTraversalWithAllPathsList(row, col + 1, p + 'L', path);
            current.addAll(left);
        }
        path[row][col] = false; // backtrack, i.e., revert the changes you made for the future calls
        return current;
    }
}
```

## Time Complexity

### Time Complexity != Time Taken

#### It is actually how (in what fashion) the time increases as the input size increases.

1. Constants and less power terms are ignored(only degree terms are kept) while writing the function in the big O notation. We are not interested in actual time, but how does it grow when `dataset increases and becomes large`.
2. Always look for the worst case time complexity.

#### General trend : O(1) < O(log(n)) < O(n) < O(n<sup>2</sup>) < O(2<sup>n</sup>)

Other time complexities like `nlog(n)` exist too, we'll have to figure out the trend accordingly if asked to compare.
Exponential time complexity is the worst as even for the small amount of data the time grows exponentially.

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

Space complexity = Height of the recursion tree, and remember that the interlinked function calls will be in the stack at the same time and NOT the unlinked ones!

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

## Linked List

A linked list is a linear data structure in which elements, known as nodes, are stored in a sequential manner. Each node contains two parts:

1. Data: The value or data stored in the node.
2. Reference (or Pointer): A reference or pointer to the next node in the sequence.

### Singly Linked List without Tail

```java
package javaPlayground.revision1.linkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        list.display();
    }

    private class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private int size = 0;

    public void add(int val) {
        head = add(head, val);
    }

    private Node add(Node head, int val) {
        if (head == null) {
            Node newNode = new Node(val);
            this.size++;
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            /*
             * we need to stop right at the tail when temp = tail,
             * hence temp.next!=null.
             */
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.next = null;
        this.size++;
        return head;
    }

    public void display() {
        display(head);
    }

    private void display(Node head) {
        if (head == null) {
            System.out.println("Linkedlist is empty." + " Size: " + this.size);
            return;
        }
        Node temp = head;
        while (temp != null) {
            /*
             * this loop prints the value hence it needs to run for the tail
             * but it will stop at tail and come out as temp = tail,
             * and since we need it to run for the tail to print its value,
             * hence temp!=null condition is there.
             */
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
    }

    public void insertAfter(int index, int val) {
        head = insertAfter(head, index, val);
    }

    private Node insertAfter(Node head, int index, int val) {
        if (head == null) {
            System.out.println("Linked list is empty. Consider adding an element first.");
            return null;
        } else if (index < 0 && index >= size) {
            System.out.println("Index out of bounds.");
            return head;
        } else if (index == size) {
            head = add(head, val);
            this.size++;
            return head;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
        return head;
    }

    public void remove(int index) {
        head = remove(head, index);
    }

    private Node remove(Node head, int index) {
        if (head == null) {
            System.out.println("Linked list is empty, cannot remove.");
            return null;
        } else if (index < 0 || index >= size) {
            System.out.println("Invalid index, cannot remove.");
            return head;
        } else if (index == 0) {
            head = head.next;
            this.size--;
            return head;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        this.size--;
        return head;
    }
}

```

### Singly Linked List With Tail

```java
package linkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] array = { 1, 2, 3, 4, 5 };
        list.addRecursively(array);
        list.display();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

    }

    private Node head; // head is initially null
    private Node tail; // tail is initially null
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void add(int value) { // 18 -> 7
        Node newNode = new Node(value);
        this.size += 1;
        if (head == null) {
            head = newNode;
            tail = head;
            return; // neat way of initializing the first node
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void add(int value, int index) {
        Node node = new Node(value);
        Node temp = head;
        this.size++;
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }

        else if (index == size) {
            tail.next = node;
            tail = node;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                Node preserveNextNode = temp.next;
                temp.next = node;
                node.next = preserveNextNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int index) {
        this.size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                Node node = temp.next;
                temp.next = node.next;
                return;
            }
            temp = temp.next;
        }
        if (head == null) {
            tail = null;
        }
    }

    public Node nodeAtIndex(int index) { // a utility function for getting node at a particular index
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        this.size += 1;
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public Node find(int value) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
        System.out.println("Size: " + this.size);
    }

    // add using recursion
    public void addRecursively(int[] array) {
        for (int i = 0; i < array.length; i++) {
            head = addRecursively(head, array[i]);
        }
    }

    private Node addRecursively(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.next = null;
            this.size++;
            return newNode;
        }

        node.next = addRecursively(node.next, value);
        tail = node;
        return node;
    }

    // insert with recursion
    public void insert(int value, int index) {
        head = insert(head, value, index);
    }

    private Node insert(Node node, int value, int index) {
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = node.next;
            this.size++;
            return newNode;
        }
        node.next = insert(node.next, value, index - 1);
        return node;
    }

}
```

### Doubly Linked List

```java
package linkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0, 0);
        list.add(1);
        list.display();
    }

    private class Node {
        private int value;
        private Node next = null;
        private Node previous = null;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (head == null) { // for the first node, we don't need to update the head ever
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (tail == null) { // for the first node, we don't need to update the tail ever again
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
        head = newNode;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
        return;
    }

    public void displayInverted() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.previous;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
    }

    public Node getNodeAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Cannot be deleted. Index out of bounds.");
            return;
        }

        this.size--; // size is at least 1
        Node nodeToBeDeleted = getNodeAtIndex(index);

        if (nodeToBeDeleted == head) {
            if (head.next != null) { // head.next will be null if there's only one element
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
            return;
        } else if (nodeToBeDeleted == tail) {
            if (tail.previous != null) {
                tail = tail.previous;
                tail.next = null;
            } else { // tail.previous will be null if and only there's one element
                head = null;
                tail = null;
            }
            return;
        }

        nodeToBeDeleted.previous.next = nodeToBeDeleted.next;
        nodeToBeDeleted.next.previous = nodeToBeDeleted.previous;
    }

    public void insert(int value, int index) {
        if (index < 0) {
            System.out.println("Index out of bounds.");
            return;
        }
        Node newNode = new Node(value);
        Node nodeAtThatIndex = getNodeAtIndex(index);
        if (nodeAtThatIndex != null && nodeAtThatIndex == head) {
            this.size++;
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            head.previous = null;
        } else if (nodeAtThatIndex != null && nodeAtThatIndex != tail) {
            this.size++;
            newNode.previous = nodeAtThatIndex;
            newNode.next = nodeAtThatIndex.next;
            nodeAtThatIndex.next.previous = newNode;
            nodeAtThatIndex.next = newNode;
        } else {
            this.add(value);
            return;
        }
    }

}

```

### Circular Linked List

- Demonstrates the implementation without tail and how to traverse through the list.

```java
package javaPlayground;

public class j8 {
    public static void main(String[] args) {
        j8 CLL = new j8();
        for (int i = 0; i < 10; i++) {
            CLL.add(i);
        }
        CLL.display();
        CLL.insertAfter(9, 33);
        CLL.display();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private int size;
    private Node head;

    /*
     * To reach the node just before the head
     * Node temp = head;
     * do{
     * temp = temp.next;
     * }while(temp.next!=head);
     * Now temp, just before head and obviously since temp.next == head, hence for
     * that last node the do{} block won't run obviously.
     */

    public void add(int value) {
        if (head == null) {
            Node headNode = new Node(value);
            head = headNode;
            headNode.next = head;
            this.size++;
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        temp.next = newNode;
        newNode.next = head;
        this.size++;
        return;
    }

    public void insertFirst(int value) {
        if (head == null) {
            Node headNode = new Node(value);
            head = headNode;
            headNode.next = head;
            this.size++;
            return;
        }

        Node temp = head;
        Node newNode = new Node(value);
        newNode.next = head;

        do {
            temp = temp.next;
        } while (temp.next != head);

        temp.next = newNode;
        head = newNode;
        this.size++;
    }

    public void insertAfter(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds, cannot insert.");
            return;
        } else if (index == size - 1) {
            this.add(value);
            this.size++;
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (temp.next != head && i < index);
            newNode.next = temp.next;
            temp.next = newNode;
            this.size++;
            return;
        }
    }

    public void display() {
        display(head);
    }

    private void display(Node node) {
        if (node == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node temp = node;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head); // keep this in mind, we have to go till head
        System.out.print("HEAD\n");
        System.out.println("Size: " + size);
    }

}

```

## Stack

A stack is a linear data structure that follows the Last In, First Out (LIFO) principle. This means that the last element added to the stack will be the first one to be removed. Stacks are used in various applications such as expression evaluation, function call management in recursion, and backtracking algorithms.

Key Operations:

1. Push: Add an element to the top of the stack.
2. Pop: Remove and return the top element from the stack.
3. Peek (or Top): Return the top element without removing it.
4. isEmpty: Check if the stack is empty.
5. Size: Get the number of elements in the stack.

### Custom Stack

```java
package stackAndQueues;
public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(15);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            int val = stack.pop();
            System.out.println(val);
        }
    }

    private int[] data;
    private int top = -1;
    private static final int DEFAULT_SIZE = 10;

    public Stack() {
        // data = new int[DEFAULT_SIZE];
        this(DEFAULT_SIZE); // calls the appropriate constructor
    }

    public Stack(int size) {
        data = new int[size];
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full stack.");
            return false;
        }
        data[++this.top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty stack.");
            return -1;
        }
        return data[this.top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in an empty stack.");
            return -1;
        }
        return data[top];
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

}

```

### Dynamic Stack

```java
package stackAndQueues;

public class DynamicStack {
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());

    }

    private int top = -1;
    private static final int DEFAULT_SIZE = 10;
    private int[] data;

    public DynamicStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public boolean push(int value) {
        if (isFull()) {
            resize();
        }
        data[++this.top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot pop from an empty stack.");
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        return data[top];
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        this.data = temp; // very important line
    }

}

```

## Queue

Definition of Queue
A queue is a linear data structure that follows the First In, First Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. Queues are used in various applications such as task scheduling, handling requests in a server, and breadth-first search (BFS) in graphs.

Key Operations:

1. Enqueue (or Offer): Add an element to the end of the queue.
2. Dequeue (or Poll): Remove and return the front element from the queue.
3. Peek (or Front): Return the front element without removing it.
4. isEmpty: Check if the queue is empty.
5. Size: Get the number of elements in the queue.

### Queue Methods

| Method       | Action                     | Empty Queue Behavior            | Exception Thrown         |
| ------------ | -------------------------- | ------------------------------- | ------------------------ |
| `add(E e)`   | Inserts element            | Throws `IllegalStateException`  | `IllegalStateException`  |
| `offer(E e)` | Inserts element            | Returns `false`                 | None                     |
| `peek()`     | Retrieves head (no remove) | Returns `null`                  | None                     |
| `element()`  | Retrieves head (no remove) | Throws `NoSuchElementException` | `NoSuchElementException` |
| `poll()`     | Retrieves and removes head | Returns `null`                  | None                     |
| `remove()`   | Retrieves and removes head | Throws `NoSuchElementException` | `NoSuchElementException` |

```java
package stackAndQueues;

public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 15; i++) {
            queue.add(i);
        }
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    private int[] data;
    private int first = 0;
    private int current = -1;
    private static final int DEFAULT_SIZE = 10;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full queue.");
            return false;
        }
        data[++this.current] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }
        return data[this.first++];
    }

    private boolean isFull() {
        return this.current == data.length - 1;
    }

    private boolean isEmpty() {
        return this.current == -1;
    }

}

```

### Queue with One Pointer

```java
package stackAndQueues;


public class QueueWithOnePointer {
    public static void main(String[] args) {
        QueueWithOnePointer queue = new QueueWithOnePointer();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.remove();
        queue.display();
    }

    private int ptr = -1;
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    public QueueWithOnePointer() {
        this(DEFAULT_SIZE);
    }

    public QueueWithOnePointer(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full queue.");
            return false;
        }
        data[++ptr] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }
        int deletedValue = data[0];
        for (int i = 0; i < data.length - 1; i++) { // left shifting the array by 1
            data[i] = data[i + 1];
        }
        this.ptr--;
        return deletedValue;
    }

    public void display() {
        for (int i = 0; i <= ptr; i++) {
            System.out.print(data[i] + " <-\s");
        }
        System.out.print("END");
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    private boolean isFull() {
        return ptr == data.length - 1;
    }
}
```

### Dynamic Queue

```java
package stackAndQueues;

public class DynamicQueue {
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();

        queue.add(1);
        queue.add(2);
        queue.display();

        queue.remove();
        queue.display();
    }

    private int[] data;
    private int first = 0;
    private int last = 0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    public DynamicQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicQueue(int initialSize) {
        this.data = new int[initialSize];
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean resize() {
        int[] temp = new int[2 * data.length];
        for (int i = first; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        return true;
    }

    public boolean add(int value) {
        if (isFull()) {
            resize();
        }
        data[this.last] = value;
        last = last + 1;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }

        int value = data[this.first];
        first = first + 1;
        this.size--;
        return value;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = first; i < last; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.print("END\n");
    }

```

## Circular Queue

```java
package stackAndQueues;

public class CircularQueue {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.add(99);
        queue.display();
        // for (int i = 0; i < 10; i++) {
        // System.out.println(queue.remove());
        // }
    }

    private int first = 0;
    private int last = 0;
    private int[] data;
    private int size;
    private final static int DEFAULT_SIZE = 10;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full circular queue.");
            return false;
        }
        data[last] = value;
        this.last = this.last + 1;
        this.last = (this.last) % data.length;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty circular queue.");
            return -1;
        }
        int value = data[this.first];
        this.first = this.first + 1;
        this.first = (this.first) % data.length;
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in an empty circular queue.");
            return -1;
        }
        return data[first];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = first;
        do {
            System.out.print(data[i] + " -> ");
            i = (i + 1) % data.length;
        } while (i != last);
        System.out.print("END");
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == data.length;
    }
}
```

### Dynamic Circular Queue

```java
package stackAndQueues;

public class DynamicCircularQueue {
    public static void main(String[] args) {
        DynamicCircularQueue queue = new DynamicCircularQueue();
        for (int i = 0; i < 20; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.display();
    }

    private int[] data;
    private int size;
    private int first;
    private int last;
    private final static int DEFAULT_SIZE = 10;

    public DynamicCircularQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicCircularQueue(int initialSize) {
        this.data = new int[initialSize];
    }

    private boolean resize() {
        int[] temp = new int[data.length * 2];
        int i = 0;
        do {
            temp[i] = data[(first + i) % data.length];
            ++i;
        } while (i != data.length);
        first = 0;
        last = data.length;
        data = temp;
        return true;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean add(int value) {
        if (isFull()) {
            resize();
        }
        data[last] = value;
        last = (last + 1) % data.length;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }

        int value = data[first];
        first = (first + 1) % data.length;
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peak in an empty queue.");
            return -1;
        }
        return data[first];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int i = first;
        do {
            System.out.print(data[i] + " -> ");
            i = (i + 1) % data.length;
        } while (i != last);
        System.out.print("END");
    }
}

```

## Trees

1. It consists of nodes. In case of a binary tree, they are atmost 2 in number.
2. Nodes &rarr; root , internal, leaf.
3. Leaf : They have no children.
4. Root : Topmost node is root.
5. Internal : Nodes with atleast 1 child.
6. `Height of a tree =  Max(height(leftSubtree), height(rightSubtree)).`
7. `Height of a node is Max number of edges from that node to the leaf node.`
8. Level of a node = Height of root - Height of the node.

#### `Time complexity while inserting, removing or traversing a binary tree(balanced) is O(log(N)).`

```java
import java.util.Scanner;

public class BinaryTree {
    private Node root; // intially null

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public void populate(Scanner scanner) {
        System.out.println("Input the value of root node: ");
        root = new Node(scanner.nextInt());
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to add a left node to  " + node.value + ": ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of the left node: ");
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to add a right node to " + node.value + ": ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of the right node: ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, "\t");
        display(node.right, "\t");
    }

}

```

### Calculating height of a node in a binary tree

```java
package binaryTrees;

@SuppressWarnings("unused")
public class HeightOfANode {
    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    private Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;

    }
}

```

### Finding a Node in a binary tree

```java
private Node findNode(Node root, Node node, int x) {

        if (root == node) {
            return node;
        }

        if (node == null) {
            return null;
        }

        if (node.value == x) {
            return node;
        }

        Node left = findNode(root, node.left, x);
        if (left != null) {
            return left;
        }
        return findNode(root, node.right, x);

    }
```

### Finding level of a node in a binary tree

```java
package binaryTrees;

@SuppressWarnings("unused")
public class LevelOfNodes {
    // We'll find the level of nodes.
    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private int findLevel(Node node, Node x, int level) {
        if (root == null) {
            return -1;
        }

        if (node == null) {
            return 0;
        }

        if (node == x) {
            return level;
        }

        int left = findLevel(node.left, x, level + 1);
        if (left != 0) {
            return left;
        }
        return findLevel(node.right, x, level + 1);

    }
}

```

## Traversal Methods in [Depth First Search](#depth-first-search)

#### The traversal methods are for Binary Trees in general.

#### Pre-order : N &rarr; L &rarr; R

- Can be seen as "top-to bottom"
- Used for evaluating mathematical expressions or making a copy.
- Convert string/array in a Binary Tree or serialize data.

```java
private void preOrder(Node node){
    if(node==null){
        return;
    }

    System.out.println(node.value +"\s");
    preOrder(node.left);
    preOrder(node.right);
}
```

#### In-order : L &rarr; N &rarr; R

- For sorted order traversal in a Binary Tree, we can use this.

```java
private void inOrder(Node node){
    if(node==null){
        return;
    }

    inOrder(node.left);
    System.out.println(node.value +"\s");
    inOrder(node.right);
}
```

#### Post-order : L &rarr; R &rarr; N

- Can be seen as "bottom-to-top"
- To delete something from the Binary Tree.
- When we perform bottom-up calculation(like calculating the height or diameter of a tree), then we can use it.

```java
private void postOrder(Node node){
    if(node==null){
        return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value +"\s");
}
```

## Binary Search Trees

- The left child node always contains value less than the parent node.
- The right child node always contains value greater than the parent node.
- BSTs are helpful while traversing, inserting or removing elements as they follow above constraints and have a time complexity of O(log(N)).

### What are Balanced Binary Search Trees?

#### Height(Left Subtree) - Height(Right Subtree) <=1.

### Why Balanced Binary Search Trees?

#### Because, in unbalanced the time complexity of worst case rises upto O(N).

```java
public class BST {
    public BST() {

    }

    private Node root;

    private class Node {
        private int value;
        private int height;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }

    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;

    }

    public void display() {
        display(root, "Root Value is : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left node value of " + node.value + " is: ");
        display(node.right, "Right node value of " + node.value + " is: ");
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);

    }

}

```

Some self balancing binary search trees are : AVL trees, Red Black Tree etc.

## AVL tree

1. Insert the node normally.
2. From `bottom-up` check for the unbalanced node(p).
3. Then according to the following `4 cases`, rotate the tree while leaving the balanced part of the tree.

- `Time Complexity  : O(log(N))`

- Parent unbalanced Node : p
- Child Node : c
- Node which is displaced : t

1. Left Rotate :

```java
private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }
```

2. Right Rotate :

```java
private Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.left;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

```

- Case 1 : Left - Left : Right rotate the unbalanced node(p).
- Case 2 : Left - Right : Left rotate the child node(c) of the unbalanced node(p) and then right rotate the unbalanced node(p).
- Case 3 : Right - Right : Left rotate the unbalanced node(p).
- Case 4 : Right - Left : Right rotate the child node(c) of the unbalanced node(p) and then left rotate the unbalanced node(p).

### Code of AVL Tree

```java
public class AVL {
    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);

    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    private Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.left;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
    }

    public void display() {
        display("Root node is : ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display("Left child of " + node.value + " is : ", node.left);
        display("Right child of " + node.value + " is : ", node.right);
    }
}
```

## Segment Trees : Perform query(sum, average, product, max, min, etc.) in a range(in an array).

- Not a BST.
- Disadvantage : Extra Space.
- Time Complexity : O(log(n))
- It is a full binary tree, every node has 2 children except leaf nodes.
- Leaf nodes = n-1. Internal Nodes = n. Total Nodes = 2n-1.

#### Update function is also of O(log(n)) time.

#### The traversal methods are for Binary Trees in general.

## Breadth First Search or Level Order Traversal

- Iterative approach is more intuitive in this case.
- When you've reached at the end of a level, the whole next level is already in the queue.
- Or it can be said that when you remove a node it's children of the next level are already inside the queue.

```java
package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private class TreeNode {
        private int value;
        private int height;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    private List<List<Integer>> BFSTraversal() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>(); // to maintain the order of the nodes that needs to be explored and
        // keep track of current level nodes to be processed.
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<Integer>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                // at this point the next level children of the node which was polled
                // is already in the queue.
            }
            result.add(currentLevelList);
        }

        return result;
    }

}

```

### Finding if the nodes are siblings

```java
package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")

public class IsSibling {
    // We'll find if the nodes of a binary tree are siblings.

    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private boolean isSibling(Node root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean foundX = false;
        boolean foundY = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // in each iteration, we are looking at the node itself
                foundX = false;
                foundY = false;
                Node currentNode = queue.poll();

                // Sibling check
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.value == x && currentNode.right.value == y) ||
                            (currentNode.left.value == y && currentNode.right.value == x)) {
                        return true;
                    }
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
        }
        return false;
    }
}

```

### Finding a node using BFS

```java
    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private Node findNodeByValue(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.value == val) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.value == val) {
                    return currentNode;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return null;
    }

    private Node findNode(Node root, Node target) {
        if (root == null) {
            return null;
        }

        if (root == target) {
            return target;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode == target) {
                    return target;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return null;
    }
```

#### Tips related to BFS questions

- While solving BFS questions, you should `consider deque` if you need to traverse the tree in left to right and then right to left manner, basically, deque shouldn't be out of picture.

```java
package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class $103_BinaryTreeZigZagLevelOrderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root); // left to right once done
        boolean reverse = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if (reverse) {
                    TreeNode currentNode = deque.removeLast();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.removeFirst();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                }

            }
            result.add(currentLevelList);
            if (reverse == true) {
                reverse = false;
            } else {
                reverse = true;
            }
        }

        return result;
    }
}

```

- Depending on the question, you might need to change the way how nodes are stored, don't just stick to the original order, improvise if need be, like in the case of symmetric trees.

```java
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class $101_SymmetricTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            // here we can see the elements are stored differently in the queue
            // as per requirements
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }

        return true;
    }
}

```

## Depth First Search

- The more intuitive approach is recursion in this algorithm.
- The methods (Pre-order, In-Order and Post-order) have been described [above](#traversal-methods-in-depth-first-search).
- It goes into the depth of one child and goes until it can't go further and then revert back.

Some Tid-bits regarding those methods:-

- Do something at that level and then move down : Use Pre-Order Traversal (N &rarr; L &rarr; R)

- To get the leftmost(smallest value in BST) value in a tree, we can use In-Order Traversal (L &rarr; N &rarr; R)

- Perform some operations on the root at the last, e.g. to delete a tree, we'll have to delete all the left nodes first then the right nodes and then the root node, therefore we'll use Post-Order Traversal (L &rarr; R &rarr; N).

- Always use queue or stack when you want to store the node to perform an operation later.
  (Like flattening a binary tree into a linked list where the left pointers need to be null
  and right ones need to point to the next node)

#### Diameter of a binary tree

```java
public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1; // we have calculated node wise
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia); // diameter is the max value of dia of each individual tree

        return Math.max(leftHeight, rightHeight) + 1;
    }
```

### Invert a binary tree

```java
package leetcode;

public class $226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return node;
        }

        if (node.left == null && node.right == null) {
            return node;
        }

        invertTree(node.left);
        invertTree(node.right);
        return swap(node);
    }

    private TreeNode swap(TreeNode x) {
        TreeNode temp = x.left;
        x.left = x.right;
        x.right = temp;
        return x;
    }
}

```

### Traversing from one node to another in a binary tree and printing the path

```java
package leetcode;

public class $2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder s = new StringBuilder(""), d = new StringBuilder("");

    public String getDirections(TreeNode root, int startValue, int destValue) {
        traverse(root, startValue, s); // s -> start
        traverse(root, destValue, d); // d -> destination
        int i = 0;
        // Find the common path prefix length
        while (i < s.length() && i < d.length() && s.charAt(i) == d.charAt(i)) {
            i++;
        }

        // Number of steps to move up from the start node to the common ancestor
        StringBuilder finalPath = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            finalPath.append('U');
        }

        // Append remaining path to the destination node
        finalPath.append(d.substring(i));

        return finalPath.toString();
    }

    // Main thing here is that how you stop the traversal using booleans
    private boolean traverse(TreeNode root, int value, StringBuilder path) {
        // Optimize traversal by stopping it the moment value is found!!
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        path.append("L");
        if (traverse(root.left, value, path)) {
            return true;
        }

        path.setLength(path.length() - 1);

        path.append("R");
        if (traverse(root.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }
}

```

## Graphs

### What is a graph?

- A structure with nodes/vertices and/or edges.
- A graph can have multiple connected components and we use the concept of `visitedArray`(with length = number of nodes(if 0-based indexing) or number of nodes+1 (if 1-based indexing)) to keep track of the vertices we visit so that every node is `visited only once`, even if the components don't appear to be connected they could be of the same graph. [(Will become more clear once we dive into algorithms)](#breadth-first-search-or-level-order-traversal-1)
- Trees are a type of graph with no cycles. If they have N vertices then number of edges equal to N-1.

### Types of Graph:

1. Directed -> The edges have arrows towards the vertices, hence giving it a direction.
2. Undirected -> The edges don't have specific directions.

- For an undirected graph the degree of the graph is 2\*(number of edges).

### Other forms are:

1. Cyclic -> When you start with a node and end up back again at that node.
2. Acyclic -> When there's no way to reach back to the node you started with.

### Degree of a graph

- For undirected graph:
  Degree of an undirected graph = 2 \* E, where E is the number of edges.
  To calculate degree of a vertex, simply calculate the number of edges attached to it and then sum of all of them would be the degree of the graph.

- For directed graph:
  Degree of a directed graph is defined using the `In-degree` and the `Out-degree` of the nodes. As the name suggests `in-degree` of a node are the number of edges with arrows pointing towards the node and `out-degree` is the number of edges with arrows pointing outwards.

### Ways to store a Graph(complex data structure):

1. Adjacency Matrix(adjMatrix.length = number of nodes), space complexity is O(n<sup>2</sup>), where, n is the number of nodes, that's why avoided. We create a matrix of N X N, where N is the number of Nodes.

2. `Adjacency list(adjList.length = number of nodes), space complexity is ~O(V + 2E), hence this is preferred. V is the number of vertices and E is the number of edges.`

- We create a list of size V.

- Explanation of point 2:

  > adj.get(u).add(v);

  > adj.get(v).add(u);

  The above statments tell us that each edge will be repeated twice in the list(for every u, a v and for every v, a u), hence the 2E plus the number of vertices(V) as the length of the list is V, that's why O(V + 2E).

- `For a directed graph it will be O(V+E)` as no edges are repeated.

---

### if 1-based indexed graph:

#### `Length of visited array = length of adjList = length of adjMatrix = number of vertices + 1.`

### if 0-based indexed graph:

#### `Length of visited array = length of adjList = length of adjMatrix = number of vertices/nodes.`

---

```java
package graphs;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class AdjacencyList {
    public static void main(String[] args) {
        // 1 -- 2 -- 3 -- 1 -> graph
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list

        // we'll insert (n+1) empty lists in the 'adj' list, where 'n' is the number of
        // nodes.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); // (n+1) array lists inserted
        }

        // 1 -- 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // 2 -- 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // 3--1
        adj.get(3).add(1);
        adj.get(1).add(3);

        /*
         * u--v : Undirected graph
         * adj.get(u).add(v);
         * adj.get(v).add(u);
         *
         * u-->v : Directed graph
         * adj.get(u).add(v);
         */

        for (int i = 1; i <= n; i++) {
            System.out.print("Node " + i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + "\s");
            }
            System.out.println();
        }
    }

}
```

For a directed graph one of the `adj.get(u).add(v)` or `adj.get(v).add(u)` is omitted as the direction would be specified.

## Breadth First Search or Level Order Traversal

```java
package javaPlayground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 // Time complexity = O(N) + O(2*E)
 // Space complexity = O(3*N)

public class j10 {
    public void bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.offer(1); // Starting with node 1 (1-based indexing)
        vis[1] = true; // whatever goes into the queue is considered to be visited
        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            bfs.add(currentNode); // add the currentNode from queue into the resultant array
            for (Integer connectedNode : adj.get(currentNode)) {
                if (!vis[connectedNode]) {
                    q.offer(connectedNode);
                    vis[connectedNode] = true;
                }
            }
        }
        System.out.println(bfs);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) { // Create adjacency list for 6 nodes (0 to 5)
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(2).add(5);
        adj.get(3).add(5);

        j10 obj = new j10();
        obj.bfs(adj);
    }
}

```

- Queue always stores the next level while the alogrithm traverses the current one.

## Depth First Search or DFS traversal

- It goes into the depth of one child and goes until it can't go further and then revert back.
- Visited array in this case is a must though it could be avoided in the case of trees.

### DFS Concept

```java
package luv.graphs;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = 10, m = 15; // n: no of vertices and m being the number of edges
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
            // if m is given then we are given the configuration of one of the combinations
            // 1 -- 2, we do the 2 -- 1 by ourselves and run the loop m times instead of n.
        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis);
            }
        }
    }
    /*
     * graph = [
     *            vertex 0 -> [ 1 , 2 , 3 ], -> it's elements are the children
     *            vertex 1 ->  [ 4 , 5 , 6 ],
     *         ]
     vertex 0 -> [ 1 , 2 , 3 ] => 0 -- 1, 0 -- 2, 0--3; -- : edges
     * 'child' itself is an array, so for(int child : graph[vertex]) => you are already inside the vertex array at a child.
     */
    static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        /*
         * Take action on vertex after entering the vertex
         * Going down
         */
        // if(vis[vertex]) {return;}
        vis[vertex] = true;
        for (int child : graph.get(vertex)) {
            /*
             * Take action on child before entering the child node
             * Going down
             */
            if (vis[child]) {
                continue;
            }
            dfs(child, graph, vis);
            /*
             * Take action on child after exiting child node
             * Coming back up
             */
        }
        /*
         * Take action on the vertex before exiting the vertex
         * Coming back up
         */
    }
}
```

- DFS Implementation

```java
package graphs;

import java.util.ArrayList;

public class DFS {
    public void dfsTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()]; // this calls every component!
        for (int vertex = 0; vertex < vis.length; vertex++) {
            dfs(vertex, vis, adj);
        }
    }

    private void dfs(int vertex, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // this visits/traverses every node!
        vis[vertex] = true;
        for (Integer child : adj.get(vertex)) {
            System.out.println("vertex: " + vertex + "child: "+ child);
            if (!vis[child])
                dfs(child, vis, adj);
        }
    }
}


```

---

The following code illustrates the `conversion of adjacency matrix to adjacency list` along with DFS traversal.

```java
package javaPlayground;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class j9 {
    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 }, // 0
                { 1, 1, 0 }, // 1
                { 0, 0, 1 } // 2
        };
        findCircleNum(isConnected);
    }

    public static void findCircleNum(int[][] isConnected) {
        // 0-based indexed graph
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < isConnected.length; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        System.out.println("adjacencyList: " + adjacencyList);
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < vis.length; i++) { // it calls every component
            if (vis[i] == false) {
                count++;
                dfs(i, adjacencyList, vis);
            }
        }
        System.out.println(count);
    }

    private static void dfs(Integer node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] vis) {
        // this visits every connected node of that component
        vis[node] = true;
        for (Integer connectedNode : adjacencyList.get(node)) {
            if (vis[connectedNode] == false) {
                dfs(connectedNode, adjacencyList, vis);
            }
        }
    }
}

```

- The above code also shows the importance of visited array as when the graph has been divided into 'k' connected components then that's how we can reach every node using the visited array.

---

### DFS in Trees(n-Ary)

- No need of a visited array as no loops exist in trees.
- We just need to make sure that we don't visit the parent node which we came from and for that we can pass on the parent node to the 'dfs' function.
- Although the exact DFS code for graphs will run for trees because visited array helps us avoiding the same node from visitation twice as that will cause an infinite loop.

```java
public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // vertices
        System.out.println(n);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // int m = input.nextInt(); // edges
        // in trees, number of edges = n - 1
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();
        int depth[] = new int[n + 1];
        int height[] = new int[n + 1];
        dfs(1, 0, graph, depth, height);
        System.out.println("depth: " + Arrays.toString(depth));
        System.out.println("height: " + Arrays.toString(height));
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int depth[], int height[]) {
        // vertex is the current one and the parent one is the one from which it came from
        // do something when you enter the vertex/enter the recursion
        for (int child : graph.get(vertex)) {
            // in context of the vertex
            if (child == parent) {
                continue;
            }
            // do something when you enter the child/enter the recursion of that child(going
            // down)
            // 3 nodes : child, parent and vertex(the current one) and all are different
            depth[child] = depth[vertex] + 1; // here the parent is the vertex, i.e., child of the current vertex
            dfs(child, vertex, graph, depth, height);
            height[vertex] = Math.max(height[child] + 1, height[vertex]);
            // do something when you leave the child/coming back from the recursion of that
            // child(coming back up)
        }
        // do something when you leave the vertex/exit the recursion
    }

}

```

### Pre-Computation using DFS in graphs(or trees)

- Pre-computation using DFS, like finding sum of elements of a subtree/subgraph, is done while coming back up from the recursion. (It's obvious just think about it)

#### Way 1: Calling DFS for every query.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // vertices
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();
        System.out.println(subtreeSumUsingDFS(1, 0, graph)); // subtree sum
        System.out.println(evenCountInASubtreeUsingDFS(13, 1, graph));
    }

    static int subtreeSumUsingDFS(int vertex, int parent, ArrayList<ArrayList<Integer>> graph) {
        // do something when you enter the vertex/enter the recursion
        int currentSum = 0;
        currentSum += vertex;
        for (int child : graph.get(vertex)) {
            // for the same vertex all its children, so the parent is the vertex's parent while for all its children the parent is the vertex itself, so the parent is grandparent of the child here.
            if (child == parent) {
                // 1 -- 2 : when 2 will run then 1 will be its parent and since we don't want infinite loops we avoid that condition here
                continue;
            }
             // do something when you enter the child/enter the recursion of that child(going
            // down)
            int prevSum = subtreeSumUsingDFS(child, vertex, graph);
             // do something when you leave the child/coming back from the recursion of that
            // child(coming back up)
            currentSum += prevSum;
        }
        // do something when you leave the vertex/exit the recursion
        return currentSum;
    }

    static int evenCountInASubtreeUsingDFS(int vertex, int parent, ArrayList<ArrayList<Integer>> graph) {
        int currentCount = 0;
        if (vertex % 2 == 0) {
            currentCount++;
        }
        for (int child : graph.get(vertex)) {
            if (child == parent)
                continue;
            int prevCount = evenCountInASubtreeUsingDFS(child, vertex, graph);
            currentCount += prevCount;
        }
        return currentCount;
    }

}

```

#### Way 2: Calculating subtree sum and even count of the children of each parent

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();
        int subtreeSum[] = new int[n + 1];
        int evenCount[] = new int[n + 1];
        dfs(1, 0, graph, subtreeSum, evenCount);
        System.out.println("subtreeSum: " + Arrays.toString(subtreeSum));
        System.out.println("evenCount: " + Arrays.toString(evenCount));
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int[] subtreeSum, int[] evenCount) {
        // going into the vertex
        subtreeSum[vertex] += vertex;
        if (vertex % 2 == 0) {
            evenCount[vertex]++;
        }
        for (int child : graph.get(vertex)) {
            // for the same vertex all its children
            if (child == parent)
                continue;
            // entering the recursion into the child
            dfs(child, vertex, graph, subtreeSum, evenCount);
            subtreeSum[vertex] += subtreeSum[child];
            evenCount[vertex] += evenCount[child];
            // coming back up in the recursion from the child
        }
        // exiting the vertex
    }

}

```

### Diameter of a tree

- Diameter of a tree = max(depth between any two nodes)

##### Brute Force approach

- Brute Force method would be to find the depth between every node and then traversing through that array and finding the maximum depth among them.

##### Optimized approach

- Assume any node to be the root and then go down and find the node at maximum depth. That node will be one of ends of the diameter.

- Then assume that max depth node to be the root and run DFS algorithm to go again to the node which has maximum depth w.r.t this node, this new found node will be the other end of the diameter.

```java
package luv.trees;

import java.util.*;

public class DiameterOfATree {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();
        int depth[] = new int[n + 1];

        dfs(1, 0, graph, depth);
        System.out.println("depth: " + Arrays.toString(depth));

        int max_depth = -1;
        int max_depth_node = -1;

        for (int i = 0; i < depth.length; i++) {
            if (max_depth < depth[i]) {
                max_depth = depth[i];
                max_depth_node = i;
            }
            depth[i] = 0;
        }

        System.out.println("max_depth_node: " + max_depth_node);
        dfs(max_depth_node, 0, graph, depth);
        for (int i = 0; i < depth.length; i++) {
            if (max_depth < depth[i]) {
                max_depth = depth[i];
                max_depth_node = i;
            }
            depth[i] = 0;
        }
        System.out.println("max_depth_node: " + max_depth_node);
        System.out.println("max_depth: " + max_depth);
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int[] depth) {
        // at this point three different nodes are there : parent(the past one),
        // vertex(the current one), child(it's future)
        for (int child : graph.get(vertex)) {
            // for the same vertex all its children, so the parent is the vertex's parent
            // while for all its children the parent is the vertex itself, so the parent is
            // grandparent of the child here.
            if (child == parent) {
                // 1 -- 2 : when 2 will run then 1 will be its parent and since we don't want
                // infinite loops we avoid that condition here
                continue;
            }
            System.out.println("Vertex: " + vertex + " parent: " + parent + " child: " + child);
            depth[child] = depth[vertex] + 1;
            dfs(child, vertex, graph, depth);
            // coming back up in the recursion from the child
        }
    }
}

```

---

#### Output:

    Vertex: 1 parent: 0 child: 2

    Vertex: 2 parent: 1 child: 5

    Vertex: 5 parent: 2 child: 6

    Vertex: 5 parent: 2 child: 7

    Vertex: 5 parent: 2 child: 8

    Vertex: 8 parent: 5 child: 12

    Vertex: 1 parent: 0 child: 3

    Vertex: 3 parent: 1 child: 4

    Vertex: 4 parent: 3 child: 9

    Vertex: 4 parent: 3 child: 10

    Vertex: 10 parent: 4 child: 11

    Vertex: 1 parent: 0 child: 13

    depth: [0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 1]

    max_depth_node: 11

    Vertex: 11 parent: 0 child: 10

    Vertex: 10 parent: 11 child: 4

    Vertex: 4 parent: 10 child: 3

    Vertex: 3 parent: 4 child: 1

    Vertex: 1 parent: 3 child: 2

    Vertex: 2 parent: 1 child: 5

    Vertex: 5 parent: 2 child: 6

    Vertex: 5 parent: 2 child: 7

    Vertex: 5 parent: 2 child: 8

    Vertex: 8 parent: 5 child: 12

    Vertex: 1 parent: 3 child: 13

    Vertex: 4 parent: 10 child: 9

    max_depth_node: 12

    max_depth: 8

---

### Lowest Common Ancestor of two nodes in a tree

- While travelling up from the bottom of the tree, the first common node we find for the given nodes, is called the LCA(Lowest Common Ancestor).

- To find LCA we store the path of both the given nodes in an array and then loop through them till the last common index, that element is our LCA.

- And for this, we'll need to store the parents of each node, in an array, so that we can easily trace the path of each node to the root node. For this we'll use DFS.

```java
public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();

        int par[] = new int[n + 1];
        dfs(1, -1, graph, par); // dfs to store parent of each vertex

        // paths of each from 'node to vertex'
        List<Integer> path1 = path(10, par);
        List<Integer> path2 = path(3, par);

        int length = Math.min(path1.size(), path2.size());
        int LCA = -1;

        // looping through both the path arrays to find the lowest common ancestor
        for (int i = 0; i < length; i++) {
            if (path1.get(i) == path2.get(i)) {
                LCA = path1.get(i);
            } else {
                break;
            }
        }

        System.out.println(LCA);
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int[] par) {
        par[vertex] = parent;
        for (int child : graph.get(vertex)) {

            if (child == parent) {
                continue;
            }
            // going down in the recursion of the child
            dfs(child, vertex, graph, par);
            // coming back up in the recursion from the child
        }
    }

    static List<Integer> path(int vertex, int[] par) {
        List<Integer> ans = new ArrayList<>();
        while (vertex != -1) {
            ans.add(vertex);
            vertex = par[vertex];
        }
        return ans.reversed(); // important step!! As we traverse the tree from bottom to top through the parent array, we actually need the path from 'node to vertex', hence the 'ans' list has been reversed.
    }
```

### Precomputation and deleting the edges between nodes

Examples :

1. Maximizing the sum of the subtrees

2. Maximizing the sum of the primes in a subtree

We pre-compute the sum/number of primes and then delete the edges using a for loop and then apply the given condition.

```java
package luv.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EdgeDeletionPrecomputation {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();

        boolean[] vis = new boolean[n + 1];
        int[] subtreeSum = new int[n + 1];
        dfs(1, graph, vis, subtreeSum);

        System.out.println("subtreeSum: " + Arrays.toString(subtreeSum));

        long ans = 0;
        for (int i = 2; i <= n; i++) {
            int sum1 = subtreeSum[i];
            int diff = subtreeSum[1] - sum1;
            ans = Math.max(ans, diff * sum1);
            System.out.println("ans at " + i + ": " + ans);
        }
        System.out.println("max product: " + ans);
    }

    static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] vis, int[] subtreeSum) {
        vis[vertex] = true;
        subtreeSum[vertex] += vertex;
        for (int child : graph.get(vertex)) {
            // going down in the recursion of the child
            if (vis[child]) {
                continue;
            }
            dfs(child, graph, vis, subtreeSum);
            subtreeSum[vertex] += subtreeSum[child];
            // coming back up in the recursion from the child
        }
    }
}

```
