package luv.graphs;

public class DFS {
    public static void main(String[] args) {

    }

    static int n, m;
    static int[][] graph = new int[n][n];

    static boolean[] vis = new boolean[n];

    static void dfs(int vertex) {
        // Basic DFS, not correct but basic DFS algo.
        for (int child : graph[vertex]) {
            dfs(child);
        }
    }
}