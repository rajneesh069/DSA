package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class $448_AllMissingNumbers {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1 };
        System.out.println(Arrays.toString(findAllMissingNumbers(arr)));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static int[] findAllMissingNumbers(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (correctIndex < arr.length && arr[correctIndex] != arr[i]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        System.out.println("arr: " + Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                System.out.println(j + 1);
                ans.add(j + 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
