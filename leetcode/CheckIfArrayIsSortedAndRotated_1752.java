package leetcode;

public class CheckIfArrayIsSortedAndRotated_1752 {
    public static void main(String[] args) {
        // int[] arr = { 4, 5, 0, 1, 2 };
        // int[] arr = { 6 };
        int[] arr = { 2, 1, 3, 4 };
        // int[] arr = { 4, 5, 0, 1, 2, 6 };
        // int[] arr = { 2, 7, 4, 1, 2, 6, 2 };
        System.out.println(isRotatedAndSorted(arr));
    }

    static boolean isRotatedAndSorted(int[] arr) {
        boolean isSorted = false;
        int start = 0, end = arr.length - 1;
        int pivotCount = 0;
        if (arr.length == 1) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                isSorted = true;
            } else {
                if (arr[i] > arr[i + 1] && pivotCount < 2) {
                    pivotCount++;
                    isSorted = true;
                    continue;
                } else if (arr[i] < arr[i - 1] && i >= 1 && pivotCount < 2) {
                    pivotCount++;
                    isSorted = true;
                    continue;
                }
                isSorted = false;
            }
        }

        // now check rotated
        if (pivotCount == 0 && isSorted) {
            return true;
        } else if (pivotCount == 1 && isSorted) {
            if (arr[start] >= arr[end]) {
                return true;
            }
        }
        return false;

    }
}
