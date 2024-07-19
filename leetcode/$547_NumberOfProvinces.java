package leetcode;

import java.util.ArrayList;

public class $547_NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        // 0-based indexed graph
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < isConnected.length; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < vis.length; i++) { // it calls every component
            if (vis[i] == false) {
                count++;
                dfs(i, adjacencyList, vis);
            }
        }
        return count;
    }

    private static void dfs(Integer node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] vis) {
        // this visits every connected node
        vis[node] = true;
        for (Integer connectedNode : adjacencyList.get(node)) {
            if (vis[connectedNode] == false) {
                dfs(connectedNode, adjacencyList, vis);
            }
        }
    }
}
