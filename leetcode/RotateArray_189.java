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
        x = x % arr.length;
        int[] rotatedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rotatedArray[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            rotatedArray[(i + x) % arr.length] = arr[i];
        }

        return rotatedArray;
    }
}
