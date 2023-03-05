package com.krishnamurti.hackerrank;

import java.util.List;

public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        if(arr == null || arr.isEmpty())
            return;

        Long sum = 0l;

        for (Integer a: arr) {
            sum += a;
        }

        Long minSum = sum;
        Long maxSum = Long.valueOf(arr.get(0));

        for(Integer a: arr) {
            Long sum4 = sum - a;
            if (sum4 > maxSum) {
                maxSum = sum4;
            }

            if (sum4 < minSum) {
                minSum = sum4;
            }
        }

        System.out.print(minSum + " " + maxSum);

    }

    public static void main(String[] args) {
        miniMaxSum(List.of(1, 2, 3, 4, 5));
    }


}
