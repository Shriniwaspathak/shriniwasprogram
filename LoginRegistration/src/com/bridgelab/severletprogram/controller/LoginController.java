package com.bridgelab.severletprogram.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelab.servletprogram.service.ServletServiceImpl;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ServletServiceImpl service = new ServletServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean flag = service.dologin(req, resp);
		if (flag) {

			HttpSession session = req.getSession();
			session.setAttribute("userName", req.getParameter("username"));
			session.setMaxInactiveInterval(5);
			RequestDispatcher rd = req.getRequestDispatcher("homepage.jsp");
			rd.forward(req, resp);
		}
	}
}
