package com.gdwii.authentication;

import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/authentication")
public class AuthenticationTest extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		System.out.println("=================header===========");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			System.out.println(name + ":" + req.getHeader(name));
		}
		System.out.println("=================header===========");
		
		String authorization = req.getHeader("Authorization");
		if(authorization == null || authorization.length() == 0){
			authenticationResponse(resp, "");
			System.out.println("[log] no authentication");
			return ;
		}
		authorization = decodeAuthorization(authorization);
		System.out.println("授权信息:" + authorization);
		if(authorization.equals("test:123")){
			resp.getWriter().println("授权成功");
		}else{
			authenticationResponse(resp, "invalid password");
			System.out.println("[log] authentication fail");
		}
	}
	
	public void authenticationResponse(HttpServletResponse resp, String message){
		resp.setHeader("WWW-Authenticate", "BASIC realm=\"" + message + "\"");
		resp.setStatus(401);
	}
	
	public static final String Authorization_PREFIX = "Basic ";
	public String decodeAuthorization(String authorization){
		authorization = authorization.substring(Authorization_PREFIX.length());
		return new String(Base64.getDecoder().decode(authorization));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
