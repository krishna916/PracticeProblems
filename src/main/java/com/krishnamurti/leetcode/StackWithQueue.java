package com.krishnamurti.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    Queue<Integer> queue;

    public StackWithQueue()
    {
        this.queue=new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x)
    {
        queue.offer(x);
        for(int i=0;i<queue.size()-1;i++)
        {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public int pop()
    {
        return queue.poll();
    }

    // Get the top element.
    public int top()
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty()
    {
        return queue.isEmpty();
    }



    public static void main(String[] args) {
        StackWithQueue s = new StackWithQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s.top());

        s.push(6);
        s.push(7);
    }
}
