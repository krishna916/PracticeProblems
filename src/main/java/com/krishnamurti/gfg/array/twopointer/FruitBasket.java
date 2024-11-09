package com.krishnamurti.gfg.array.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

    public static int totalFruits(Integer[] arr) {

        Map<Integer, Integer> numFreqMap = new HashMap<>();
        int maxLen = 0;
        int currLen = 0;
        int left = 0; int right = 0;

        while (right < arr.length) {
            if (right == 58) {
                System.out.println("here");
            }
            Integer n = arr[right];
            if (numFreqMap.containsKey(n)) {
                numFreqMap.put(n, numFreqMap.get(n) + 1);
            } else {
                numFreqMap.put(n, 1);
            }

            if (numFreqMap.size() < 3) {
                currLen++;

            } else {
                while (numFreqMap.size() > 2) {
                    Integer n1 = arr[left];
                    Integer n1Freq = numFreqMap.get(n1);
                    if (n1Freq == 1) {
                        numFreqMap.remove(n1);
                    } else {
                        numFreqMap.put(n1, --n1Freq);
                    }
                    left++;
                    currLen--;
                }
            }
            right++;
            maxLen = Math.max(right - left , maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String line ="62 56 24 25 2 52 22 48 2 24 39 1 47 3 25 59 29 9 48 63 12 44 46 60 54 16 28 58 59 26 9 6 21 11 59 63 3 19 52 25 34 9 65 10 33 48 21 61 29 3 50 62 9 36 16 9 40 42 24 53 64 23 23 50 25";
        String[] tokens = line.split(" ");

        // Create an ArrayList to store the integers
        ArrayList<Integer> array = new ArrayList<>();

        // Parse the tokens into integers and add to the array
        for (String token : tokens) {
            array.add(Integer.parseInt(token));
        }

        // Convert ArrayList to array
        Integer[] arr = new Integer[array.size()];
        array.toArray(arr);

        System.out.println(totalFruits(arr));
    }

}
