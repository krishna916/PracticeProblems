package com.krishnamurti.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FizzBuzzTest {

    @Test
    public void fizzBuzzTest() {
        List<String> expectedResult = List.of("1","2","Fizz");
        Assertions.assertEquals(expectedResult, FizzBuzz.fizzBuzz(3));
    }

    @Test
    public void fizzBuzzTest1() {
        List<String> expectedResult = List.of("1","2","Fizz","4","Buzz");
        Assertions.assertEquals(expectedResult, FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void fizzBuzzTest2() {
        List<String> expectedResult = List.of("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz");
        Assertions.assertEquals(expectedResult, FizzBuzz.fizzBuzz(15));
    }
}
