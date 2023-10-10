package com.krishnamurti.codestudio.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    private static final int ROTTEN = 2;
    private static final int FRESH = 1;
    private static final int EMPTY = 0;

    private static final int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static int minTimeToRot(int[][] grid, int n, int m) {
        // Write your code here.
        if (grid.length == 0) {
            return 0;
        }

        int freshOranges = 0;

        Queue<int[]> queue = new LinkedList<>();

        // add all the rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.add(new int[] {i , j});
                } else if (grid[i][j] == FRESH) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        int currentQueueSize = queue.size();
        // perform bfs starting every rotten oranges
        while (!queue.isEmpty()) {

            // track the level(minutes)
            if (currentQueueSize == 0) {
                minutes++;
                currentQueueSize = queue.size();
            }
            currentQueueSize--;
            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (nextRow >= n || nextRow < 0 ||
                        nextCol >= m || nextCol < 0 ||
                        grid[nextRow][nextCol] == EMPTY || grid[nextRow][nextCol] == ROTTEN
                ) {
                    continue;
                }

                grid[nextRow][nextCol] = ROTTEN;
                freshOranges--;
                queue.offer(new int[]{nextRow, nextCol});
            }
        }

        if (freshOranges > 0) {
            return -1;
        }
        return minutes;

    }
}
