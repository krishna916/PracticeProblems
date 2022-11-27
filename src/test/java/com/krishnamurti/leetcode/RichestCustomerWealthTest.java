package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RichestCustomerWealthTest {

    @Test
    public void testSuccess() {
        int[][] accounts = {{1,2,3},{3,2,1}};
        Assertions.assertEquals(6, RichestCustomerWealth.maximumWealth(accounts));
    }

    @Test
    public void testSuccess1() {
        int[][] accounts = {{1,5},{7,3},{3,5}};
        Assertions.assertEquals(10, RichestCustomerWealth.maximumWealth(accounts));
    }

    @Test
    public void testSuccess2() {
        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
        Assertions.assertEquals(17, RichestCustomerWealth.maximumWealth(accounts));
    }
}
