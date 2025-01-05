package com.krishnamurti.tuf.greedy;

import com.krishnamurti.Util;

import java.util.Arrays;
import java.util.Comparator;

// https://takeuforward.org/plus/data-structures-and-algorithm/greedy-algorithms/scheduling-and-interval-problems/non-overlapping-intervals
public class RemoveOverlappingIntervals {
    public static  int MaximumNonOverlappingIntervals(int[][] intervals) {
        //your code goes here
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));

        int removed = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prev <= intervals[i][0]) {
                prev = intervals[i][1];
            } else {
                removed++;
            }
        }

        return removed;
    }

    public static void main(String[] args) {
        String s = "[ [1, 2] , [2, 3] , [3, 4] ,[1, 3] ]";
        Util.convertToJavaArray(s);
        int[][] arr = new int[][] { {1, 2} , {2, 3} , {3, 4} ,{1, 3} };
        System.out.println(MaximumNonOverlappingIntervals(arr));
    }

}
