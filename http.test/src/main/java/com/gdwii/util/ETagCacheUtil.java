package com.gdwii.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ETagCacheUtil {
	/**
	 * 没有发生改变时的响应
	 * @param req 
	 * @param resp
	 * @param etagKey 生成ETag的关键字
	 * @return
	 */
	public static boolean noChangeResponse(HttpServletRequest req, HttpServletResponse resp, String etagKey){
		String etag = md5(etagKey); // 此处采用的是md5处理，也可以采用其他方式
		resp.setHeader("ETag", etag);
		
		String lastETag = req.getHeader("If-None-Match");
		if(lastETag == null || !lastETag.equals(etag)){
			return false;
		}
		
		// 返回302
		resp.setStatus(302);
		return true;
	}
	
	public static String md5(String str) {
	 	MessageDigest md;
	 	try {
	 		md = MessageDigest.getInstance("MD5");
	 	} catch (NoSuchAlgorithmException e) {
	 		throw new RuntimeException("MD5 cryptographic algorithm is not available.", e);
	 	}
	 	byte[] messageDigest = md.digest(str.getBytes());
	 	BigInteger number = new BigInteger(1, messageDigest);
	 	// prepend a zero to get a "proper" MD5 hash value
	 	StringBuffer sb = new StringBuffer('0');
	 	sb.append(number.toString(16));
	 	return sb.toString();
	 }

}
