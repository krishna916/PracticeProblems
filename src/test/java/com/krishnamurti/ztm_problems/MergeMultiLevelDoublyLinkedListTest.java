package com.krishnamurti.ztm_problems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krishnamurti.DS.DSUtil.PopulateUtil;
import com.krishnamurti.DS.ListNode;
import com.krishnamurti.DS.Node;
import org.junit.jupiter.api.Test;

public class MergeMultiLevelDoublyLinkedListTest {

    @Test
    void testFlatten() throws JsonProcessingException {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);
        Node node6 = new Node(6, node5);

        Node node7 = new Node(7, null);
        Node node8 = new Node(8, node7);
        Node node9 = new Node(9, node8);
        Node node10 = new Node(10, node9);

        Node node11 = new Node(11, null);
        Node node12 = new Node(12, node11);

        node3.child = node7;
        node8.child = node11;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        node11.next = node12;

        ListNode expected = PopulateUtil.populateLinkedList(new int[] {1,2,3,7,8,11,12,9,10,4,5,6}).head;
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(expected));
        System.out.println(mapper.writeValueAsString(MergeMultiLevelDoublyLinkedList.flatten(node1)));
    }


    @Test
    void test2() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        node1.val = 1;
        node2.val =2;
        node3.val = 3;

        node1.next = node2;
        node2.prev = node1;
        node2.next =node3;
        node3.prev = node2;


//        node1.child = node3;
        MergeMultiLevelDoublyLinkedList.flatten(node1);
    }


}
