package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    @Test
    void bruteForceTest1() {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        Assertions.assertEquals(49, ContainerWithMostWater.maxAreaBruteForce(height));
    }

    @Test
    void bruteForceTest2() {
        int[] height = new int[] {1,1};
        Assertions.assertEquals(1, ContainerWithMostWater.maxAreaBruteForce(height));
    }

    @Test
    void bruteForceTest3() {
        int[] height = new int[] {1, 8, 6,2,9,4};
        Assertions.assertEquals(24, ContainerWithMostWater.maxAreaBruteForce(height));
    }

    @Test
    void twoTest1() {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        Assertions.assertEquals(49, ContainerWithMostWater.maxArea1(height));
    }

    @Test
    void bruteForceTest4() {
        int[] height = new int[] {2,3,4,5,18,17,6};
        Assertions.assertEquals(17, ContainerWithMostWater.maxAreaBruteForce(height));
    }

    @Test
    void twoTest2() {
        int[] height = new int[] {2,3,4,5,18,17,6};
        Assertions.assertEquals(17, ContainerWithMostWater.maxArea1(height));
    }
}
