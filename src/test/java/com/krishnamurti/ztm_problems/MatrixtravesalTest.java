package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MatrixtravesalTest {

    int[][] testMatrix = {
            { 1, 2, 3, 4, 5},
            { 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
    };

    @Test
    void testDfsTest() {
        Integer[] values = MatrixTraversal.traveselDFS(testMatrix);
        System.out.println(Arrays.toString(values));
    }

    @Test
    void testBfsTest() {
        Integer[] values = MatrixTraversal.traveselBFS(testMatrix);
        System.out.println(Arrays.toString(values));
    }

    @Test
    void testWallsAndGates() {
        int[][] rooms = new int[][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        prettyPrint2DMatrix(rooms);
        MatrixTraversal.wallsAndGates(rooms);
        System.out.println("\n\n");
        prettyPrint2DMatrix(rooms);

    }

    private void prettyPrint2DMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
