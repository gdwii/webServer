package web.cache;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Test {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://127.0.0.1:7070/http/partalDownload");  
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
        //设置连接的相关属性  
        conn.setRequestMethod("HEAD"); 
        System.out.println(conn.getContentLength());
        
	}
}
