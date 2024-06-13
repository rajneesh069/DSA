package recursion;

public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(product(55));
    }

    static int product(int num) {
        if (num == 0) {
            return 1;
        }
        int digit = num % 10;
        num /= 10;
        return digit * product(num);
    }
}
