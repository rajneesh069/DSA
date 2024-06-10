package patternQuestions.selfPractice;

public class Q6 {
    public static void main(String[] args) {
        p6(5);
    }

    static void p6(int n) {
        for (int row = 1; row <= n; row++) {
            int c = row;
            int noOfSpaces = n - c;

            for (int s = 1; s <= noOfSpaces; s++) {
                System.out.print("  ");
            }

            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
