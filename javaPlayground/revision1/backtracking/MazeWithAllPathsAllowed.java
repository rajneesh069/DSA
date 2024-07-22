package javaPlayground.revision1.backtracking;

public class MazeWithAllPathsAllowed {
    public static void main(String[] args) {
        // boolean[][] maze = new boolean[3][3];
        boolean[][] path = new boolean[3][3];
        mazeTraversalWithAllPaths(2, 2, "", path);
    }

    static void mazeTraversalWithAllPaths(int row, int col, String p, boolean[][] path) {
        if (row == 0 && col == 0) {
            path[row][col] = false;
            System.out.println(p);
            return;
        }
        if (path[row][col] == true) {
            return;
        }

        path[row][col] = true;
        if (row > 0) {
            mazeTraversalWithAllPaths(row - 1, col, p + 'D', path);

        }
        if (row < 2) {
            mazeTraversalWithAllPaths(row + 1, col, p + 'U', path);
        }
        if (col > 0) {
            mazeTraversalWithAllPaths(row, col - 1, p + 'R', path);
        }
        if (col < 2) {
            mazeTraversalWithAllPaths(row, col + 1, p + 'L', path);
        }
        path[row][col] = false; // backtrack
    }
}
