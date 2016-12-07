package com.kenny.test;

public class ImmutableComplex {
	Address address = new Address("Boston", 70);

	public Address getAddress() {
		//String s = new String(address.city);
		Address a2 = new Address(address.city, address.number);
		return a2;
	}
	
	public static void main(String[] args){
		ImmutableComplex ic = new ImmutableComplex();
		System.out.println(ic.address.city);
		ic.getAddress().setCity("NYC");
		System.out.println(ic.address.city);
		ImmutableComplex ic2 = new ImmutableComplex();
		System.out.println(ic2.address.city);
	}
}
