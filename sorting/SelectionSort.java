package sorting;

import java.util.Arrays;

//O(n^2)
//not a stable sorting algo

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { -3, -99, 0, 1, 56, 76 };
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    static int getMaxIndex(int[] arr, int end) {
        int max = 0;
        for (int j = 0; j <= end; j++) {
            if (arr[max] < arr[j]) {
                max = j;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int end = arr.length - i - 1;
            int max = getMaxIndex(arr, end);
            swap(arr, max, end);
        }
        return arr;
    }
}
