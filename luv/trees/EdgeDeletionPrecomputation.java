package luv.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EdgeDeletionPrecomputation {
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
        int[] subtreeSum = new int[n + 1];
        dfs(1, graph, vis, subtreeSum);

        System.out.println("subtreeSum: " + Arrays.toString(subtreeSum));

        long ans = 0;
        for (int i = 2; i <= n; i++) {
            int sum1 = subtreeSum[i];
            int diff = subtreeSum[1] - sum1;
            ans = Math.max(ans, diff * sum1);
            System.out.println("ans at " + i + ": " + ans);
        }
        System.out.println("max product: " + ans);
    }

    static void dfs(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] vis, int[] subtreeSum) {
        vis[vertex] = true;
        subtreeSum[vertex] += vertex;
        for (int child : graph.get(vertex)) {
            // going down in the recursion of the child
            if (vis[child]) {
                continue;
            }
            dfs(child, graph, vis, subtreeSum);
            subtreeSum[vertex] += subtreeSum[child];
            // coming back up in the recursion from the child
        }
    }
}
