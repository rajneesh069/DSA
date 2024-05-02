package leetcode;

import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 });
    }

    static int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            

        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
