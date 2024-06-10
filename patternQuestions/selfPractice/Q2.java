package patternQuestions.selfPractice;

public class Q2 {
    public static void main(String[] args) {
        int n = 5;
        p2(n);
    }

    static void p2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
