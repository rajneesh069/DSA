package recursion.subsequencesAndSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsForRepeatedElements {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 2, 2, 3 };
        System.out.println(subsetRepeatedIntegers(arr));
    }

    static List<List<Integer>> subsetRepeatedIntegers(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        Arrays.sort(arr);
        int start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<Integer>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }
}
