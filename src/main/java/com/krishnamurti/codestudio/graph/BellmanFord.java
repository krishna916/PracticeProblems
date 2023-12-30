package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://www.codingninjas.com/studio/problems/bellman-ford_2041977
public class BellmanFord {
    public static int[] bellmonFord(int n, int src, List<List<Integer>> edges) {
        int[] distArr = new int[n+1];

        for (int i= 1; i <= n; i++) {
            distArr[i] = (int)1e8;
        }
        distArr[src] = 0;

        for (int i = 0; i < n-1; i++) {
            for (List<Integer> edge: edges) {
                int curr = edge.get(0);
                int next = edge.get(1);
                int wt = edge.get(2);

                if ( distArr[curr] + wt < distArr[next]) {
                    distArr[next] = distArr[curr] + wt;
                }
            }
        }

        // int[] dist = new int[n];
        // int index = 0;
        // for (int i = 1; i <= n; i++) {
        //     dist[index++] = distArr[i];
        // }
        return distArr;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(1,2,4));
        edges.add(List.of(1,3,3));
        edges.add(List.of(2,4,7));
        edges.add(List.of(3,4,-2));

        int[] dist = bellmonFord(4, 1, edges);
        System.out.println(Arrays.toString(dist));


    }
}
