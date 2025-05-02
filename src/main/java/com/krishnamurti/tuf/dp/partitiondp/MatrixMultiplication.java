package com.krishnamurti.tuf.dp.partitiondp;

import java.util.Arrays;

// https://takeuforward.org/plus/dsa/dynamic-programming/mcm-dp/matrix-chain-multiplication
public class MatrixMultiplication {

    public  int matrixMultiplication(int[] nums) {
        //your code goes here
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }

        return matrixMultiplication(1 , n-1, nums, dp);
    }

    private  int matrixMultiplication(int i, int j, int[] nums, int[][] dp) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = nums[i-1] * nums[k] * nums[j] +
                    matrixMultiplication(i, k, nums, dp) + matrixMultiplication(k+1, j, nums, dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }

    public int matrixMultiplicationTabulation(int[] nums) {
        //your code goes here
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = nums[i - 1] * nums[k] * nums[j] +
                            dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 25};
//        int[] arr1 = {4, 2, 3};
//        int[] arr2 = {1,2,3,4,5};
        MatrixMultiplication sol = new MatrixMultiplication();

//        System.out.println(Arrays.toString(arr) + ":  " + sol.matrixMultiplication(arr));
        System.out.println(Arrays.toString(arr) + ":  " + sol.matrixMultiplicationTabulation(arr));

    }

}
