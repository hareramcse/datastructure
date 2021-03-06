package com.hs.checkandprint;

import java.util.HashSet;

public class CheckIfTreeContainsDuplicateValue {

	// Function that used HashSet to find presence of duplicate nodes
	public static boolean checkDupUtil(Node root, HashSet<Integer> s) {
		// If tree is empty, there are no
		// duplicates.
		if (root == null)
			return false;

		// If current node's data is already present.
		if (s.contains(root.data))
			return true;

		// Insert current node
		s.add(root.data);

		// Recursively check in left and right
		// subtrees.
		return checkDupUtil(root.left, s) || checkDupUtil(root.right, s);
	}

	// To check if tree has duplicates
	public static boolean checkDup(Node root) {
		HashSet<Integer> s = new HashSet<>();
		return checkDupUtil(root, s);
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		if (checkDup(root))
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}