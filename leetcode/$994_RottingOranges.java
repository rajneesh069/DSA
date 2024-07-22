package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int t;

    public Pair(int row, int col, int t) {
        this.row = row;
        this.col = col;
        this.t = t;
    }
}

public class $994_RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        orangesRotting(grid);
    }

    public static int orangesRotting(int[][] grid) {
        int maxTime = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[m][n]; // m x n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] drow = { -1, 0, 0, 1 };
        int[] dcol = { 0, 1, -1, 0 };
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().t;
            q.poll(); // don't do q.poll().row as it will remove the first object resulting in null
            // pointer exception for col
            maxTime = Math.max(maxTime, t);
            for (int i = 0; i < drow.length; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.offer(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                }

            }
        }

        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (vis[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxTime;

    }
}
