package com.krishnamurti.leetcode.arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpiralMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int maxRow =n-1, maxCol = n -1;
        int row = 0,col = 0;
        int count = 0;
        int t = n * n;
        int el = 1;

        while (row <= maxRow && col <= maxCol) {

            for (int c = col; c <= maxCol; c++) {
                mat[row][c] = el++;
            }

            for (int r = row + 1; r <= maxRow; r++) {
                mat[r][maxCol] = el++;
            }

            for (int c = maxCol - 1; c >= col; c--) {
                mat[maxRow][c] = el++;
            }

            for (int r = maxRow - 1; r > row; r--) {
                mat[r][col] = el++;
            }

            row++;
            col++;
            maxRow--;
            maxCol--;

        }
        return mat;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(generateMatrix(3)));
    }
}
