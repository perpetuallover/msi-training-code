package com.mercury.code;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestString {

	@Test //?
	public void test01() {
		//fail("Not yet implemented");
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		assertEquals(str1, str2); // compare values
		assertSame(str1, str2); // compare references
		assertTrue(str1 == str2);
		assertTrue(str1.equals(str2));
		assertEquals(str1, str3);
		assertNotSame(str1, str3);
	}
	public void test02(){
		String str1 = "abc";
		String str2 = new String("abc");
		assertEquals(str1, str2);
		assertNotSame(str1, str2);
		assertTrue(str1 == str2.intern()); //?
	}
	private boolean inPool(String str){
		return str == null ? false : (str == str.intern());		
	}
	
	@Test
	public void testInPool(){
		assertFalse(inPool(null));
		assertTrue(inPool("abc"));
		assertFalse(inPool(new String("abc")));
	}
	
	@Test
	public void test03(){
		String s1 = "ab";
		String s2 = s1 + "cd";
		String s3 = "ab" + "cd";
		assertEquals(s2, s3);
		assertNotSame(s2, s3);
		assertTrue(inPool(s3));
		assertFalse(inPool(s2));
	}
	
	private void change(String str){
		str = "change";
	}
	
	@Test
	public void testChange(){
		String s = "abc";
		change(s);
		assertEquals("abc", s);
	}
	//reflection
	private void change2(String str) throws Exception{
		Field value = String.class.getDeclaredField("value");
		value.setAccessible(true);
		value.set(str, "change".toCharArray());
	}
	
	@Test
	public void testChange2() throws Exception{
		String s = "abcd";
		assertTrue(s.getClass() == String.class);
		change2(s);
		assertEquals("change", s);
		System.out.println("abcd");
		//assertTrue(inPool(s));
	}

}
