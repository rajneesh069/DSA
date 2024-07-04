package practice;

import java.util.ArrayList;

public class SubsetsOfAnArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subsets(arr));
    }

    static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>()); // [ [] ]

        for (int num : arr) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j)); // [ [] [] ]
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }
}
