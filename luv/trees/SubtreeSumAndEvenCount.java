package luv.trees;

import java.util.*;

public class SubtreeSumAndEvenCount {

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
        int subtreeSum[] = new int[n + 1];
        int evenCount[] = new int[n + 1];
        dfs(1, 0, graph, subtreeSum, evenCount);
        System.out.println("subtreeSum: " + Arrays.toString(subtreeSum));
        System.out.println("evenCount: " + Arrays.toString(evenCount));
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int[] subtreeSum, int[] evenCount) {
        subtreeSum[vertex] += vertex;
        if (vertex % 2 == 0) {
            evenCount[vertex]++;
        }
        for (int child : graph.get(vertex)) {
            // for the same vertex all its children
            if (child == parent)
                continue;
            // entering the recursion into the child
            dfs(child, vertex, graph, subtreeSum, evenCount);
            // coming back up in the recursion from the child
            subtreeSum[vertex] += subtreeSum[child];
            evenCount[vertex] += evenCount[child];
        }

    }

}
