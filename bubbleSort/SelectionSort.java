package bubbleSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 3, 2 };
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    static int getMaxIndex(int[] arr, int end) {
        int max = 0;
        for (int j = 0; j < end; j++) {
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
            int end = arr.length - i;
            int max = getMaxIndex(arr, end);
            swap(arr, max, end - 1);
        }
        return arr;
    }
}
