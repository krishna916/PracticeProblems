package com.krishnamurti.codestudio.graph;

import com.krishnamurti.Util;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-islands-ii/description/
public class NumOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DisjointSet1 set = new DisjointSet1(m * n);
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];

        int[][] directions = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        int count = 0;
        for (int[] p: positions) {
            int row = p[0];
            int col = p[1];
            int node = n * row + col;
            if (!visited[row][col]) {
                visited[row][col] = true;
                count++;
                for (int[] d: directions) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    int nNode = n * nr + nc;
                    if (nr < 0 || nr >= m ||
                            nc < 0 || nc >= n

                    ) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        if (!set.connected(node, nNode)) {
                            set.union(node, nNode);
                            count--;
                        }
                    }

                }

            }
            ans.add(count);
        }


        return ans;
    }

    public static void main(String[] args) {
//        Util.convertToJavaArray("[[0,0],[0,1],[1,2],[2,1]]");


        NumOfIslands2 o = new NumOfIslands2();
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};

        List<Integer> ans = o.numIslands2(8, 4, positions);
        System.out.println(ans);

//       Util.convertToJavaArray("[[0,0],[7,1],[6,1],[3,3],[4,1]]");
    }
}

class DisjointSet1 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet1(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
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

        if (rank.get(up) < rank.get(vp)) {
            parent.set(up, vp);
        } else if (rank.get(vp) < rank.get(up)) {
            parent.set(vp, up);
        } else {
            rank.set(up, rank.get(up) + 1);
            parent.set(vp, up);
        }
    }

    public boolean connected(int u, int v) {
        return findP(u) == findP(v);
    }

}
