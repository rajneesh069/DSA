package luv.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowestCommonAncestor {
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

        int par[] = new int[n + 1];
        dfs(1, -1, graph, par);
        List<Integer> path1 = path(10, par);
        List<Integer> path2 = path(3, par);

        int length = Math.min(path1.size(), path2.size());
        int LCA = -1;

        for (int i = 0; i < length; i++) {
            if (path1.get(i) == path2.get(i)) {
                LCA = path1.get(i);
            } else {
                break;
            }
        }

        System.out.println(LCA);
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int[] par) {
        par[vertex] = parent;
        for (int child : graph.get(vertex)) {

            if (child == parent) {
                continue;
            }
            // going down in the recursion of the child
            dfs(child, vertex, graph, par);
            // coming back up in the recursion from the child
        }
    }

    static List<Integer> path(int vertex, int[] par) {
        List<Integer> ans = new ArrayList<>();
        while (vertex != -1) {
            ans.add(vertex);
            vertex = par[vertex];
        }
        return ans.reversed();
    }
}
