package com.krishnamurti.codestudio;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static int[] getFrequencies(int []v) {
        // Write Your Code Here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : v) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] ans = new int[2];
        for (int k : map.keySet())
        {
            int va = map.get(k);
            if (min > va) {
                min = va;
                ans[0] = k;
            }
            if (max < va) {
                max = va;
                ans[1] = k;
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] t = {1, 2, 3, 1, 1, 4};
        System.out.println(Arrays.toString(getFrequencies(t)));
    }
}
