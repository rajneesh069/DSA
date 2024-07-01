package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class $60_PermutationSequence {
    public static void main(String[] args) {
        System.out.println(permutations("123", ""));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder string = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            string.append(i);
        }
        ArrayList<Integer> ans = permutations(string.toString(), "");
        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }
        Arrays.sort(arr);
        return arr[k - 1] + "";
    }

    public static ArrayList<Integer> permutations(String string, String p) {
        ArrayList<Integer> local = new ArrayList<>();
        if (string.isEmpty()) {
            local.add(Integer.parseInt(p));
            return local;
        }

        for (int i = 0; i < p.length() + 1; i++) {
            String f = (p.substring(0, i));
            char ch = (string.charAt(0));
            String s = p.substring(i, p.length());
            ArrayList<Integer> ansFromBelow = permutations(string.substring(1), f + ch + s);
            local.addAll(ansFromBelow);
        }

        return local;
    }
}
