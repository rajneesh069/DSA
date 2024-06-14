package leetcode;

public class $1342_NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {

    }

    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    static int helper(int num, int count) {
        if (num == 0) {
            return count;
        } else if (num % 2 == 0) {
            count++;
            num = num / 2;
        } else {
            num--;
            count++;
        }

        return helper(num, count);
    }
}