package com.krishnamurti.tuf.stacks;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    Map<Integer, Node> keyNodeMap;
    Map<Integer, DList> freqListMap;
    int cap;
    int minFreq;

    public LFUCache(int capacity) {
        cap = capacity;
        minFreq = 0;
        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    public void freqUpdateInList(Node node) {
        // first remove the Node from list and Map
        int key = node.key;
        keyNodeMap.remove(node.key);
        freqListMap.get(node.count).removeNode(node);

        // if the current has lowest freq update it
        if (node.count == minFreq && freqListMap.get(node.count).size == 0) {
            // if the current node has least frequency and the only node with that frequency
            // update the minFreq
            minFreq++;
        }

        DList nextHigherFreqList = new DList();

        if (freqListMap.containsKey(node.count +1) ) {
            nextHigherFreqList = freqListMap.get(node.count + 1);
        }

        node.count = node.count + 1;
        nextHigherFreqList.insertAtFront(node);

        freqListMap.put(node.count, nextHigherFreqList);
        keyNodeMap.put(node.key, node);
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            freqUpdateInList(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cap == 0) return;

        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.val = value;
            freqUpdateInList(node);
        } else {

            if (cap == keyNodeMap.size()) {
                DList minFreqList = freqListMap.get(minFreq);
                keyNodeMap.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
            }

            // new Node so update minFreq = 1;

            minFreq = 1;
            DList minFreqList = new DList();
            if (freqListMap.containsKey(minFreq)) {
                minFreqList = freqListMap.get(minFreq);
            }

            Node node = new Node(key, value);
            node.count = 1;
            minFreqList.insertAtFront(node);
            keyNodeMap.put(key, node);
            freqListMap.put(minFreq, minFreqList);
        }
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);

        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


    }
}

class DList {
    public int size;
    Node head;
    Node tail;

    public DList() {
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void insertAtFront(Node node) {
        Node nextNode = head.next;

        node.next = nextNode;
        head.next = node;
        node.prev = head;

        nextNode.prev = node;
        size++;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
        size--;
    }
}




class Node {
    int val;
    int key;
    int count;

    Node prev, next;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        count = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */