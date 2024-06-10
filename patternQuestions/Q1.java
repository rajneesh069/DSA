package patternQuestions;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // Q1.
        // *
        // **
        // ***
        Scanner input = new Scanner(System.in);
        System.out.print("Input the rows: ");
        int n = input.nextInt();
        input.close();
        for (int row = 1; row <= n; row++) { // rows
            for (int col = 1; col <= row; col++) { // columns
                System.out.print("* ");
            }
            System.out.println();
        }


    }
}
