package graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        return dfs(V, 0, adj, vis, list);

    }

    private ArrayList<Integer> dfs(int V, int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis,
            ArrayList<Integer> list) {
        list.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(V, it, adj, vis, list);
            }
        }
        return list;
    }
}
