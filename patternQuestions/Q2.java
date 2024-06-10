package patternQuestions;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        // Q2.
        // ****
        // ****
        // ****
        // ****
        // rows = columns = n;
        Scanner in = new Scanner(System.in);
        System.out.print("Input rows: ");
        int n = in.nextInt();
        in.close();
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }
}
