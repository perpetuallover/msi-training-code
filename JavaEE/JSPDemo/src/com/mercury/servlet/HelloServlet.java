package com.mercury.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.beans.User;
import com.mercury.service.HelloService;

/**
 * Servlet implementation class HelloServlet
 */
//each servlet only have one instance, servlet is lazy created
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HelloService hs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// object is singleton, helloservice is stateless, immutable thus thread safe.
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
        if(hs == null){
        	hs = new HelloService();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<h2 style = 'color: blue'>");
//		out.print("Hello " + name + ", your age is " + age);
//		out.print("</h2>");
		User user = parse(request); // sateful have thread safe issue, must use shallow copy(local variable)
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HelloService hs = new HelloService();
		out.print(hs.sayHello1(user)); // return a JSP 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		User user = parse(request);
		request.setAttribute("userInfo", hs.process(user));
		String url = "/result.jsp";
		//forward to a new page
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private User parse(HttpServletRequest request){
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		return user;
	}
}
