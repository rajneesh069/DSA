package patternQuestions.selfPractice;

public class Q3 {
    public static void main(String[] args) {
        int n = 5;
        p3(n);
    }

    static void p3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
