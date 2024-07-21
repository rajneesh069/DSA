package javaPlayground.revision1.recursion;

public class SumOfDigits {
    /*
     * Approach to hold answers from previous recursion calls and then add them to
     * the current one
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
}
