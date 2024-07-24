package luv.graphs;

public class DFS {
    public static void main(String[] args) {

    }

    static int n, m;
    static int[][] graph = new int[n][n];

    static boolean[] vis = new boolean[n];

    static void dfs(int vertex) {
        /*
         * Take action on vertex after entering the vertex
         */
        // if(vis[vertex]) {return;}
        vis[vertex] = true;
        for (int child : graph[vertex]) {
            /*
             * Take action on child before entering the child node
             */
            if (vis[child]) {
                continue;
            }
            dfs(child);
            /*
             * Take action on child after exiting child node
             */
        }
        /*
         * Take action on the vertex before exiting the vertex
         */
    }
}