package recursion.subsequencesAndSubsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfAnArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subsets(arr));
    }

    static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

}
