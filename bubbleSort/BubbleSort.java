package bubbleSort;

import java.util.Arrays;

//O(n^2) time complexity
//stable sorting algorithm, i.e., original order is maintained even after sorting

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2 };
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    // keep this in mind, you need to pass in the original array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static int[] bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }

            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}
