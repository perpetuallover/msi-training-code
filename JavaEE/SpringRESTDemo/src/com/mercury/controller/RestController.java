package com.mercury.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

@Controller
public class RestController {
	@Autowired
	private User user;
	@Autowired
	@Qualifier("hd02")
	private HelloDao hd;
	@RequestMapping(value="/user", method=RequestMethod.GET)
	@ResponseBody
	public User getUser(){
		// only java object will convert to json
		return user;
	}
	@RequestMapping(value="/user", method=RequestMethod.POST)
	@ResponseBody
	public List<User> getUsers(){
		// only java object will convert to json
		return hd.queryAll();
	}
	
}
