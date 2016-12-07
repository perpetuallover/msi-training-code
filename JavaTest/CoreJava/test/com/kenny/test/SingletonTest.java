package com.kenny.test;

import com.kenny.beans.ThreadRunnable;

public class SingletonTest {
	public static void main(String[] args){
		for(int i = 0; i < 100; i++){
			Runnable r1 = new ThreadRunnable();
			Thread t1 = new Thread(r1);
			t1.start();
		}
	}
}
