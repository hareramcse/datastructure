package com.hs.construction;

class ConstructBinaryTreeToDoubleTree {

	Node root;

	/* Function to convert a tree to double tree */
	void doubleTree(Node node) {
		Node oldleft;

		if (node == null) {
			return;
		}

		/* do the subtrees */
		doubleTree(node.left);
		doubleTree(node.right);

		/* duplicate this node to its left */
		oldleft = node.left;
		node.left = new Node(node.data);
		node.left.left = oldleft;
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String args[]) {
		ConstructBinaryTreeToDoubleTree tree = new ConstructBinaryTreeToDoubleTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Original tree is : ");
		tree.printInorder(tree.root);
		tree.doubleTree(tree.root);
		System.out.println("");
		System.out.println("Inorder traversal of double tree is : ");
		tree.printInorder(tree.root);

	}
}