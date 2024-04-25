package libearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 23, 3 },
                { 2, 19, 8 },
                { 6, 7 }
        };
        System.out.println((Arrays.toString(linearSearchFor2DArray(arr, 23))));
    }

    static int[] linearSearchFor2DArray(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[] { row, col };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
