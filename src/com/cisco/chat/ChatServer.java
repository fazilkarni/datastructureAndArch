package com.cisco.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatServer {
	private static List<User>  defaultGusers = new ArrayList<User>();
	private static Map<String,List<User>> usersMap = new  HashMap<String,List<User>>();
	
	private static Queue<String> messageQueue = new LinkedBlockingQueue();
	private static Thread sender;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ServerSocket serverSocket;
		OutputStream out = null;
		InputStream in = null;
		usersMap.put("default", defaultGusers);
		int count=0;
		try {
			serverSocket = new ServerSocket(9000);
			boolean isStopped = false;
			while(!isStopped){
				
			    Socket clientSocket = serverSocket.accept();
			    User user = new User(clientSocket,""+count++,"default");
			    defaultGusers.add(user);
			    (new ServerReader(user,messageQueue)).start();
			    if(sender==null)(new ServerWriter(usersMap,messageQueue)).start();
			}
		} catch (IOException e) {
			 try {
				out.close();
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		
	}
}

class ServerReader extends Thread{
	User user;
	InputStream in = null;
	OutputStream out = null;
	private volatile static Queue<String> messageQueue;
	
	public ServerReader(User user,  Queue<String> messageQueue){
		this.user = user;
		this.messageQueue = messageQueue;
		setName("ServerReader");
	}
	@Override
	public void run() {

			try {
				in = user.connection.getInputStream();
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
						String recvedMessage = new String(arrayBytes, "UTF-8");
						System.out.println("Received message :" + recvedMessage+" from : "+user.group);
						messageQueue.offer(user.group+":"+recvedMessage);
					}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} 
	}
}


class ServerWriter extends Thread {
	private Map<String,List<User>> usersMap;
	private static Queue<String> messageQueue=null;
	private OutputStream out = null;
	
	
	public ServerWriter(Map<String,List<User>> usersMap,  Queue<String> messageQueue){
		this.usersMap = usersMap;
		ServerWriter.messageQueue = messageQueue;
		setName("ServerWriter");
	}
	
	@Override
	public void run() {
		try {
			List<User> clients = usersMap.get("default");
			while(true){
				if(messageQueue.size()>0){
					String message = messageQueue.poll();
					for(User user:clients){
						out = user.connection.getOutputStream();
						if(message!=null && !message.contains(user.group)){//dont send message to the sender back.
							out.write(message.getBytes("UTF-8"));
							out.flush();
						}
					}
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



