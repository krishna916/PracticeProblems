package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/number-of-provinces/1
public class NumOfProvinces {
    static int numProvinces(List<List<Integer>> adj, int V) {
        // code here
        DisjointSet set = new DisjointSet(V);

        for (int i = 0 ; i < V; i++) {
            for (int j = 0 ; j < V; j++) {
                if (i != j && adj.get(i).get(j) == 1) {
                    if (!set.isSameComponent(i, j)) {
                        set.union(i, j);
                    }
                }
            }
        }

        return set.getNoOfComponent();


    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(List.of(1,0,1));
        arr.add(List.of(0,1,0));
        arr.add(List.of(1,0,1));
        System.out.println(numProvinces(arr, 3));
    }
}



class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();


    public DisjointSet(int n) {
        for  (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int ulp(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = ulp(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }


    public void union(int a, int b) {
        int aUlp = ulp(a);
        int bUlp = ulp(b);

        if (aUlp == bUlp) {
            return;
        }

        if (rank.get(aUlp) < rank.get(bUlp)) {
            parent.set(aUlp, bUlp);
        } else if (rank.get(bUlp) < rank.get(aUlp)) {
            parent.set(bUlp, aUlp);
        } else {
            rank.set(aUlp, rank.get(aUlp) + 1);
            parent.set(bUlp, aUlp);
        }
    }

    public boolean isSameComponent (int u, int v) {
        return ulp(u) == ulp(v);
    }

    public int getNoOfComponent () {
        int n = 0;
        for (int i = 0; i < parent.size() ;i++) {
            if (i == parent.get(i)) {
                n++;
            }
        }
        return n - 1;
    }

}