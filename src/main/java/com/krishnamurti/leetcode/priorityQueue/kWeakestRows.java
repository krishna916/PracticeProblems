package com.krishnamurti.leetcode.priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kWeakestRows {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] rows = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int ones = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] ==0) {
                    break;
                }
                ones++;
            }
            rows[i] = ones;
        }

        PriorityQueue<Integer[]> rowPQ = new PriorityQueue<>((a, b) -> {
            int diff = a[1] - b[1];
            return diff != 0 ? diff : a[0] - b[0];
        });

        for (int i = 0; i < rows.length; i++) {
            rowPQ.offer(new Integer[] { i, rows[i] });
        }

        int[] ans = new int[k];
        for (int i = 0; i <k  ; i++) {
            ans[i] =  rowPQ.poll()[0];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
