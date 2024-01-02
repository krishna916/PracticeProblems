package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetByRank {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSetByRank(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUltimateParent (int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v) {
        int ulpU = findUltimateParent(u);
        int ulpV = findUltimateParent(v);

        if (ulpU == ulpV) {
            return;
        }
        if (rank.get(ulpU) < rank.get(ulpV)) {
            parent.set(ulpU, ulpV);
        } else if (rank.get(ulpV) < rank.get(ulpU)) {
            parent.set(ulpV, ulpU);
        } else {
            parent.set(ulpV, ulpU);
            rank.set(ulpU, rank.get(ulpU) + 1);
        }
    }


    public static void main (String[] args) {
        DisjointSetByRank ds = new DisjointSetByRank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }


}
