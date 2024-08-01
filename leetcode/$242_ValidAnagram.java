package leetcode;

import java.util.TreeSet;

public class $242_ValidAnagram {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            f1[(int) ((s.charAt(i)) - 'a')]++;
            f2[(int) ((t.charAt(i)) - 'a')]++;
        }
        for (int i = 0; i < f2.length; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }
}
