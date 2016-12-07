package com.mercury.thread;

public class ThreadLocalDemo{
	public static void main(String[] args) throws InterruptedException{
		final ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
			@Override
			protected Integer initialValue(){
				return 10;
			}
		};
		Thread t1 = new Thread(){
			@Override
			public void run(){
				int x = local.get();
				System.out.println(x + " in t1");
				x++;
				local.set(x);
				System.out.println(local.get() + " in t1");
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run(){
				int x = local.get();
				System.out.println(x + " in t2");
				x += 10;
				local.set(x);
				System.out.println(local.get() + " in t2");
			}
		};
//		t1.start();
//		t2.start();
//		try{
//			t1.join();
//			t2.join();
//		}catch (Exception e){}
		t1.start();
		t1.join();
		t2.start();
		t2.join();
	}
}
