package com.krishnamurti.codestudio.matrix;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class ShortestPathBinaryMatrix {
    private static int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    } ;

    public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
        // Write your code here

        if (src.x == dest.x && src.y == dest.y) {
            return 0;
        }


        int[][] distArr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (src.x == i && src.y == j) {
                    continue;
                }

                distArr[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> queue = new LinkedList<>();

        queue.offer(src);

        while (!queue.isEmpty()) {
            Point cell = queue.poll();
            int dist = distArr[cell.x][cell.y];
            for (int[] direction: directions) {
                int row = cell.x + direction[0];
                int col = cell.y + direction[1];

                if ( row < 0 || row >= matrix.length ||
                        col < 0 || col >= matrix[0].length ||
                        matrix[row][col] == 0
                ) {
                    continue;
                }

                int cDist = dist + 1;
                if (cDist < distArr[row][col]) {
                    if (row == dest.x && col == dest.y) {
                        return cDist;
                    }
                    distArr[row][col] = cDist;
                    queue.offer(new Point(row, col));
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {

    }
}
