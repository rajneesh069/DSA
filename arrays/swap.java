package arrays;

import java.util.Arrays;

public class swap {
    static void swapFn(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        swapFn(nums);
        System.out.println(Arrays.toString(nums));
    }
}
