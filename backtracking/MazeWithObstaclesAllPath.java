package backtracking;

public class MazeWithObstaclesAllPath {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        boolean[][] path = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };

        allPathNoObstacle("", maze, path, 0, 0);
    }

    static void allPathNoObstacle(String p, boolean[][] maze, boolean[][] path, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPathNoObstacle(p + "D", maze, path, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPathNoObstacle(p + "R", maze, path, r, c + 1);
        }

        if (r > 0) {
            allPathNoObstacle(p + "U", maze, path, r - 1, c);
        }

        if (c > 0) {
            allPathNoObstacle(p + "L", maze, path, r, c - 1);
        }

        maze[r][c] = true;

    }
}
