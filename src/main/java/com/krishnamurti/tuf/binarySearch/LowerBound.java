package com.krishnamurti.tuf.binarySearch;

public class LowerBound {
    public static int lowerBound(int[] nums, int x) {
        int ans = nums.length;
        int low = 0, high = ans - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] >= x) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -49049,12215,14963,74220,91021 };
        int result = lowerBound(nums, 89353);

        System.out.println(result);
    }

}
