package com.bridgelab.loginregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelab.loginregistration.model.ForgetPassword;
import com.bridgelab.loginregistration.service.UserServiceImpl;

@Controller
public class EmailSender {
	@Autowired
	UserServiceImpl service;

	private String emailid = null;
	private String otpgenerate = null;

	// Handler service for Forget page
	@RequestMapping(value = "/Forget", method = RequestMethod.GET)

	public ModelAndView showLogin(@ModelAttribute ForgetPassword forgetpassword) {
		ModelAndView mv = new ModelAndView("Forget");
		
		return mv;
	}

// post mapping for emailsendingprocess

	@RequestMapping(value = "/emailSendingProcess", method = RequestMethod.POST)
	public ModelAndView sendEmail(@ModelAttribute ForgetPassword forgetpassword) {

		emailid = forgetpassword.getEmailid();
		if(emailid==null) {
			ModelAndView mv=new ModelAndView();
			mv.addObject("invalidCredential",forgetpassword);
		}
		int result = service.checkEmail(emailid);

		if (result > 0) {
			otpgenerate = "abcdefgh";
			service.sendEmail(emailid, otpgenerate);
			ModelAndView mv = new ModelAndView("enterpassword");
			mv.addObject("forgetpassword", forgetpassword);
			return mv;
		} else {
			ModelAndView mv2 = new ModelAndView("invalidCredentials");
			return mv2;
		}
	}

	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)

	public String setPassword(@ModelAttribute ForgetPassword forgetpassword) {

		if (forgetpassword.getOtp().equals(otpgenerate)) {
			service.setPassword(forgetpassword.getPassword(), emailid);

			return "passwordRest";
		} else {
			return "invalidOtp";
		}
	}
}