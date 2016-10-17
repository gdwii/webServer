package com.gdwii.cache;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/cache/time.html")
public class CacheTest1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setHeader("If-Modified-Since", "Mon, 17 Oct 2016 07:34:33 GMT");
		resp.setHeader("Cache-Control", "max-age=600");
//		resp.setDateHeader("Expires", System.currentTimeMillis()+60*5*1000);
		
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().print("时间相关的缓存测试");
		System.out.println("访问请求一次");
		
		System.out.println(req.getHeader("If-Modified-Since"));
	}
}
