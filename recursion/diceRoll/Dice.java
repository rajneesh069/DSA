package recursion.diceRoll;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
        // dice("", 4);
        // System.out.println(diceArrayList("", 4));
        System.out.println(listCustomFace("", 4, 6));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static List<String> diceArrayList(String p, int target) {
        List<String> ans = new ArrayList<>();
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            List<String> temp = diceArrayList(p + i, target - i);
            ans.addAll(temp);
        }
        return ans;
    }

    static ArrayList<String> listCustomFace(String p, int target, int face) {
        ArrayList<String> ans = new ArrayList<String>();
        if (target == 0) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        for (int i = 1; i <= face && i <= target; i++) {
            ArrayList<String> temp = listCustomFace(p + i, target - i, face);
            ans.addAll(temp);
        }
        return ans;
    }
}
