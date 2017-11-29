package com.cisco.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class chatClient {
	
	public static void main(String[] args){
		OutputStream out = null;
		InputStream in = null;
		Socket socket = null;
		try {
			socket = new Socket("localhost",9000);
			(new Reader(socket)).start();
			(new Writer(socket)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class Reader extends Thread{
	Socket socket;
	InputStream in = null;
	public Reader(Socket socket){
		this.socket = socket;
		setName("Reader");
	}
	@Override
	public void run() {

		try {
			in = socket.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    int data = -1;
		try {
			data = in.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(data!=-1){
			try {
				byte[] readBuffer = new byte[200];
				int num = in.read(readBuffer);
				if (num > 0) {
					byte[] arrayBytes = new byte[num];
					System.arraycopy(readBuffer, 0, arrayBytes, 0, num);
					String recvedMessage = new String(readBuffer, "UTF-8");
					System.out.println();
					System.out.println("Received from Server :" + recvedMessage);
				} 
			}catch (IOException e) {
				e.printStackTrace();
			}	
	} 
}
	
}

class Writer extends Thread {
	Socket socket;
	OutputStream out = null;
	public Writer(Socket socket){
		this.socket = socket;
		setName("Writer");
	}
	@Override
	public void run() {
		try {
			
			out = socket.getOutputStream();
			Scanner scanner = new Scanner(System.in);
			//System.out.print("                                                             you:");	
			String data = scanner.nextLine();
			while(!data.equals("exit")){
				//System.out.print("                                                             you:");	
				if(!data.contains("Received from Server"))
				out.write(data.getBytes("UTF-8"));
				data = scanner.nextLine();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
