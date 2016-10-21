package com.gdwii.cache;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdwii.util.ETagCacheUtil;

@WebServlet(urlPatterns="/cache/etag")
public class ETagCacheTest extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8350912821791825137L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = "test";
		if(ETagCacheUtil.noChangeResponse(req, resp, key)){
			return;
		}
		resp.getWriter().println("etag cache test");
	}
}
