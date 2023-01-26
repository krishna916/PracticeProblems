package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumRemoveValidParenthesisTest {

    @Test
    void minRemoveToMakeValidTest() {
        String s = "lee(t(c)o)de)";
        String result = MinimumRemoveValidParenthesis.minRemoveToMakeValid(s);


        Assertions.assertTrue(result.equals("lee(t(c)o)de") || result.equals("lee(t(co)de)") || result.equals("lee(t(c)ode)"));
    }

    @Test
    void minRemoveToMakeValidTest1() {
        String s = "a)b(c)d";
        String result = MinimumRemoveValidParenthesis.minRemoveToMakeValid(s);
        Assertions.assertEquals("ab(c)d", result);
    }

    @Test
    void minRemoveToMakeValidTest2() {
        String s = "))((";
        String result = MinimumRemoveValidParenthesis.minRemoveToMakeValid(s);
        Assertions.assertEquals("", result);
    }
}
