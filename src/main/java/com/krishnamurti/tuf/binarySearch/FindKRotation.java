package com.krishnamurti.tuf.binarySearch;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/plus/data-structures-and-algorithm/binary-search/logic-building/find-out-how-many-times-the-array-is-rotated
public class FindKRotation {
    public static int findKRotation(List<Integer> nums) {
        int left = 0, right = nums.size() - 1;
        int[] minIndex = {Integer.MAX_VALUE, -1};

        while (left <= right) {
            int mid = left + (right - left) /2;

            if (nums.get(left) <= nums.get(mid)) {
                if (nums.get(left) < minIndex[0]) {
                    minIndex[0] = nums.get(left);
                    minIndex[1] = left;
                }
                left = mid + 1;

            } else if (nums.get(mid) <= nums.get(right)) {
                if (nums.get(mid) < minIndex[0]) {
                    minIndex[0] = nums.get(mid);
                    minIndex[1] = mid;
                }
                right = mid - 1;
            }

        }

        return minIndex[1];
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 5, 6, 7, 0, 1, 2, 3);
        System.out.println(findKRotation(nums));
    }
}
