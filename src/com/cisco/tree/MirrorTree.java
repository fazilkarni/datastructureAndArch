package com.cisco.tree;

public class MirrorTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean checkIfMirror(Node left,Node right){
		if(left==null && right==null) return true;
		if(left==null || right == null) return false;
		
		if(left.getData() == right.getData()){
			return (checkIfMirror(left.left,right.right)&&checkIfMirror(left.right,right.left));
		}
		
		return false;		
	}

}
