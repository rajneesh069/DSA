package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // mazeTraversal(0, 0, "");
        System.out.println(mazeTraversalList(0, 0, ""));
    }

    static void mazeTraversal(int row, int col, String p) {
        if (row == 2 && col == 2) {
            System.out.println(p);
            return;
        }

        /*
         * You cannot stand at row == 2 || col == 2 because then one of the
         * if conditions would be satisfied and you'll make a move but rather
         * once you reach at 2, the further moves in that direction are blocked!
         */

        if (row < 2) {
            // p = p+ 'D'; Don't do this as it changes 'p' for the whole body.
            mazeTraversal(row + 1, col, p + 'D');
        }

        if (col < 2) {
            // p = p + 'R'; Don't do this as it changes 'p' for the whole body.
            mazeTraversal(row, col + 1, p + 'R');
        }
    }

    static ArrayList<String> mazeTraversalList(int row, int col, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (row == 2 && col == 2) {
            current.add(p);
            return current;
        }

        // Here left and right refer to the calls in recursion tree and not paths.
        if (row < 2) {
            ArrayList<String> left = mazeTraversalList(row + 1, col, p + 'D');
            current.addAll(left);
        }

        if (col < 2) {
            ArrayList<String> right = mazeTraversalList(row, col + 1, p + 'R');
            current.addAll(right);
        }

        return current;
    }
}
