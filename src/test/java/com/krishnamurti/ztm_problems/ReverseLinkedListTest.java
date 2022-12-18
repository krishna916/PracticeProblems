package com.krishnamurti.ztm_problems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnamurti.DS.DSUtil.PopulateUtil;
import com.krishnamurti.DS.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {

    @Test
    void testReverseLinkedList() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 1,2,4,5,6,6 }).head;
        ListNode expected = PopulateUtil.populateLinkedList(new int[] {6,6,5,4,2,1} ).head;
        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(ReverseLinkedList.reverseList(node)));
    }

    @Test
    void testReverseLinkedLis1() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 1,2,3,4,5,6,7,8 }).head;
        ListNode expected = PopulateUtil.populateLinkedList(new int[] {1,2,6,5,4,3,7,8} ).head;
        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(ReverseLinkedList.reverseList(node, 3, 6)));
    }

    @Test
    void testReverseLinkedList1() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 1,2,3,4,5,6,7,8 }).head;
        ListNode expected = PopulateUtil.populateLinkedList(new int[] {8,7,6,5,4,3,2,1} ).head;
        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(ReverseLinkedList.reverseList(node, 1, 8)));
    }

    @Test
    void testReverseLinkedLis2() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 5}).head;
        ListNode expected = PopulateUtil.populateLinkedList(new int[] {5} ).head;
        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(ReverseLinkedList.reverseList(node, 1, 1)));
    }

    @Test
    void testReverseLinkedLis3() throws JsonProcessingException {
        ListNode node = PopulateUtil.populateLinkedList(new int[] { 5, 7}).head;
        ListNode expected = PopulateUtil.populateLinkedList(new int[] {7, 5} ).head;
        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(ReverseLinkedList.reverseList(node, 1, 2)));
    }
}
