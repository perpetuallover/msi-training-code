package com.mercury.code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBasic {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test01() {
		//inside -128 ~ 127 same
		Integer x = -128;
		Integer y = -128;
		assertSame(x, y);
		Integer u = 1000;
		Integer v = 1000;
		assertNotSame(u, v);
	}
	
	private String getValue(int x){
		return "Int " + x;
	}
	private String getValue(Short x){
		return "Short " + x;
	}
	private String getValue(Long x){
		return "Long " + x;
	}
	@Test
	public void test02(){
		short x = 7;
		long y = 6;
		Short z = 5;
		assertEquals("Int 7", getValue(x)); // convert to primitive type first
		assertEquals("Long 6", getValue(y));
		assertEquals("Short 5", getValue(z));
	}
	private String getObject(Object obj){
		return "object";
	}
	private String getObject(String str){
		return str;
	}
//	private String getObject(Integer x){
//		return "int";
//	}
//	private String getObject(int x){
//	return "int";
//	}
	@Test
	public void test03(){
		assertEquals("abc", getObject("abc"));
		assertEquals(null, getObject(null)); // null is only for object
		Object obj = "def";
		assertEquals("object", getObject(obj));
	}
	
	private String get(int a, int b){
		return "A";
	}
	private String get(int... value){
		return "B";
	}
	@Test
	public void test04(){
		assertEquals("A", get(3, 4));
		assertEquals("B", get(5));
		assertEquals("B", get(6,7,8));
	}

}
