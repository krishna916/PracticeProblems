package com.krishnamurti.leetcode;

/**
 *  <b><a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/" >Problem Statement</a></b>
 */
public class StepsToZero {

    public static int stepsToZero(int num) {
        int steps = 0;
        while(num > 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            steps++;
         }
        return steps;
    }
}
