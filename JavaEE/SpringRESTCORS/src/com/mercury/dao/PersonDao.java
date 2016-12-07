package com.mercury.dao;

import java.util.List;

import com.mercury.beans.Person;

public interface PersonDao {
	public List<Person> findAll();
	public Person findByName(String name);
	public void update(Person person);
	public void deleteByName(String name);
	public void save(Person person);
}
