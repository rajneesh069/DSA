package recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 8, 3, 4, 12, 5, 6 };
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // O(n) -> space complexity and O(n*log(n)) -> time complexity
    static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid)); // [8, 3]
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length)); // [4]

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[first.length + second.length];
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mergedArray[k] = first[i];
                i++;
            } else {
                mergedArray[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mergedArray[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mergedArray[k] = second[j];
            j++;
            k++;
        }
        return mergedArray;
    }

}
