package recursion.stringsQuestions;

import java.util.ArrayList;

public class SubSequenceIteration {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subset(arr));
    }

    static ArrayList<ArrayList<Integer>> subset(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();

        outer.add(new ArrayList<Integer>());

        for (int num : arr) {
            for (int i = 0; i < outer.size(); i++) {
                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }
}
