package com.hs.linkedlist;

public class Node {
	int data;
	Node next;
	Node prev;// this is for doubly linked list only
	Node tail;
	String value;
	
	Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
		this.tail=null;
	}
	
	Node(String value){
		this.value=value;
		this.next=null;
		this.prev=null;
		this.tail=null;
	}
}
