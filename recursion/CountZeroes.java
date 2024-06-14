package recursion;

public class CountZeroes {
    public static void main(String[] args) {
        System.out.println(countZeroes(100));
    }

    // static int countZeroes(int num, int count) {
    // int digit = num % 10;
    // if (num == 0) {
    // return count;
    // }
    // if (digit == 0) {
    // count++;
    // }
    // num = num / 10;
    // return countZeroes(num, count);
    // }
    static int countZeroes(int num) {
        int count = 0;
        int digit = num % 10;
        if (num == 0) {
            return count;
        }
        if (digit == 0) {
            count++;
        }
        num = num / 10;
        int prevCount = countZeroes(num); // the prodigal line returns, although not recommended to use,
        // as count variable is declared everytime
        System.out.println("count: " + count);
        count += prevCount;
        return count;
    }
}
