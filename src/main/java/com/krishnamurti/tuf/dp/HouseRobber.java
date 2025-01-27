package com.krishnamurti.tuf.dp;

import java.util.Arrays;

public class HouseRobber {
    public int houseRobber(int[] nums) {
        int houses = nums.length;
        int[] dp1 = new int[houses];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[houses];
        Arrays.fill(dp2, -1);

        // first and last are adjacent. so exclude them and consider max from either
        int[] arr1 = Arrays.copyOfRange(nums, 0, houses - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, houses);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        return Math.max(
                houseRobber(arr1, houses - 2, dp1), // exclude last house
                houseRobber(arr2, houses - 2, dp2) // exclude first house
        );
    }

    private int houseRobber(int[] money, int index, int[] dp) {
        if (index == 0) {
            return money[index];
        }

        if (index < 0) {
            return 0;//Math.max(money[0], money[1]);
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // current money + money of total till previous house robbed (adj cant be robbed so index - 2)
        int robCurrent = money[index] + houseRobber(money, index - 2, dp);

        // skip current house, consider money till previous house robbed. ie adjacent house
        int skippedCurrent = houseRobber(money, index - 1, dp);

        // store the max of the scenario: current robbed or adj hourse robbed
        dp[index] = Math.max(robCurrent, skippedCurrent);
        return dp[index];
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,9};

        //Create an instance of Solution class
        HouseRobber sol = new HouseRobber();

        System.out.println(sol.houseRobber(arr));
    }
}
