package com.mercury.thread;

public class Thread1 extends Thread{
	// program and thread are running in stack, thread is an object, garbage collection only
	// happens when it lost its reference, e.g: reference = null
	public Thread1(){
		super();
	}
	public Thread1(String name){
		super(name);
	}
	@Override
	public void run(){
		System.out.println("Running Thread1 by " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args){
		Thread t = new Thread1("thread1"); // can give a name here
		t.run();
		t.run();
		t.start();//create a new one(add a new stack place)
	}
}
