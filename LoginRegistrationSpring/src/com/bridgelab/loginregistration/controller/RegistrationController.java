package com.bridgelab.loginregistration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelab.loginregistration.model.RegistrationDetail;
import com.bridgelab.loginregistration.service.UserServiceImpl;
@Controller
public class RegistrationController {
	 
	@Autowired
	public UserServiceImpl service;
  
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("registerdetail",new RegistrationDetail());
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("registerdetail") RegistrationDetail registerdetail) {
		service.register(registerdetail);
		return new ModelAndView("welcome","username", registerdetail.getUsername());

	}
}
