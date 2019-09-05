package com.bridgelab.loginregistration.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.bridgelab.loginregistration.dao.UserServiceDao;
import com.bridgelab.loginregistration.model.LoginDetail;
import com.bridgelab.loginregistration.model.RegistrationDetail;

public class UserServiceImpl implements UserService {
	@Autowired
	UserServiceDao dao;
	@Autowired
	private MailSender mailsender;
	
	public void setMailsender(MailSender mailsender) {
		this.mailsender = mailsender;
	}

	@Override
	public void register(RegistrationDetail detail) {
		int result = dao.doregistration(detail);
	}

	@Override
	public RegistrationDetail validateUser(LoginDetail login) {
		RegistrationDetail result = dao.dologin(login);
		return result;

	}

	@Override
	public void setPassword(String password, String emailid) {
		dao.setpasswordtodatabase(password, emailid);

	}

	@Override
	public void sendEmail(String to, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rishuparasar5@gmail.com");
		message.setTo(to);
		message.setSubject("OTP");
		message.setText(otp);
		mailsender.send(message);

	}

	@Override
	public int checkEmail(String email) {
		int result = dao.checkEmail(email);
		
		if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static  String getSecurePassword(String passwordToHash) {
		String generatepassword = null;
		try {
			// create messageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// add password byte to digest
			md.update(passwordToHash.getBytes());
			// get the hash's bytes
			byte[] bytes = md.digest();
			// this bytes[] has byte in decimal format;
			// convert it to hexadecimal format;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// get complete hashed password in hex format
			generatepassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}
		return generatepassword;
	}

}
