package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepsToZeroTest {


    @Test
    void stepsToZeroTest() {
        Assertions.assertEquals(6, StepsToZero.stepsToZero(14));
    }

    @Test
    void stepsToZeroTest1() {
        Assertions.assertEquals(4, StepsToZero.stepsToZero(8));
    }

    @Test
    void stepsToZeroTest2() {
        Assertions.assertEquals(12, StepsToZero.stepsToZero(123));
    }

}
