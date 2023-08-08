package com.krishnamurti.DS;

public class BinaryNode {
    public int val;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int val) {
        this.val = val;
    }

    public BinaryNode(int val, BinaryNode left, BinaryNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
