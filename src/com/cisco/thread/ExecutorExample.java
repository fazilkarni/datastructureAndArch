package com.cisco.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
	
	public static void main(String[] args){
		
		ExecutorService executor =  Executors.newFixedThreadPool(5);
		
		for(int i=0;i<10;i++){
			executor.execute(new work(i));
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
	}

}

class work implements Runnable{
	int i;
	public work(int i){
		this.i=i;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+" Started task"+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName()+" Ended task "+i);
	}
}
