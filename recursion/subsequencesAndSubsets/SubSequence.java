package recursion.subsequencesAndSubsets;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        String s = new String("ab");
        ArrayList<String> ans = new ArrayList<String>();
        // subSequences(s, "");
        // subSequences(s, "", ans);

        // System.out.println(subSequences(s, ""));
        System.out.println(subSequences(s, "", ans));
    }

    // static void subSequences(String s, String ans) {
    // if (s.isEmpty()) {
    // System.out.println(ans);
    // return;
    // }
    // char ch = s.charAt(0);
    // s = "abc"
    // subSequences(s.substring(1), ans);
    // subSequences(s.substring(1), ans + ch); // s= abc
    // }

    static ArrayList<String> subSequences(String s, String current, ArrayList<String> ans) {
        if (s.isEmpty()) {
            if (!current.isEmpty())
                ans.add(current);
            return ans;
        }
        subSequences(s.substring(1), current, ans);
        subSequences(s.substring(1), current + s.charAt(0), ans);
        return ans;
    }

    static ArrayList<String> subSequences(String s, String current) {
        if (s.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if (!current.isEmpty())
                list.add(current);
            return list;
        }
        ArrayList<String> left = subSequences(s.substring(1), current);
        ArrayList<String> right = subSequences(s.substring(1), current + s.charAt(0));
        left.addAll(right);
        return left;
    }
}
