package com.cisco.tree;

public class BST {
	Node root;
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(10);
		bst.insert(9);
		bst.insert(11);
		bst.insert(8);
		Node node = bst.root;
		bst.inOrderTraversal(node);
		System.out.println("Decensding order values");
		Node node1 = bst.root;
		bst.printDecendingOrder(node1);
	}

	public void insert(int data){
		
		if(root==null){
			root = new Node(data);
		}else{
			Node temp = root;
			Node parent = temp;
			while(temp!=null){
				if(data<temp.data){
					parent = temp;
					temp = temp.left;
				}else{
					parent = temp;
					temp = temp.right;
				}
			}
			
			if(data<parent.data){
				parent.left = new Node(data);
			}else{
				parent.right = new Node(data);
			}
		}
	}
	
	public void inOrderTraversal(Node root){
		if(root!=null){
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
		}
	}
	
	public void preOrderTraversal(Node root){
		if(root!=null){
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public void postOrderTraversal(Node root){
		if(root!=null){
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}
	
	public void printDecendingOrder(Node root){
		if(root!=null){
		printDecendingOrder(root.right);
		System.out.println(root.data);
		printDecendingOrder(root.left);
		}
	}
	

}
