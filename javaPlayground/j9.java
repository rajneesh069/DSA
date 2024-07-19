package javaPlayground;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class j9 {
    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 }, // 0
                { 1, 1, 0 }, // 1
                { 0, 0, 1 } // 2
        };
        findCircleNum(isConnected);
    }

    public static void findCircleNum(int[][] isConnected) {
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

        System.out.println("adjacencyList: " + adjacencyList);
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < vis.length; i++) { // it calls every component
            if (vis[i] == false) {
                count++;
                dfs(i, adjacencyList, vis);
            }
        }
        System.out.println(count);
    }

    private static void dfs(Integer node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] vis) {
        // this visits every connected node of that component
        vis[node] = true;
        for (Integer connectedNode : adjacencyList.get(node)) {
            if (vis[connectedNode] == false) {
                dfs(connectedNode, adjacencyList, vis);
            }
        }
    }
}
