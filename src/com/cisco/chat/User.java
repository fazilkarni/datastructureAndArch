package com.cisco.chat;

import java.net.Socket;

public class User {
	
	Socket connection;
	String group;
	String name;
	
	public User(Socket connetion,String group,String name){
		this.connection = connetion;
		this.group = group;
		this.name = name;
		
	}
	

}
