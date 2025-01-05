package com.krishnamurti.tuf.binarysearch;

//https://takeuforward.org/plus/data-structures-and-algorithm/binary-search/faqs/book-allocation-problem
public class BookAllocation {
    public static int findPages(int[] nums, int m) {
        if (m > nums.length) {
            return -1;
        }
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num: nums) {
            left = Math.max (left, num);
            right += num;
        }
        while (left <= right) {
            int pages = left + (right - left)/2;
            int noOfStudents = students (nums, pages);
            if (noOfStudents > m) {
                left = pages + 1;
            } else {
                right = pages - 1;
            }
        }
        return  left;
    }
    private static int students(int[] books, int pages) {
        int students = 1;
        int currentPages  = 0;
        for (int i = 0; i < books.length; i++) {
            if (currentPages + books[i] <= pages) {
                currentPages += books[i];
            } else {
                students++;
                currentPages = books[i];
            }
        }
        return students;
    }

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int result = findPages(books, 2);

        System.out.println("expected: 113, actual: " + result);
    }
}
