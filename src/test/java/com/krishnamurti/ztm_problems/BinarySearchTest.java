package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    int[] arr = new int[] {1,2,3,5,23,43, 55,223,543,544,766,2333};
    int[] arr1 = new int[] {1,2,3,3,3,5,5,6,6,6,6,7,7,7,7,8,9,9};

    @Test
    void searchTest() {
        Assertions.assertEquals(2, BinarySearch.search(arr, 3));
    }


    @Test
    void searchTest1() {
        Assertions.assertEquals(-1, BinarySearch.search(arr, 85));
    }

    @Test
    void searchTestRange2() {
        Assertions.assertArrayEquals(new int[]{2, 4}, BinarySearch.searchRange(arr1, 3));
    }

    @Test
    void searchTestRange3() {
        Assertions.assertArrayEquals(new int[]{0, 1}, BinarySearch.searchRange(new int[]{2, 2}, 2));
    }

    @Test
    void searchTestRange4() {
        Assertions.assertArrayEquals(new int[]{2, 4}, BinarySearch.searchRangeBinary(arr1, 3));
    }

    @Test
    void searchItTest2() {
        Assertions.assertEquals(7, BinarySearch.searchIt(arr, 223));
    }

    @Test
    void searchItTestRange2() {
        Assertions.assertEquals(7, BinarySearch.searchIt(arr, 223));
    }
}
