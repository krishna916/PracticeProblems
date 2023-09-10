package com.krishnamurti.leetcode.Trie;

import java.util.HashMap;
import java.util.Map;

class Node {
    private Map<Character, Node> children = new HashMap<>();
    private int values = 0;
    private boolean isWord = false;

    public Node(){}

    public boolean contains(char c) {
        return children.containsKey(c);
    }

    public void put(char c, Node node) {
        children.put(c, node);
    }

    public Node get(char c) {
        return children.get(c);
    }

    public void setValues(int v) {
        values += v;
    }

    public int getValues() {
        return values;
    }

    public void setWord() {
        isWord = true;
    }
}


 class MapSum {
    Map<String, Integer> keyValueMap;
    Node root;

    public MapSum() {
        root = new Node();
        keyValueMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        // incase the key already exists
        int delta = val - keyValueMap.getOrDefault(key, 0);
        Node current = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!current.contains(c)) {
                current.put(c, new Node());
            }
            current = current.get(c);
            current.setValues(delta);
        }
        current.setWord();
    }

    public int sum(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!current.contains(c)) {
                return 0;
            }
            current = current.get(c);
        }

        return current.getValues();
    }
}


public class MapSumPairs {
    public static void main(String[] args) {
        MapSum  sum = new MapSum();

        sum.insert("apple", 3);
        System.out.println(sum.sum("ap"));

        sum.insert("app", 2);
        System.out.println(sum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */