package com.krishnamurti.hackerearth.arrays;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotateArrays {
    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/krishnamurti/hackerearth/arrays/rotateArrayTC.txt")))) {
           int TC = Integer.parseInt(br.readLine());

           for (int i = 0 ; i < TC; i++) {
                String[] tcase = br.readLine().split(" ");
                int N = Integer.parseInt(tcase[0]);
                int K = Integer.parseInt(tcase[1]);

                String[] sInputArr = br.readLine().split(" ");
                int[] nums = new int[N];
                for (int j = 0; j< N; j++) {
                    nums[j] = Integer.parseInt(sInputArr[j]);
                }

                rotateArrays(nums, K);

               StringBuilder builder = new StringBuilder();
               for (int a: nums) {
                   builder.append(a).append(" ");
               }
               builder.deleteCharAt(builder.length() - 1);
               System.out.print(builder);
               System.out.println();
           }
        }
    }

    private static void rotateArrays(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - k - 1);
        reverseArray(nums, nums.length - k,nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
