package com.krishnamurti.ztm_problems;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TwoSumTest {


    @Test
    public void twoSumSuccessTest() {
        int[] arr = {1,3,7,9,2};
        int[] result = TwoSum.twoSumOptimal(arr, 11);

        assertArrayEquals(new int[]{3, 4}, result);
    }

    @Test
    public void twoSumNegativeTest() {
        int[] arr = {1,3,7,9,2};
        int[] result = TwoSum.twoSumOptimal(arr, 25);
        assertNull(result);
    }

    @Test
    public void twoSumNegativeTest2() {
        int[] arr = {};
        int[] result = TwoSum.twoSumOptimal(arr, 25);
        assertNull(result);
    }

    @Test
    public void twoSumNegativeTest3() {
        int[] arr = {5};
        int[] result = TwoSum.twoSumOptimal(arr, 5);
        assertNull(result);
    }

    @Test
    public void twoSumTest2() {
        int[] arr = {1,3};
        int[] result = TwoSum.twoSumOptimal(arr, 4);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void twoSumSuccessBruteTest() {
        int[] arr = {1,3,7,9,2};
        int[] result = TwoSum.twoSumBruteForce(arr, 11);
        assertArrayEquals(new int[]{3, 4}, result);
    }

    @Test
    public void twoSumNegativeBruteTest() {
        int[] arr = {1,3,7,9,2};
        int[] result = TwoSum.twoSumBruteForce(arr, 25);
        assertNull(result);
    }

    @Test
    public void twoSumNegativeBruteTest2() {
        int[] arr = {};
        int[] result = TwoSum.twoSumBruteForce(arr, 25);
        assertNull(result);
    }

    @Test
    public void twoSumNegativeBruteTest3() {
        int[] arr = {5};
        int[] result = TwoSum.twoSumBruteForce(arr, 5);
        assertNull(result);
    }

    @Test
    public void twoSumBruteTest2() {
        int[] arr = {1,3};
        int[] result = TwoSum.twoSumBruteForce(arr, 4);
        assertArrayEquals(new int[]{0, 1}, result);
    }

}
