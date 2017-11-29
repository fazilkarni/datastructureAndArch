package com.cisco.general;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Matrix_Boomerang {

	public static void main(String[] args) {
		int m,n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total rows");
		m = scanner.nextInt();
		System.out.println("Enter total columns");
		n = scanner.nextInt();
		AtomicInteger[][] matrix = new AtomicInteger[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=new AtomicInteger(scanner.nextInt());
			}
		}
		
		//convert rows to 1s of rows
		for(int i=0;i<m;i++){
			AtomicInteger rowRef = new AtomicInteger(0);
			for(int j=0;j<n;j++){
				if(matrix[i][j].intValue()==1){
					matrix[i][j]=new AtomicInteger(2);
					rowRef.set(1);
				}else{
					matrix[i][j]=rowRef;
				}
			}
		}
		
		for(int i=0;i<n;i++){
			AtomicInteger rowRef = new AtomicInteger(0);
			for(int j=0;j<m;j++){
				if(matrix[j][i].intValue()==2){
					matrix[j][i]=new AtomicInteger(1);
					rowRef.set(1);
				}else if(matrix[j][i].intValue()==0){
					matrix[j][i]=rowRef;
				}
			}
		}
		System.out.println("Transformed matrix");
		for(int i=0;i<m;i++){
			
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println("\n");
		}

	}

}
