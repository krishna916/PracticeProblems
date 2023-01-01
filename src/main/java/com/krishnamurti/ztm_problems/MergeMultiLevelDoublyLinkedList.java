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


}
