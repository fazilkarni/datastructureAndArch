package com.cisco.search;
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println("found at "+binarySearch(a,11));

	}
	public static int binarySearch(int[] a,int x){
		
		int start = 0;
		int end = a.length-1;
		int mid = 0;
		while(start<=end){
			mid = (start+end)/2;
			if(a[mid]==x) return mid;
			if(x<a[mid]){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		return -1;
	}
}
