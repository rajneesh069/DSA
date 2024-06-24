package leetcode;

import java.util.Arrays;

//pending

public class $283_MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
