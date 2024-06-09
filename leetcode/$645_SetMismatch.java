package leetcode;

import java.util.Arrays;

public class $645_SetMismatch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    public static int[] findErrorNums(int[] arr) {
        int[] ans = new int[2];

        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[correctIndex] != arr[i]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans[0] = arr[j];
                ans[1] = j + 1;
            }
        }

        return ans;
    }
}
