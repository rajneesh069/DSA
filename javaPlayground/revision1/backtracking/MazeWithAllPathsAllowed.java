package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class MazeWithAllPathsAllowed {
    public static void main(String[] args) {
        boolean[][] path = new boolean[3][3];
        mazeTraversalWithAllPaths(2, 2, "", path);
        System.out.println(mazeTraversalWithAllPathsList(2, 2, "", path));
    }

    static void mazeTraversalWithAllPaths(int row, int col, String p, boolean[][] path) {
        if (row == 0 && col == 0) {
            path[row][col] = false;
            System.out.println(p);
            return;
        }
        if (path[row][col] == true) { // return if already visited so that you don't get into infinite loop
            return;
        }

        path[row][col] = true; // as soon as you visit the cell, mark it true
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
        path[row][col] = false; // backtrack, i.e., revert the changes you made for the future calls
    }

    static ArrayList<String> mazeTraversalWithAllPathsList(int row, int col, String p, boolean[][] path) {
        ArrayList<String> current = new ArrayList<>();
        if (row == 0 && col == 0) {
            path[row][col] = false;
            current.add(p);
            return current;
        }
        if (path[row][col] == true) { // return if already visited so that you don't get into infinite loop
            return current;
        }

        path[row][col] = true; // as soon as you visit the cell, mark it true
        if (row > 0) {
            ArrayList<String> down = mazeTraversalWithAllPathsList(row - 1, col, p + 'D', path);
            current.addAll(down);
        }
        if (row < 2) {
            ArrayList<String> up = mazeTraversalWithAllPathsList(row + 1, col, p + 'U', path);
            current.addAll(up);
        }
        if (col > 0) {
            ArrayList<String> right = mazeTraversalWithAllPathsList(row, col - 1, p + 'R', path);
            current.addAll(right);
        }
        if (col < 2) {
            ArrayList<String> left = mazeTraversalWithAllPathsList(row, col + 1, p + 'L', path);
            current.addAll(left);
        }
        path[row][col] = false; // backtrack, i.e., revert the changes you made for the future calls
        return current;
    }
}
