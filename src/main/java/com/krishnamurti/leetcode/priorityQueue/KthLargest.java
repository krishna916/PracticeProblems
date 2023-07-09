package com.krishnamurti.leetcode.priorityQueue;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k = -1;
    public KthLargest(int k, int[] nums) {
        this.k = k;
//        for (int i = 0; i < k; i++) {
//            heap.offer(nums[i]);
//        }
//
//        for (int i = k; i < nums.length; i++) {
//            if (nums[i] > heap.peek()) {
//                heap.poll();
//                heap.offer(nums[i]);
//            }
//        }
        int index = 0;
        while ( index < nums.length) {
            if (index < k) {
                heap.offer(nums[index]);
            } else {
                if (nums[index] > heap.peek()) {
                    heap.poll();
                    heap.offer(nums[index]);
                }
            }
            index++;
        }

    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
//        [[1,[]],[-3],[-2],[-4],[0],[4]]
        KthLargest k = new KthLargest(1, new int[] {});
        System.out.println(k.add(-3));
        System.out.println(k.add(-2));
        System.out.println(k.add(-4));
        System.out.println(k.add(0));
        System.out.println(k.add(4));
    }
}
