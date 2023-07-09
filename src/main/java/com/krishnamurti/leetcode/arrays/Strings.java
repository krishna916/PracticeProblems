package com.krishnamurti.leetcode.arrays;

public class Strings {
    public static int strStr(String haystack, String needle) {

        haystack.charAt(2);

        if (needle.length() > haystack.length()) return -1;

        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();

        for (int i =0; i <hArray.length; i++) {
            if (hArray[i] == nArray[0]) {
                int index = i;
                boolean isStr = true;
                int outerIndex = i;
                for (int j = 1; j < nArray.length; j++) {


                    if (outerIndex == hArray.length - 1 || nArray[j] != hArray[++outerIndex]) {
                        isStr = false;
                        break;
                    }
                }
                if(isStr) return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "ppi"));
    }
}
