package binarySearch.binarySearchIn2DArray;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingInAnUnsorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 9, 3 },
                { 2, 7 },
                { 5, 90, 23, 45 }
        };
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        System.out.println(Arrays.toString(search(arr, target)));
        in.close();
        return;
    }

    static int[] search(int[][] arr, int target) {
        int[] ans = { -1, -1 };
        for (int row = 0; row < ans.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    ans[0] = row;
                    ans[1] = col;
                    break;
                }
            }
        }

        return ans;
    }
}
