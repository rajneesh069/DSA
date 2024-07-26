package luv.graphs;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class StoringConnectedComponents {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = 10, m = 15; // n: no of vertices and m being the number of edges
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // if m is given then we are given the configuration of one of the combinations
        // 1 -- 2, we do the 2 -- 1 by ourselves and run the loop m times instead of n.
        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                count++; // number of connected components
                connectedComponents.add(new ArrayList<>());
                dfs(i, graph, vis, connectedComponents.get(connectedComponents.size() - 1));
            }
        }
        System.out.println("No. of connected components: " + count);
        System.out.println("Connected Components: " + connectedComponents);
    }

    static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] vis,
            ArrayList<Integer> currentComponent) {
        // Take action on just entering the vertex
        if (vis[vertex])
            return;
        vis[vertex] = true;
        currentComponent.add(vertex);
        for (int child : graph.get(vertex)) {
            // Take action on just entering the child
            // if (vis[child])
            // continue;
            dfs(child, graph, vis, currentComponent);
            // Take action after just leaving the child
        }
        // Take action after just leaving the vertex
    }
}
