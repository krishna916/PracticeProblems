package com.krishnamurti.leetcode.Trie;


class BitNode {
    private BitNode[] children = new BitNode[2];

    public boolean contains(int bit) {
        return children[bit] != null;
    }

    public void put(int bit, BitNode node) {
        children[bit] = node;
    }

    public BitNode get(int bit) {
        return children[bit];
    }
}

class Trie {
    private BitNode root;

    public Trie() {
        root = new BitNode();
    }

    public void insert(int num) {
        BitNode current = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!current.contains(bit)) {
                current.put(bit, new BitNode());
            }
            current = current.get(bit);
        }
    }

    public int getMax(int num) {
        BitNode current = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.contains(1-bit)) {
                maxNum = (1 << i) | maxNum;
                current = current.get(1-bit);
            } else {
                current = current.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxNum = 0;
        System.out.println("Test");
        Trie trie = new Trie();
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
            for (int j = 0; j <= i; j++) {
                maxNum = Math.max(maxNum, trie.getMax(nums[j]));
            }
        }
        return maxNum;
    }
}


public class MaxXORofNumbers {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,10,5,25,2,8};
        System.out.println(s.findMaximumXOR(arr));
    }
}
