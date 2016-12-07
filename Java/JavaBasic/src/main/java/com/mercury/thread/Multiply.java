package com.mercury.thread;

public class Multiply implements Runnable{
	private int x;
	private int y;
	private int result;
	private boolean done;
	public Multiply(){}
	public Multiply(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	synchronized public void run(){
		result = x * y;
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
