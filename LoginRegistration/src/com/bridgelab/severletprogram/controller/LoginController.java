package com.bridgelab.severletprogram.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelab.servletprogram.service.ServletServiceImpl;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletServiceImpl service = new ServletServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean flag = service.dologin(req, resp);
		String username1 = req.getParameter("username");
		if (flag) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username1);
			session.setMaxInactiveInterval(10);
			Cookie cookiename = new Cookie("username", username1);
			resp.addCookie(cookiename);
			resp.sendRedirect("homepage.jsp");
			//RequestDispatcher rd = req.getRequestDispatcher("homepage.jsp");
			//rd.forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.println("Invalid User");
			
		}
	}
}

/*
 * <% 
 HttpSession session1=request.getSession();
if(session1.getAttribute("userName")==null){
	System.out.println("inside :"+ session1.getAttribute("name"));
	response.sendRedirect("login.jsp");
}else{
	System.out.println("outside :"+ session1.getAttribute("name"));
}  
%>
 * 
 * */
 