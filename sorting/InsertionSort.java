package sorting;

import java.util.Arrays;

//O(n^2)
//stable
//adaptive and works good when the array/subarrays in an array is partially sorted

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 2, 3, 1 };
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                /*
                 * keep in mind we are traversing the subarrays from opposite side hence
                 * everything will be sorted at once
                 */
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
