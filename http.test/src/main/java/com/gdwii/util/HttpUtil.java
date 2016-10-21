package com.gdwii.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {
	public static void printHeader(HttpServletRequest request){
		System.out.println("=================header start=================");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
		System.out.println("=================header end  =================");
	}
}
