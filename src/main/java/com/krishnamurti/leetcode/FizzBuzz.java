package com.krishnamurti.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  <b><a href="https://leetcode.com/problems/fizz-buzz/">Problem Statement</a></b>
 */
public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for(int i = 1; i <= n; i++ ) {
            if( i % 3 ==0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
