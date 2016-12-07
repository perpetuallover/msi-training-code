package com.mercury.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class TestIterator {
	private String iterate(Iterator<String> it){
		String result = "";
		while(it.hasNext()){
			result += it.next();
		}
		return result;
	}
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = ConcurrentModificationException.class)
	public void test01() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		assertEquals("ABC", iterate(list.iterator()));
		Iterator<String> it = list.iterator();
		list.add("D"); // collection change itself
		iterate(it);
	}
	
	@Test(expected = ConcurrentModificationException.class)
	public void test02() {
		Set<String> set = new LinkedHashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		assertEquals("ABC", iterate(set.iterator()));
		Iterator<String> it = set.iterator();
		set.add("D"); // collection change itself
		iterate(it);
	}
	
	@Test(expected = ConcurrentModificationException.class)
	public void test03(){
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		map.put("D", 4);
		iterate(it);
	}
	@Test(expected = ConcurrentModificationException.class)
	public void test04(){
		Map<String, Integer> map = new Hashtable<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		map.put("D", 4);
		iterate(it);
	}
	@Test
	public void test05(){
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		map.put("D", 4);
		iterate(it);
	}
	//? list iterator, iterator interface, sub interface, collection, set
}
