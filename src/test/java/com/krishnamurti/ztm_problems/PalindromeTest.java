package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    void isValidPalindromeTest() {
        String s = "A man, a plan, a canal: Panama";
        Assertions.assertTrue(Palindrome.isValidPalindrome(s));
    }

    @Test
    void isValidPalindromeTest1() {
        String s = "abccba";
        Assertions.assertTrue(Palindrome.isValidPalindrome(s));
    }

    @Test
    void isValidSubPalindromeTest() {
        String s = "abccdba";
        Assertions.assertTrue(Palindrome.isValidSubPalindrome(s));
    }
}
