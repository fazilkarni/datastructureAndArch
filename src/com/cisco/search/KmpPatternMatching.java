package com.cisco.search;
import java.util.Scanner;

public class KmpPatternMatching {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter text:");
		String txt = scanner.nextLine();
		System.out.println("Enter pattern:");
		String pattern = scanner.nextLine();
		int[] lps = computeLPSArray(pattern);
		for(int i=0;i<lps.length;i++)
		System.out.print(lps[i]+" ");
		
		searchPatternOccurance(pattern,lps,txt);
		

	}
	
	public static void searchPatternOccurance(String pattern,int[] lps,String txt){
		int length = txt.length();
		int pLenth = pattern.length();
		int i= 0;
		int j=0;
		while(i<length){
			if(pattern.charAt(j)==txt.charAt(i)){
				i++;j++;
			}else{
				if(j>0){ 
					j=lps[j-1];
				}else{
					i++;
				}
			}
			
			if(j==pLenth){
				System.out.println("\npatter found at: "+(i-j));
				j=lps[j-1];
			}
		}
	}
	
	public static int[] computeLPSArray(String pattern){
		int[] lps = new int[pattern.length()];
		//int i = 0;
		int length = pattern.length();
		String subString;
		
		for(int i=1;i<length;i++){
			lps[i] = computeLPS(pattern.substring(0,i+1));
		}
		return lps;
	}
	
	public static int computeLPS(String subPattern){
		int lps = 0;
		int i=1;
		int j=subPattern.length();int l=j;
		while(i<l){
			if(subPattern.substring(0,i).equals(subPattern.substring(j-1,l))){
				lps=subPattern.substring(0,i).length();
			}//else{
//				break;
//			}
			i++;j--;
		}
		return lps;
	}

}
