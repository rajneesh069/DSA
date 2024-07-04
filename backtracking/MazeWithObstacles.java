package backtracking;

public class MazeWithObstacles {
    public static void main(String[] args) {
        mazeWithObstaclesPath("", 3, 3);
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
}
