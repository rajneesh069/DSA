package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class SubSequence {
    // For subsequences, its always processed(p) and unprocessed(up) strings
    public static void main(String[] args) {
        String up = "abc";
        String p = "";
        // subsequences(up, p);
        // ArrayList<String> ans = subsequences(up, p, new ArrayList<String>());
        // System.out.println(ans);
        System.out.println(subsequencesList(up, p));
    }

    // Approach 1
    static void subsequences(String up, String p) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsequences(up.substring(1), p + (ch));
        subsequences(up.substring(1), p);
    }

    // Approach 2
    static ArrayList<String> subsequences(String up, String p, ArrayList<String> list) {
        if (up.isEmpty()) { // You get the answer when the "up" is empty.
            if (!p.isEmpty())
                list.add(p); // add it to the list and return it
            return list;
        }
        char ch = up.charAt(0);
        subsequences(up.substring(1), p + (ch), list);
        subsequences(up.substring(1), p, list);
        return list;
    }

    // Approach 3
    static ArrayList<String> subsequencesList(String up, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (up.isEmpty()) {
            current.add(p);
            return current;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsequencesList(up.substring(1), p + (ch));
        ArrayList<String> right = subsequencesList(up.substring(1), p);
        left.addAll(right);
        return left;
    }
}
