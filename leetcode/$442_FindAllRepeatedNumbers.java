package leetcode;

import java.util.ArrayList;
import java.util.List;

public class $442_FindAllRepeatedNumbers {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        System.out.println(findDuplicates(arr));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    public static List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;

            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans.add(arr[j]);
            }
        }

        return ans;
    }
}
