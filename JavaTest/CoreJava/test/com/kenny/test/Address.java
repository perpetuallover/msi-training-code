package com.kenny.test;

public class Address {
	String city = "Princeton";
	int number = 50;
	public Address() {}
	public Address(String city, int number){
		this.city = city;
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
