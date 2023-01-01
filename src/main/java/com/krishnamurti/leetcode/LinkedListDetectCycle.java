package com.krishnamurti.leetcode;

import com.krishnamurti.DS.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListDetectCycle
{
    public static ListNode detectCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> seenNodes = new HashSet<>();
        while(!seenNodes.contains(current)) {
            if(current .next == null) {
                return null;
            }
            seenNodes.add(current);
            current = current.next;
        }
        return current;
    }

    public static ListNode turlteHareDetection(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode turtle = head;
        ListNode hare = head;
        do {
            if( hare.next == null || hare.next.next ==null) {
                return null;
            }
            hare = hare.next.next;

            if (turtle.next == null) {
                return null;
            }
            turtle = turtle.next;
            if(turtle.equals(hare)) {
                break;
            }
        } while (!turtle.equals(hare));

        ListNode current = head;
        while (!current.equals(turtle)) {

            current = current.next;
            turtle = turtle.next;
        }
        return current;
    }
 }
