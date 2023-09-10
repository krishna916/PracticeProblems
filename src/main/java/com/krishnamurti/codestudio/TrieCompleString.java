package com.krishnamurti.codestudio;

import java.util.HashMap;
import java.util.Map;

class Trie {
//    private Trie[] node = new Trie[26];
    private Map<Character, Trie> node = new HashMap<>();
    private boolean isWord = false;

    public Trie() {}

    public boolean contains(char c) {
        return node.containsKey(c);
    }

    public void put(char c, Trie node) {
        this.node.put(c, node);
    }

    public Trie get(char c) {
        return node.get(c);
    }

    public void setWord() {
        this.isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }
}


public class TrieCompleString {
    static Trie root = new Trie();

    public static String completeString(int n, String[] a) {
        // Write your code here.


        // insert all words in trie
        for (int i = 0; i < n; i++) {
            String s = a[i];
            Trie current = root;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!current.contains(c)) {
                    current.put(c, new Trie());
                }
                current = current.get(c);
            }
            current.setWord();
        }


        String ans = "";

        // check string with max prefix;
        for (int i = 0; i < n; i++) {
            String s = a[i];
            Trie current = root;
            boolean isPrefix = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (current.contains(c)) {
                    current = current.get(c);
                    if (!current.isWord()) {
                        isPrefix = false;
                        break;
                    }

                } else {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                if (ans.length() < s.length() ) {
                    ans = s;
                } else if (ans.length() == s.length() && s.compareTo(ans) < 0) {
                    ans = s;
                }
            }

        }

        return ans.length() != 0 ? ans : "None";
    }

    public static void main(String[] args) {
//        String[] s = {"n", "ni", "nin", "ninj", "ninja", "ninga"};

        String[] s = {"n", "l", "i", "um", "ar", "xcfyc" };
        String ans = completeString(6, s);
        System.out.println(ans);
    }
}
