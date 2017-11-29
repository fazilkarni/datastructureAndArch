package com.cisco.tree;

public class Node {
	public Node right;
	public Node left;
	public int data;
	public int height;
	
	public Node(int data){
		this.left = null;
		this.right = null;
		this.data = data;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
