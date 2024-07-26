package javaPlayground.revision1.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        /*
         * Form of input :
         * 8 5 -> n m
         * // connection of vertices
         * 1 2
         * 2 4
         * 2 3
         * 3 5
         * 6 7
         */
        System.out.println("Input the graph");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        // 1 based indexing so we will go upto 'n+1'
        // n-> number of vertices
        // m-> number of edges
        // int[][] adj = new int[n + 1][n + 1]; -> this
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        input.close();
        System.out.println(graph);
    }

}
