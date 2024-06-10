package patternQuestions.selfPractice;

public class Q7 {
    public static void main(String[] args) {
        p7(5);
    }

    static void p7(int n) {
        for (int row = 1; row <= n; row++) {
            int c = n - row + 1;
            int spaces = n - c;
            for (int s = 1; s <= spaces; s++) {
                System.out.print("  ");
            }

            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
