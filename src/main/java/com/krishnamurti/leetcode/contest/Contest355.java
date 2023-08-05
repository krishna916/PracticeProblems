package com.krishnamurti.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class Contest355 {

    private static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        String sep = String.valueOf(separator);
        for (String word: words) {

            String[] sArr = word.split(sep);
            for(String s: sArr) {
                String ans = s.trim();
                if(!ans.equals("")) {
                    result.add(ans);
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        List<String> strings = List.of("one.two.three","four.five","six");
        System.out.println(splitWordsBySeparator(strings, '.'));
    }
}
