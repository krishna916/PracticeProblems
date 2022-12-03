package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListMiddleTest {

    @Test
    public void test() {
        {
            int[] arr = new int[]{1,2,3,4,5,6};
            ListNode node = null;
            ListNode tail = null;
            for(int e: arr) {
                ListNode n =  new ListNode(e);
                if(node == null) {
                    node = n;
                    tail = n;
                } else {
                    tail.next = n;
                    tail = tail.next;
                }
            }

            ListNode result = MiddleOfLinkedList.middleNode(node);
            System.out.print(" middle -> ");
            while(result != null) {
                System.out.print(result.val + " -> ");
                result = result.next;
            }
            System.out.print(" null ");
        }
    }

    @Test
    public void test2() {
        {
            int[] arr = new int[]{1,2,3,4,5};
            ListNode node = null;
            ListNode tail = null;
            for(int e: arr) {
                ListNode n =  new ListNode(e);
                if(node == null) {
                    node = n;
                    tail = n;
                } else {
                    tail.next = n;
                    tail = tail.next;
                }
            }

            ListNode result = MiddleOfLinkedList.middleNode(node);
            System.out.print(" middle -> ");
            while(result != null) {
                System.out.print(result.val + " -> ");
                result = result.next;
            }
            System.out.print(" null ");
        }
    }
}
