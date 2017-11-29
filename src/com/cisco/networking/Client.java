package com.cisco.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try (
			    Socket kkSocket = new Socket("localhost", 9000);
			    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			        new InputStreamReader(kkSocket.getInputStream()));
			){
			String fromServer=null;
			String fromUser = null;
			System.out.println("Server connection successful. Start chating");
			System.out.println("Got connection request from the following address");
	    	System.out.println("socket.getLocalPort()"+kkSocket.getLocalPort());
	    	System.out.println("socket.getPort()"+kkSocket.getPort());
	    	System.out.println("socket.getRemoteSocketAddress().toString()"+kkSocket.getRemoteSocketAddress().toString());

			while ((fromServer = in.readLine()) != null) {
			    System.out.println("Server: " + fromServer);
			    if (fromServer.equals("Bye."))
			        break;
			    Scanner scanner = new Scanner(System.in);
			    fromUser = scanner.nextLine();
			    if (fromUser != null) {
			        
			        out.println(fromUser);
			    }
			}
			
		}catch(Exception ex){
			
		}


	}

}
