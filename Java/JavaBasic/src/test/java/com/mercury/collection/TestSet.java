package com.mercury.collection;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
public class TestSet {
	@Test
	public void testWrappedString(){
		Set<Object> set = new HashSet<Object>();
		set.add(new WrappedString("abc"));
		set.add(new WrappedString("abc"));
		set.add(new String("abc"));
		set.add(new String("abc")); // java builtin class override hashcode and equals
		assertEquals(2, set.size());//override 2?
	}
	@Test
	public void testKeyMaster(){
		Set<KeyMaster> set = new HashSet<KeyMaster>();
		KeyMaster k1 = new KeyMaster(1);
		KeyMaster k2 = new KeyMaster(2);
		set.add(k1);
		set.add(k1);
		set.add(k2);
		set.add(k2);
		assertEquals(2, set.size());
		k2.setKey(1);
		assertEquals(2, set.size());
		set.remove(k1);
		assertEquals(1, set.size());
		set.remove(k2);
		assertEquals(1, set.size());
	}
	private String traverse(Set<String> set){
		String result = "";
		for(String s: set){
			result += s;
		}
		return result;
	}
	@Test
	public void testHashSet(){
		Set<String> set = new HashSet<>();
		set.add("X");
		set.add("A");
		set.add("D");
		assertFalse(traverse(set).equals("XAD"));		
	}
	//ordered but not sorted!
	@Test
	public void testLinkedHashSet(){
		Set<String> set = new LinkedHashSet<>();
		set.add("X");
		set.add("A");
		set.add("D");
		assertTrue(traverse(set).equals("XAD"));
		
	}
	@Test
	public void testTreeSet(){
		Set<String> set = new TreeSet<>();
		set.add("X");
		set.add("A");
		set.add("D");
		assertTrue(traverse(set).equals("ADX"));	
	}
}
