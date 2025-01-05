package com.krishnamurti.tuf.greedy;

import com.krishnamurti.Util;

import java.util.Arrays;

// https://takeuforward.org/plus/data-structures-and-algorithm/greedy-algorithms/scheduling-and-interval-problems/minimum-number-of-platforms-required-for-a-railway
public class MaxRailwayPlatform {
    public static int findPlatform(int[] arrival, int[] departure) {
        //your code goes here
        if (arrival.length == 0) {
            return 0;
        }
        Arrays.sort(departure);
        int platformInUse = 1;
        int maxPlatFormInUse = 1;

        int a = 1;
        int d = 0;

        while (a < arrival.length) {
            if (arrival[a] <= departure[d]) {
                platformInUse++;
                a++;
            } else {
                platformInUse--;
                d++;

            }
            maxPlatFormInUse = Math.max(maxPlatFormInUse, platformInUse);
        }
        return maxPlatFormInUse;
    }

    public static void main(String[] args) {

        int[] arrival = {900, 1100, 1235};
        int[] departure = {1000, 1200, 1240};

        System.out.println(findPlatform(arrival, departure));


    }
}
