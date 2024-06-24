package leetcode;

import java.util.ArrayList;

public class $26_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // Solution 1:
        // ArrayList<Integer> list = new ArrayList<Integer>();
        // int temp = nums[0];
        // list.add(temp);
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] != temp) {
        // list.add(nums[i]);
        // temp = nums[i];
        // }
        // }
        // int[] expectedArray = new int[list.size()];
        // for (int i = 0; i < expectedArray.length; i++) {
        // expectedArray[i] = list.get(i);
        // }
        // return list.size();

        // Solution 2:
        if (nums.length == 0)
            return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;

    }
}
