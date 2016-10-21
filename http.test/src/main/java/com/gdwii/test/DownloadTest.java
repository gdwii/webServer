package com.gdwii.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdwii.util.http.HttpResponeUtil;

@WebServlet(urlPatterns="/download")
public class DownloadTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = "测试下载";
		HttpResponeUtil.setDownloadHeader(req, resp, fileName);
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(req.getServletContext().getResource("cache.html").toURI()));
			PrintWriter printWriter = resp.getWriter();
			
			String str = "";
			while((str = reader.readLine()) != null){
				printWriter.println(str);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
