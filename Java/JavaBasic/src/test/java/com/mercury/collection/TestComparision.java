package com.mercury.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.Map.Entry;
public class TestComparision {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testComparable() {
		List<Counter> list = new ArrayList<>();
		list.add(new Counter(5));
		list.add(new Counter(7));
		list.add(new Counter(3));
		assertEquals(3, list.size());
		assertEquals(5, list.get(0).getCount());
		assertEquals(7, list.get(1).getCount());
		assertEquals(3, list.get(2).getCount());
		Collections.sort(list); // sort(List<Comparable>)(quick sort)
		//in normal industry(not IT like google) can just use API
		assertEquals(3, list.get(0).getCount());
		assertEquals(5, list.get(1).getCount());
		assertEquals(7, list.get(2).getCount());
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
		Collections.sort(list, new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2){
				return p1.getName().compareTo(p2.getName());
			}
		});
		// compare based on different attribute?
		assertEquals("Alice", list.get(0).getName());
		assertEquals("Bob", list.get(1).getName());
		assertEquals("Tommy", list.get(2).getName());
	}
	//be able to write on white board, a lot variations
	private String sortMapByValue(Map<String, Integer> map){
		String result = "";
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2){
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		for (Map.Entry<String, Integer> entry: list){
			result += entry.getKey() + entry.getValue();
		}
		return result;
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
