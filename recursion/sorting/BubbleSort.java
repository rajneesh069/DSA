package recursion.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        // arr.length-1 = 2
        // start=0 3,6,7
        // start=1 ++start -> start = 2
        // start=2 sort(arr, 0)-> return

        int start = 0;
        int end = arr.length - 1;
        // sort(arr, start, end);
        // loopCode(arr);
        bubbleSortPatternAnalogy(arr, end, start);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static void loopCode(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    static void sort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        } else if (start == end) {
            sort(arr, 0, --end);
        } else if (arr[start] > arr[start + 1]) {
            swap(arr, start, start + 1);
        }
        sort(arr, ++start, end);
    }

    static void bubbleSortPatternAnalogy(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        } else if (col < row) {
            if (arr[col] > arr[col + 1]) {
                swap(arr, col + 1, col);
            }
            bubbleSortPatternAnalogy(arr, row, col + 1);
        } else {
            bubbleSortPatternAnalogy(arr, --row, 0);
        }
    }
}
