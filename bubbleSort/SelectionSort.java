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

    static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = temp;
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
