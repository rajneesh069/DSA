package practice;

import java.util.ArrayList;

public class SubsetsOfAnArrayWithDuplicateElements {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 2 }));
    }

    static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0, end = 0;
        for (int j = 0; j < arr.length; j++) {
            start = 0;
            if (j > 0 && arr[j] == arr[j - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int i = start; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[j]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
