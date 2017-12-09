package com.cisco.company.tesco;

import java.util.Scanner;


public class JumbledStringComparions {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String s1=scanner.nextLine();
		String s2=scanner.nextLine();
		int ls1 = s1.length();
		int ls2 = s2.length();
		int[] tempStoreS1 = new int[256];
		int[] tempStoreS2 = new int[256];
		
		for(int i=0;i<ls1;i++){
			tempStoreS1[s1.charAt(i)] = tempStoreS1[s1.charAt(i)]+1;
		}
		
		for(int i=0;i<ls2;i++){
			tempStoreS1[s2.charAt(i)] = tempStoreS1[s2.charAt(i)]-1;
		}
		
		for(int i=0;i<256;i++){
			System.out.print(tempStoreS1[i]+" ");
		}
//		System.out.println();
//		for(int i=0;i<256;i++){
//			System.out.print(tempStoreS2[i]+" ");
//		}

	}

}
