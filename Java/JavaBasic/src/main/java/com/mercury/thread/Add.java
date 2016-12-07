package com.mercury.thread;

public class Add implements Runnable{
	private int x;
	private int y;
	private int result;
	private boolean done;
	public Add(){}
	public Add(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	synchronized public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = x + y;
		done = true;
		notify();
	}
	public synchronized int getResult(){
		while(!done){
			try{
				wait();
			}catch (Exception e){}
		}
		return result;
	}
}
