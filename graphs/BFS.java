package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class BFS {
    // Time complexity = O(N) + O(2*E)
    // Space complexity = O(3*N)
    // V is number of nodes
    private ArrayList<Integer> traversalBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // here nodes are of Integer type
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V]; // the concept of visited array ensures that every node is traversed only once
        Queue<Integer> queue = new LinkedList<>(); // to store the nodes sequentially
        queue.offer(0); // 0-based indexing
        vis[0] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            bfs.add(currentNode);

            for (Integer integer : adj.get(currentNode)) {
                if (vis[integer] == false) {
                    queue.offer(integer);
                    vis[integer] = true;
                }
            }
        }

        return bfs;
    }
}
