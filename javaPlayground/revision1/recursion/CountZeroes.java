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
