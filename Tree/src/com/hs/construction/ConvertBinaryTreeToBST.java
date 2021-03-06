package com.hs.construction;

import java.util.Arrays;

public class ConvertBinaryTreeToBST {

	// Represent the root of binary tree

	int[] treeArray;
	int index = 0;

	// convertBTBST() will convert a binary tree to binary search tree
	public Node convertBTBST(Node root) {

		// Variable treeSize will hold size of tree
		int treeSize = calculateSize(root);
		treeArray = new int[treeSize];

		// Converts binary tree to array
		convertBTtoArray(root);

		// Sort treeArray
		Arrays.sort(treeArray);

		// Converts array to binary search tree
		Node d = createBST(0, treeArray.length - 1);
		return d;
	}

	// calculateSize() will calculate size of tree
	public int calculateSize(Node root) {
		if (root == null)
			return 0;
		else {
			return calculateSize(root.left) + calculateSize(root.right) + 1;
		}
	}

	// convertBTtoArray() will convert the given binary tree to its corresponding
	// array representation
	public void convertBTtoArray(Node root) {
		// Check whether tree is empty
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if (root.left != null)
				convertBTtoArray(root.left);
			// Adds nodes of binary tree to treeArray
			treeArray[index] = root.data;
			index++;
			if (root.right != null)
				convertBTtoArray(root.right);
		}
	}

	// createBST() will convert array to binary search tree
	public Node createBST(int start, int end) {

		// It will avoid overflow
		if (start > end) {
			return null;
		}

		// Variable will store middle element of array and make it root of binary search
		// tree
		int mid = (start + end) / 2;
		Node node = new Node(treeArray[mid]);

		// Construct left subtree
		node.left = createBST(start, mid - 1);

		// Construct right subtree
		node.right = createBST(mid + 1, end);

		return node;
	}

	// inorder() will perform inorder traversal on binary search tree
	public void inorderTraversal(Node root) {

		// Check whether tree is empty
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {

			if (root.left != null)
				inorderTraversal(root.left);
			System.out.print(root.data + " ");
			if (root.right != null)
				inorderTraversal(root.right);

		}
	}

	public static void main(String[] args) {

		ConvertBinaryTreeToBST bt = new ConvertBinaryTreeToBST();
		// Add nodes to the binary tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		// Display given binary tree
		System.out.println("Inorder representation of binary tree: ");
		bt.inorderTraversal(root);

		// Converts binary tree to corresponding binary search tree
		Node bst = bt.convertBTBST(root);

		// Display corresponding binary search tree
		System.out.println("\nInorder representation of resulting binary search tree: ");
		bt.inorderTraversal(bst);
	}
}