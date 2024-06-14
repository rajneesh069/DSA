package recursion.patterns;

public class Q1 {
    public static void main(String[] args) {
        printPattern(4, 0);
    }

    static void printPattern(int rows, int cols) {
        if (rows == 0) {
            return;
        }
        if (cols < rows) {
            System.out.print("* ");
            printPattern(rows, cols + 1);
        } else {
            System.out.println();
            rows--;
            cols = 0;
            printPattern(rows, cols);
        }
    }
}
