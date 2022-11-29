package com.krishnamurti.ztm_problems;

/**
 *  <b><a href="https://leetcode.com/problems/container-with-most-water/>Problem Statement</a></b>
 */
public class ContainerWithMostWater {

    public static int maxAreaBruteForce(int[] height) {
        int max = 0;
        for(int i =0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
                max = max >= area ? max : area;
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int pointer1 = 0;
        int pointer2 = height.length - 1;
        while(pointer1 < pointer2) {
            int h = Math.min(height[pointer1], height[pointer2]);
            int w = pointer2 - pointer1;
            int area = h * w;
            maxArea = Math.max(maxArea, area);
            if(height[pointer1] <= height[pointer2]) {
                pointer1++;
            } else {
                pointer2--;
            }
        }
        return maxArea;
    }
}
