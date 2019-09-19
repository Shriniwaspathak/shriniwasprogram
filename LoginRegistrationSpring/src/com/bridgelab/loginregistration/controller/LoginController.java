package com.bridgelab.loginregistration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelab.loginregistration.model.LoginDetail;
import com.bridgelab.loginregistration.model.RegistrationDetail;
import com.bridgelab.loginregistration.service.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	UserServiceImpl service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest requst, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginDetail());
		return mav;

	}

	@RequestMapping(value = "/loginprocess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginDetail login) {

		ModelAndView mav = null;
		int registerdetail = service.validateUser(login);
		if (registerdetail > 0) {
			mav = new ModelAndView("welcome");
			mav.addObject("username", login.getName());

		} else {
			mav = new ModelAndView("errorpage");
		}
		return mav;
	}
}
