package recursion.phonePad;

import java.util.ArrayList;

public class phonePadProblem {
    public static void main(String[] args) {
        String up = "79";
        String p = "";
        System.out.println(phonePadArrayList(up, p));
        System.out.println(phonePadPermutationCount(up, p));
        // phonePad(up, p);
    }

    static void phonePad(String up, String p) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        if (digit == 7) {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                phonePad(up.substring(1), p + ch);
            }
        } else if (digit == 9) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                phonePad(up.substring(1), p + ch);
            }
        } else if (digit == 8) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                phonePad(up.substring(1), p + ch);
            }
        } else {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                phonePad(up.substring(1), p + ch);
            }
        }

    }

    static void phonePad(String up, String p, ArrayList<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
            char ch = (char) ('a' + i);
            phonePad(up.substring(1), p + ch);
        }
    }

    static ArrayList<String> phonePadArrayList(String up, String p) {
        ArrayList<String> ans = new ArrayList<>();
        if (up.isEmpty()) {
            ans.add(p);
            return ans;
        }
        int digit = up.charAt(0) - '0';
        if (digit == 7) {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                ArrayList<String> prev = phonePadArrayList(up.substring(1), p + ch);
                ans.addAll(prev);
            }
        } else if (digit == 9) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                ArrayList<String> prev = phonePadArrayList(up.substring(1), p + ch);
                ans.addAll(prev);
            }
        } else if (digit == 8) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                ArrayList<String> prev = phonePadArrayList(up.substring(1), p + ch);
                ans.addAll(prev);
            }
        } else {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                ArrayList<String> prev = phonePadArrayList(up.substring(1), p + ch);
                ans.addAll(prev);
            }
        }
        return ans;
    }

    static int phonePadPermutationCount(String up, String p) {
        int count = 0;
        if (up.isEmpty()) {
            count++;
            return count;
        }
        int digit = up.charAt(0) - '0';
        if (digit == 7) {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                int prev = phonePadPermutationCount(up.substring(1), p + ch);
                count += prev;
            }
        } else if (digit == 9) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                int prev = phonePadPermutationCount(up.substring(1), p + ch);
                count += prev;
            }
        } else if (digit == 8) {
            for (int i = 3 * (digit - 2) + 1; i < 3 * (digit - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                int prev = phonePadPermutationCount(up.substring(1), p + ch);
                count += prev;
            }
        } else {
            for (int i = 3 * (digit - 2); i < 3 * (digit - 1); i++) {
                char ch = (char) ('a' + i);
                int prev = phonePadPermutationCount(up.substring(1), p + ch);
                count += prev;
            }
        }
        return count;
    }
}
