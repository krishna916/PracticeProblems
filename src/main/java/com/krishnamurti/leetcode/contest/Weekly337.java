package com.krishnamurti.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class Weekly337 {
    public static boolean checkValidGrid(int[][] grid) {
        Map<Integer, Integer[]> map = new HashMap<>();

        for (int row = 0; row < grid.length;row++) {
            for (int col = 0; col < grid.length; col++) {
                map.put(grid[row][col], new Integer[] { row, col });
            }
        }

        int n = map.size();
//        int index = 1;
        int step = 1;
        Integer[] previous = new Integer[] { 0, 0 };
        while (step < n) {
            Integer[] g = map.get(step);
            int pRow = previous[0];
            int pCol = previous[1];

            int cRow = g[0];
            int cCol = g[1];

            if (
                    (cRow == pRow + 2 && cCol == pCol + 1) ||
                            (cRow == pRow - 2 && cCol == pCol + 1) ||
                            (cRow == pRow + 2 && cCol == pCol - 1) ||
                            (cRow == pRow - 2 && cCol == pCol - 1) ||
                            (cCol == pCol + 2 && cRow == pRow + 1) ||
                            (cCol == pCol + 2 && cRow == pRow - 1) ||
                            (cCol == pCol - 2 && cRow == pRow + 1) ||
                            (cCol == pCol - 2 && cRow == pRow - 1)
            ) {
                previous[0] = cRow;
                previous[1] = cCol;
            } else {
                return false;
            }
            step++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };

        int[][] grid1 = {{0,3,6},{5,8,1},{2,7,4}};
        System.out.println(checkValidGrid(grid1));
    }
}
