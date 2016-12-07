package com.mercury.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class TestMap {

	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testHashMap() {
		Map<String, String> map = new HashMap<>(); // Diamond rule in Java
		map.put(null, "A");
		map.put(null, "AA");
		map.put("B", null);
		assertEquals(null, map.get("B"));
		assertEquals("AA", map.get(null));
		assertEquals(2, map.size());		
	}
	@Test(expected = NullPointerException.class)
	public void testHashtable() {
		Map<String, String> map = new Hashtable<>();
		map.put("B", null);
		//map.entrySet();
	}
	@Test(expected = NullPointerException.class)
	public void testConcurrentHashMap() {
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put(null, "A");
	}

}
