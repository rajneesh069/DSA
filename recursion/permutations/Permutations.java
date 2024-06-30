package recursion.permutations;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String p = "", up = "abc";
        // permutations(p, up);
        System.out.println(permutationsArrayList(p, up));
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsArrayList(String current, String s) {
        ArrayList<String> ans = new ArrayList<String>();
        if (s.isEmpty()) {
            ans.add(current);
            return ans;
        }

        for (int i = 0; i < current.length() + 1; i++) {
            ArrayList<String> temp = permutationsArrayList(
                    current.substring(0, i) + s.charAt(0) + current.substring(i, current.length()), s.substring(1));
            ans.addAll(temp);
        }
        return ans;

    }
}
