package com.mercury.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.beans.Person;
import com.mercury.dao.PersonDao;

@Controller
public class PersonController {
	@Autowired
	private PersonDao pd;
	@RequestMapping(value="/person", method=RequestMethod.GET)
	@ResponseBody
	public List<Person> getPersonList(HttpServletResponse response){
		return pd.findAll();
	}
	@RequestMapping(value="/person/{name}", method=RequestMethod.GET)
	@ResponseBody
	public Person getPerson(@PathVariable String name,HttpServletResponse response){
		return pd.findByName(name);
	}
	@RequestMapping(value="/person", method=RequestMethod.POST)
	@ResponseBody
	public void savePerson(@RequestBody Person person, HttpServletResponse response){
		pd.save(person);
	}
	@RequestMapping(value="/person", method=RequestMethod.PUT)
	@ResponseBody
	public void updatePerson(@RequestBody Person person, HttpServletResponse response){
		pd.update(person);
	}
	@RequestMapping(value="/person/{name}", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable String name, HttpServletResponse response){
		pd.deleteByName(name);
	}
}
