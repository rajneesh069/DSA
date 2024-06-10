package patternQuestions.selfPractice;

public class Q4 {
    public static void main(String[] args) {
        p4(5);
    }

    static void p4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
