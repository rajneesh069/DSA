package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class MazeWithDiagonal {
    public static void main(String[] args) {
        // mazeTraversal(2, 2, "");
        System.out.println(mazeTraversalArrayList(2, 2, ""));
    }

    static void mazeTraversal(int row, int col, String p) {
        if (row == 0 && col == 0) {
            System.out.println(p);
            return;
        }

        /*
         * You cannot stand at row == 0 || col == 0 because then one of the
         * if conditions would be satisfied and you'll make a move but rather
         * once you reach at 0, the further moves in that direction are blocked!
         */

        if (row > 0 && col > 0) {
            mazeTraversal(row - 1, col - 1, p + 'D'); // D : Diagonal
        }

        if (row > 0) {
            mazeTraversal(row - 1, col, p + 'V'); // V : Vertically down
        }

        if (col > 0) {
            mazeTraversal(row, col - 1, p + 'R'); // R : Right
        }

    }

    static ArrayList<String> mazeTraversalArrayList(int row, int col, String p) {
        ArrayList<String> currentPaths = new ArrayList<>();
        if (row == 0 && col == 0) {
            currentPaths.add(p);
            return currentPaths;
        }

        if (row > 0 && col > 0) {
            ArrayList<String> diagonalPath = mazeTraversalArrayList(row - 1, col - 1, p + 'D');
            currentPaths.addAll(diagonalPath);
        }

        if (row > 0) {
            ArrayList<String> downPath = mazeTraversalArrayList(row - 1, col, p + 'V');
            currentPaths.addAll(downPath);
        }
        if (col > 0) {
            ArrayList<String> rightPath = mazeTraversalArrayList(row, col - 1, p + 'R');
            currentPaths.addAll(rightPath);
        }

        return currentPaths;
    }
}
