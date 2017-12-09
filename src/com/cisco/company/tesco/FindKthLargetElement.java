package com.cisco.company.tesco;

import java.util.Scanner;

public class FindKthLargetElement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[] array = {10,1,2,8,3,4,5,7,6,9};
		for(int i = 0;i<array.length-k;i++){
			for(int j=i;j<array.length;j++){
				if(array[i]>array[j]){
					int temp = array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		System.out.println(array);

	}

}
