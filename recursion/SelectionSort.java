package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        System.out.println("maxIndex: " + maxIndex(arr, arr.length - 1, arr.length - 1));
        selection(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int maxIndex(int[] arr, int end, int max) {
        if (end < 0) {
            return max;
        } else if (arr[end] > arr[max]) {
            max = end;
        }
        return maxIndex(arr, --end, max);
    }

    static void selection(int[] arr, int end) {
        if (end == 0) {
            return;
        }
        swap(arr, end, maxIndex(arr, end, end)); // important
        selection(arr, --end);
        // {1,3,2,4}
        // {1,2,3,4}
        //
    }
}
