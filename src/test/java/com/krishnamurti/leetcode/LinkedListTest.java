package com.krishnamurti.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class LinkedListTest {


    @Test
    void addTwoNumbersTest() throws JsonProcessingException {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next= node2;
        node2.next = node3;

        ListNode node12 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node32 = new ListNode(4);
        node12.next= node22;
        node22.next = node32;

        ListNode result = LinkedListAddTwoNumbers.addTwoNumbers(node1, node12);
        ObjectMapper mapper = new ObjectMapper();
//        System.out.println(mapper.writeValueAsString(result));

    }
}
