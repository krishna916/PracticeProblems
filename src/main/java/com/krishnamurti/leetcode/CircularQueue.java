package com.krishnamurti.leetcode;

import java.util.Arrays;

class CircularQueue {
    int[] circularQueue;
    int length = -1;
    int front = 0;
    int rear = -1;

    public CircularQueue(int k) {
        circularQueue = new int[k];
       // Arrays.fill(circularQueue, -1);
        length = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (rear == circularQueue.length - 1) {
            rear = 0;
            circularQueue[rear] = value;
        } else {
            circularQueue[++rear] = value;
        }
        length++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        circularQueue[front] = -1;
        front = front == circularQueue.length - 1 ? 0 : front + 1;
        length--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return circularQueue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return circularQueue[rear];
    }

    public boolean isEmpty() {
//        for (int q: circularQueue) {
//            if (q != -1) {
//                return false;
//            }
//        }
//        return true;
        return length == 0;
    }

    public boolean isFull() {
        return length == circularQueue.length;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(6);
        System.out.println(q.enQueue(6));
        System.out.println(q.Rear());
        System.out.println(q.Rear());
        System.out.println(q.deQueue());
        System.out.println(q.enQueue(5));
        System.out.println(q.Rear());
        System.out.println(q.deQueue());
        System.out.println(q.Front());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
