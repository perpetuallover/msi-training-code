package com.mercury.io;
import java.io.*;
public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5128066832535631787L; //unique identification
	// used to be deserialized
	private transient int x;
	private double d;
	private boolean b;
	public Data(){
		System.out.println("Create an instance of Data");
	}
	public Data(int x, double d, boolean b){
		this.x = x;
		this.d = d;
		this.b = b;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	
}
