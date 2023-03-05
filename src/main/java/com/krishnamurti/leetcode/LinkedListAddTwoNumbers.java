package com.krishnamurti.leetcode;

public class LinkedListAddTwoNumbers {

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int num1 = getNumber(l1);
            int num2 = getNumber(l2);

            int num3 = num1 + num2;

            int dec = 100;
            ListNode result = null;
            ListNode current = null;
            while (true) {
                boolean doBreak = dec == 1;
                int num = dec == 1 ? num3 : num3 % dec;
                dec = dec / 10;
                num3 = num3 / 10;
                if (result == null) {
                    result = new ListNode(num);
                    current = result;
                } else {
                    current.next = new ListNode(num);
                    current = current.next;
                }
                if (doBreak) {
                    break;
                }
            }

            return result;
        }

        private static int  getNumber(ListNode l1) {
            int dec = 1;
            int num1 = 0;
            if (l1 != null) {
                while(l1 != null) {
                    num1 = num1 + (l1.val * dec);
                    l1 = l1.next;
                    dec = dec * 10;
                }
            }
            return num1;
        }

}
