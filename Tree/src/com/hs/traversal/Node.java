package com.hs.traversal;

public class Node {
	int data;
	Node left, right, next;

	public Node(int item) {
		data = item;
		left = right = next = null;
	}
	
	public Node() {

	}
}
