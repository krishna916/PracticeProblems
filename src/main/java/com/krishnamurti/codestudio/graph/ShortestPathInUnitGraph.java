package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInUnitGraph {

    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.

        // adj list
        List<Set<Integer>> adj = new ArrayList<>();

        // dist arr
        int[] dist = new int[n];


        for (int i = 0 ; i < n; i++) {
            // initialize adj
            adj.add(new HashSet<>());

            // initialize dist array with max value
            if (src != i) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // populate adj
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src); // add source to the queue with distance = 0

        while (!queue.isEmpty()) {
            Integer nodeValue = queue.poll();

            for (Integer nei: adj.get(nodeValue)) {
                if (dist[nodeValue] != Integer.MAX_VALUE && dist[nodeValue] + 1 < dist[nei]) {
                    dist[nei] = dist[nodeValue] + 1;
                    queue.offer(nei);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {2, 3}
        };

        System.out.println(Arrays.toString(shortestPath(4, edges, 0)));
    }
}
