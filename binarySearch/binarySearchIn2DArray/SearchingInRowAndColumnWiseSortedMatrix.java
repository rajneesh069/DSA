package binarySearch.binarySearchIn2DArray;

import java.util.Arrays;

//sorted in a row and column wise manner
public class SearchingInRowAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 40, 41, 50 }
        };
        System.out.println(Arrays.toString(search(matrix, 37)));
    }

    static int[] search(int[][] matrix, int target) {
        int[] ans = { -1, -1 };
        int row = 0, column = matrix.length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                ans[0] = row;
                ans[1] = column;
                break;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return ans;
    }
}
