package com.krishnamurti.DS.DSUtil;

import com.krishnamurti.DS.ListNode;
import com.krishnamurti.DS.SinglyLinkedList;


public class PopulateUtil {

    public static SinglyLinkedList populateLinkedList(int [] arr) {
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
        return new SinglyLinkedList(node, tail, arr.length);
    }

}
