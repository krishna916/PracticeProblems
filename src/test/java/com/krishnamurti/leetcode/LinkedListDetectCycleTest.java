package com.krishnamurti.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnamurti.DS.DSUtil.PopulateUtil;
import com.krishnamurti.DS.ListNode;
import org.junit.jupiter.api.Test;

public class LinkedListDetectCycleTest {

    @Test
    void detectCycleTest() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 3,2,0,-4 }).head;
        ListNode current = node;
        ListNode tail = null;
        ListNode cycleStart = null;
        int index= 0;
        while (current != null) {
            if(index == 1) {
                cycleStart = current;
            }
            tail = current;
            index++;
            current = current.next;
        }

        tail.next = cycleStart;
        ListNode start = LinkedListDetectCycle.detectCycle(node);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(start.val);
    }


    @Test
    void detectCycleTest1() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 3,2,0,-4 }).head;
        ListNode current = node;
        ListNode tail = null;
        ListNode cycleStart = null;
        int index= 0;
        while (current != null) {
            if(index == 1) {
                cycleStart = current;
            }
            tail = current;
            index++;
            current = current.next;
        }

        tail.next = cycleStart;
        ListNode start = LinkedListDetectCycle.turlteHareDetection(node);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(start.val);
    }
}
