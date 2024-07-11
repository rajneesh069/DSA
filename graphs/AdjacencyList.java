package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyList {
    public static void main(String[] args) {
        // 1 -- 2 -- 3 -- 1 -> graph
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list
        // we'll insert (n+1) empty lists in the 'adj' list, where 'n' is the number of
        // nodes.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); // (n+1) array lists inserted
        }

        // 1 -- 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // 2 -- 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // 3--1
        adj.get(3).add(1);
        adj.get(1).add(3);

        /*
         * u--v
         * adj.get(u).add(v);
         * adj.get(v).add(u);
         */

        for (int i = 1; i <= n; i++) {
            System.out.print("Node " + i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + "\s");
            }
            System.out.println();
        }
    }

}
