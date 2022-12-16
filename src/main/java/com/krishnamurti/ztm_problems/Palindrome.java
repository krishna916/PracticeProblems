package com.krishnamurti.ztm_problems;

public class Palindrome {

    public static boolean isValidPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int leftPointer, rightPointer = 0;

        int initialPointer = (s.length() / 2); // not adding + 1 as array is 0-indexed
        if (s.length() % 2 == 1) {
            leftPointer = initialPointer;
            rightPointer = initialPointer;
        } else {
            leftPointer = initialPointer - 1;
            rightPointer = initialPointer;
        }

        char[] sArr = s.toCharArray();
        while(leftPointer >= 0 && rightPointer < s.length() ) {
            char left = sArr[leftPointer];
            char right = sArr[rightPointer];
            if(left != right) {
                return false;
            }
            leftPointer--;
            rightPointer++;
        }
        return true;
    }

    public static boolean isValidSubPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        char[] sArr = s.toCharArray();

        while (leftPointer <= rightPointer) {
            if(sArr[leftPointer] != sArr[rightPointer]) {
                return isValidSubPalindrome(sArr, leftPointer + 1, rightPointer) || isValidSubPalindrome(sArr, leftPointer, rightPointer - 1);
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    private static boolean isValidSubPalindrome(char[] sArr, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            if(sArr[leftPointer] != sArr[rightPointer]) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
