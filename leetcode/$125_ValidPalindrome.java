package leetcode;

import java.util.Arrays;

public class $125_ValidPalindrome {
    public static void main(String[] args) {
        // String s = "A man, a plan, a canal: Panama";
        String s = "aa";
        System.out.println(isPalindrome(s));
    }

    private static String cleanString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder cleanString = new StringBuilder("");
        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
                cleanString.append(ch[i]);
            } else if ((ch[i] >= '0' && ch[i] <= '9')) {
                cleanString.append(ch[i]);

            }
        }
        return cleanString.toString().toLowerCase();
    }

    private static boolean helper(char[] ch, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (start < ch.length && end > -1 && ch[start] == ch[end]) {
            return helper(ch, start + 1, end - 1);
        }
        return false;
    }

    public static boolean isPalindrome(String s) {
        s = cleanString(s);
        System.out.println(Arrays.toString(s.toCharArray()));
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        return helper(s.toCharArray(), 0, s.length() - 1);
    }
}
