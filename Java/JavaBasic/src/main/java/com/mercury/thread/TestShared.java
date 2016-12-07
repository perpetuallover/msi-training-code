package com.mercury.thread;

public class TestShared {
	public static void main(String[] args){
		final Shared s = new Shared();
		Thread t1 = new Thread(){
			@Override
			public void run(){
				s.foo1();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run(){
				s.foo3();
			}
		};
		t1.start();
		t2.start();
	}
}
