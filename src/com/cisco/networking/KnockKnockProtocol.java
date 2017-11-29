package com.cisco.networking;

public class KnockKnockProtocol {
	
	public static String processInput(String clientString){
		if(clientString!=null){
			return "received "+clientString.length()+" length string";
		}else{
			return "Nothing received from client";
		}
	}

}
