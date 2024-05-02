package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(s));
    }

    static String longestCommonPrefix(String[] s) {
        String ans = "";
        int minLength = s[0].length();
        for (int i = 0; i < s.length; i++) {
            minLength = Math.min(minLength, s[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            boolean isMatching = true;
            for (int j = 0; j < s.length - 1; j++) {
                if (s[j].charAt(i) != s[j + 1].charAt(i)) {
                    isMatching = false;
                    break;
                }
            }
            if (isMatching) {
                ans += s[0].charAt(i);
            } else {
                break;
            }
        }
        return ans;
    }
}
