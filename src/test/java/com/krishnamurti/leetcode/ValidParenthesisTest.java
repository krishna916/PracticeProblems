package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidParenthesisTest {

    @Test
    void validParenthesisTest1() {
        String s= "";
        Assertions.assertTrue(ValidParenthesis.isValid(s));
    }

    @Test
    void validParenthesisTest2() {
        String s= "{[()]}";
        Assertions.assertTrue(ValidParenthesis.isValid(s));
    }

    @Test
    void validParenthesisTest3() {
        String s= "[{()[";
        Assertions.assertFalse(ValidParenthesis.isValid(s));
    }

}
