package leetcode;

import java.util.*;
@SuppressWarnings("unused")
public class $40_CombinationSum2 {
    public static void main(String[] args) {

    }

    private static void findCombinations(int ind, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds,
            int[] arr) {
                // sort the array in the main function
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            findCombinations(i + 1, target - arr[i], ans, ds, arr);
            ds.removeLast();
        }
    }
}
