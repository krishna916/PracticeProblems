package com.krishnamurti.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2D {


    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length ==0 || mat[0].length == 0) {
            return new int[0];
        }
        int maxRow = mat.length, maxCol = mat[0].length;
        int[] result = new int[maxRow * maxCol];
        int resultIndex = 0;
        int row = 0, col = 0;
        boolean up = true;

        while( row < maxRow && col < maxCol) {
            if(up) {
                // traverse upwards
                while (col < maxCol - 1 && row > 0) {
                    result[resultIndex++] = mat[row][col];
                    col++;
                    row--;
                }
                // Enter the last node in digonal traversal
                result[resultIndex++] = mat[row][col];
                if (col == maxCol -1) {
                    row++;
                } else {
                    col++;
                }

            } else {
                // traverse downwards
                while(row < maxRow - 1 && col > 0) {
                    result[resultIndex++] = mat[row][col];
                    col--;
                    row++;
                }
                // enter last node in diagonal
                result[resultIndex++] = mat[row][col];
                if (row == maxRow -1) {
                    col++;
                } else {
                    row++;
                }
            }

            // change direction at the end of every diagonal
            up = !up;
        }
        return result;

    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int maxRow = matrix.length -1, maxCol = matrix[0].length - 1;
        int minCol = 0, minRow = 0;

        int row = 0, col = 0;

        int n = matrix.length * matrix[0].length;
        int direction = 1; // 1- right, 2- down , 3 - left, 4 - up
        while (result.size() < n) {
            switch (direction) {
                case 1: { // right
                    while (col < maxCol) {
                        result.add(matrix[row][col]);
                        col++;
                    }
                    result.add(matrix[row][col]);
                    row++;
                    minRow = minRow + 1;// increment minRow so that spiral goes inward
                    direction = 2;
                    break;
                }
                case 2: { // down
                    while (row < maxRow) {
                        result.add(matrix[row][col]);
                        row++;
                    }
                    result.add(matrix[row][col]);
                    col--;
                    maxCol = maxCol -1;// decrement maxCol so that spiral goes inward
                    direction = 3;
                    break;
                }
                case 3: { //left
                    while (col > minCol) {
                        result.add(matrix[row][col]);
                        col--;
                    }
                    result.add(matrix[row][col]);
                    row--;
                    maxRow = maxRow -1;// decrement maxRow so that spiral goes inward
                    direction = 4;
                    break;
                }
                case 4: { //up
                    while (row > minRow) {
                        result.add(matrix[row][col]);
                        row--;
                    }
                    result.add(matrix[row][col]);
                    col++;
                    minCol = minCol + 1; // increment minCol so that spiral goes inward
                    direction = 1;
                    break;
                }
            }

        }
        return result;
    }

    public static  List<List<Integer>> generatePascal(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>(1);
        one.add(1);
        result.add(one);
        int currentRowCount = 2;
        while (currentRowCount <= numRows) {
            List<Integer> currentRow = new ArrayList<>(currentRowCount);
            currentRow.add(1);
            int colCount = 1;
            List<Integer> previousRow = result.get(currentRowCount - 2);
            while(currentRowCount > 2 && colCount <= currentRowCount - 2) {
                currentRow.add(previousRow.get(colCount) + previousRow.get(colCount - 1));
                colCount++;
            }

            currentRow.add(1);
            result.add(currentRow);
            currentRowCount++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
//         [1,2,4,7,5,3,6,8,9]

//        System.out.println(spiralOrder(mat));
//        [1,2,3,6,9,8,7,4,5]
        System.out.println(generatePascal(5));
    }
}
