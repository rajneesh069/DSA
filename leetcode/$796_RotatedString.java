package leetcode;

import java.util.Arrays;

public class $796_RotatedString {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));

    }

    public static boolean rotateString(String s, String goal) {
        char[] ans = s.toCharArray();

        if (s.equals(goal)) {
            return true;
        } else if (s.length() != goal.length()) {
            return false;
        }

        int x = 1;
        while (x <= s.length() && !ans.toString().equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                ans[(i + x) % s.length()] = s.charAt(i);
            }
            x++;
        }

        System.out.println(Arrays.toString(ans));

        if (x > s.length()) {
            return false;
        }
        if (ans.toString().equals(goal)) {
            return true;
        }

        return true;

    }
}