package com.mercury.thread;

public class Room {
	private static void delay(long ms){
		try{
			Thread.sleep(ms);
		}catch(Exception e){}
	}
	synchronized public static void enter(){
		delay(2000);
		System.out.println("Enter the room");
	}
	public void exit(){
		synchronized (this){
			delay(2000);
			System.out.println("Exit the room");
		}
	}
	
}
