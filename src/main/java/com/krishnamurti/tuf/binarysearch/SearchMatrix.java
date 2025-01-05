package com.krishnamurti.tuf.binarysearch;

import com.krishnamurti.Util;

public class SearchMatrix {
    public static boolean searchMatrix(int[][] mat, int target) {
        int left = 0;
        int r = mat.length;
        int c = mat[0].length;
        int right = (r * c) - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = (mid / c) ;
            int col = mid % c;

            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String arr = "[ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12] ]";
        Util.convertToJavaArray(arr);
        int[][] a = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
        System.out.println(searchMatrix(a, 8));
    }
}
