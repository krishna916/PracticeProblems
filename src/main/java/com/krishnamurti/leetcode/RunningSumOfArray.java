package com.krishnamurti.leetcode;

/**
 *  <b><a href="https://leetcode.com/problems/running-sum-of-1d-array/">Problem Statement</a></b>
 */
public class RunningSumOfArray {

    /**
     * Time: <b>O(n)</b>
     * Space: <b>O(1)</b> // Input and output are not considered in calculation
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }

    /**
     * Time: <b>O(n)</b>
     * Space: <b>O(1)</b>
     * <br>Better approach as memory used is less as it in place
     * @param nums
     * @return
     */
    public static int[] runningSumInPlace(int[] nums) {
        for(int i=1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
