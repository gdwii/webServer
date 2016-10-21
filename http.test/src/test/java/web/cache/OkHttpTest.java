package web.cache;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.IntStream;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {
	public static void main(String[] args) throws IOException {
		int cacheSize = 100 * 1024 * 1024;
		Cache cache = new Cache(Files.createTempDirectory("cache").toFile(), cacheSize);
		OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();
		
		String url = "http://127.0.0.1:7070/cache/cache/time";
		for(int i = 0; i < 5; i++){
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
			System.out.println(response.code());
			System.out.println("===============Header===============");
			response.headers().names().forEach(name ->{
				System.out.println(name + "===>" + response.headers(name));
			});
		}
	}
}
