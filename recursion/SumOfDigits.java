package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(12354));
    }

    static int sum(int num) {
        if (num == 0) {
            return 0;
        }
        int digit = num % 10;
        num /= 10;
        return digit + sum(num);
    }
}
