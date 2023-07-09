package com.krishnamurti.leetcode.LinkedList;

public class DoublyLinkedList {

  public static void main(String[] args) {
    MyDoublyLinkedList linkedList = new MyDoublyLinkedList();
  // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
    // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
    
//    linkedList.addAtHead(7); // 7
//    linkedList.addAtHead(2); // 2 -> 7
//    linkedList.addAtHead(1);  //  1 -> 2 -> 7
//    linkedList.addAtIndex(3, 0);  // 1 -> 2 -> 7 -> 0
//    linkedList.deleteAtIndex(2);   // 1 -> 2 -> 0
//    linkedList.addAtHead(6);  // 6 -> 1 -> 2 -> 0
//    linkedList.addAtTail(4); // 6 -> 1 -> 2 -> 0 -> 4

    // System.out.println(linkedList.get(4));  // 4
    // linkedList.addAtHead(4); // 4-> 6 -> 1 -> 2 -> 0 -> 4
    // linkedList.addAtIndex(5, 0); // 4-> 6 -> 1 -> 2 -> 0 -> 0 -> 4
    // linkedList.addAtHead(6);  // 6->4-> 6 -> 1 -> 2 -> 0 -> 0 -> 4
    // //System.out.println(linkedList.get(1));

	// // ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
	// // [[],[0,10],[0,20],[1,30],[0]]

	// linkedList.addAtTail(10);
	// // linkedList.addAtIndex(0, 20);
	// // linkedList.addAtIndex(0, 30);
	// System.out.println(linkedList.get(0));


//      ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        [[],[1],[3],[1,2],[1],[1],[1]]
//      linkedList.addAtHead(1); // 1
//      linkedList.addAtTail(3); // 1 -> 3
//      linkedList.addAtIndex(1,2); //  1 -> 2 -> 3
//
//      System.out.println(linkedList.get(1)); // 2
//
//      linkedList.deleteAtIndex(1); // 1 -> 3
//      System.out.println(linkedList.get(1)); // 3

//        ["MyLinkedList","addAtHead","deleteAtIndex"]
//        [[],[1],[0]]

//      linkedList.addAtHead(1); // 1
//      linkedList.deleteAtIndex(0);

//      ["MyLinkedList","addAtTail","get"]
//        [[],[1],[0]]

      linkedList.addAtTail(1);
      System.out.println(linkedList.get(0));

  }

  
}


class ListNode {
  public ListNode prev;
  public ListNode next;
  public int val;

  public ListNode(int val) {
      this.val = val;
  }

  public ListNode(int val, ListNode next, ListNode prev) {
      this.prev = prev;
      this.next = next;
      this.val = val;
  }
}

class MyDoublyLinkedList {
  private ListNode head;
  private ListNode tail;
  private int length;

  public MyDoublyLinkedList() {
      head = null;
      tail = null;
      length = 0;
  }
  
  public int get(int index) {
      if (index >= length) {
          return -1;
      }

      if (index == length - 1) {
          return tail.val;
      }

      int i = 0;
      ListNode current = head; 
      while (i <= index) {
          if (i == index) {
              return current.val;
          }
          current = current.next;
          i++;
      }
      return -1;
  }
  
  public void addAtHead(int val) {
      ListNode newHead = new ListNode(val, head, null);
      if (head != null) {
          head.prev = newHead;
      }
      head = newHead;
      if (length == 0) {
          tail = newHead;
      }
      length++;

  }
  
  public void addAtTail(int val) {
      ListNode newTail = new ListNode(val, null, tail);
      if (tail != null)
        tail.next = newTail;
      tail = newTail;
      if (length == 0) {
          head = tail;
      }
      length++;
  }
  
  public void addAtIndex(int index, int val) {
      if (index > length) {
          return;
      }

      if (index == 0) {
          addAtHead(val);
          return;
      }
      if (index == length) {
          addAtTail(val);
          return;
      }

      int i = 0;
      ListNode current = head;
      while (i <= index) {
          if (i == index) {
              ListNode newNode = new ListNode(val);
              ListNode prev = current.prev;
              
              prev.next = newNode;
              newNode.prev = prev;

              newNode.next = current;
              current.prev = newNode;
              length++;
              return;
          }
          current = current.next;
          i++;
      }

  }
  
  public void deleteAtIndex(int index) {
      if (index >= length) {
          return;
      }

      if (index == 0) {
          if (head.next != null) {
              head = head.next;
              head.prev = null;
          } else {
              head = null;
              tail = null;
          }
          length--;
          return;
      }

      if (index == length - 1) {
          if (tail.prev != null) {
              tail = tail.prev;
              tail.next = null;
          } else {
              tail = null;
              head = null;
          }

          length--;
          return;
      }
      int i = 0;
      ListNode current = head;
      while (i <= index) {
          if (i == index) {
              current.prev.next = current.next;
              current.next.prev = current.prev;
              current.next = null;
              current.prev = null;
              length--;
              return;
          }
          current = current.next;
          i++;
      }


  }
}

/**
* Your MyLinkedList object will be instantiated and called as such:
* MyLinkedList obj = new MyLinkedList();
* int param_1 = obj.get(index);
* obj.addAtHead(val);
* obj.addAtTail(val);
* obj.addAtIndex(index,val);
* obj.deleteAtIndex(index);
*/
