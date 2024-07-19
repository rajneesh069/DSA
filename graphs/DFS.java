package graphs;

import java.util.ArrayList;

public class DFS {
    public void dfsTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()]; // this calls every component!
        for (int i = 0; i < vis.length; i++) {
            dfs(i, vis, adj);
        }
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // this visits/traverses every node!
        vis[node] = true;
        System.out.println("Node: " + node);
        for (Integer connectedNode : adj.get(node)) {
            if (!vis[connectedNode])
                dfs(connectedNode, vis, adj);
        }
    }
}
