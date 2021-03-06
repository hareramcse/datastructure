package com.hs.construction;

public class TreeIsoMorphysm {

	/* Given a binary tree, print its nodes in reverse level order */
	boolean isIsomorphic(Node n1, Node n2) {
		// Both roots are NULL, trees isomorphic by definition
		if (n1 == null && n2 == null) {
			return true;
		}

		// Exactly one of the n1 and n2 is NULL, trees not isomorphic
		if (n1 == null || n2 == null) {
			return false;
		}

		if (n1.data != n2.data) {
			return false;
		}

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
		// Both of these subtrees have to be isomorphic, hence the &&
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}

	// Driver program to test above functions
	public static void main(String args[]) {

		TreeIsoMorphysm tree = new TreeIsoMorphysm();
		// Let us create trees shown in above diagram
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.left = new Node(6);
		root1.left.right.left = new Node(7);
		root1.left.right.right = new Node(8);

		Node root2 = new Node(1);
		root2.left = new Node(3);
		root2.right = new Node(2);
		root2.right.left = new Node(4);
		root2.right.right = new Node(5);
		root2.left.right = new Node(6);
		root2.right.right.left = new Node(8);
		root2.right.right.right = new Node(7);

		if (tree.isIsomorphic(root1, root2) == true) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}