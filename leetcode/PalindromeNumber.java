package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    static boolean isPalindrome(int x) {
        int temp =x;
        if (x >= 0) {
            long revInt = 0;
            while (x != 0) {
                revInt = revInt * 10 + x % 10;
                x = x / 10;
            }
            if (revInt < Integer.MIN_VALUE || revInt > Integer.MAX_VALUE) {
                return false;
            }
            if ((int) revInt == temp) {
                return true;
            }
        }
        return false;
    }
}
