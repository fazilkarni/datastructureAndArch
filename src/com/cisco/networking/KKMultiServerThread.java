package com.cisco.networking;

import java.net.*;
import java.io.*;

public class KKMultiServerThread extends Thread {
    private Socket socket = null;

    public KKMultiServerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
    }
    
    public void run() {
    	System.out.println("Got connection request from the following address");
    	System.out.println("socket.getLocalPort()"+socket.getLocalPort());
    	System.out.println("socket.getPort()"+socket.getPort());
    	System.out.println("socket.getRemoteSocketAddress().toString()"+socket.getRemoteSocketAddress().toString());

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        	DataInputStream in = new DataInputStream(socket.getInputStream());
        ) {
            String inputLine, outputLine;
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);
            FileWriter fr = new FileWriter("/Users/mkarni/fromNitin1.txt");
            BufferedWriter br = new BufferedWriter(fr);
            while ((inputLine = in.readUTF()) != null) {
            	br.append(inputLine);
            	 br.flush();
            	System.out.println("Data received of size "+inputLine.length());
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye"))
                    break;
            }
            br.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}