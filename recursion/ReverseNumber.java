package recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder("");
        System.out.println(reverse(1234, ans));
        System.out.println(reverse(1258));
    }

    static String reverse(int num, StringBuilder ans) {
        if (num == 0) {
            return ans.toString();
        }
        int digit = num % 10;
        num /= 10;
        ans.append(digit);
        return reverse(num, ans);
    }

    // static int reverse(int num, int ans) {
    // if (num == 0) {
    // return ans;
    // }
    // int digit = num % 10;
    // num /= 10;
    // ans = digit + ans * 10;
    // return reverse(num, ans);
    // }

    static int reverse(int num) {
        if (num == 0) {
            return 0;
        }
        int digits = (int) (Math.log10(num)) + 1;
        return (int) ((num % 10) * (Math.pow(10, digits - 1))) + reverse(num / 10);
    }

}
