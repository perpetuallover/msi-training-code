package com.mercury.thread;

public class Thread2 extends Thread{
	public Thread2(){
		super();
	}
	public Thread2(String name){
		super(name);
	}
	@Override
	public void run(){
		while(true){
			System.out.println("Running by " + Thread.currentThread().getName());
		}
	}
	public static void main(String[] args){
		Thread t = new Thread2("Thread2");
		t.setDaemon(true);
		t.start();
		try{
			Thread.sleep(2);
		} catch(Exception e){}
		System.out.println("End of Main");
	}
}
