package leetcode;

public class $733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfs(sr, sc, image[sr][sc], color, image);
        }
        return image;
    }

    private static void dfs(int i, int j, int initialColor, int newColor, int[][] image) {
        int n = image.length;
        int m = image[0].length;
        if (i < 0 || j < 0) {
            return;
        }
        if (i >= n || j >= m) {
            return;
        }
        if (image[i][j] != initialColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(i - 1, j, initialColor, newColor, image);
        dfs(i, j - 1, initialColor, newColor, image);
        dfs(i + 1, j, initialColor, newColor, image);
        dfs(i, j + 1, initialColor, newColor, image);
    }
}
