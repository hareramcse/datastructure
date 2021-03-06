package com.hs.traversal;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

public class DiagonalTraversal {

	/*
	 * root - root of the binary tree d - distance of current line from rightmost
	 * -topmost slope. diagonalPrint - HashMap to store Diagonal elements (Passed by
	 * Reference)
	 */
	static void printDiagonal(Node root, HashMap<Integer, List<Integer>> map, int d) {

		// Base case
		if (root == null)
			return;

		// get the list at the particular d value
		List<Integer> list = map.get(d);

		// vector is null then create a vector and store the data
		if (list == null) {
			list = new Vector<>();
			list.add(root.data);
		}

		// vector is not null then update the list
		else {
			list.add(root.data);
		}

		// Store all nodes of same line together as a vector
		map.put(d, list);

		// Increase the vertical distance if left child
		printDiagonal(root.left, map, d + 1);

		// Vertical distance remains same for right child
		printDiagonal(root.right, map, d);
	}

	// Print diagonal traversal of given binary tree
	static void diagonalPrint(Node root) {
		// create a map of vectors to store Diagonal elements
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		printDiagonal(root, map, 0);

		System.out.println("Diagonal Traversal of Binnary Tree");
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	// Driver program
	public static void main(String[] args) {

		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		diagonalPrint(root);
	}
}