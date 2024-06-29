package leetcode;

public class $50_myPow {
    public static void main(String[] args) {
        System.out.println((double)(1/myPow(2, -2)));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return x * myPow(x, ++n);
        }
        return x * myPow(x, --n);
    }
}
