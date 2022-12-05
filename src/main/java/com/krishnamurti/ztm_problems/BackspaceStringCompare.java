package com.krishnamurti.ztm_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> sStack = new ArrayDeque<>();
        Deque<Character> tStack = new ArrayDeque<>() ;
        fillStack(s, sStack);
        fillStack(t, tStack);

        return sStack.toString().equals(tStack.toString());
    }

    private static void fillStack(String s, Deque<Character> sStack) {
        int slength = s.length();
        for(int i = 0; i < slength; i++) {
            char currentChar = s.charAt(i);
            if (currentChar =='#' && !sStack.isEmpty()) {
                sStack.pollLast();
            } else if(currentChar != '#') {
                sStack.add(currentChar);
            }
        }
    }
}
