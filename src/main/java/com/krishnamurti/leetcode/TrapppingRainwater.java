package com.krishnamurti.leetcode;

/**
 *  <b><a href="https://leetcode.com/problems/trapping-rain-water/" >Problem Statement</a></b>
 */
public class TrapppingRainwater {


    public static int trappedWaterOptimal(int[] height) {
        int trappedWater = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int pointer1 = 0;
        int pointer2 = height.length - 1;

        while (pointer1 != pointer2) {
            if(height[pointer1] <= height[pointer2]) {
                if (maxLeft <= height[pointer1]) {
                    maxLeft = height[pointer1];
                } else {
                    trappedWater = trappedWater + (maxLeft - height[pointer1]);
                }
                pointer1++;
            } else {
                if(maxRight <= height[pointer2]) {
                    maxRight = height[pointer2];
                } else {
                    trappedWater = trappedWater + (maxRight - height[pointer2]);
                }
                pointer2--;
            }
        }
        return trappedWater;
    }


    public static int trappedWater(int[] height) {
        int trappedWater = 0;

        // water at current level: Min(maxLeft, maxRight) - currentHeight

        for (int i = 0; i < height.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            int pointer1 = i; // loop left starting from current index
            int pointer2 = i; // loop right starti+ng from current index

            while(pointer1 > 0 ) {
                pointer1--;
                if(maxLeft <= height[pointer1]) {
                    maxLeft = height[pointer1];
                }
            }

            while(pointer2 < height.length - 1) {
                pointer2++;
                if(maxRight <= height[pointer2]) {
                    maxRight = height[pointer2];
                }
            }
            int waterInCurrentIndex = Math.min(maxLeft, maxRight) - height[i];
            trappedWater += Math.max(waterInCurrentIndex, 0);

        }
        return trappedWater;
    }

}
