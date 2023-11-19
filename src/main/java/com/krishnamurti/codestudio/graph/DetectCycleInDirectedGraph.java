package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleInDirectedGraph {
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        // Write your code here.
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // create adjacenyList
        for (int i = 0; i < e; i++) {
            int[] edge = edges[i];
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>());
        }

        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];

        for (Integer node: adjList.keySet()) {
            if (!visited[node]) {
                boolean hasCycle = hasCycle(node, pathVisited, visited, adjList);
                if (hasCycle) {
                    return hasCycle;
                }
            }
        }

        return false;
    }

    private static boolean hasCycle(int src, boolean[] pathVisited, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        visited[src] = true;
        pathVisited[src] = true;


        for (Integer node: adjList.get(src)) {
            if (pathVisited[node]) {
                return true;
            }
            boolean hasCycle = hasCycle(node, pathVisited, visited, adjList);
            if (hasCycle) {
                return true;
            }
        }

        pathVisited[src] = false;
        return false;

    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1},{0, 2}
        };
        System.out.println(isCyclic(edges, 3, 2));

    }
}
