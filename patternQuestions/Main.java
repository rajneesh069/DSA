package patternQuestions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Q1.
        // *
        // **
        // ***
        Scanner input = new Scanner(System.in);
        System.out.print("Input the rows: ");
        int n = input.nextInt();
        input.close();
        for (int i = 1; i <= n; i++) { // rows
            for (int j = 1; j <= i; j++) { // columns
                System.out.print("*");
            }
            System.out.println();
        }



        
    }
}
