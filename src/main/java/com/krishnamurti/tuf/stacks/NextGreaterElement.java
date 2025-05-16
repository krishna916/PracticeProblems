package com.krishnamurti.tuf.stacks;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://takeuforward.org/plus/dsa/stack-and-queues/monotonic-stack/next-greater-element?tab=submissions
public class NextGreaterElement {

    // does not work when arr has duplicate elements
    public int[] nextLargerElement(int[] arr) {
        Map<Integer, Integer> numNextGreaterMap = new HashMap<>();

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                numNextGreaterMap.put(stack.pop(), arr[i]);
            }
            stack.push(arr[i]);
        }

        while(!stack.isEmpty()) {
            numNextGreaterMap.put(stack.pop(), -1);
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = numNextGreaterMap.get(arr[i]);
        }

        return result;
    }

    public int[] nextLargerElementHandleDuplicate(int[] arr) {
        int[] result = new int[arr.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int el = arr[i];

            while (!stack.isEmpty() && stack.peek() <= el) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(el);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {915,429,791,901,455,702,240,425,482,657,869,482,654,25,559};

        NextGreaterElement sol = new NextGreaterElement();

        int[] result = sol.nextLargerElementHandleDuplicate(arr);
        System.out.println(Arrays.toString(result));
    }
}
