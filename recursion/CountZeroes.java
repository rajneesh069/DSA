package recursion;

public class CountZeroes {
    public static void main(String[] args) {
        System.out.println(countZeroes(1000, 0));
    }

    static int countZeroes(int num, int count) {
        int digit = num % 10;
        if (num == 0) {
            return count;
        }
        if (digit == 0) {
            count++;
        }
        num = num / 10;
        return countZeroes(num, count);
    }
}
