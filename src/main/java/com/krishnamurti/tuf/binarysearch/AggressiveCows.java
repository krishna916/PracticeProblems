package com.krishnamurti.tuf.binarysearch;

import java.util.Arrays;

// https://takeuforward.org/plus/data-structures-and-algorithm/binary-search/faqs/aggressive-cows
public class AggressiveCows {

    public static int aggressiveCows(int[] nums, int k) {

        Arrays.sort(nums);
        int left = 1; // minimum distance
        // max distance will be diff  of max and minimum dist in array
        int right = nums[nums.length - 1] - nums[0];
        int ans = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = left + (right - left)/2;
            boolean canBePlaced = canBePlaced(nums, k, mid);
            if (canBePlaced) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canBePlaced(int[] nums, int cows, int dist) {
        int cowsPlaced = 1;
        int lastPlaced = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastPlaced >= dist) {
                cowsPlaced++;
                lastPlaced = nums[i];
            }
            if (cowsPlaced == cows) {
                return true;
            }
        }
        return cowsPlaced >= cows;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 4, 7, 10, 9};
        int result = aggressiveCows(nums, 4);

        if (result == 3) {
            System.out.println("Passed");
        }

        System.out.println(result);

    }
}
