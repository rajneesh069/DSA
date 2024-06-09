package leetcode;

public class MissingNumber_268 {
    public static void main(String[] args) {
        // int[] arr = { 3, 0, 1 };
        int[] arr1 = { 10, 6, 4, 2, 3, 5, 8, 0, 1 };
        System.out.println((findMissingNumber(arr1)));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int findMissingNumber(int[] arr) {
        // int ans = -1;
        // Mathematical approach
        /*
         * int actualSum = 0;
         * int n = arr.length + 1;
         * int expectedSum = (n) * (n - 1) / 2;
         * for (int i = 0; i < arr.length; i++) {
         * actualSum += arr[i];
         * }
         * ans = expectedSum - actualSum;
         */

        // Cyclic sort approach
        int ans = arr.length;
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (correctIndex < arr.length && arr[correctIndex] != arr[i]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                ans = j;
                break;
            }
        }
        return ans;
    }
}
