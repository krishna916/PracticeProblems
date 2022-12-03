package com.krishnamurti.leetcode;



/**
 *  <b><a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem Statement</a></b>
 */
public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {

        int length = 0;
        ListNode currentNode = head;
        while(currentNode != null ) {
            currentNode = currentNode.next;
            length++;
        }
        int middleNodeIndex = Math.round(length / 2) + 1;
        currentNode = head;
        length = 1;
        while(currentNode != null) {
            if(length == middleNodeIndex) {
                return currentNode;
            }
            currentNode = currentNode.next;
            length++;
        }
        return null;
    }

}




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
