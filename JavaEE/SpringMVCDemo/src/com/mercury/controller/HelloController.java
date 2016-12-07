package com.mercury.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//controller
public class HelloController {
	//model
	@Value("hello")
	private String viewPage;
	//view
	// in out mapping
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView sayHello(HttpServletRequest request){
		String name = request.getParameter("name");
		ModelAndView mav = new ModelAndView();
		mav.addObject("welcome", "Hello, " + name + " welcome to Spring MVC!");
		mav.setViewName(viewPage);
		return mav;
	}
	@RequestMapping("/main")
	public String goMain(ModelMap model, HttpSession session){
		model.addAttribute ("message", "Additional message from ModelMap");
		session.setAttribute("msg", "Additional message from session");
		return "main";
	}
	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return "Welcome to Spring!";
	}
}
