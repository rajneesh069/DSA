package luv.trees;

import java.util.*;

public class DiameterOfATree {
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
        int depth[] = new int[n + 1];

        dfs(1, 0, graph, depth);
        System.out.println("depth: " + Arrays.toString(depth));

        int max_depth = -1;
        int max_depth_node = -1;

        for (int i = 0; i < depth.length; i++) {
            if (max_depth < depth[i]) {
                max_depth = depth[i];
                max_depth_node = i;
            }
            depth[i] = 0;
        }

        System.out.println("max_depth_node: " + max_depth_node);
        dfs(max_depth_node, 0, graph, depth);
        for (int i = 0; i < depth.length; i++) {
            if (max_depth < depth[i]) {
                max_depth = depth[i];
                max_depth_node = i;
            }
            depth[i] = 0;
        }
        System.out.println("max_depth_node: " + max_depth_node);
        System.out.println("max_depth: " + max_depth);
    }

    static void dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> graph, int[] depth) {
        // at this point three different nodes are there : parent(the past one),
        // vertex(the current one), child(it's future)
        for (int child : graph.get(vertex)) {
            // for the same vertex all its children, so the parent is the vertex's parent
            // while for all its children the parent is the vertex itself, so the parent is
            // grandparent of the child here.
            if (child == parent) {
                // 1 -- 2 : when 2 will run then 1 will be its parent and since we don't want
                // infinite loops we avoid that condition here
                continue;
            }
            System.out.println("Vertex: " + vertex + " parent: " + parent + " child: " + child);
            depth[child] = depth[vertex] + 1;
            dfs(child, vertex, graph, depth);
            // coming back up in the recursion from the child
        }
    }
}
