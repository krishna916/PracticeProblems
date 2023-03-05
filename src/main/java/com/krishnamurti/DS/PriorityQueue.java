package com.krishnamurti.DS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {

    private Comparator<T> comparator;
    private List<T> heap;

    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
    }

    public int size() {
        return this.heap.size();
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    public T peek() {
        return this.heap.get(0);
    }

    // parent = floor((idx-1)/2)
    private int parentIndex(int index) {
        return (int)Math.floor((double) (index-1)/2);
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(int i, int j) {
        T temp = this.heap.get(i);
        this.heap.set(i, heap.get(j));
        this.heap.set(j, temp);
    }

    private boolean compare(int i, int j) {
        return comparator.compare(heap.get(i), heap.get(j)) > 0;
    }

    public int push(T element) {
        this.heap.add(element);
        this.shiftUp();
        return this.size();
    }

    private void shiftUp() {
        int nodeIdx = this.size() - 1;
        int parentIndex = this.parentIndex(nodeIdx);
        while (nodeIdx > 0 && this.compare(nodeIdx, parentIndex)) {
            this.swap(nodeIdx, parentIndex);
            nodeIdx = parentIndex;
            parentIndex = this.parentIndex(nodeIdx);
        }
    }

    public T pop() {
       if (this.size() > 1) {
           this.swap(this.heap.size() - 1, 0);
       }
       T element = this.heap.remove(this.size() - 1);
       this.shiftDown();
       return element;
    }

    private void shiftDown() {
        int nodeIdx = 0;
        int leftChild = this.leftChild(nodeIdx);
        int rightChild = this.rightChild(nodeIdx);
        while ( (leftChild < this.size() && this.compare(leftChild, nodeIdx)) ||
                (rightChild < this.size() && this.compare(rightChild, nodeIdx)) ) {
            int greaterChildIdx = rightChild < this.size() &&
                    this.compare(rightChild, leftChild) ? rightChild : leftChild;

            this.swap(greaterChildIdx, nodeIdx);
            nodeIdx = greaterChildIdx;
            leftChild = this.leftChild(nodeIdx);
            rightChild = this.rightChild(nodeIdx);
        }
    }

}
