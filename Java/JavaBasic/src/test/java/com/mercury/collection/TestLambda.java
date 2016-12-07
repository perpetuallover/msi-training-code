package com.mercury.collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLambda {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComparator(){
		List<Person> list = new ArrayList<>();
		list.add(new Person("Tommy"));
		list.add(new Person("Alice"));
		list.add(new Person("Bob"));
		assertEquals(3, list.size());
		assertEquals("Tommy", list.get(0).getName());
		assertEquals("Alice", list.get(1).getName());
		assertEquals("Bob", list.get(2).getName());
		//interface one method?
		Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		// compare based on different attribute?
		assertEquals("Alice", list.get(0).getName());
		assertEquals("Bob", list.get(1).getName());
		assertEquals("Tommy", list.get(2).getName());
	}
	private String sortMapByValue(Map<String, Integer> map){
		final StringBuffer sb = new StringBuffer();
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		//Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		list.forEach(e -> sb.append(e.getKey() + e.getValue()));
		return sb.toString();
	}
	@Test
	public void testSortMapByValue(){
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 5);
		map.put("B", 2);
		map.put("C", 7);
		map.put("D", 1);
		assertEquals("D1B2A5C7", sortMapByValue(map));
	}

}
