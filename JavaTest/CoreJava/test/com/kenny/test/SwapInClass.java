package com.kenny.test;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class SwapInClass {
	public void swap(AtomicInteger a, AtomicInteger b){
		int temp = a.get();
		a.set(b.get());
		b.set(a.get());		
	}
	public void swapWrapper(IntWrapper a, IntWrapper b){
		int temp = a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);
	}
	public void swapInteger(Integer a, Integer b) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field f = a.getClass().getDeclaredField("value");
		f.setAccessible(true);
		f.set(a, b.intValue());
	}
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		SwapInClass sic = new SwapInClass();
		int a = 1;
		int b = 9;
		//sic.swap(a, b);
		System.out.println(a);
		System.out.println(b);
		IntWrapper aiw = new IntWrapper(111);
		IntWrapper biw = new IntWrapper(999);
		sic.swapWrapper(aiw, biw);
		System.out.println(aiw.getValue());
		System.out.println(biw.getValue());
		Integer ai = new Integer(1111);
		Integer bi = new Integer(9999);
		sic.swapInteger(ai, bi);
		System.out.println(ai.intValue());
		System.out.println(bi.intValue());
	}
}