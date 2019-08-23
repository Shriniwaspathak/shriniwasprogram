package com.bridgelab.severletprogram.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelab.servletprogram.service.ServletServiceImpl;

public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ServletServiceImpl service = new ServletServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inside do post");
		int demo = service.doregistration(req);
		if (demo > 0) {
			System.out.println("inside do post if block");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

	}
}
