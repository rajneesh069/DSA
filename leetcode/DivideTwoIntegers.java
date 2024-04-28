package leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }

    static int divide(int dividend, int divisor) {
        int quotient = 0;
        boolean isDividendNegative = false, isDivisorNegative = false;

        if (divisor == 1 || dividend == 0) {
            return dividend;
        }

        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (divisor == Integer.MIN_VALUE && dividend != Integer.MIN_VALUE) {
            return 0;
        } else if (divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) {
            return 1;
        }

        if (divisor < 0 && divisor > Integer.MIN_VALUE) {
            isDivisorNegative = true;
            divisor = -1 * divisor;
        }

        if (dividend == Integer.MIN_VALUE) {
            isDividendNegative = true;
            quotient++;
            dividend = dividend + divisor;
        }
        if (dividend < 0) {
            isDividendNegative = true;
            dividend = -1 * dividend;
        }

        while (dividend >= divisor) {
            dividend = dividend - divisor;
            quotient++;
        }
        return ((isDividendNegative ^ isDivisorNegative)) ? -1 * (int) quotient : (int) quotient;

    }
}
