package com.kenny.beans;

public class ThreadRunnable implements Runnable{
	public ThreadRunnable(){
		super();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstance();
	}
	
}
