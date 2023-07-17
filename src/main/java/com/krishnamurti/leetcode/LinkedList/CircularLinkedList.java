package com.krishnamurti.leetcode.LinkedList;

import com.krishnamurti.DS.ListNode;

// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
public class CircularLinkedList {

    public static ListNode insert(ListNode head, int insertVal) {
        ListNode newNode = new ListNode(insertVal);


        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        if (head.next == null) {
            newNode.next = head;
            return head;
        }


        ListNode prev = head;
        ListNode current = head.next;
        boolean toInsert = false;
        do {
            // case 1: insert between the sorted list
            if (prev.val < insertVal && current.val >= insertVal) {
                toInsert = true;
            } // case 2: insert at end or start of the list
            else if (prev.val > current.val) {
                // insert val is either greater than the last node or smaller than the first node
                if (insertVal >= prev.val || insertVal <= current.val) {
                    toInsert = true;
                }
            }

            if (toInsert) {
                prev.next = newNode;
                newNode.next = current;
                return head;
            }

            prev = current;
            current = current.next;
        } while (prev != head);

        // case 3: where all the nodes in the list have same value
        prev.next = newNode;
        newNode.next = current; // current here is head

        return head;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(5);

        node.next = node1;
        node1.next = node2;
        node2.next = node;
//        node3.next = node;


//        ListNode node = new ListNode(1);
//        node.next = node;
        insert(node, 0);
    }
}
