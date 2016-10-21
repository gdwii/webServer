package com.gdwii.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdwii.util.http.HttpResponeUtil;

@WebServlet(urlPatterns="/forward")
public class ForwardTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpResponeUtil.redirect(resp, req.getServletContext().getContextPath() + "/cache.html");
	}
}
