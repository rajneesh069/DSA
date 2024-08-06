package leetcode;

import java.util.*;

public class $39_CombinationSum {
    public static void main(String[] args) {

    }

    static void findCombinations(int[] nums, ArrayList<Integer> ds, int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                System.out.println(ds);
            }

            return;
        }

        if (nums[i] <= target) {
            ds.add(nums[i]);
            findCombinations(nums, ds, i + 1, target - nums[i]);
            ds.removeLast();
        }

        findCombinations(nums, ds, i + 1, target);

    }
}
