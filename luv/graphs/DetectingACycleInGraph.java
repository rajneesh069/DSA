package luv.graphs;

import java.util.*;

public class DetectingACycleInGraph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of vertices
        int m = input.nextInt(); // number of edges

        // System.out.println("number of vertices: " + n);
        // System.out.println("number of edges: " + m);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        input.close();
        // int count = 0;
        // for (int i = 0; i < vis.length; i++) {
        // if (!vis[i]) {
        // count++;
        // dfs(i, graph, vis);
        // }
        // }
        System.out.println(graph);
        boolean doesLoopExist = false;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (dfsDetectCycle(i, 0, graph, vis)) {
                    doesLoopExist = true;
                    break;
                }
            }
        }
        System.out.println(doesLoopExist);
        // System.out.println(count);
    }

    static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[vertex] = true;
        for (int child : graph.get(vertex)) {
            if (vis[child]) {
                continue;
            }
            dfs(child, graph, vis);

        }
    }

    static boolean dfsDetectCycle(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[vertex] = true;
        // do something when you enter the vertex
        boolean doesLoopExist = false;
        for (int child : graph.get(vertex)) {
            // do something when you enter the child
            if (vis[child] && child == parent) {
                continue;
            }
            if (vis[child]) {
                return true;
            }
            doesLoopExist |= dfsDetectCycle(child, vertex, graph, vis);
            // do something when you exit the child

        }
        return doesLoopExist;
        // do something when you exit the vertex
    }
}
