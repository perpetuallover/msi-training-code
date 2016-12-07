package com.mercury.cache.beans;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class Rectangle {
	@Cacheable("areas")
	public int getArea(int width, int height){
		System.out.print("Calculating the area of the rectangle...");
		return width * height;
	}
	@CacheEvict(value="areas", allEntries=true)
	public void clearAreas(){
		System.out.println("Clear all cache entries");
	}
	@Cacheable(value="diagonals", condition="#width<100")
	public double getDiagonal(int width, int height){
		System.out.println("Calculating the length of the diagonal...");
		return Math.sqrt(width*width + height*height);
	}
}
