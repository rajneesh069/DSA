package patternQuestions;

public class Q6 {
    public static void main(String[] args) {
        pattern5(5);
    }

    static void pattern5(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int totalColsInARow = row > n ? 2 * n - row : row;
            // int numOfSpaces = Math.absExact(row - n);
            int numOfSpaces = n - totalColsInARow;

            for (int i = 1; i <= numOfSpaces; i++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= (totalColsInARow); col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
