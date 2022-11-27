package com.krishnamurti.leetcode;

/**
 *  <b><a href="https://leetcode.com/problems/richest-customer-wealth/">Problem Statement</a></b>
 */
public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int i = 0; i < accounts.length; i++) {
            int[] customerAccounts = accounts[i];
            int sum = 0;
            for(int j =0; j < customerAccounts.length; j++) {
                sum += customerAccounts[j];
            }
            if(sum >= result) {
                result = sum;
            }
        }
        return result;
    }

}
