package com.krishnamurti.gfg;

import java.util.HashSet;
import java.util.Set;

public class POTD {
    public static long totalTime(int n,int arr[],int time[])
    {
        int totalTime = 0;
        Set<Integer> picked = new HashSet<>();
        picked.add(arr[0]);
        for (int i = 2; i <= n; i++) {
            int c = arr[i-1];
            if(!picked.contains(c)) {
                totalTime++;
                picked.add(c);
            } else {
                // System.out.println(totalTime + "  " + time[arr[i-1]]);
                int t = time[c-1];
                totalTime += t ;
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int time[] = { 1, 2, 3, 4 };
        System.out.println(totalTime(4, arr, time));
    }
}
