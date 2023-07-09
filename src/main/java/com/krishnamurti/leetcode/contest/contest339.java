package com.krishnamurti.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contest339 {

    public static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            numIndexMap.computeIfAbsent(nums[i], value -> new ArrayList<>()).add(nums[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: numIndexMap.entrySet()) {
            int k = entry.getKey();
            List<Integer> v = entry.getValue();
            for (int i = 0; i < v.size(); i++) {
                if (result.size()  <= i) {
                   List<Integer> arr = new ArrayList<>();
                   arr.add(k);
                   result.add(arr);
                } else {
                    result.get(i).add(k);
                }
            }
        }

        return result;
    }

    public static int longestBalancedSubstring(String s) {
        int maxLen = 0;             // variable to store the length of the longest balanced substring seen so far
        int countZeros = 0;         // variable to keep track of the number of zeroes in the current window
        int countOnes = 0;          // variable to keep track of the number of ones in the current window
        int left = 0;               // variable to keep track of the left endpoint of the current window

        for (int right = 0; right < s.length(); right++) {    // iterate through the string
            if (s.charAt(right) == '0') {   // if we encounter a zero
                countZeros++;               // increment the count of zeroes in the current window
            } else {                        // otherwise, we encounter a one
                countOnes++;                // increment the count of ones in the current window
            }

            while (countZeros < countOnes) {    // if the current window is unbalanced, we need to move the left endpoint
                if (s.charAt(left) == '0') {    // if the left endpoint is a zero
                    countZeros--;               // decrement the count of zeroes in the current window
                } else {                        // otherwise, the left endpoint is a one
                    countOnes--;                // decrement the count of ones in the current window
                }

                left++;                         // move the left endpoint to the right
            }

            if (countZeros == countOnes) {      // if the current window is balanced
                maxLen = Math.max(maxLen, right - left + 1);   // update the maximum length seen so far
            }
        }

        return maxLen;          // return the maximum length of a balanced substring
    }

    public static void main(String[] args) {
//        int[] arr = new int[] {1,3,4,1,2,3,1};
//        int[] arr1 = new int[] {1,2,3,4};
//        System.out.println(findMatrix(arr1));

        System.out.println(longestBalancedSubstring("01000111"));
    }

}
