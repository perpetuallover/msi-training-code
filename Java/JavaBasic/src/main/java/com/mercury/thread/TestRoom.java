package com.mercury.thread;

public class TestRoom {
	public static void main(String[] args){
		Room r = new Room();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				Room.enter();
			}
		});
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				r.exit();
			}
		});
		t1.start();
		t2.start();
		//class level lock can be converted to object level lock?
	}
}
