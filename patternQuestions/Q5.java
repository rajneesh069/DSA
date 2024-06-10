package patternQuestions;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input rows: ");
        int n = in.nextInt();
        in.close();

        for (int row = 1; row <= 2 * n - 1; row++) {

            for (int col = 1; col <= (row > n ? 2 * n - row : row); col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}