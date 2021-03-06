package com.hs.summation;

import java.util.HashMap;

public class DiagonalSumOfBinaryTree {

	private void diagonalSum(Node root) {

		// base case
		if (root == null) {
			return;
		}

		// Creates an empty hashMap hM
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Calls the VerticalSumUtil() to store the
		// vertical sum values in hM
		diagonalSumUtil(root, map, 0);

		// Prints the values stored by VerticalSumUtil()
		if (map != null) {
			System.out.println(map.entrySet());
		}
	}

	// Traverses the tree in Inoorder form and builds
	// a hashMap hM that contains the vertical sum
	private void diagonalSumUtil(Node root, HashMap<Integer, Integer> map, int hD) {

		// base case
		if (root == null) {
			return;
		}

		// Store the values in hM for left subtree
		diagonalSumUtil(root.left, map, hD + 1);

		// Update vertical sum for hD of this node
		int prevSum = (map.get(hD) == null) ? 0 : map.get(hD);
		map.put(hD, prevSum + root.data);

		// Store the values in hM for right subtree
		diagonalSumUtil(root.right, map, hD);
	}

	// Driver class to test the verticalSum methods

	public static void main(String[] args) {
		DiagonalSumOfBinaryTree tree = new DiagonalSumOfBinaryTree();
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.left.setLeft(new Node(4));
		root.left.setRight(new Node(5));
		root.right.setLeft(new Node(6));
		root.right.setRight(new Node(7));

		System.out.println("Following are the values of" + " vertical sums with the positions"
				+ " of the columns with respect to root ");
		tree.diagonalSum(root);
	}
}
