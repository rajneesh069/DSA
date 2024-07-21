package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        System.out.println(diceList(3, ""));
    }

    static void dice(int target, String p) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) { // loop for other combinations
            dice(target - i, p + i);
        }
    }

    // Another approach to hold the answer in prev and then add it to the current
    // array list
    static ArrayList<String> diceList(int target, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (target == 0) {
            current.add(p);
            return current;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            ArrayList<String> prev = diceList(target - i, p + i);
            current.addAll(prev);
        }

        return current;
    }
}
