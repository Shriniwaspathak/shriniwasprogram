package com.bridgelab.servletprogram.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletService {

	public boolean dologin(HttpServletRequest request, HttpServletResponse response);

	public int doregistration(HttpServletRequest request);

}
