package com.krishnamurti.programmingTechniques;

import com.krishnamurti.DS.DSUtil.PopulateUtil;
import com.krishnamurti.DS.ListNode;

import java.util.Arrays;

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


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // sort left to mid
            mergeSort(arr, left, mid);

            // sort mid to right
            mergeSort(arr, mid + 1, right);

            // merge the sorted left and right sub-arrays.
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // build a temp array to avoid modifying the original array
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // while both the sub-array have values, merge them in sorted order
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // add any remaining values in the left sub-array to the result. (happens when right sub-array is finished in previous iteration)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // add any remaining values in the right sub-array to the result. (happens when left sub-array is finished in first iteration)
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static ListNode recursiveLinkedListReverse(ListNode node) {
        if (node == null || node.next == null) {
            return  node;
        }

        ListNode reversedNode = recursiveLinkedListReverse(node.next);
        node.next.next = node;
        node.next = null;

        return reversedNode;
    }

    public static ListNode mergeSortedList(ListNode A, ListNode B) {
        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }

        if (A.val < B.val) {
            A.next = mergeSortedList(A.next, B);
            return A;
        } else {
            B.next = mergeSortedList(A, B.next);
            return B;
        }
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

//        System.out.println(fibonacci(10));

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length - 1);
        System.out.println(Arrays.toString(intArray));

        //reverse linked list
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        PopulateUtil.printLinkedList(node1);

        ListNode reversed = recursiveLinkedListReverse(node1);

        PopulateUtil.printLinkedList(reversed);



        //merge sorted list
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(13);
        ListNode n4 = new ListNode(14);
        ListNode n5 = new ListNode(550);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        ListNode n_n1 = new ListNode(2);
        ListNode n_n2 = new ListNode(15);
        ListNode n_n3 = new ListNode(130);
        ListNode n_n4 = new ListNode(200);
        ListNode n_n5 = new ListNode(350);

        n_n1.next = n_n2;
        n_n2.next = n_n3;
        n_n3.next = n_n4;
        n_n4.next = n_n5;


        PopulateUtil.printLinkedList(mergeSortedList(n1, n_n1));
    }
}
