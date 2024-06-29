package recursion.stringsQuestions;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        String s = new String("ab");
        ArrayList<String> ans = new ArrayList<String>();
        // subSequences(s, "");
        subSequences(s, "", ans);
        System.out.println(ans);
    }

    static void subSequences(String s, String ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        // s = "abc"
        subSequences(s.substring(1), ans);
        subSequences(s.substring(1), ans + ch); // s= abc
    }

    static void subSequences(String s, String current, ArrayList<String> ans) {
        if (s.isEmpty()) {
            if (!current.isEmpty())
                ans.add(current);
            return;
        }
        subSequences(s.substring(1), current, ans);
        subSequences(s.substring(1), current + s.charAt(0), ans);
    }
}
