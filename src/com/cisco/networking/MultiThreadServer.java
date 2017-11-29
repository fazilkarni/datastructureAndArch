package com.cisco.networking;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiThreadServer {
	public static void main(String[] args){
		int portNumber = Integer.parseInt("9000");
	    boolean listening = true;
	     
	    try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
	    	
	        while (listening) {
	            new KKMultiServerThread(serverSocket.accept()).start();
	        }
	    } catch (IOException e) {
	        System.err.println("Could not listen on port " + portNumber);
	        System.exit(-1);
	    }
	}

}
