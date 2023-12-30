package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.codingninjas.com/studio/problems/floyd-warshall_2041979
public class FloydWarshalShortestPath {

    static int floydWarshall(int n, int m, int src, int dest, List<List<Integer>> edges) {
        // Write your code here.
        int[][] costMat = new int[n+1][n+1];
        for (int[] arr: costMat) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            costMat[u][v] = wt;
            costMat[u][u] = 0;
            costMat[v][v] = 0;

        }

        for (int via = 1; via <= n; via++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n; j++) {
                    if (costMat[i][via] != Integer.MAX_VALUE && costMat[via][j] != Integer.MAX_VALUE) {
                        costMat[i][j] = Math.min(costMat[i][j], costMat[i][via] + costMat[via][j]);
                    }
                }
            }
        }

        return costMat[src][dest];


    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(1,2,4));
        edges.add(List.of(1,3,3));
        edges.add(List.of(2,4,7));
        edges.add(List.of(3,4,-2));

        int dist = floydWarshall(4, 4, 1, 4, edges);
        System.out.println(dist);
    }
}
