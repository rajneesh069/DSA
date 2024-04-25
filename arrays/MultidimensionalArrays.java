package arrays;

public class MultiDimensionalArrays {
    public static void main(String[] args) {

        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5 },
                { 6, 7, 8, 9 }
        };

        // printing the 2D array
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        // printing using the enhaced for loop
        for (int[] a : arr) {
            for (int j : a) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
