package com.cisco.tree.nitin;

public class AVL {
	
	public static void main(String[] args) {
		AVLTreeOperation t = new AVLTreeOperation();
		Node root = null;
		root = t.add(root, 3);
		root = t.add(root, 2);
		root = t.add(root, 1);
		System.out.println(root);

	}
}

class Node {
	int value;
	Node right = null;
	Node left = null;
	int height;

	Node(int value) {
		height = 0;
		this.value = value;
		right = null;
		left = null;
	}
}

class AVLTreeOperation {
	Node add(Node root, int value) {

		if (root == null) {
			return new Node(value);
		}

		if (root.value < value) {
			root.right = add(root.right, value);
		} else if (root.value > value) {
			root.left = add(root.left, value);
		} else if (root.value == value) {
			return root;
		}

		root.height = calculateHeight(root);
		int balance = isBalance(root);

		if (balance < -1 && root.right.value < value) {
			// rr
			root = rightBalance(root);
		}
		if (balance < -1  && root.right.value > value) {
			// RL
		}

		if (balance > 1 && root.left.value > value) {
			// LL
			root = leftBalance(root);
		}
		if (balance > 1 && root.left.value < value) {
			// LR
		}

		return root;

	}

	private Node leftBalance(Node root) {
		Node t1 = root.left.right;
		Node t2 = root.left;
		root.left = t1;
		t2.right = root;
		return t2;
	}

	private Node rightBalance(Node root) {
		Node t1 = root.right.left;
		Node t2 = root.right;
		root.right = t1;
		t2.left = root;
		return t2;

	}

	private int isBalance(Node root) {
		int right = -1, left = -1;
		if (root.right != null)
			right = root.right.height;
		if (root.left != null)
			left = root.left.height;

		return left - right;
	}

	private int calculateHeight(Node root) {
		int right = -1, left = -1;
		if (root.right != null)
			right = root.right.height;
		if (root.left != null)
			left = root.left.height;

		return Math.max(right, left) + 1;
	}
}