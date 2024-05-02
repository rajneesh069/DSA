package leetcode;

import java.util.Arrays;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        buildArray(new int[] { 0, 2, 1, 5, 3, 4 });
    }

    static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
