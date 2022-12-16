package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringTest {

    @Test
    void longestSubstringTest() {
        String s = "abcabcbb";
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    void longestSubstringTest1() {
        String s = "bbbbb";
        Assertions.assertEquals(1, LongestSubstring.lengthOfLongestSubstring(s));
    }


    @Test
    void longestSubstringTest2() {
        String s = "pwwkew";
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    void longestSubstringTest3() {
        String s = "xxzqi";
        Assertions.assertEquals(4, LongestSubstring.lengthOfLongestSubstring(s));
    }


    @Test
    void longestSubstringOptimalTest() {
        String s = "abcabcbb";
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstringOptimal(s));
    }

    @Test
    void longestSubstringOptimalTest1() {
        String s = "dvdf";
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstringOptimal(s));
    }


    @Test
    void longestSubstringOptimalTest2() {
        String s = "pwwkew";
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstringOptimal(s));
    }

    @Test
    void longestSubstringOptimalTest3() {
        String s = "xxzqi";
        Assertions.assertEquals(4, LongestSubstring.lengthOfLongestSubstringOptimal(s));
    }

}
