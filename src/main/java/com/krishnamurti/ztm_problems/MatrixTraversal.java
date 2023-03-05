package com.krishnamurti.ztm_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixTraversal {

    static int[][] directions = {
            {-1, 0}, // up
            {0, 1},  //right
            {1, 0},  //down
            {0, -1}  //left
    };

    public static Integer[] traveselDFS(int[][] matrix) {
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];

        List<Integer> values = new ArrayList<>();
        dfs(matrix, 0, 0, seen, values);
        return values.toArray(new Integer[0]);
    }

    /*
     DFS: UP -> RIGHT -> DOWN -> LEFT
     */
    private static void dfs(int[][] matrix, int row, int col, boolean[][] seen, List<Integer> values) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || seen[row][col]) {
            return;
        }

        values.add(matrix[row][col]);
        seen[row][col] = true;

        for (int[] currentDir : directions) {
            dfs(matrix, row + currentDir[0], col + currentDir[1], seen, values);
        }
    }

    public static Integer[] traveselBFS(int[][] matrix) {
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        List<Integer> values = new ArrayList<>();

        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] first = {0, 0};
        queue.add(first);
        while (!queue.isEmpty()) {
            Integer[] currentPost = queue.poll();
            int  row = currentPost[0];
            int col = currentPost[1];
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || seen[row][col]) {
                continue;
            }
            seen[row][col] = true;
            values.add(matrix[row][col]);

            for (int[] i: directions) {
                Integer[] dir = { row + i[0], col + i[1]};
                queue.add(dir);
            }
        }

        return values.toArray(new Integer[0]);
    }


    public static void wallsAndGates(int[][] rooms) {
        List<Integer[]> gates = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < rooms.length ; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    gates.add(new Integer[] { i, j });
                }
            }
        }

        if(!gates.isEmpty()) {
            int[][] directions = {
                    { -1, 0 },
                    { 0, 1 },
                    { 1, 0 },
                    {0, -1}
            };
            // int[][] seen = new int[rooms.length][rooms[0].length];
            for (Integer[] gate: gates) {

                dfs(gate[0], gate[1], rooms, directions, 0);
            }
        }

    }
    private static void dfs(int row, int col, int[][] rooms, int[][] directions, int path) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || path > rooms[row][col] ) {
            return;
        }

        rooms[row][col] = path;
        for(int[] dir: directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            dfs(nextRow, nextCol, rooms, directions, path + 1);
        }

    }


}
