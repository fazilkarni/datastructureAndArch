package com.cisco.memorymgmt;

public class TestMemory {
	
	public static void main(String [] args) {
		TestMemory.memoryStack();
		TestMemory.createThreads();
	}
	
	public static void createThreads(){
		MyThread mt2 = null;
		for(int i=0;i<100000000;i++){
			 mt2 = new MyThread();
			mt2.start();
		}
	}
	public static void memoryStack(){
		int mb = 1024*1024;
		
		//Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();
//		
//		System.out.println("##### Heap utilization statistics [MB] #####");
//		
//		//Print used memory
//		System.out.println("Used Memory:" 
//			+ (runtime.totalMemory() - runtime.freeMemory()) / mb);
//
//		//Print free memory
//		System.out.println("Free Memory:" 
//			+ runtime.freeMemory() / mb);
//		
		//Print total available memory
		System.out.println("Free memory "+( runtime.freeMemory() / mb)+" Total Memory: " + (runtime.totalMemory() / mb)+ ( " Max Memory:" + runtime.maxMemory() / mb));

		//Print Maximum available memory
		//System.out.println("Max Memory:" + runtime.maxMemory() / mb);
	}
	
}

class MyThread extends Thread{
	public void run(){
		long l=0;
		for(int i=0;i<1000000000;i++){
			l=l+i;

		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestMemory.memoryStack();
	}
}