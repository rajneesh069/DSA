package luv.graphs;

public class DFS {
    public static void main(String[] args) {

    }

    static void dfs(int vertex, int[][] graph, boolean[] vis) {
        /*
         * Take action on vertex after entering the vertex
         */
        // if(vis[vertex]) {return;}
        vis[vertex] = true;
        for (int child : graph[vertex]) {
            if (vis[child]) {
                continue;
            }
            /*
             * Take action on child before entering the child node
             */
            dfs(child, graph, vis);
            /*
             * Take action on child after exiting child node
             */
        }
        /*
         * Take action on the vertex before exiting the vertex
         */
    }
}