package com.kenny.beans;

public class Singleton {
	private static Singleton singleton;
	private static int count = 0;
	private Singleton(){
		count++;
		System.out.println("count: " + count);
	};
	public static Singleton getInstance(){
		if(singleton == null){
			synchronized(Singleton.class){
				if(singleton == null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
