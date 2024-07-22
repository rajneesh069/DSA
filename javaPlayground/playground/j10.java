package javaPlayground.playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class j10 {
    public void bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.offer(1); // 1-based indexing
        vis[1] = true;
        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            bfs.add(currentNode);
            for (Integer connectedNode : adj.get(currentNode)) {
                if (!vis[connectedNode]) {
                    q.offer(connectedNode);
                    vis[connectedNode] = true;
                }
            }
        }
        System.out.println(bfs);
    }
}
