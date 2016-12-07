package com.mercury.thread;

public class Shared {
	private static void delay(long ms){
		try{
			Thread.sleep(ms);
		}catch(Exception e){}
	}
	synchronized public void foo1(){
		delay(2000);
		System.out.println("End of foo1");
	}
	synchronized public void foo2(){
		delay(2000);
		System.out.println("End of foo2");
	}
	synchronized public static void foo3(){
		delay(2000);
		System.out.println("End of foo3");
	}
	synchronized public static void foo4(){
		delay(2000);
		System.out.println("End of foo4");
	}
	public static void foo5(){
		delay(2000);
		System.out.println("End of foo5");
	}
}
