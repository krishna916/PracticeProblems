package com.krishnamurti.leetcode.LinkedList;

public class LinkedList {
  
  public static void main(String[] args) {
    MyLinkedList linkedList = new MyLinkedList();
    // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
    // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
    
    // linkedList.addAtHead(7); // 7
    // linkedList.addAtHead(2); // 2 -> 7
    // linkedList.addAtHead(1);  //  1 -> 2 -> 7
    // linkedList.addAtIndex(3, 0);  // 1 -> 2 -> 7 -> 0
    // linkedList.deleteAtIndex(2);   // 1 -> 2 -> 0
    // linkedList.addAtHead(6);  // 6 -> 1 -> 2 -> 0
    // linkedList.addAtTail(4); // 6 -> 1 -> 2 -> 0 -> 4

    // System.out.println(linkedList.get(4));  // 4
    // linkedList.addAtHead(4); // 4-> 6 -> 1 -> 2 -> 0 -> 4
    // linkedList.addAtIndex(5, 0); // 4-> 6 -> 1 -> 2 -> 0 -> 0 -> 4
    // linkedList.addAtHead(6);  // 6->4-> 6 -> 1 -> 2 -> 0 -> 0 -> 4
    // //System.out.println(linkedList.get(1));

	// ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
	// [[],[0,10],[0,20],[1,30],[0]]

	linkedList.addAtTail(10);
	// linkedList.addAtIndex(0, 20);
	// linkedList.addAtIndex(0, 30);
	System.out.println(linkedList.get(0));

  }
}


class Node {
  public int val;
  public Node next;
  
  public Node(int val, Node next) {
      this.val = val;
      this.next = next;
  }
   public Node(int val) {
      this.val = val;
      this.next = null;
  }
}


class MyLinkedList {
  Node head;
  Node tail;
  int length;
  
  public MyLinkedList() {
      this.length = 0;
      this.head = null;
      this.tail = null;
  }
  
  public int get(int index) {
      if (index >= length)
          return -1;
      
      int i= 0;
      Node current = this.head;
      while (current != null) {
          if (i == index)
              return current.val;
          
          current = current.next;
          i++;
      }
      return -1;
  }
  
  public void addAtHead(int val) {
      Node newHead = new Node (val, this.head);
      if (this.head == null) {
          this.tail = newHead;
      }
      this.head = newHead;
      this.length++;
  }
  
  public void addAtTail(int val) {
      Node newTail = new Node(val, null);
	  if (this.tail != null) {
		this.tail.next = newTail;
	  } else {
		this.head = newTail;
	  }
		this.tail = newTail;
	  
      
      this.length++;
  }
  
  public void addAtIndex(int index, int val) {
      if (index > this.length) 
          return;
      
		  if (index == 0) {
			this.addAtHead(val);
			return;  
		}

      if (this.length == index) {
          this.addAtTail(val);
          return;
      }




      Node previous = null;
      int i= 0;
      Node current = this.head;
      while (current != null) {
          if (i == index) {
              Node newNode = new Node(val, current);
              previous.next = newNode;
              this.length++;
              return;
          } 
              
          previous = current;
          current = current.next;
          i++;
      }
      
          
  }
  
  public void deleteAtIndex(int index) {
      if (index > this.length) 
          return;
      
      if (index == 0) {
          this.head = head.next;
          this.length--;
          return;
      }

      Node previous = null;
      int i= 0;
      Node current = this.head;
      while (current != null) {
          if (i == index) {
              previous.next = current.next;
              if (index == this.length - 1) {
                  this.tail = previous;
                         
              } 
              this.length--;
              return;
          } 
              
          previous = current;
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