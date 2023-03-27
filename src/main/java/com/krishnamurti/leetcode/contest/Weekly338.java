package com.krishnamurti.leetcode.contest;

public class Weekly338 {
    public static  int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        if(numOnes >= k) {
            return k;
        }
        k = k - numOnes;
        sum = numOnes;

        if (numZeros >= k) {
            return sum;
        }

        k = k - numZeros;

        sum = sum - k;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(2, 2, 4, 3));
    }
}
