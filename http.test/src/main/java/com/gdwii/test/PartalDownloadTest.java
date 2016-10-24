package com.gdwii.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdwii.util.HttpUtil;
import com.gdwii.util.http.PartialDownload;

@WebServlet(urlPatterns="/partalDownload")
public class PartalDownloadTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpUtil.printHeader(req);
		
		File file  = new File("D:/test_new.txt");
		PartialDownload downlaod = new PartialDownload(req, resp, file);
		downlaod.download();
	}
}
