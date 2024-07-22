package javaPlayground.revision1.backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        // mazeWithObstacles(2, 2, "");
        System.out.println(mazeWithObstaclesArrayList(2, 2, ""));
    }

    static void mazeWithObstacles(int row, int col, String p) {
        if (row == 0 && col == 0) {
            System.out.println(p);
            return;
        }

        if (row == 1 && col == 1) { // obstacle at (1,1)
            return;
        }

        if (row > 0 && col > 0) {
            mazeWithObstacles(row - 1, col - 1, p + "D");
        }

        if (row > 0) {
            mazeWithObstacles(row - 1, col, p + 'V');
        }

        if (col > 0) {
            mazeWithObstacles(row, col - 1, p + 'R');
        }
    }

    static ArrayList<String> mazeWithObstaclesArrayList(int row, int col, String p) {
        ArrayList<String> current = new ArrayList<>();
        if (row == 0 && col == 0) {
            current.add(p);
            return current;
        }

        if (row == 1 && col == 1) {
            return current;
        }
        if (row > 0 && col > 0) {
            ArrayList<String> diagonal = mazeWithObstaclesArrayList(row - 1, col - 1, p + 'D');
            current.addAll(diagonal);
        }
        if (row > 0) {
            ArrayList<String> down = mazeWithObstaclesArrayList(row - 1, col, p + 'V');
            current.addAll(down);
        }
        if (col > 0) {
            ArrayList<String> right = mazeWithObstaclesArrayList(row, col - 1, p + 'R');
            current.addAll(right);
        }
        return current;
    }
}
