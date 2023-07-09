package com.krishnamurti.ztm_problems;

import com.krishnamurti.DS.Node;

import java.util.Map;

public class MergeMultiLevelDoublyLinkedList {

    public static Node flatten(Node head) {
       if(head == null) {
           return null;
       }

        Node current = head;
        Node child = null;
        Node result = null;
        Node resultHead = null;

        while(current != null) {
            Node node = new Node();
            node.val = current.val;
            node.prev = current.prev;
            if(result == null) {
                result = node;
                resultHead = node;
            } else {
                result.next = node;
                result = result.next;
            }
            if(current.child != null) {
                Node currentChildNode = current.child;
                Node childTail = current.child;
                while (currentChildNode != null) {
                    childTail = currentChildNode;
                    currentChildNode = currentChildNode.next;
                }

                Node parentNext = current.next;
                current.child.prev = result;
                current.next = current.child;
                childTail.next = parentNext;
                childTail.next.prev = childTail;
                current.child = null;
            }

            current = current.next;
        }

        return resultHead;
    }


    public static Node flatten2(Node head) {
        if (head == null || (head.next == null && head.child == null)) {
            return head;
        }

        Node current = head;

        while (current != null) {
            if (current.child != null) {
                Node child = current.child;
                current.child = null;
                child.prev = current;
                Node childTail = current.next;
                current.next = child;
                while (child.next != null) {
                    child = child.next;
                }
                if (childTail != null) {
                    child.next = childTail;
                    childTail.prev = child;     }
            }

            current = current.next;
        }
        return head;
    }


}
