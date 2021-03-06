package com.hs.checkandprint;

class PrintAllPathFromRootToLeaf {

	/*
	 * Given a binary tree, print out all of its root-to-leaf paths, one per line.
	 * Uses a recursive helper to do the work.
	 */
	void printPaths(Node root) {
		int path[] = new int[1000];
		printPathsRecur(root, path, 0);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the path
	 * from the root node up to but not including this node, print out all the
	 * root-leaf paths.
	 */
	void printPathsRecur(Node root, int path[], int pathLen) {
		if (root == null)
			return;

		/* append this node to the path array */
		path[pathLen] = root.data;
		pathLen++;

		/* it's a leaf, so print the path that led to here */
		if (root.left == null && root.right == null)
			printArray(path, pathLen);
		else {
			/* otherwise try both subtrees */
			printPathsRecur(root.left, path, pathLen);
			printPathsRecur(root.right, path, pathLen);
		}
	}

	/* Utility that prints out an array on a line */
	void printArray(int ints[], int len) {
		for (int i = 0; i < len; i++)
			System.out.print(ints[i] + " ");
		System.out.println("");
	}

	/* Driver program to test all above functions */
	public static void main(String[] args) {
		PrintAllPathFromRootToLeaf tree = new PrintAllPathFromRootToLeaf();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		/* Print all root-to-leaf paths of the input tree */
		tree.printPaths(root);

	}
}