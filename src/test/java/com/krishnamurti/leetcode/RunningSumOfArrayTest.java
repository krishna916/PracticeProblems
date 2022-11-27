package com.krishnamurti.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RunningSumOfArrayTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSuccess() throws JsonProcessingException {
        int[] a = new int[] {1,2,3,4};
        int[] result = RunningSumOfArray.runningSum(a);
        Assertions.assertArrayEquals(new int[] {1,3,6,10}, result);
     }

    @Test
    public void testSuccess1() {
        int[] a = new int[] {1,1,1,1,1};
        int[] result = RunningSumOfArray.runningSum(a);
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5}, result);
    }

    @Test
    public void testSuccess2() {
        int[] a = new int[] {3,1,2,10,1};
        int[] result = RunningSumOfArray.runningSum(a);
        Assertions.assertArrayEquals(new int[] {3,4,6,16,17}, result);
    }

    @Test
    public void testSuccessInPlace() throws JsonProcessingException {
        int[] a = new int[] {1,2,3,4};
        int[] result = RunningSumOfArray.runningSumInPlace(a);
        Assertions.assertArrayEquals(new int[] {1,3,6,10}, result);
    }

    @Test
    public void testSuccess1InPlace() {
        int[] a = new int[] {1,1,1,1,1};
        int[] result = RunningSumOfArray.runningSumInPlace(a);
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5}, result);
    }

    @Test
    public void testSuccess2InPlace() {
        int[] a = new int[] {3,1,2,10,1};
        int[] result = RunningSumOfArray.runningSumInPlace(a);
        Assertions.assertArrayEquals(new int[] {3,4,6,16,17}, result);
    }
}
