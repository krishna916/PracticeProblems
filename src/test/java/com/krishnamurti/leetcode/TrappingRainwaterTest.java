package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrappingRainwaterTest {

    @Test
    void trapRainwaterTest() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assertions.assertEquals(6, TrapppingRainwater.trappedWater(height));
    }

    @Test
    void trapRainwaterTest1() {
        int[] height = new int[]{4,2,0,3,2,5};
        Assertions.assertEquals(9, TrapppingRainwater.trappedWater(height));
    }


    @Test
    void trapRainwaterOPTest() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assertions.assertEquals(6, TrapppingRainwater.trappedWaterOptimal(height));
    }

    @Test
    void trapRainwaterOpTest1() {
        int[] height = new int[]{4,2,0,3,2,5};
        Assertions.assertEquals(9, TrapppingRainwater.trappedWaterOptimal(height));
    }
}
