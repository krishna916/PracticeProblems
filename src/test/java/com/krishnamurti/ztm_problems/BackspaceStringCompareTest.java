package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BackspaceStringCompareTest {

    @Test
    void backSpaceStringCompareTest() {
        String s = "ab#c", t = "ad#c";
        Assertions.assertTrue(BackspaceStringCompare.backspaceCompare(s, t));
    }

    @Test
    void backSpaceStringCompareTest1() {
        String s = "y#fo##f", t = "y#f#o##f";
        Assertions.assertTrue(BackspaceStringCompare.backspaceCompare(s, t));
    }

    @Test
    void backSpaceStringCompareTest11() {
        String s = "ab#c", t = "ad#c";
        Assertions.assertTrue(BackspaceStringCompare.backSpaceCompareOptimal(s, t));
    }

    @Test
    void backSpaceStringCompareTest12() {
        String s = "y#fo##f", t = "y#f#o##f";
        Assertions.assertTrue(BackspaceStringCompare.backSpaceCompareOptimal(s, t));
    }
}
