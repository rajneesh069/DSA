package patternQuestions.selfPractice;

public class Q5 {
    public static void main(String[] args) {
        p5(5);
    }

    static void p5(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int c = row > n ? 2 * n - row : row;

            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
