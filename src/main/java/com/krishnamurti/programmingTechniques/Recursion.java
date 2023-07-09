package com.krishnamurti.programmingTechniques;

/**
 *  Set of problems solved using recursion.
 *  From the youtube channel of Freecodecamp.
 */
public class Recursion {

    public static String stringReverse(String input) {
        // base case
        if (input.equals("")) {
            return "";
        }

        // smallest work for every iteration
        return stringReverse(input.substring(1)) + input.charAt(0);
    }

    public static String decimalToBinary(int decimal, String result) {
        // base case
        if (decimal == 0) {
            return result;
        }

        result = decimal % 2 + result;
        return decimalToBinary(decimal / 2 , result);
    }


    public static void main(String[] args) {

        // String reverse
        System.out.println(stringReverse("hello"));

        // decimalToBinary

        System.out.println(decimalToBinary(233, ""));

    }
}
