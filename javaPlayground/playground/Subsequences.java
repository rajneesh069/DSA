package javaPlayground.playground;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        String s = "ab";
        ArrayList<String> ans = new ArrayList<String>();
        // subSequences(s, "", ans);
        // subSeqArrayList(s, "", ans);
        ans = subArrayList(s, "");
        System.out.println(ans);
    }

    static void subSequences(String s, String current) {
        if (s.isEmpty()) {
            System.out.println(current);
            return;
        }

        subSequences(s.substring(1), s.charAt(0) + current);
        subSequences(s.substring(1), current);
    }

    static void subSequences(String s, String current, ArrayList<String> ans) {
        if (s.isEmpty()) {
            if (!current.isEmpty()) {
                ans.add(current);
            }
            return;
        }
        subSequences(s.substring(1), s.charAt(0) + current, ans);
        subSequences(s.substring(1), current, ans);
    }

    static ArrayList<String> subSeqArrayList(String s, String current, ArrayList<String> ans) {
        if (s.isEmpty()) {
            if (!current.isEmpty()) {
                ans.add(current);
            }
            return ans;
        }
        subSequences(s.substring(1), s.charAt(0) + current, ans);
        subSequences(s.substring(1), current, ans);
        return ans;
    }

    static ArrayList<String> subArrayList(String s, String current) {
        ArrayList<String> currentList = new ArrayList<String>();
        if (s.isEmpty()) {
            if (!current.isEmpty())
                currentList.add(current);
            return currentList;
        }

        ArrayList<String> left = subArrayList(s.substring(1), s.charAt(0) + current);
        ArrayList<String> right = subArrayList(s.substring(1), current);
        left.addAll(right);
        return left;
    }
}
