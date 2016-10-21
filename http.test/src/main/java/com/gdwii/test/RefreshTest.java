package com.gdwii.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdwii.util.http.HttpResponeUtil;

@WebServlet(urlPatterns="/refresh")
public class RefreshTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		HttpResponeUtil.refresh(resp, "http://www.baidu.com", 5);
		resp.getWriter().println("刷新测试");
	}
}
