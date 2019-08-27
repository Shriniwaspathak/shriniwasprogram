package com.bridgelab.servletprogram.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelab.severletprogram.dao.Servletdao;
import com.bridgelab.severletprogram.model.UserDetails;

public class ServletServiceImpl implements ServletService {
	UserDetails details = new UserDetails();
	Servletdao dao = new Servletdao();

	@Override
	public boolean dologin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("reched in dologin service ... ");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		details.setUsername(username);
		details.setPassword(password);
		boolean flag = false;
		try {
			flag = dao.dologin(details);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int doregistration(HttpServletRequest request) {
		int status = 0;
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String Email = request.getParameter("Email");
			String mobileno = request.getParameter("mobileno");
			details.setUsername(username);
			details.setPassword(password);
			details.setFirstname(firstname);
			details.setLastname(lastname);
			details.setEmail(Email);
			details.setMobileno(mobileno);

			status = dao.doregistratin(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
}
