package com.krishnamurti.codestudio.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetBySize {

    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSetBySize(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int ulpU = findUltimateParent(u);
        int ulpV = findUltimateParent(v);

        if (ulpU == ulpV) {
            return;
        }
        if (size.get(ulpU) < size.get(ulpV)) {
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));
        } else  {
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }

    public static void main (String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
