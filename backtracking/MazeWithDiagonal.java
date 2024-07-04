package backtracking;

public class MazeWithDiagonal {
    public static void main(String[] args) {
        mazeWithDiagonalPath("", 3, 3);
    }

    static void mazeWithDiagonalPath(String path, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if (r > 1 && c > 1) {
            mazeWithDiagonalPath(path + "D", r - 1, c - 1);
        }

        if (r > 1) {
            mazeWithDiagonalPath(path + "V", r - 1, c);
        }

        if (c > 1) {
            mazeWithDiagonalPath(path + "R", r, c - 1);

        }
    }
}
