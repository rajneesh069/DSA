package practice;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String p = "", up = "ab";
        // permuatations(p, up);
        System.out.println(permutationsArrayList(p, up));
    }

    static void permuatations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i < p.length() + 1; i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permuatations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsArrayList(String p, String up) {
        ArrayList<String> ans = new ArrayList<>();
        if (up.isEmpty()) {
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        for (int i = 0; i < p.length() + 1; i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ArrayList<String> prev = permutationsArrayList(f + ch + s, up.substring(1));
            ans.addAll(prev);
        }
        return ans;
    }
}
