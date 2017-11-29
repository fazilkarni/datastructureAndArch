package com.cisco;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class ChatClient {

	public static void main(String[] args) {
		String serverName = "10.232.16.32";
		int port = 8011;
		String username = "U1";
		String password = "P1";
		
		System.out.println("Connecting to " + serverName + " on port " + port);
		Socket client = null;
		try {
			client = new Socket(serverName, port);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//while (true) {
			try {
				
				System.out.println("Just connected to " + client.getRemoteSocketAddress());
				OutputStream outToServer = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				String dataToserver = "auth:"+username+":"+password;
				Scanner scanner = new Scanner(System.in);
				String input = null;//scanner.nextLine();
				out.writeUTF(dataToserver);
				String serverData = null;
				InputStream inFromServer = client.getInputStream();
				DataInputStream in = new DataInputStream(inFromServer);
				while(true){
					input = scanner.nextLine();
					out.writeUTF(input);
					serverData = in.readUTF();
					System.out.println( serverData);
					if(serverData.equals("Exit")){
						client.close();break;
					}
					
				}
				
				
				
			} catch (IOException e) {
				e.printStackTrace();

			}
		//}
		
	}
}