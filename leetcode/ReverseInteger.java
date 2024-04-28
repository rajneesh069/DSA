package leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    static int reverse(int x) {
        long revInt = 0;
        boolean isNegative = false;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            isNegative = true;
            x = -1 * x;
        }
        while (x != 0) {
            revInt = revInt * 10 + x % 10;
            x = x / 10;
        }

        if (revInt > Integer.MAX_VALUE)
            return 0;
        return isNegative ? -1 * (int) revInt : (int) revInt;
    }
}
