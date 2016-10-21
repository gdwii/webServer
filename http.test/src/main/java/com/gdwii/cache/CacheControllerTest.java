package com.gdwii.cache;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdwii.util.HttpUtil;

@WebServlet(urlPatterns="/cache/time")
public class CacheControllerTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpUtil.printHeader(req);
		resp.setHeader("Cache-Control", "Cache-Control: no-cache");
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().print("时间相关的缓存测试");
		System.out.println("访问请求一次");
	}
}
