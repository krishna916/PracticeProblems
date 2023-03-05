package com.krishnamurti.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumRemoveValidParenthesis {

    public static String minRemoveToMakeValid(String s) {
        char[] sArr = s.toCharArray();
        Deque<Integer> brac = new LinkedList<>();
        for(int i =0 ; i < sArr.length; i++) {
            char r = sArr[i];
            if (r == '(') {
                brac.push(i);
            } else if (r == ')') {
                if ( !brac.isEmpty() ) {
                    brac.pop();
                } else {
                    sArr[i] = Character.MIN_VALUE;
                }
            }
        }
        int size = brac.size();
        if (!brac.isEmpty()) {
            for (int i =0 ; i < size; i++) {
                int index= brac.pop();
                sArr[index] = Character.MIN_VALUE;
            }
        }

        StringBuilder result = new StringBuilder("");
        for(char r: sArr) {
            if(r != Character.MIN_VALUE) {
                result.append(r);
            }
        }

        return result.toString();
    }
}
