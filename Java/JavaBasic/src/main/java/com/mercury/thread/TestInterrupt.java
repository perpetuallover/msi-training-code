package com.mercury.thread;

public class TestInterrupt {
	public static void main(String[] args){
		Thread t = new Thread(){
			@Override
			public void run(){
				try{
					Thread.sleep(2000);
				} catch (InterruptedException e){
					System.err.println(e);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("End of thread t");
			}
		};
		t.start();
		t.interrupt();
		System.out.println("End of Main");
		
	}
}
