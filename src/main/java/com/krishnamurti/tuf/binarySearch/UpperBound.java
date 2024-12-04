package com.krishnamurti.tuf.binarySearch;

public class UpperBound {
    public static int upperBound(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] <= x) {
                ans = nums[mid] <= x ? ans : mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3,5,8,15,19 };
        int result = upperBound(nums, 9);

        System.out.println(result);

    }
}
