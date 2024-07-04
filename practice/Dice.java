package practice;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        // permutations("", 4);
        System.out.println(permutationsArrayList("", 5));
    }

    static void permutations(String p, int target) {

        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 0; i < 6 && i < target; i++) {
            int num = target - i;
            permutations(p + num, target - num);
        }
    }

    static ArrayList<String> permutationsArrayList(String p, int target) {
        ArrayList<String> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(p);
            return ans;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            int num = i;
            ArrayList<String> prev = permutationsArrayList(p + num, target - num);
            ans.addAll(prev);
        }

        return ans;
    }
}
