package patternQuestions;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        // Q3
        // ****
        // ***
        // **
        // *
        Scanner in = new Scanner(System.in);
        System.out.print("Input rows: ");
        int n = in.nextInt();
        in.close();
        for (int row = n; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
