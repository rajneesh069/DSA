package javaPlayground;

import java.util.Arrays;

//valid for 1 to n (or 0 to n depending on the question) 

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 3, -1, 1, 2, 0, 4, -2, -10 };
        System.out.println((sort(arr)));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int sort(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        if (min < 2) {
            int i = 0;
            while (i < arr.length) {
                int correctIndex = arr[i] - 1;
                if (arr[i] > 0 && correctIndex > 0 && correctIndex < arr.length && arr[correctIndex] != arr[i]) {
                    swap(arr, i, correctIndex);
                } else {
                    i++;
                }
            }
            System.out.println(Arrays.toString(arr));
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != j + 1) {
                    return j + 1;
                }
            }
        }

        return 1;
    }
}
