package leetcode;

import java.util.ArrayList;
import java.util.List;

public class $17_LettersCombination {
    public static void main(String[] args) {
        String current = "", s = "79";
        // combintations(s, current);
        System.out.println(letterCombinationsCount(s, current));
    }

    static void combintations(String s, String current) {
        if (s.isEmpty()) {
            System.out.println(current);
            return;
        }

        int digit = s.charAt(0) - '0';
        if (digit == 7 || digit == 9) {
            for (int i = 3 * (digit - 2); i <= 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                combintations(s.substring(1), ch + current);
            }
        } else {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                combintations(s.substring(1), ch + current);
            }
        }
    }

    static List<String> letterCombinations(String s, String current) {
        List<String> ans = new ArrayList<String>();
        if (s.isEmpty()) {
            ans.add(current);
            return ans;
        }

        int digit = s.charAt(0) - '0';
        if (digit == 7) {
            for (int i = 3 * (digit - 2); i <= 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                List<String> temp = letterCombinations(s.substring(1), current + ch);
                ans.addAll(temp);
            }
            return ans;
        } else if (digit == 9) {
            for (int i = 3 * (digit - 2) + 1; i <= 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                List<String> temp = letterCombinations(s.substring(1), current + ch);
                ans.addAll(temp);
            }
            return ans;
        } else if (digit == 8) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                List<String> temp = letterCombinations(s.substring(1), current + ch);
                ans.addAll(temp);
            }
            return ans;
        }

        else {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                List<String> temp = letterCombinations(s.substring(1), current + ch);
                ans.addAll(temp);
            }
            return ans;
        }
    }

    static int letterCombinationsCount(String s, String current) {
        int count = 0;
        if (s.isEmpty()) {
            count++;
            return count;
        }

        int digit = s.charAt(0) - '0';
        if (digit == 7) {
            for (int i = 3 * (digit - 2); i <= 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                int prevCount = letterCombinationsCount(s.substring(1), current + ch);
                count += prevCount;
            }
            return count;
        } else if (digit == 9) {
            for (int i = 3 * (digit - 2) + 1; i <= 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                int prevCount = letterCombinationsCount(s.substring(1), current + ch);
                count += prevCount;
            }
            return count;
        } else if (digit == 8) {
            for (int i = 3 * (digit - 2) + 1; i <= 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                int prevCount = letterCombinationsCount(s.substring(1), current + ch);
                count += prevCount;
            }
            return count;
        }

        else {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                int prevCount = letterCombinationsCount(s.substring(1), current + ch);
                count += prevCount;
            }
            return count;
        }
    }
}
