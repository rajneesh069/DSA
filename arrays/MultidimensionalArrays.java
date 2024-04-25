package arrays;

import java.util.Scanner;

public class MultiDimensionalArrays {
    public static void main(String[] args) {

        int[][] arr = new int[3][];
        Scanner in = new Scanner(System.in);

        // taking the input into the 2D array from the user :-
        for (int row = 0; row < arr.length; row++) {
            System.out.println("Enter the number of elements for row number: " + (row + 1));
            int length = in.nextInt();
            in.nextLine(); // to consume extra inputs
            arr[row] = new int[length];
            System.out.println("Please input the elements for the row number: " + (row + 1));
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = in.nextInt();
            }
            in.nextLine(); // to consume extra inputs
        }

        // for (int row = 0; row < arr.length; row++) {

        // }

        in.close();

        // printing the 2D array
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        // printing using the enhaced for loop
        // for (int[] a : arr) {
        // for (int j : a) {
        // System.out.print(j + " ");
        // }
        // System.out.println();
        // }

    }
}
