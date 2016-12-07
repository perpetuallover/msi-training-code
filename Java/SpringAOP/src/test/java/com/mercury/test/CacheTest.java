package com.mercury.test;





import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.cache.beans.Rectangle;

public class CacheTest {
	public static void main(String[] args){
		try(ClassPathXmlApplicationContext actx = new ClassPathXmlApplicationContext("cacheconfig.xml")){
			Rectangle rect = (Rectangle)actx.getBean("rectangle");
			int area1 = rect.getArea(10, 20);
			System.out.println("Area #1: " + area1);
			int area2 = rect.getArea(10, 20);
			System.out.println("Area #2: " + area2);
			int area3 = rect.getArea(15, 30);
			System.out.println("Area #3: " + area3);
			rect.clearAreas();
			int area4 = rect.getArea(10, 20);
			System.out.println("Area #4: " + area4);
			double d1= rect.getDiagonal(30, 40);
			System.out.println("Diagonal #1: " + d1);
			double d2= rect.getDiagonal(30, 40);
			System.out.println("Diagonal #2: " + d2);
			double d3= rect.getDiagonal(120, 40);
			System.out.println("Diagonal #3: " + d3);
			double d4= rect.getDiagonal(120, 40);
			System.out.println("Diagonal #4: " + d4);
			
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
