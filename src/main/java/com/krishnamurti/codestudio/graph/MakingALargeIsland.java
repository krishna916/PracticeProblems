package com.krishnamurti.codestudio.graph;

import com.krishnamurti.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/making-a-large-island/description/
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSetSize set = new DisjointSetSize(n * n);

        int[][] directions = {
                { -1, 0},
                { 0, 1},
                { 1, 0},
                { 0, -1}
        };

        // step 1: add the current islands to the DisjointSet
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                int node = row * n + col;
                for (int[] d: directions) {
                    int adjR = row + d[0];
                    int adjC = col + d[1];

                    if (adjR < 0 || adjR >= n ||
                            adjC < 0 || adjC >= n ||
                            grid[adjR][adjC] == 0
                    ) {
                        continue;
                    }
                    int adjNode = adjR * n + adjC;
                    set.union(node, adjNode);
                }

            }
        }
        //step 2: check for the other cells and flip zero to 1
        int maxSize = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }
                int size = 0;
                Set<Integer> sizeSet = new HashSet<>();
                for (int[] d: directions) {
                    int adjR = row + d[0];
                    int adjC = col + d[1];

                    if (adjR < 0 || adjR >= n ||
                            adjC < 0 || adjC >= n ||
                            grid[adjR][adjC] == 0
                    ) {
                        continue;
                    }
                    int adjNode = adjR * n + adjC;
                    int up = set.findP(adjNode);

                    sizeSet.add(up);
                }

                for (int i: sizeSet) {
                    size += set.size(i);
                }
                maxSize = Math.max(maxSize, size+1);
                sizeSet.clear();
            }

        }

        // safety check if all the cell is 1
        for (int node = 0; node < n*n; node++) {
            maxSize = Math.max(maxSize, set.size(set.findP(node)));
        }
        return maxSize;
    }

    public static void main(String[] args) {
        MakingALargeIsland a = new MakingALargeIsland();

        Util.convertToJavaArray("[[1,1],[1,1]]");
        int[][] grid = {{1,1},{1,1}};
        int size = a.largestIsland(grid);
        System.out.println(size);
    }
}


class DisjointSetSize {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSetSize(int n) {
        for (int i = 0; i < n ; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findP(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int up = findP(parent.get(node));
        parent.set(node, up);
        return up;
    }

    public void union(int u, int v) {
        int up = findP(u);
        int vp = findP(v);

        if (up == vp) {
            return;
        }

        if (size.get(up) < size.get(vp) ) {
            parent.set(up, vp);
            size.set(vp, size.get(vp) + size.get(up));
        } else {
            parent.set(vp, up);
            size.set(up, size.get(up) +  size.get(vp));
        }
    }

    public boolean connected(int u, int v) {
        return findP(u) == findP(v);
    }

    public int size(int node) {
        return size.get(node);
    }


}