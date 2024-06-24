package leetcode;

import java.util.Arrays;

public class RotateArray_189 {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int[] arr = { -1, -100, 3, 99 };
        int x = 2;
        System.out.println(Arrays.toString(rotateArray(arr, x)));
    }

    static int[] rotateArray(int[] arr, int x) {
        // Solution 1:
        x = x % arr.length;
        // int[] rotatedArray = new int[arr.length];
        // for (int i = 0; i < arr.length; i++) {
        // rotatedArray[i] = arr[i];
        // }
        // for (int i = 0; i < arr.length; i++) {
        // rotatedArray[(i + x) % arr.length] = arr[i];
        // }

        // return rotatedArray;

        // Solution 2:
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, x - 1); // the xth element is pivot so before it, make everything ascending
        reverseArray(arr, x, arr.length - 1); // and after it make everything ascending
        return arr;

    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
