package sorting;

import java.util.Arrays;

public class CyclicSort {

    /*
     * when numbers are given in a range from 1 to n(unsorted ofc) then use cyclic
     * sort
     */
    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 1, 4 };
        System.out.println(Arrays.toString(cyclicSort(arr)));
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int[] cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        return arr;
    }
}
