package web.cache;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CacheTest {
	public static void main(String[] args) throws IOException {
		testDateCache();
		testEtagCache();
	}
	
	/**
	 * 通过ETag控制缓存
	 * @throws IOException 
	 */
	public static void testEtagCache() throws IOException {
		OkHttpClient client = new OkHttpClient();
		String url = "http://127.0.0.1:7070/cache/cache.html"; // 要请求的资源
		for(int i = 0; i < 5; i++){
			Headers headers = new Headers.Builder().
					// If-None-Match值必须是响应消息头中Last-Modified的值
					add("If-None-Match", "W/\"134-1476858415548\"") .build();
			Request request = new Request.Builder().url(url).headers(headers).build();
			Response response = client.newCall(request).execute();
			// 当If-None-Match与Last-Modified一致时，返回304状态码
			System.out.println("状态码：" + response.code());
			System.out.println("===============返回响应消息头===============");
			response.headers().names().forEach(name ->{
				System.out.println(name + "===>" + response.headers(name));
			});
		}
	}
	
	/**
	 * 通过时间是否过期控制缓存
	 * @throws IOException 
	 */
	public static void testDateCache() throws IOException {
		OkHttpClient client = new OkHttpClient();
		String url = "http://127.0.0.1:7070/cache/cache.html"; // 要请求的资源
		for(int i = 0; i < 5; i++){
			Headers headers = new Headers.Builder().
					// If-Modified-Since值必须是响应消息头中Last-Modified的值
					add("If-Modified-Since", "Wed, 19 Oct 2016 07:14:20 GMT") .build();
			Request request = new Request.Builder().url(url).headers(headers).build();
			Response response = client.newCall(request).execute();
			// 当If-Modified-Since与Last-Modified一致时，返回304状态码
			System.out.println("状态码：" + response.code());
			System.out.println("===============返回响应消息头===============");
			response.headers().names().forEach(name ->{
				System.out.println(name + "===>" + response.headers(name));
			});
		}
	}
}
