package com.krishnamurti.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        if(s != null) {
            if("".equals(s))
                return true;

            Deque<Character> stack = new LinkedList<>();
            char[] sArr = s.toCharArray();
            for (char c : sArr) {
                if (stack.peekLast() == null) { //empty stack
                    stack.add(c);
                } else {
                    char topChar = stack.peekLast();
                    if (topChar == corresponsdingOpen(c)) {
                        stack.pollLast();
                    } else {
                        stack.add(c);
                    }
                }
            }

            return stack.size() == 0;

        }
        return false;
    }

    private static char corresponsdingOpen(char s) {
        if (s == ')') {
            return '(';
        } else if (s == '}') {
            return '{';
        } else if (s == ']') {
            return '[';
        } else {
            return 'n';
        }
    }
}
