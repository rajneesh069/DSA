package graphs;

import java.util.ArrayList;

public class DFS {
    public void dfsTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()]; // this calls every component!
        for (int vertex = 0; vertex < vis.length; vertex++) {
            dfs(vertex, vis, adj);
        }
    }

    private void dfs(int vertex, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // this visits/traverses every node!
        vis[vertex] = true;
        System.out.println("Node: " + vertex);
        for (Integer child : adj.get(vertex)) {
            if (!vis[child])
                dfs(child, vis, adj);
        }
    }
}
