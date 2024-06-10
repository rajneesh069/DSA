package patternQuestions;

public class Q8 {

    public static void main(String[] args) {
        printPattern8(5);
    }

    public static void printPattern8(int n) {
        int numOfRows = 2 * n - 1;
        for (int row = 1; row <= numOfRows; row++) {
            int c = row > n ? 2 * n - row : row;
            int numberOfSpaces = Math.absExact(n - row);
            for (int spaces = 1; spaces <= numberOfSpaces; spaces++) {
                System.out.print(" " + " ");
            }

            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }

            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }

    }

}
