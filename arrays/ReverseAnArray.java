package arrays;

import java.util.Arrays;

public class ReverseAnArray {

    static int[] arrayReverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = { 1, 32, 4 };
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            swap.swapFn(array, start, end);
            start++;
            end--;
        }
        System.out.println(Arrays.toString((array)));
    }

}
