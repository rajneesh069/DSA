package recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder("");
        System.out.println(reverse(1234, ans));
        System.out.println(reverse(1234, 0));
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

    static int reverse(int num, int ans) {
        if (num == 0) {
            return ans;
        }
        int digit = num % 10;
        num /= 10;
        ans = digit + ans * 10;
        return reverse(num, ans);
    }
}
