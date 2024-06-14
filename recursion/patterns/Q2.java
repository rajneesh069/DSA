package recursion.patterns;

public class Q2 {
    public static void main(String[] args) {
        printPattern(2, 0);
    }

    static void printPattern(int rows, int cols) {
        if (rows == 0) {
            return;
        } else if (rows > cols) {
            printPattern(rows, cols + 1);
            System.out.print("* ");
        } else {
            printPattern(rows - 1, 0);
            System.out.println();
        }
    }
}
