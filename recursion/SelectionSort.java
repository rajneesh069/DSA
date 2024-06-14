package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        selection(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static void selection(int[] arr, int r, int c, int max) { // think in 2d
        if (r == 0) {
            return;
        } else if (r > c) {
            if (arr[c] > arr[max]) {
                max=c;
            }
            selection(arr, r, c + 1, max);
        } else {
            swap(arr, max, r-1);
            selection(arr, --r, 0, 0);
        }

    }

    // static int maxIndex(int[] arr, int end, int max) {
    // if (end < 0) {
    // return max;
    // } else if (arr[end] > arr[max]) {
    // max = end;
    // }
    // return maxIndex(arr, --end, max);
    // }

    // static void selection(int[] arr, int end) {
    // if (end == 0) {
    // return;
    // }
    // swap(arr, end, maxIndex(arr, end, end)); // important
    // selection(arr, --end);
    // // {1,3,2,4}
    // // {1,2,3,4}
    // //
    // }

}
