package com.krishnamurti.ztm_problems;

import com.krishnamurti.DS.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while(current != null) {
            ListNode newNode = new ListNode();
            newNode.val = current.val;
            newNode.next = previous;
            previous = newNode;
            current = current.next;
        }
        return previous;
    }

    public static ListNode reverseList(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }

        int index = 1;
        ListNode root = null;
        ListNode tail = null;
        ListNode source = head;
        while ( (index == 1 && left != 1) || index < left) {
            if (root == null) {
                root = head;
                tail = head;
            } else {
                tail.next = new ListNode(source.val, source.next);
                tail = tail.next;
                if (index == (left - 1) ) {
                    tail.next = null;
                }
            }
            source = source.next;
            index++;
        }

        ListNode reverseHead = null;
        ListNode reverseTail = null;
        ListNode subTail = null;
        while (index <= right) {
            ListNode node = new ListNode(source.val);
            if(reverseTail == null) {
                reverseTail = node;
                subTail = reverseTail;
            } else {
                node.next = reverseTail;
                reverseTail = node;
                if(index == right) {
                    reverseHead = reverseTail;
                }
            }
            source = source.next;
            index++;
        }
        if(tail != null ){
            tail.next = reverseHead;
        } else {
            tail = reverseHead;
            root = reverseHead;
        }

        while (source != null) {
            if (subTail != null) {
                subTail.next = new ListNode(source.val, source.next);
                subTail = subTail.next;
            }
            source = source.next;
        }


        return root;
    }
}
