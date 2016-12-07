package com.mercury.lecturetest;

public class MyThread implements Runnable{
	public void MyThread(){}
    @Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args){
		MyThread mt = new MyThread();
		mt.run();
		Thread t = new Thread(mt);
		t.start();
		t.run();
	}

}

