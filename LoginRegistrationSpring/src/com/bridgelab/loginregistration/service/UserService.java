package com.bridgelab.loginregistration.service;

import com.bridgelab.loginregistration.model.LoginDetail;
import com.bridgelab.loginregistration.model.RegistrationDetail;

public interface UserService {
	public void register(RegistrationDetail detail);
	RegistrationDetail validateUser(LoginDetail login);
	public void setPassword(String password,String emailid);
	public void sendEmail(String email,String password);
	public int checkEmail(String email);

}
