package com.krishnamurti.tuf.binarysearch;

import com.krishnamurti.Util;

public class RowsWithMax1s {
    public static int rowWithMax1s(int[][] mat) {
        int index = -1;
        int maxOnes = 0;

        for (int row = 0; row < mat.length; row++) {
            int left = 0;
            int right = mat[row].length - 1;
            int firstOne = 0;
            int[] cRow = mat[row];
            while (left <= right) {
                int mid = left + (right - left)/2;

                if (cRow[mid] == 1) {
                    firstOne = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (firstOne > 0 || mat[row][0] == 1) {
                int ones = mat[row].length - firstOne;
                if (ones > maxOnes) {
                    maxOnes = ones;
                    index = row;
                }
            }
        }

        return index;

    }

    public static void main(String[] args) {
        String arr = "[[0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]]";

        Util.convertToJavaArray(arr);

        int[][] mat = {{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

        System.out.println(rowWithMax1s(mat));


    }
}
