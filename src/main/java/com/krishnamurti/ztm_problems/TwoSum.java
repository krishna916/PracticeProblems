package com.krishnamurti.ztm_problems;

public class TwoSum {


    /**
    * Given an array of integers, return
    * the list of the two numbers that add up
    * to given target
    * <ul>
    *   <li>input 1 < arr < N</li>
    *   <li> No duplicates </li>
    *   <li> Only Pair to sum </li>
    * </ul>
    */
    public static int[] twoSumOptimal(int[] arr, int target) {
        return null;
    }

    public static int[] twoSumBruteForce(int[] arr, int target) {
        if (arr.length < 2) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
           int requiredValue = target - arr[i];
           for (int j = i+1 ; j < arr.length; j++) {
               if(requiredValue == arr[j]) {
                   return new int[] {i, j};
               }
           }
        }
        return null;
    }
}
