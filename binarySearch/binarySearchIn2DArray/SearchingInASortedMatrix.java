package binarySearch.binarySearchIn2DArray;

import java.util.Arrays;

public class SearchingInASortedMatrix {
    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int target = 7;
        System.out.println(Arrays.toString(search(arr, target)));

    }

    static int[] search(int[][] arr, int target) {
        int[] ans = { -1, -1 };

        return ans;
    }
}
