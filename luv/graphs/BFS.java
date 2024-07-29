package luv.graphs;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        input.close();

        boolean[] vis = new boolean[n + 1];
        bfs(1, graph, vis);
    }

    static void bfs(int source, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            int currentVertex = q.poll();
            for (int child : graph.get(currentVertex)) {
                if (!vis[child]) {
                    q.add(child);
                    vis[child] = true;
                }
            }
        }
    }
}
