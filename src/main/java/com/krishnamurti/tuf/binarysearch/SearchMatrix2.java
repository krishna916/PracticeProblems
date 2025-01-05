package com.krishnamurti.tuf.binarysearch;

import com.krishnamurti.Util;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        boolean result = false;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                result = true;
                break;
            } else if (matrix[row][col] < target) {
                row++;
            } else  {
                col--;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        String arrs = "[ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30] ]";
        Util.convertToJavaArray(arrs);
        int[][] mat = { {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30} };
        System.out.println(searchMatrix(mat, 20));
    }
}
