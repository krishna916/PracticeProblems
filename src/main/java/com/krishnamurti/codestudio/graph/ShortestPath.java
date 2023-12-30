package com.krishnamurti.codestudio.graph;

import com.krishnamurti.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {
    public static List<Integer> shortestPath(int n, int m, int[][] edges){
        //  Code Here.

        //adj
        List<List<int[]>> adj = new ArrayList<>();

        //dist arr
        int[] distArr = new int[n+1];

        // parent arr
        int[] parent = new int[n+1];

        // initialize
        for (int i = 0; i <= n; i++ ) {

            //adj
            adj.add(new ArrayList<>());

        }

        for (int i = 1; i <= n; i++) {
            //distArr
            distArr[i] = Integer.MAX_VALUE;

            // parent
            parent[i] = i;
        }


        // populate adj
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];

            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adj.get(edge[1]).add(new int[] { edge[0], edge[2] });

        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.offer(new Pair(0, 1));
        distArr[1] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int dist = pair.dist;
            int node = pair.node;

            for (int[] nei: adj.get(node)) {
                int adjNode = nei[0];
                int wt = nei[1];

                int currentD = dist + wt;

                if (currentD < distArr[adjNode]) {
                    distArr[adjNode] = currentD;
                    pq.offer(new Pair(currentD, adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;

    }

    public static void main(String[] args) {
//        Util.convertToJavaArray("[[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]");
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        List<Integer> ans = shortestPath(5, 6, edges);
        System.out.println(ans);

    }
}

class Pair {
    public int dist;
    public int node;

    public Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}