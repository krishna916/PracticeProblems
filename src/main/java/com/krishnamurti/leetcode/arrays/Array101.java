package com.krishnamurti.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array101 {

    public static  boolean validMountainArray(int[] arr) {
        if (arr.length ==1) {
            return true;
        }

        if (arr.length > 1 && arr[1] < arr[0]) {
            return false;
        }

        boolean isIncreasing = true;
        int previous = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == previous) {
                return false;
            }

            if (arr[i] < previous) {
                if (isIncreasing) {
                    isIncreasing = false;
                }
            }else if (arr[i] > previous && !isIncreasing) {
                return false;
            }
            previous = arr[i];

        }

        return true;
    }

    public static int dominantIndex(int[] nums) {
        String max = "max";
        String m2 = "m2";
        Map<String, Integer[]> map = new HashMap<>();
        if(nums[0] > nums[1]) {
            map.put(max, new Integer[]{ nums[0], 0});
            map.put(m2, new Integer[]{nums[1], 1});
        } else {
            map.put(max, new Integer[]{nums[1], 1});
            map.put(m2, new Integer[]{nums[0], 0});
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > map.get(m2)[0]) {
                System.out.println(map);
                if (nums[i] > map.get(max)[0]) {
                    map.put(m2, map.get(max));
                    map.put(max, new Integer[]{nums[i], i});
                } else {
                    map.put(m2, new Integer[]{nums[i], i});
                }
            }
        }
        if (map.get(max)[0] >= map.get(m2)[0] * 2) {
            return map.get(max)[1];
        }
        return -1;
    }


    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }
        if (lastIndex == 0 && digits[lastIndex] == 9 ) {
            return new int[]{1, 0};
        }

        boolean addDigit = false;
        int convertZeroFrom = -1;
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                if (i==0) {
                    addDigit = true;
                }
                continue;
            } else {
                digits[i] = digits[i] + 1;
                convertZeroFrom = i+1;
                break;
            }
        }
        if (convertZeroFrom > 0) {
            for(int i = convertZeroFrom; i <= lastIndex; i++) {
                digits[i] = 0;
            }
        }


        if(!addDigit)
            return digits;

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;

        return newDigits;
    }

    public static void main(String[] args) {
//        System.out.println(validMountainArray(new int[] { 3,5,5 }));
//        System.out.println(dominantIndex(new int[]{1,2,3,4}));
        System.out.println(Arrays.toString(plusOne(new int[]{ 9, 9})));
    }
}
