package com.krishnamurti.ztm_problems;

import com.krishnamurti.leetcode.KthLargestElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestTest {

    @Test
    void kthTest() {
        int[] arr = new int[] {3,345,23,213,534, 34345, 323};
        Assertions.assertEquals(534, KthLargestElement.largestKthValue(arr, 2));
    }
}
