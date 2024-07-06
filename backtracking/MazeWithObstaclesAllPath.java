package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeWithObstaclesAllPath {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        int[][] path = new int[maze.length][maze[0].length];
        allPathNoObstaclePrint("", maze, path, 0, 0, 0);
        // allPathNoObstacle("", maze, path, 0, 0);
        // System.out.println(allPathNoObstacleArrayList("", maze, 0, 0));
    }

    static void allPathNoObstacle(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPathNoObstacle(p + "D", maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPathNoObstacle(p + "R", maze, r, c + 1);
        }

        if (r > 0) {
            allPathNoObstacle(p + "U", maze, r - 1, c);
        }

        if (c > 0) {
            allPathNoObstacle(p + "L", maze, r, c - 1);
        }

        maze[r][c] = true;

    }

    static ArrayList<String> allPathNoObstacleArrayList(String p, boolean[][] maze, int r, int c) {
        ArrayList<String> current = new ArrayList<String>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            current.add(p);
            return current;
        }

        if (!maze[r][c]) {
            return current;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            ArrayList<String> prev = allPathNoObstacleArrayList(p + "D", maze, r + 1, c);
            current.addAll(prev);
        }

        if (c < maze[0].length - 1) {
            ArrayList<String> prev = allPathNoObstacleArrayList(p + "R", maze, r, c + 1);
            current.addAll(prev);
        }

        if (r > 0) {
            ArrayList<String> prev = allPathNoObstacleArrayList(p + "U", maze, r - 1, c);
            current.addAll(prev);
        }

        if (c > 0) {
            ArrayList<String> prev = allPathNoObstacleArrayList(p + "L", maze, r, c - 1);
            current.addAll(prev);
        }

        maze[r][c] = true;
        return current;
    }

    static void allPathNoObstaclePrint(String p, boolean[][] maze, int[][] path, int r, int c,
            int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
           for (int[] arr : path) {
            System.out.println((Arrays.toString(arr)));
           }
           System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            allPathNoObstaclePrint(p + "D", maze, path, r + 1, c, step + 1);

        }

        if (c < maze[0].length - 1) {
            allPathNoObstaclePrint(p + "R", maze, path, r, c + 1, step + 1);

        }

        if (r > 0) {
            allPathNoObstaclePrint(p + "U", maze, path, r - 1, c, step + 1);

        }

        if (c > 0) {
            allPathNoObstaclePrint(p + "L", maze, path, r, c - 1, step + 1);

        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
