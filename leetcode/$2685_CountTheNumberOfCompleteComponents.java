package leetcode;

public class $2685_CountTheNumberOfCompleteComponents {
    public static int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                dfs(i, edges, vis);
                count++;
            }
        }

        return count;
    }

    public static void dfs(int node, int[][] edges, boolean[] vis) {
        vis[node] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == node) {
                if (!vis[edges[i][1]]) {
                    dfs(edges[i][1], edges, vis);
                }
            }

            if (edges[i][1] == node) {
                if (!vis[edges[i][0]]) {
                    dfs(edges[i][0], edges, vis);
                }
            }
        }

    }
}
