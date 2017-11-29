package com.cisco.tree;

public class AVL {
	Node root;
	public static void main(String args[]){
		AVL avl = new AVL();
		Node root ;
		
	
		avl.root = avl.insert(avl.root,3);
		avl.root = avl.insert(avl.root,1);
		avl.root = avl.insert(avl.root,2);
		System.out.println(avl.root.data);
		
	}
	
	public Node insert(Node root,int value){
		if(root==null){
			return new Node(value);
		}
		
		if(value<root.data){
			root.left = insert(root.left,value);
		}else if(value>root.data){
			root.right = insert(root.right,value);
		}else{
			return root;
		}
		root.height = Math.max(height(root.left), height(root.right))+1;
		int balanceFactor = getBalanceFactor(root.left,root.right);
		//rotate from here
		
		if(balanceFactor < -1 && root.data < value){
			//RR
			return RightRightRotate(root);
		}else if(balanceFactor < -1 && root.data > value){
			//RL
			LeftLeftRotate(root.right);
			return RightRightRotate(root);
		}else if(balanceFactor > 1 && root.data < value){
			//LL
			return LeftLeftRotate(root);
		}else if (balanceFactor > 1 && root.data > value){
			//LR
			RightRightRotate(root.left);
			return LeftLeftRotate(root);
		}
		
		return root;
				
	}
	
	private Node RightRightRotate(Node root){
		Node RR = root.right;
		Node RRL = RR.left;
		root.right = RRL;
		RR.left = root;
		return RR;
		
	}
	
	private Node LeftLeftRotate(Node root){
		Node LL = root.left;
		Node LLR = LL.left;
		root.left = LLR;
		LL.right = root;
		return LL;
	}
	
	private Node leftRightRotate(Node root){
		Node L = root.left;
		Node LR = L.right;
		L.right = root;
		root.left = LR;
		return L;
			
	}
	private Node RightLeft(Node root){
		
	}
	private int height(Node node){
		int lh=0;
		int rh=0;
		if(node==null) return -1;
		if(node.left!=null) lh=node.left.height;
		if(node.right!=null) lh=node.right.height;
		return Math.max(lh,rh)+1;
	}
	
	private int getBalanceFactor(Node left,Node right){
		int r=0;
		int l=0;
		if(right!=null) r=right.height;
		if(left!=null) l=left.height;
		return l-r;
	}
	
}
