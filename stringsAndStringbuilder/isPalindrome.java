package stringsAndStringbuilder;

public class isPalindrome {
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(isStringPalindrome(s));
    }

    public static boolean isStringPalindrome(String s) {
        boolean ans = true;
        int start = 0;
        int end = s.length() - 1;
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        while (start <= end) {
            if (s.charAt(end) == s.charAt(start)) {
                start++;
                end--;
            } else {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
