package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathInDAG {

    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here

        int[] ans = new int[n];
        int src = 0;

        // adjeceny list
        List<List<int[]>> adj = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            // initialize adj
            adj.add(new ArrayList<>());

            // fill answer with max values
            if (i != src) {
                ans[i] = Integer.MAX_VALUE;
            }

        }

        // populate adj
        for (int[] edge: edges) {
            int child = edge[0];

            int[] parent = new int[2];
            parent[0] = edge[1];
            parent[1] = edge[2];

            adj.get(child).add(parent);
        }

        // required components
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new LinkedList<>();

        // Topo Sort - DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }


        while (!stack.isEmpty()) {
            int node = stack.pop();
            List<int[]> connNodes = adj.get(node);

            for (int[] connNode: connNodes) {
                int nei = connNode[0];
                int wt = connNode[1];
                if ( ans[node] != Integer.MAX_VALUE &&  ans[node] + wt < ans[nei]) {
                    ans[nei] = ans[node] + wt;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }



        return ans;
    }

    private static void dfs(int node, boolean[] visited, List<List<int[]>> adj, Deque<Integer> stack) {
        // mark node as visited
        visited[node] = true;

        // dfs for the connected nodes
        List<int[]> connNodes = adj.get(node);
        for(int[] connNode: connNodes) {
            if (!visited[connNode[0]]) {
                dfs(connNode[0], visited, adj, stack);
            }
        }

        // add node to stack as last step
        stack.push(node);
    }

    public static void main(String[] args) {
        int[][] edges = {
                {2, 0, 4},
                {0, 1, 3},
                {2, 1, 2}
        };

        System.out.println(Arrays.toString(shortestPathInDAG(3, 3, edges)));
    }
}
