package arrays;

import java.util.Arrays;

public class swap {
    static int[] swapFn(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        swapFn(nums, 0, 1);
        System.out.println(Arrays.toString(nums));
    }
}
