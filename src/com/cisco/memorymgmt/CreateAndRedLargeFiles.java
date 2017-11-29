package com.cisco.memorymgmt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateAndRedLargeFiles {

	public static void main(String[] args) {
		writeToFile();
		//readFromFile();
	}
	
	public static void writeToFile(){
		Path pathToFile = Paths.get("/tmp/myfile.txt");
		try {
			BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
			BufferedWriter bw = Files.newBufferedWriter(pathToFile, StandardCharsets.US_ASCII);
			// skip the line till test_scenarios row in the input file.
			StringBuffer sb = new StringBuffer(1024*1024*1024);//1km*1024=1mb*1024=1gb
			for(int i=0;i<10000;i++){
				while (sb.length()<sb.capacity()) {
					sb.append("Hello cisco. How is life at cisco. Its awesome. Having great fun");
				}
				bw.write(sb.toString());
				bw.flush();
				sb.delete(0, sb.length());
			}
			bw.write("End of the file");
		}catch(Exception io){
			System.out.println(io);
		}
	}
	
	public static void readFromFile(){
		int i=0;
		Path pathToFile = Paths.get("/tmp/myfile.txt");
		try {
			BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
			// skip the line till test_scenarios row in the input file.
			CharBuffer chbuff = CharBuffer.allocate(1024*1024);//(1024*1024*1024);//1km*1024=1mb*1024=1gb
			br.read(chbuff);
			System.out.println(chbuff.length());
			int ii =1024*1024+1;
			while(ii>1000000){
				 br.read(chbuff);
				 ii = chbuff.length();
				i++;
				chbuff.clear();
			}
			System.out.println("I="+i);
		}catch(java.lang.OutOfMemoryError io){
			System.out.println(io+"i==========="+i);
		}
		catch(Exception io){
			System.out.println(io+"i==========="+i);
		}
	}

}
