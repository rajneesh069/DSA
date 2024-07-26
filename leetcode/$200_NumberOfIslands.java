package leetcode;

public class $200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds check
        if (i < 0 || j < 0) {
            return;
        }
        if (i >= n || j >= m) {
            return;
        }
        // to not visit the zeroes
        if (grid[i][j] != '1') {
            return;
        }
        // to not visit the same node more than once
        if (vis[i][j]) {
            return;
        }
        vis[i][j] = true;
        dfs(i - 1, j, grid, vis);
        dfs(i, j - 1, grid, vis);
        dfs(i + 1, j, grid, vis);
        dfs(i, j + 1, grid, vis);
    }
}
