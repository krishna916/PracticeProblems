package com.krishnamurti.leetcode;

public class KthLargestElement {


    private static void quickSort(int[] arr, int left, int right) {
       if(left < right) {
           int partitionIndex = partition(arr, left, right);
           quickSort(arr, left, partitionIndex -1);
           quickSort(arr, partitionIndex + 1, right );
       }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int  partitionIndex = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, partitionIndex, j);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int largestKthValue(int[] arr, int k) {
        int indexToFind = arr.length - k;
        quickSort(arr, 0, arr.length - 1);
        return arr[indexToFind];
    }

}
