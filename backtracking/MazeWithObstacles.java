package backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        // mazeWithObstaclesPath("", 3, 3);
        // System.out.println(mazeWithObstaclesPathArrayList("", 3, 3));
        boolean[][] maze = {
                { true, true, true },
                { true, false, true },
                { true, true, true },
        };
        System.out.println(mazeWithObstaclesPathArrayList("", maze, 0, 0));
        mazeWithObstaclesPath("", maze, 0, 0);
    }

    static void mazeWithObstaclesPath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r == 2 && c == 2) {
            return;
        }

        if (r > 1 && c > 1) {
            mazeWithObstaclesPath(p + "D", r - 1, c - 1);
        }

        if (r > 1) {
            mazeWithObstaclesPath(p + "V", r - 1, c);
        }
        if (c > 1) {
            mazeWithObstaclesPath(p + "R", r, c - 1);
        }
    }

    static ArrayList<String> mazeWithObstaclesPathArrayList(String p, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }

        if (r == 2 && c == 2) {
            return ans;
        }

        if (r > 1 && c > 1) {
            ArrayList<String> prev = mazeWithObstaclesPathArrayList(p + "D", r - 1, c - 1);
            ans.addAll(prev);
        }

        if (r > 1) {
            ArrayList<String> prev = mazeWithObstaclesPathArrayList(p + "V", r - 1, c);
            ans.addAll(prev);
        }
        if (c > 1) {
            ArrayList<String> prev = mazeWithObstaclesPathArrayList(p + "R", r, c - 1);
            ans.addAll(prev);
        }
        return ans;
    }

    static ArrayList<String> mazeWithObstaclesPathArrayList(String p, boolean[][] maze, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ans.add(p);
            return ans;
        }

        if (maze[r][c] == false) {
            return ans;
        }

        if ((r < maze.length - 1 && c < maze[0].length - 1)) {
            ArrayList<String> prev = mazeWithObstaclesPathArrayList(p + "D", maze, r + 1, c + 1);
            ans.addAll(prev);
        }

        if (r < maze.length - 1) {
            ArrayList<String> prev = mazeWithObstaclesPathArrayList(p + "V", maze, r + 1, c);
            ans.addAll(prev);
        }
        if (c < maze[0].length - 1) {
            ArrayList<String> prev = mazeWithObstaclesPathArrayList(p + "R", maze, r, c + 1);
            ans.addAll(prev);
        }
        return ans;
    }

    static void mazeWithObstaclesPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c] == false) {
            return;
        }

        if ((r < maze.length - 1 && c < maze[0].length - 1)) {
            mazeWithObstaclesPath(p + "D", maze, r + 1, c + 1);

        }

        if (r < maze.length - 1) {
            mazeWithObstaclesPath(p + "V", maze, r + 1, c);

        }
        if (c < maze[0].length - 1) {
            mazeWithObstaclesPath(p + "R", maze, r, c + 1);

        }
        return;
    }
}
