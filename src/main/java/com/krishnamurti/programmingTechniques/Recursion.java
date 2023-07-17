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


    public static int recursiveSummation (int inputNumber) {
        // base case
        if (inputNumber <= 1) {
            return inputNumber;
        }
        // minimum logic
        return inputNumber + recursiveSummation(inputNumber - 1);
    }

    /**
     * recursive BinarySearch
     * @param arr array to be operated upon
     * @param left left index of current iteration
     * @param right right index of current iteration
     * @param x value to be searched
     * @return index of the value if found. -1 if not found.
     */
    public static int binarySearch(int[] arr, int left, int right, int x)  {
        // base case
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // base case: success case
        if (arr[mid] == x) {
            return mid;
        }

        if (x < arr[mid]) {
            return binarySearch(arr, left, mid - 1, x);
        }

        return binarySearch(arr, mid + 1, right, x);
    }

    public static long fibonacci(long n) {
        if (n == 0 || n == 1)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }



    public static void main(String[] args) {

        // String reverse
        System.out.println(stringReverse("hello"));

        // decimalToBinary
        System.out.println(decimalToBinary(233, ""));

        // recursive summation
        System.out.println(recursiveSummation(5));

        // recursive binarySearch
        int[] arr = new int[] { -1, 0, 4, 5, 6, 18, 45, 56, 89, 100 };
        System.out.println(binarySearch(arr, 0, arr.length -1, 100));
        System.out.println(binarySearch(arr, 0, arr.length -1, 99));

        System.out.println(fibonacci(10));
    }
}
