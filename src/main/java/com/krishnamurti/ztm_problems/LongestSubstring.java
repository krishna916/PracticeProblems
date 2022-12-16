package com.krishnamurti.ztm_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {


    // Sliding window technique
    public static int lengthOfLongestSubstringOptimal(String s) {
        int longest = 1;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        if (s.length() <= 1) {
            return s.length();
        }
        char[] sArr = s.toCharArray();
        int leftPointer = 0, rightPointer = 1;
        charIndexMap.put(sArr[leftPointer], leftPointer);
        while (rightPointer < s.length()) {
            char r = sArr[rightPointer];
            if (!charIndexMap.containsKey(r) || (charIndexMap.containsKey(r) && charIndexMap.get(r) < leftPointer)) {
                charIndexMap.put(r, rightPointer);
            } else if (charIndexMap.containsKey(r)) {
                int previousIndex = charIndexMap.get(r);
                charIndexMap.put(r, rightPointer);
                leftPointer = previousIndex + 1;

            }
            longest = Math.max(longest, (rightPointer - leftPointer + 1));
            rightPointer++;
        }
        return longest;
    }


    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int length = s.length();

        Set<Character> substring = new HashSet<>();
        for(int i = 0; i < length; i++) {
            substring.add(s.charAt(i));
            for (int j = i + 1; j < length; j++) {
                Character charc = s.charAt(j);
                if (substring.contains(charc)) {
                    break;
                } else {
                    substring.add(charc);
                }
            }
            int currentLength = substring.size();
            if(longest < currentLength) {
                longest = currentLength;
            }
            substring.clear();
        }

        return longest;
    }
}
